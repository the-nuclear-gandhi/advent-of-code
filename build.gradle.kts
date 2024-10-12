plugins {
    kotlin("jvm") version "2.0.21"
    id("org.sonarqube") version "5.1.0.4882"
    jacoco
}

repositories {
    mavenCentral()
}

version = "1.0"

dependencies {
    implementation("com.github.ajalt.clikt:clikt:5.0.1")
    implementation("ch.qos.logback:logback-classic:1.5.10")

    testImplementation(platform("org.junit:junit-bom:5.11.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

sonar {
    properties {
        property("sonar.projectKey", "the-nuclear-gandhi_advent-of-code")
        property("sonar.organization", "the-nuclear-gandhi")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

jacoco {
    toolVersion = "0.8.12"
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)

    reports {
        xml.required.set(true)
    }
}
