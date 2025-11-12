package org.acqic.acquicBot.utils

tailrec fun <V> List<Pair<String, V>>.firstValueOfKeyMatching(string: String, sizePassedThrough: Int = 1): V? {
    val result: Pair<String, V>? = this.firstOrNull { string.take(sizePassedThrough).contains(it.first) }

    return if (result != null)
        result.second
    else
        if (string.length >= sizePassedThrough)
            firstValueOfKeyMatching(string, sizePassedThrough + 1)
        else
            null
}