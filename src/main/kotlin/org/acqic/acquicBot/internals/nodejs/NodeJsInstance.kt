package org.acqic.acquicBot.internals.nodejs

import kotlinx.serialization.json.Json

object NodeJsInstance {
    private val process = ProcessBuilder("node").start()

    init {
        TODO("Should load bundle.js")
    }

    fun exec(funcName: String, vararg args: JsType<*>): JsOutput {
        process.outputWriter().write(
            "console.log($funcName(${
                args.fold("") { acc, curr -> "$acc${handleExecParam(curr)}," }
            })"
        )

        return JsOutput(process.inputStream.bufferedReader().readLine())
    }

    private fun handleExecParam(arg: JsType<*>): String = when (arg) {
        is JsNum -> arg.toString()
        is JsString -> "\"$arg\""
        is JsArray<*> -> TODO()
//        is JsJson -> TODO()
    }
}