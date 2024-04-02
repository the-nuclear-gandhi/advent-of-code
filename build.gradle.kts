plugins {
    kotlin("jvm") version "1.9.23"
    id("org.sonarqube") version "5.0.0.4638"
    jacoco
}

repositories {
    mavenCentral()
}

version = "1.0"

dependencies {
    implementation("com.github.ajalt.clikt:clikt:4.3.0")
    implementation("ch.qos.logback:logback-classic:1.5.3")

    testImplementation(platform("org.junit:junit-bom:5.10.2"))
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
