package maxwainer.blockchain.backend

import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import maxwainer.blockchain.backend.plugins.configureHTTP
import maxwainer.blockchain.backend.plugins.configureRouting
import maxwainer.blockchain.backend.plugins.configureSecurity
import maxwainer.blockchain.backend.plugins.configureSerialization

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureHTTP()
    configureSecurity()
    configureRouting()
}
