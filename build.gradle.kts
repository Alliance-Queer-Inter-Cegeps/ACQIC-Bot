plugins {
    kotlin("jvm") version "2.2.20"
    id("com.gradleup.shadow") version "9.2.2"
}

group = "org.acqic"
version = "1.0-SNAPSHOT"

repositories {
    maven { url = uri("https://jitpack.io") }
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(libs.discordkt)
    implementation(libs.coroutines)
    implementation(libs.dotenv)
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(24)
}