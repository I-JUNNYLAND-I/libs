package com.junnyland.stat.client

import org.jsoup.Jsoup
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

interface ParserInfo {
    fun call(userId:String): Baekjoon.Result

    @Component
    class Baekjoon(
        @Value("\${baekjoon.url}") private val url: String) : ParserInfo{
        override fun call(userId: String): Result {
            val info = url+userId

            val get = Jsoup.connect(info).get()

            val myData = get.getElementById("statics")!!.allElements.eachText().get(0).split(" ")
            val myBadge = get.getElementsByClass("solvedac-tier").attr("src")

            return Result(
                grade = myData[1],
                submit = myData[11],
                solved = myData[4],
                fail = myData[9],
                badge = myBadge,
                myPage = info
            )
        }
        data class Result(
            val grade: String,
            val submit: String,
            val solved: String,
            val fail: String,
            val badge: String,
            val myPage: String,
        )

    }
}