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
    compileOnly(project(path = ":domain"))

	compileOnly("jakarta.persistence:jakarta.persistence-api:2.2.3")    
    compileOnly("javax.ejb:javax.ejb-api:3.2")
}
