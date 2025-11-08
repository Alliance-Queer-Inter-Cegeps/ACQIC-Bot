package org.acqic.acquicBot.events.handler.newMessage

import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.x.emoji.DiscordEmoji
import dev.kord.x.emoji.Emojis
import dev.kord.x.emoji.toReaction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.acqic.acquicBot.events.BotEvent
import org.acqic.acquicBot.events.logic.newMessage.ReactToLogic
import org.acqic.acquicBot.events.logic.newMessage.impl.ReactToLogicImpl

class ReactTo : BotEvent<MessageCreateEvent>() {
    override fun cond(event: MessageCreateEvent): Boolean =
        event.member?.isBot == false

    override suspend fun execute(event: MessageCreateEvent): Unit {
        val handler: ReactToLogic = ReactToLogicImpl(event)

        withContext(Dispatchers.Default) {
            handler.getReactionOrNull(reactWithToWhat)
        }?.let {
            event.message.addReaction(it.toReaction())
        }
    }
}

private val reactWithToWhat: List<Pair<String, DiscordEmoji>> = listOf(
    "trans" to Emojis["\uD83C\uDFF3\uFE0F\u200D⚧\uFE0F"]!!,
    // gay flag or smth
)