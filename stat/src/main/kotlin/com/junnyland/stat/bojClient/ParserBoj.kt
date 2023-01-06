package com.junnyland.stat.bojClient

import com.junnyland.stat.config.ApiClient
import com.junnyland.stat.converter.convert
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

interface ParserBoj {
    fun call(userId:String): Boj

    @Component
    class Baekjoon(
        @Value("\${baekjoon.url}") private val url: String,
        private val apiClient: ApiClient
    ) : ParserBoj {
        override fun call(userId: String): Boj {
            val info = url+userId

            val get = Jsoup.connect(info).get()

            val myData = get.getElementById("statics")!!.allElements.eachText()[0].split(" ")

            return Boj(
                grade = myData[1],
                submit = myData[11],
                solved = myData[13],
                fail = myData[18],
                badge = findBadge(get),
                myPage = info
            )
        }

        private fun findBadge(get: Document) = get.getElementsByClass("solvedac-tier").attr("src")
                .let { apiClient.get(it).orEmpty() }
                .let { convert(it) }

    }
}