package org.acqic.acquicBot.events

import dev.kord.core.event.Event
import me.jakejmattson.discordkt.dsl.Listeners
import org.acqic.acquicBot.events.handler.newMessage.newMessageEvents

val botEvents: Array<BotEventList> = arrayOf(
    newMessageEvents
)

typealias BotEventList = () -> Listeners

abstract class BotEvent<T : Event> {
    protected abstract fun cond(event: T): Boolean

    protected abstract fun execute(event: T): Unit

    public final fun handle(event: T) {
        if (cond(event))
            execute(event)
    }
}