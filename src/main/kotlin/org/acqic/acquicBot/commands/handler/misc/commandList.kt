package org.acqic.acquicBot.commands.handler.misc

import me.jakejmattson.discordkt.commands.CommandSet
import me.jakejmattson.discordkt.commands.commands
import org.acqic.acquicBot.commands.handler.BotCommandSet

val miscCommands: BotCommandSet = {
    commands(
        "Miscellaneous"
    ) {
        getSource()
    }
}