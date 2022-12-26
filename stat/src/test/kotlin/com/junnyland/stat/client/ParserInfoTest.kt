package com.junnyland.stat.client

import org.junit.jupiter.api.Test

class ParserInfoTest{

    @Test
    fun `test`(){
        val baekjoon = ParserInfo.Baekjoon("https://www.acmicpc.net/user/")
        val call = baekjoon.call("wjwan0")

        println("call = ${call}")
    }
}
