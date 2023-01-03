package com.junnyland.stat

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class StatApplication

fun main(args: Array<String>) {
	runApplication<StatApplication>(*args)
}

