plugins {
    java
    war
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

    // https://mvnrepository.com/artifact/org.zkoss.zk/zk-bom
    implementation(platform("org.zkoss.zk:zk-bom:9.6.0.2"))
    // https://mvnrepository.com/artifact/org.zkoss.zk/zkbind
    implementation("org.zkoss.zk:zkbind")
    // https://mvnrepository.com/artifact/org.zkoss.zk/zkplus
    implementation("org.zkoss.zk:zkplus")

    // https://mvnrepository.com/artifact/commons-io/commons-io
    //compileOnly("commons-io:commons-io:2.5")

    // https://mvnrepository.com/artifact/javax.ejb/javax.ejb-api
    compileOnly("javax.ejb:javax.ejb-api:3.2")
    // https://mvnrepository.com/artifact/jakarta.enterprise/jakarta.enterprise.cdi-api
    compileOnly("jakarta.enterprise:jakarta.enterprise.cdi-api:2.0.2")
}
