plugins {
    kotlin("jvm") version "2.4.10"
    id("org.sonarqube") version "7.4.0.8496"
    jacoco
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(25)
}

version = "1.0"

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.11.0")
    implementation("com.github.ajalt.clikt:clikt:5.1.0")
    implementation("ch.qos.logback:logback-classic:1.6.3")

    testImplementation(platform("org.junit:junit-bom:6.1.3"))
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
    toolVersion = "0.8.15"
}

tasks.test {
    jvmArgs("-Xmx4G")
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)

    reports {
        xml.required.set(true)
    }
}
