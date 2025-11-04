package org.acqic.acquicBot

import discord4j.core.DiscordClient
import discord4j.core.GatewayDiscordClient
import discord4j.core.event.domain.message.MessageCreateEvent
import discord4j.core.`object`.entity.Message
import org.acqic.acquicBot.events.BotEvent
import reactor.core.publisher.Mono

val events: Array<Class<BotEvent>> = arrayOf(

)

fun main() {
    DiscordClient.create("TOKEN")
        .withGateway { client: GatewayDiscordClient? ->
            client!!.on(MessageCreateEvent::class.java) { event: MessageCreateEvent? ->
                val message = event!!.message
                if (message.content.equals("!ping", ignoreCase = true)) {
                    message.channel.flatMap { it -> it.createMessage("Pong!") }
                }
                Mono.empty<Message?>()
            }
        }
        .block()
}