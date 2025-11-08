package org.acqic.acquicBot.events.handler.newMessage

import dev.kord.core.event.message.MessageCreateEvent
import me.jakejmattson.discordkt.dsl.listeners
import org.acqic.acquicBot.events.BotEvent
import org.acqic.acquicBot.events.BotEventList

private val handlers: Array<BotEvent<MessageCreateEvent>> by lazy {
    arrayOf(
        ReactTo()
    )
}

val newMessageEvents: BotEventList = {
    listeners {
        on<MessageCreateEvent> {
            handlers.map { it.handle(this) }
        }
    }
}