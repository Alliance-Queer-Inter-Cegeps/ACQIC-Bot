package org.acqic.acquicBot.internals.nodejs

@JvmInline
value class JsOutput(private val output: String) {
    fun asString() = output
    fun asInt() = output.toInt()
    fun asLong() = output.toLong()
    fun asFloat() = output.toFloat()
    fun asDouble() = output.toDouble()
    fun asJson(): Nothing = TODO()
}