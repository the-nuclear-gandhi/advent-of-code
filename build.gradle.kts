plugins {
    kotlin("jvm") version "2.1.20"
    id("org.sonarqube") version "6.1.0.5360"
    jacoco
}

repositories {
    mavenCentral()
}

version = "1.0"

dependencies {
    implementation("com.github.ajalt.clikt:clikt:5.0.3")
    implementation("ch.qos.logback:logback-classic:1.5.18")

    testImplementation(platform("org.junit:junit-bom:5.12.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
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
