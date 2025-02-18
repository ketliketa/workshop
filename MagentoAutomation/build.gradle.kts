plugins {
    id("java")
}

group = "com.selenium"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.seleniumhq.selenium:selenium-java:4.15.0")
    implementation("org.testng:testng:7.7.0")
    implementation("io.github.bonigarcia:webdrivermanager:5.7.0")
    implementation("org.seleniumhq.selenium:selenium-chrome-driver:4.15.0")
    implementation("com.aventstack:extentreports:5.0.9")



}

tasks.test {
    useTestNG()
}