plugins {
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.serialization") version "2.0.0"
    id("com.squareup.wire") version "5.0.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

wire {
    protoPath {
        srcDir("src/main/proto")
    }
    sourcePath {
        srcDir("src/main/proto")
    }

    kotlin {
        javaInterop = true
        out = "$projectDir/build/generated/source/wire"
    }
}

dependencies {
    testImplementation(kotlin("test"))

    implementation ("com.google.code.gson:gson:2.10.1")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}