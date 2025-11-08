package org.acqic.acquicBot.events.logic.newMessage.impl

import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.x.emoji.DiscordEmoji
import org.acqic.acquicBot.events.logic.newMessage.ReactToLogic
import org.acqic.acquicBot.utils.firstValueOfKeyMatching

class ReactToLogicImpl(event: MessageCreateEvent) : ReactToLogic {
    val messageContent: String = event.message.content

    override fun getReactionOrNull(reactionsToCertainMsg: List<Pair<String, DiscordEmoji>>): DiscordEmoji? =
        reactionsToCertainMsg.firstValueOfKeyMatching(messageContent)
}