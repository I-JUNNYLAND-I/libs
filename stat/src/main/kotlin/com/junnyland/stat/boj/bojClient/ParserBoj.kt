package com.junnyland.stat.boj.bojClient

import com.junnyland.stat.config.ApiClient
import com.junnyland.stat.converter.convert
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

interface ParserBoj {
    fun call(userId: String): Boj

    @Component
    class Baekjoon(
        @Value("\${baekjoon.url}") private val url: String,
        private val apiClient: ApiClient
    ) : ParserBoj {
        override fun call(userId: String) = load(url + userId)
            .let { (profile, badge) -> Boj.convert(profile, badge) }

        private fun load(info: String) = Jsoup.connect(info).get().let {
            val profile = getStaticsElement(it)
                .run { allElements.eachText()[0] }
                .split(" ")
            val badge = loadBadge(parserBadgeUrl(it))

            profile to badge
        }

        private fun getStaticsElement(get: Document) = (get.getElementById("statics")
            ?: throw IllegalStateException("NOT FOUND"))

        private fun parserBadgeUrl(document: Document): String? = document.run {
            getElementsByClass("solvedac-tier")
            attr("src")
        }.takeIf(String::isBlank)

        private fun loadBadge(badgeUrl: String?) = badgeUrl
            ?.let { apiClient.get(it).orEmpty() }
            ?.run(::convert)
            ?: ""
    }
}