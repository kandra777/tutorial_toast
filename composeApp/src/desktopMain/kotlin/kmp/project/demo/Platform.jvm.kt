package kmp.project.demo

import java.util.UUID

class JVMPlatform : Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
    override val uuid: String = UUID.randomUUID().toString()
}

actual fun getPlatform(): Platform = JVMPlatform()