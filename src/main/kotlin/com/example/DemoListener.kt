package com.example

import io.micronaut.rabbitmq.annotation.Queue
import io.micronaut.rabbitmq.annotation.RabbitListener

@RabbitListener
open class DemoListener {

    @Queue("q.demo.ack")
    fun receive(body: String) {
        println(body)
    }
}