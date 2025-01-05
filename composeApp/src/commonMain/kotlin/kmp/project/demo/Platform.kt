package kmp.project.demo

interface Platform {
    val name: String
    val uuid: String
}

expect fun getPlatform(): Platform