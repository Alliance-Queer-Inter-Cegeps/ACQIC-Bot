package org.acqic.acquicBot.commands.handler.misc

import org.acqic.acquicBot.commands.handler.BotCommand
import org.acqic.acquicBot.commands.logic.misc.GetSourceLogic
import org.acqic.acquicBot.commands.logic.misc.impl.GetSourceLogicImpl

val getSource: BotCommand = {
    slash("source", "Obtiens un lien vers le code source du bot") {
        execute {
            val logic: GetSourceLogic = GetSourceLogicImpl()

            respond(logic.getSourceCode())
        }
    }
}