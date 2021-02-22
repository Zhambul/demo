package com.example.rabbit

import com.rabbitmq.client.BuiltinExchangeType
import com.rabbitmq.client.Channel
import io.micronaut.rabbitmq.connect.ChannelInitializer
import javax.inject.Singleton

@Singleton
class ChannelPoolListener : ChannelInitializer() {

    override fun initialize(channel: Channel) {
        channel.exchangeDeclare("exd.demo.ack", BuiltinExchangeType.DIRECT, true)
        channel.queueDeclare("q.demo.ack", true, false, false, null)
        channel.queueBind("q.demo.ack", "exd.demo.ack", "k.demo.ack")
    }
}