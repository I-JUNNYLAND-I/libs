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
import reactor.netty.http.client.HttpClient
import java.time.Duration
import java.util.concurrent.TimeUnit

@Configuration
class ApiConfig {
    private val MEMORY_BUFFER = 100 * 1024 * 1024

    private val CONNECTION_TIMEOUT = 30000
    private val READ_TIMEOUT = 30000
    private val WRITE_TIMEOUT = 30000

    @Bean
    fun webClient(): WebClient {
        val strategies = ExchangeStrategies.builder()
            .codecs { it.defaultCodecs().maxInMemorySize(MEMORY_BUFFER) }
            .build()

        val httpClient = HttpClient.create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, CONNECTION_TIMEOUT)
            .responseTimeout(Duration.ofMillis(READ_TIMEOUT.toLong()))
            .doOnConnected { it
                .addHandlerLast(ReadTimeoutHandler(READ_TIMEOUT.toLong(), TimeUnit.MILLISECONDS))
                .addHandlerLast(WriteTimeoutHandler(WRITE_TIMEOUT.toLong(), TimeUnit.MILLISECONDS))
            }
        return WebClient.builder()
            .exchangeStrategies(strategies)
            .clientConnector(ReactorClientHttpConnector(httpClient))
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
            .build()
    }
}