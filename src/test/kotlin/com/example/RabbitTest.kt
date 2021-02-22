package com.example

import io.micronaut.test.support.TestPropertyProvider
import org.junit.jupiter.api.TestInstance
import org.testcontainers.containers.RabbitMQContainer

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class RabbitTest: TestPropertyProvider {

    val container = RabbitMQContainer("rabbitmq:3.7.25-management-alpine").apply { this.start() }

    override fun getProperties(): MutableMap<String, String> {
        return mutableMapOf(Pair("RABBIT_PORT", container.amqpPort.toString()))
    }
}