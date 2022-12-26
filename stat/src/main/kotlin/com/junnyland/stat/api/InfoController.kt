package com.junnyland.stat.api

import com.junnyland.stat.client.ParserInfo
import com.junnyland.stat.svgFixture.SvgData
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class InfoController(
    private val parserInfo: ParserInfo
) {
    @GetMapping("/info")
    fun info(@RequestParam userId: String): ResponseEntity<String> {

        val call = parserInfo.call(userId)
        val readLines = SvgData().data.lines()
            .asSequence()
            .map { it.replace("{{submit}}", call.submit) }
            .map { it.replace("{{resolved}}", call.solved) }
            .map { it.replace("{{failed}}", call.fail) }
            .map { it.replace("{{my}}", userId) }
            .joinToString("\n")

        return ResponseEntity.ok()
            .header("Content-Type", "image/svg+xml")
            .header("Connection", "keep-alive")
            .body(readLines);
    }
}