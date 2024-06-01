plugins {
    kotlin("jvm") version "1.9.23"
    id("maven-publish")
}

group = "cn.trollaura"
version = "1.1"

repositories {
    mavenCentral()
       maven {
           url = uri("https://www.xn--lzs769c.icu/repository/repository/")
       }


}

dependencies {
    implementation("mysql:mysql-connector-java:8.0.28")
    implementation("com.github.SNWCreations:JKook:0.52.1")
    implementation("cn.trollaura:api:1.2")
}

kotlin {
    jvmToolchain(8)
}



