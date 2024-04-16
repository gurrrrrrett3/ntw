plugins {
    id("xyz.jpenilla.run-paper") version "2.2.2"
    kotlin("jvm")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "sh.gart"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.23")
    implementation("commons-io:commons-io:2.6")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks {
    runServer {
        // Configure the Minecraft version for our task.
        // This is the only required configuration besides applying the plugin.
        // Your plugin's jar (or shadowJar if present) will be used automatically.
        minecraftVersion("1.20.4")
        downloadPlugins {
            url("https://ci.lucko.me/job/spark/404/artifact/spark-bukkit/build/libs/spark-1.10.61-bukkit.jar")
        }
    }
}
