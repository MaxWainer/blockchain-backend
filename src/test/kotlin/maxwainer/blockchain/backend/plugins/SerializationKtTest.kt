package maxwainer.blockchain.backend.plugins;

import maxwainer.blockchain.backend.module

import io.ktor.client.plugins.websocket.*
import io.ktor.client.request.*
import io.ktor.client.statement.bodyAsChannel
import io.ktor.client.statement.bodyAsText
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertTrue

class SerializationKtTest {

    @Test
    fun testGetJsonKotlinxserialization() = testApplication {
        application {
            module()
        }
        client.get("/json/kotlinx-serialization").apply {
            assertTrue { bodyAsText() == """{"hello":"world"}""" }
        }
    }
}
