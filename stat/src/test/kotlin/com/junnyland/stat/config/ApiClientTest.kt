package com.junnyland.stat.config

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class ApiClientTest{
    val apiClient = ApiClient(ApiConfig().webClient())

    @Test
    fun dafdf(){
        val get = apiClient.get("https://d2gd6pc034wcta.cloudfront.net/tier/2.svg")

        println("apiClient = ${get}")
    }
}