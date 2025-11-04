package org.acqic.acquicBot.events

import discord4j.core.event.domain.Event

abstract class BotEvent<T, M : Event>(open val event: M) {
    abstract val condition: () -> Boolean

    abstract suspend fun handle (): T

    fun execute() {
        if (condition()) handle(event)
    }

}