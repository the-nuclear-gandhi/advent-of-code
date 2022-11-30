plugins {
    kotlin("jvm") version "1.7.20"
}

repositories {
    mavenCentral()
}

version = "1.0"

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
