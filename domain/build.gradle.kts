plugins {
    java
}

repositories {
    mavenCentral()
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

dependencies {
    compileOnly("javax.ejb:javax.ejb-api:3.2")
    compileOnly("jakarta.validation:jakarta.validation-api:2.0.2")
}
