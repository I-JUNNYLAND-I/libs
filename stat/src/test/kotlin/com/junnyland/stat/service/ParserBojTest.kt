package com.junnyland.stat.service

import com.junnyland.stat.boj.bojClient.ParserBoj
import com.junnyland.stat.config.ApiClient
import com.junnyland.stat.config.ApiConfig
import org.junit.jupiter.api.Test

class ParserBojTest{

    @Test
    fun `test`(){
        val baekjoon = ParserBoj.Baekjoon("https://www.acmicpc.net/user/", ApiClient(ApiConfig().webClient()))
        val call = baekjoon.call("wjwan0")

        println("call = $call")
    }
}
