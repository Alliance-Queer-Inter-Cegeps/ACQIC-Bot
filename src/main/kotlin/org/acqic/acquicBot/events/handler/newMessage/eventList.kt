package org.acqic.acquicBot.events.handler.newMessage

import dev.kord.core.event.message.MessageCreateEvent
import kotlinx.coroutines.coroutineScope
import me.jakejmattson.discordkt.dsl.listeners
import org.acqic.acquicBot.events.BotEventList
import org.acqic.acquicBot.events.BotEventSublist
import org.acqic.acquicBot.events.mapThemConcurrently

private val sndPriorityThingiesIdk: BotEventSublist<MessageCreateEvent> by lazy {
    arrayOf(
        ReactTo()
    )
}

val newMessageEvents: BotEventList = {
    listeners {
        on<MessageCreateEvent> {
            coroutineScope {


                // ils devraient être executer en ordre de priorité (modération always first imo)

                // add moderation if possible

                sndPriorityThingiesIdk.mapThemConcurrently(this@on, this)
            }
        }
    }
}