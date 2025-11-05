package org.acqic.acquicBot

typealias State<S, A> = (S) -> Pair<S, A>

fun <S, A, B> State<S, A>.flatMap(next: (A) -> State<S, B>): State<S, B> = { s: S ->
    with(this(s)) {
        next(second)(first)
    }
}

fun <S> get(): State<S, S> = { s -> Pair(s, s) }

fun main() {
    val test: State<Int, String> = { s ->
        (s + 1).also { println(it) } to ":3"
    }

    test.flatMap { a: String ->
        { s ->
            s to print(a)
        }
    }(5)
}