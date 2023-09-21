plugins {
    id("application")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

application {
    mainClass.set(project.property("mainClass") as String)
}

tasks.jar {
    manifest {
        attributes.set("Main-Class", project.property("mainClass") as String)
    }
}

/*
tasks.run {
    with (this as JavaExec) {
        standardInput = System.`in`
    }
}
*/

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}