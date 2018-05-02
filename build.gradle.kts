import org.gradle.kotlin.dsl.*
import org.gradle.api.plugins.*
//import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper

plugins {
//    kotlin("kapt") version "1.2.40"
//    kotlin("jvm") version "1.2.40"
    java
    idea
}
repositories {
    jcenter()
    maven(url = "https://jitpack.io")
}
allprojects {
    plugins.apply("java")
    plugins.apply("idea")
    project.convention
            .getPlugin(conventionType=JavaPluginConvention::class)
            .sourceSets["main"].java.srcDir( file("$buildDir/classes/java/main"))
    idea {
        module {
            generatedSourceDirs.add(file("$buildDir/classes/java/main"))
        }
    }
}
description = "${name.replace("_", " ").toUpperCase()} issue at JDK 9 & JDK 8"
//val kotlinVersion = plugins.getPlugin(KotlinPluginWrapper::class.java).kotlinPluginVersion
dependencies {

    compileOnly(project(path=":ap"))
    annotationProcessor(project(path=":ap"))
    implementation(project(":common"))

//    implementation(kotlin("stdlib-jdk8", kotlinVersion))
}
