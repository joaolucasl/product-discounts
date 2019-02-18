import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.3.20"
    id("com.github.johnrengelman.shadow") version "2.0.4"
    application
}

group = "com.github.joaolucasl.chumlee"
version = "0.0.1"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.koin:koin-spark:1.0.1")
    implementation("org.slf4j:slf4j-api:1.7.5")
    implementation("org.slf4j:slf4j-simple:1.7.5")
    implementation("io.github.microutils:kotlin-logging:1.6.24")
    implementation("com.google.code.gson:gson:2.8.5")
}

application {
    mainClassName = "com.github.joaolucasl.chumlee.products.ServerKt"
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = application.mainClassName
    }
}

tasks.withType<ShadowJar> {
    baseName = "app"
    classifier = ""
    version = ""
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}