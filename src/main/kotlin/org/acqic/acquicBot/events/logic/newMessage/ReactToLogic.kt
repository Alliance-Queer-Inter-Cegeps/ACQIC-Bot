package org.acqic.acquicBot.events.logic.newMessage

import dev.kord.x.emoji.DiscordEmoji

interface ReactToLogic {
    fun getReactionOrNull(reactionsToCertainMsg: List<Pair<String, DiscordEmoji>>): DiscordEmoji?
}