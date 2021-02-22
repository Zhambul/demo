package com.example

import io.micronaut.rabbitmq.annotation.Binding
import io.micronaut.rabbitmq.annotation.RabbitClient

@RabbitClient("exd.demo.ack")
interface MyRabbitClient {

    @Binding("k.demo.ack")
    fun send(body: ByteArray)
}