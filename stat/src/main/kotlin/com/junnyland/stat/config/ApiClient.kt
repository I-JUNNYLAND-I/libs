package com.junnyland.stat.config

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono

@Component
class ApiClient(
    private val webClient: WebClient
) {
    fun get(url: String) =
        if(url.isBlank()) ""
        else runBlocking { withContext(Dispatchers.IO) {
            webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono<String>()
                .block()
        }
    }
}