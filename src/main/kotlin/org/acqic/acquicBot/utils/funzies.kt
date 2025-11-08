package org.acqic.acquicBot.utils

tailrec fun <T> dotoWhile(value: T, whileCond: (T) -> Boolean, block: (T) -> T): T =
    if (whileCond(value))
        dotoWhile(block(value), whileCond, block)
    else
        value