plugins {
  kotlin("jvm") version "1.4.30"
}

repositories {
  mavenCentral()
}

version = "1.0"

dependencies {
  testImplementation(platform("org.junit:junit-bom:5.7.0"))
  testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
  useJUnitPlatform()
}
