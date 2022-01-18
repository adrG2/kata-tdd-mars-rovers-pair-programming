plugins {
    kotlin("jvm") version "1.5.10"
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    runtimeOnly("io.kotest:kotest-assertions-core-jvm:5.1.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}