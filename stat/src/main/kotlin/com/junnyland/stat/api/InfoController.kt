package com.junnyland.stat.api

import com.junnyland.stat.config.ApiClient
import com.junnyland.stat.converter.Converter
import com.junnyland.stat.service.ParserBoj
import com.junnyland.stat.svgFixture.JunnylandSvg
import com.junnyland.stat.svgFixture.SvgData
import com.junnyland.stat.svgFixture.SvgData.data
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

interface  InfoController {
    fun info(userId: String): ResponseEntity<String>

    @RestController
    @RequestMapping("/api")
    class InfoWebController(
        private val parserBoj: ParserBoj,
        private val apiClient: ApiClient
    ) :InfoController{
        val logger = LoggerFactory.getLogger("boj")!!

        @GetMapping("/info/boj")
        override fun info(@RequestParam userId: String): ResponseEntity<String> {
            if (userId.equals("{{MyId}}")) throw Exception("Please set your id")
            if (userId.contains("}") || userId.contains("{") ) throw Exception("Please set your id")

            logger.info("userId: $userId")
            val call = parserBoj.call(userId)

            return ResponseEntity.ok()
                .header("Content-Type", "image/svg+xml")
                .header("Cache-Control", "no-cache")
                .header("Pragma", "no-cache")
                .header("Expires", "0")
                .header("Access-Control-Allow-Origin", "*")
                .body(data(call.submit, call.grade, call.solved, call.fail, userId, Converter.convert(apiClient.get(call.badge).orEmpty())));
        }

        @GetMapping("/junnyland")
        fun junnyland(): ResponseEntity<String> {
            return ResponseEntity.ok()
                .header("Content-Type", "image/svg+xml")
                .header("Cache-Control", "no-cache")
                .header("Pragma", "no-cache")
                .header("Expires", "0")
                .header("Access-Control-Allow-Origin", "*")
                .body(JunnylandSvg.data);
        }
    }
}
