import org.gradle.kotlin.dsl.extra
//import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper

plugins {
//    kotlin("kapt") version "1.2.40"
//    kotlin("jvm") version "1.2.40"
    java
//    `java-library`
//    idea
}
repositories {
    jcenter()
    maven(url = "https://jitpack.io")
}
description = "${name.replace("_", " ").toUpperCase()} issue at JDK 9 & JDK 8"
//val kotlinVersion = plugins.getPlugin(KotlinPluginWrapper::class.java).kotlinPluginVersion
dependencies {

    compileOnly(project(path=":ap"))
    annotationProcessor(project(path=":ap"))//abe9f2dbf188608a056111ba550d545e7ff7c1bb

    compileOnly(group="com.github.filiphr.mapstruct",         name="mapstruct-jdk8",       version="1453_wrong-capture-SNAPSHOT")
    annotationProcessor(group="com.github.filiphr.mapstruct", name="mapstruct-processor",  version="1453_wrong-capture-SNAPSHOT")

    implementation(group="org.projectlombok",                 name="lombok",               version="1.16.20")
    annotationProcessor(group="org.projectlombok",            name="lombok",               version="1.16.20")

    annotationProcessor(group="javax.xml.bind",               name="jaxb-api",             version="2.3.0") {
        because("MetaModel and some other components require this to be on annotationProcessor classpath") }
    annotationProcessor(group="javax.annotation",             name="javax.annotation-api", version="1.3.2") {
        because("Some annotation Processors require this to be on annotationProcessor classpath") }

//    implementation(kotlin("stdlib-jdk8", kotlinVersion))
}
