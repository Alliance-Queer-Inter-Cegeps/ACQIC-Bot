package org.acqic.acquicBot.commands.handler

import me.jakejmattson.discordkt.commands.CommandSet
import me.jakejmattson.discordkt.commands.CommandSetBuilder
import org.acqic.acquicBot.commands.handler.misc.miscCommands

val botCommands: Array<BotCommandSet> = arrayOf(
    miscCommands
)

typealias BotCommand = CommandSetBuilder.() -> Unit
typealias BotCommandSet = () -> CommandSet