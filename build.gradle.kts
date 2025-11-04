plugins {
    kotlin("jvm") version "2.2.20"
    id("application")
    id("org.graalvm.buildtools.native") version "0.10.2"
}

group = "org.acqic"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.graalvm.polyglot:polyglot:25.0.1")
    implementation("org.graalvm.polyglot:js-community:25.0.1")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(24)
}

application {
    mainClass.set("org.acqic.acquicBot.AppKt")
    applicationDefaultJvmArgs =
        "-agentlib:native-image-agent=config-output-dir=./graalcnf/".split(
            " "
        )
}
