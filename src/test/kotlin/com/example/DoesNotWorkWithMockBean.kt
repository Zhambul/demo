package com.example
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import io.mockk.*
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class DoesNotWorkWithMockBean: RabbitTest() {

    @Inject
    lateinit var demoListener: DemoListener

    @Inject
    lateinit var myRabbitClient: MyRabbitClient

    @MockBean(DemoListener::class)
    fun demoScheduled(): DemoListener = mockk()

    @Test
    fun `mocked rabbitListener must be called`() {
        every { demoListener.receive(any()) } just Runs

        myRabbitClient.send("HelloWorld".toByteArray())

        Thread.sleep(1000)

        verify { demoListener.receive(any()) }
    }
}
