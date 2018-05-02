import org.gradle.kotlin.dsl.extra
plugins {
    java
}
repositories {
    jcenter()
    maven(url = "https://jitpack.io")
}
description = "${name.replace("-", " ").toUpperCase()} issue at JDK 9 & JDK 8"
dependencies {
    compileOnly(group="com.github.filiphr.mapstruct", name="mapstruct-processor", version="1453_wrong-capture-SNAPSHOT")

    //JDK 9
    annotationProcessor(group="javax.xml.bind",   name="jaxb-api",             version="2.3.0") {
        because("MetaModel and some other components require this to be on annotationProcessor classpath") }
    annotationProcessor(group="javax.annotation", name="javax.annotation-api", version="1.3.2") {
        because("Some annotation Processors require this to be on annotationProcessor classpath") }
}
