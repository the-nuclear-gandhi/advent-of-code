plugins {
    kotlin("jvm") version "1.5.10"
}

repositories {
    mavenCentral()
}

version = "1.0"

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.8.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
