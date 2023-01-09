package com.junnyland.stat.config

import io.netty.channel.ChannelOption
import io.netty.handler.timeout.ReadTimeoutHandler
import io.netty.handler.timeout.WriteTimeoutHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.WebClient.Builder
import reactor.netty.http.client.HttpClient
import java.time.Duration
import java.util.concurrent.TimeUnit

fun Builder.initHeaders() = this
    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
    .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)

@Configuration
class ApiConfig {
    @Bean
    fun webClient() = WebClient.builder()
        .exchangeStrategies(createStrategies())
        .clientConnector(ReactorClientHttpConnector(createHttpClient()))
        .initHeaders()
        .build()

    private fun createStrategies(): ExchangeStrategies =
        ExchangeStrategies.builder()
            .codecs { it.defaultCodecs().maxInMemorySize(MEMORY_BUFFER) }
            .build()

    private fun createHttpClient(): HttpClient = HttpClient.create()
        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, CONNECTION_TIMEOUT)
        .responseTimeout(Duration.ofMillis(READ_TIMEOUT))
        .doOnConnected { it
                .addHandlerLast(ReadTimeoutHandler(READ_TIMEOUT, TimeUnit.MILLISECONDS))
                .addHandlerLast(WriteTimeoutHandler(WRITE_TIMEOUT, TimeUnit.MILLISECONDS))
        }

    companion object {
        private val MEMORY_BUFFER = 100 * 1_024 * 1_024
        private val CONNECTION_TIMEOUT = 30_000
        private val READ_TIMEOUT = 30_000L
        private val WRITE_TIMEOUT = 30_000L
    }
}