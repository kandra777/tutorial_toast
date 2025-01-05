package kmp.project.demo

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class Greeting {
    private val platform = getPlatform()
    private val client = HttpClient()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }

    suspend fun ktorDoc():String{
        return client.get("https://ktor.io/docs/").bodyAsText()
    }

    fun uuid(): String {
        return platform.uuid
    }
}