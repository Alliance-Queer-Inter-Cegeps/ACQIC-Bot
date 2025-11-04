package org.acqic.acquicBot.events.newMessage

import discord4j.core.event.domain.Event
import discord4j.core.event.domain.message.MessageCreateEvent
import discord4j.core.`object`.entity.Message
import kotlinx.coroutines.coroutineScope
import org.acqic.acquicBot.events.BotEvent
import reactor.core.publisher.Mono

class PingEvent(override val event: MessageCreateEvent) : BotEvent<Mono<Message?>?, MessageCreateEvent>(event = event) {
    override val condition: () -> Boolean = { event.message.content.equals("!ping", ignoreCase = true) }

    override suspend fun handle(): Mono<Message?> = coroutineScope {
        event.message.channel.flatMap { it -> it.createMessage("Pong!") }
        Mono.empty<Message?>()
    }
}