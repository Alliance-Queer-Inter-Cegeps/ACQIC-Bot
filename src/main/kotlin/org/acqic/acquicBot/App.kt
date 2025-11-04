package org.acqic.acquicBot

import org.graalvm.polyglot.Context
import org.graalvm.polyglot.Source
import java.io.File

fun main() {
    Context.create().eval(
        "js",
        "var jsHello = () => {\n" +
                "    console.log(\"Hello from javascriptttt\");\n" +
                "}"

//        with(File(, "hi.js")) {
//            Source
//                .newBuilder(Source.findLanguage(this), this)
//                .build()
//        }
    ).getMember("jsHello").execute()
        .asString().also(::println)
}