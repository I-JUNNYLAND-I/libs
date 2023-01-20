package com.junnyland.stat.instagram.application.adapter.`in`

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class InstaController {

    @GetMapping("/insta/info/{userId}")
    fun instaInfo(@PathVariable userId: String) {

    }
}