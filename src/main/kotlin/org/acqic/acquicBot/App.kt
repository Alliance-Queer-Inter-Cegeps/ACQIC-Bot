package org.acqic.acquicBot

import dev.kord.gateway.Intent
import dev.kord.gateway.Intents
import dev.kord.gateway.PrivilegedIntent
import io.github.cdimascio.dotenv.Dotenv
import kotlinx.coroutines.runBlocking
import me.jakejmattson.discordkt.dsl.bot
import org.acqic.acquicBot.commands.handler.botCommands
import org.acqic.acquicBot.events.botEvents

@OptIn(PrivilegedIntent::class)
fun main(): Unit = runBlocking {
    // .env file at the project root
    val token = Dotenv.load().get("BOT_TOKEN")

    bot(token) {
        configure {
            deleteInvocation = false

            commandReaction = null

            intents = Intents(
                Intent.MessageContent
            )
        }

        onStart {
            println("Bot started.")
        }

        botCommands.map { it() }
        botEvents.map { it() }
    }
}