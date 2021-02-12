plugins {
    kotlin("jvm")
}

dependencies {
    api(project(":core:v2"))
    implementation(kotlin("stdlib"))
    implementation("org.junit.jupiter:junit-jupiter:5.7.1")
    implementation("software.amazon.awssdk:aws-core:2.15.71")
    implementation("software.amazon.awssdk:sns:2.15.71")
    testImplementation(project(":localstack"))
    testImplementation("org.testcontainers:localstack:1.15.2")
    testImplementation("org.assertj:assertj-core:3.19.0")
}
