package org.acqic.acquicBot.events.handler.newMessage

import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.x.emoji.DiscordEmoji
import dev.kord.x.emoji.Emojis
import org.acqic.acquicBot.events.BotEvent
import org.jetbrains.annotations.ApiStatus

class ReactTo : BotEvent<MessageCreateEvent>() {
    override fun cond(event: MessageCreateEvent): Boolean =
        event.member?.isBot == false

    override fun execute(event: MessageCreateEvent) {
        // TODO: Move stuff into a logic class (im exhassuted while im writing all this)
//        event.message.addReaction()
    }
}

private val reactWithToWhat: Map<String, DiscordEmoji> = mapOf(
    "trans" to Emojis["\uD83C\uDFF3\uFE0F\u200D⚧\uFE0F"]!!,
    // gay flag or smth
)

// TODO: Move this out in utils
tailrec fun <V> firstValueOfKeyMatchingString(string: String, map: Map<String, V>, sizePassedThrough: Int = 1): V? {
    // TODO: check the difference between map and List of pair cause idk rn
    val result: Pair<String, V>? = map.toList().firstOrNull { it.first.contains(string.take(sizePassedThrough)) }

    return if (result != null)
        result.second
    else
        if (string.length > sizePassedThrough)
            firstValueOfKeyMatchingString(string, map, sizePassedThrough + 1)
        else
            null
}