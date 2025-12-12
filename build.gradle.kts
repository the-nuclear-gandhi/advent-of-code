plugins {
    kotlin("jvm") version "2.2.21"
    id("org.sonarqube") version "7.2.1.6560"
    jacoco
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(24)
}

version = "1.0"

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
    implementation("com.github.ajalt.clikt:clikt:5.0.3")
    implementation("ch.qos.logback:logback-classic:1.5.22")

    testImplementation(platform("org.junit:junit-bom:6.0.1"))
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
    toolVersion = "0.8.14"
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
