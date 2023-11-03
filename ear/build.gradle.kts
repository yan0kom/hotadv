plugins {
    ear
}

repositories {
    mavenCentral()
}

dependencies {
    deploy(project(path = ":domain"))
    deploy(project(path = ":persist"))
    deploy(project(path = ":ui", configuration = "archives"))
}

tasks.ear {
    archiveBaseName = "hotel-advisors"

    deploymentDescriptor {
        applicationName = "hotel-advisors"
    }
}

tasks.register<Exec>("redeploy") {
    dependsOn(tasks.ear)

    commandLine("${projectDir}/wildfly-cli/redeploy.sh")
}
