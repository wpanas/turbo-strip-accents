plugins {
    kotlin("jvm") version "2.0.0"
    id("org.jetbrains.kotlinx.benchmark") version "0.4.11"
    kotlin("plugin.allopen") version "2.0.0"
}

allOpen {
    annotation("org.openjdk.jmh.annotations.State")
}

group = "com.github.wpanas"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.commons:commons-lang3:3.14.0")
    implementation("org.jetbrains.kotlinx:kotlinx-benchmark-runtime:0.4.11")
    testImplementation(kotlin("test"))
    testImplementation("io.kotest:kotest-runner-junit5:5.9.1")
    testImplementation("io.kotest:kotest-property:5.9.1")
}

tasks.test {
    useJUnitPlatform()
}

benchmark {
    targets {
        register("main")
    }
}

kotlin {
    jvmToolchain(21)
}