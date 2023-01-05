package com.junnyland.stat.service

import org.junit.jupiter.api.Test

class ParserBojTest{

    @Test
    fun `test`(){
        val baekjoon = ParserBoj.Baekjoon("https://www.acmicpc.net/user/")
        val call = baekjoon.call("wjwan0")

        println("call = ${call}")
    }
}
