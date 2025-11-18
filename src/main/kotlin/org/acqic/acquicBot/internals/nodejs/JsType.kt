package org.acqic.acquicBot.internals.nodejs

sealed class JsType<T> {
    abstract val value: T

    override fun hashCode(): Int = value?.hashCode() ?: 0
    override fun equals(other: Any?): Boolean = value == other
    override fun toString(): String = value.toString()
}

class JsNum(override val value: Number) : JsType<Number>()
class JsString(override val value: String): JsType<String>()
class JsArray<T: JsType<*>>(override val value: Array<T>): JsType<Array<T>>()
// TODO: JSON