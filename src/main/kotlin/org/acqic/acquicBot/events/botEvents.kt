package org.acqic.acquicBot.events

import dev.kord.core.event.Event
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.jakejmattson.discordkt.dsl.Listeners
import org.acqic.acquicBot.events.handler.newMessage.newMessageEvents

val botEvents: Array<BotEventList> = arrayOf(
    newMessageEvents
)

abstract class BotEvent<T : Event> {
    protected abstract fun cond(event: T): Boolean

    protected abstract suspend fun execute(event: T): Unit

    public final suspend fun handle(event: T) {
        if (cond(event))
            execute(event)
    }
}

typealias BotEventList = () -> Listeners

typealias BotEventSublist<T> = Array<BotEvent<T>>

suspend inline fun <T : Event> BotEventSublist<T>.mapThem(event: T) = this.map { it.handle(event) }
fun <T : Event> BotEventSublist<T>.mapThemConcurrently(event: T, scope: CoroutineScope) = this.map {
    scope.launch(Dispatchers.IO) {
        it.handle(event)
    }
}