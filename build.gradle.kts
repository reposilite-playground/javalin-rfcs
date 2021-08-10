plugins {
    base
    kotlin("jvm") version "1.5.20"
    `maven-publish`
}


allprojects {
    group = "com.reposilite"
    version = "1.0.0"

    repositories {
        mavenCentral()
        maven { url = uri("https://repo.panda-lang.org/releases") }
    }
}

publishing {
    repositories {
        maven {
            credentials {
                username = property("mavenUser") as String
                password = property("mavenPassword") as String
            }
            name = "panda-repository"
            url = uri("https://repo.panda-lang.org/releases")
        }
    }
    publications {
        create<MavenPublication>("library") {
            from(components.getByName("java"))
        }
    }
}