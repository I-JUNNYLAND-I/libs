package com.junnyland.stat.instagram.application.adapter.`in`

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class InstaController {

    @GetMapping("/insta/info/")
    fun instaInfo(@RequestParam userId: String) {

    }
}