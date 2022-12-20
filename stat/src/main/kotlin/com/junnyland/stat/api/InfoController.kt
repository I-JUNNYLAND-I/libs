package com.junnyland.stat.api

import com.junnyland.stat.client.ParserInfo
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam


@Controller
@RequestMapping("/api")
class InfoController(
    private val parserInfo: ParserInfo
) {
    @GetMapping("/info")
    fun info(@RequestParam userId : String, model: Model): String {
        model.addAttribute("info", parserInfo.call(userId))
        return "info"
    }
}