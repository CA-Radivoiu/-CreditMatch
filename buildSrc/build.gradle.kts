import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

repositories {
    jcenter()
}

sourceSets {
    main {
        java.srcDir("src/main/kotlin")
    }
}
