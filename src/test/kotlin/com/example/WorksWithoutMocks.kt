package com.example

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import javax.inject.Inject

@MicronautTest
class WorksWithoutMocks: RabbitTest() {

    @Inject
    lateinit var myRabbitClient: MyRabbitClient

    @Test
    fun `demoListener is called when it is not mocked`() {
        myRabbitClient.send("Hello World".toByteArray())

        Thread.sleep(1000)
    }


}