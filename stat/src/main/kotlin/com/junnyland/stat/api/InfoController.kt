package com.junnyland.stat.api

import com.junnyland.stat.service.ParserBoj
import com.junnyland.stat.config.ApiClient
import com.junnyland.stat.converter.Converter
import com.junnyland.stat.svgFixture.JunnylandSvg
import com.junnyland.stat.svgFixture.SvgData
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class InfoController(
    private val parserBoj: ParserBoj,
    private val apiClient: ApiClient
) {
    val logger = LoggerFactory.getLogger("boj")!!

    @GetMapping("/info/boj")
    fun info(@RequestParam userId: String): ResponseEntity<String> {
        if (userId.equals("{{MyId}}")) throw Exception("Please set your id")

        logger.info("userId: $userId")
        val call = parserBoj.call(userId)
        val get = apiClient.get(call.badge).orEmpty()

        val readLines = SvgData.data().lines()
            .asSequence()
            .map { it.replace("{{submit}}", call.submit) }
            .map { it.replace("{{grade}}", call.grade) }
            .map { it.replace("{{resolved}}", call.solved) }
            .map { it.replace("{{failed}}", call.fail) }
            .map { it.replace("{{my}}", userId) }
            .map { it.replace("{{src}}", Converter(get).run()) }
            .map { it.replace("{{page}}", call.myPage) }
            .joinToString("\n")

        return ResponseEntity.ok()
            .header("Content-Type", "image/svg+xml")
            .header("Cache-Control", "no-cache")
            .header("Pragma", "no-cache")
            .header("Expires", "0")
            .header("Access-Control-Allow-Origin", "*")
            .body(readLines);
    }

    @GetMapping("/junnyland")
    fun junnyland(): ResponseEntity<String> {
        SvgData.data()
        return ResponseEntity.ok()
            .header("Content-Type", "image/svg+xml")
            .header("Cache-Control", "no-cache")
            .header("Pragma", "no-cache")
            .header("Expires", "0")
            .header("Access-Control-Allow-Origin", "*")
            .body(JunnylandSvg.data);
    }
}