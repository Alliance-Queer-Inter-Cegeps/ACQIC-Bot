package org.acqic.acquicBot.commands.logic.misc.impl

import org.acqic.acquicBot.commands.logic.misc.GetSourceLogic

// You can consider this as a small sample as the code is kinda nonsensical (overengineered at least here)
class GetSourceLogicImpl : GetSourceLogic {
    val repoHostLink: String = "https://github.com/"

    object Pure {
        fun processSourceLink(sourceLink: String): String = sourceLink + "Alliance-Queer-Inter-Cegeps/ACQIC-Bot"
    }

    override fun getSourceCode(): String = Pure.processSourceLink(repoHostLink)
}