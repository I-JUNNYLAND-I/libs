package com.junnyland.stat.svgFixture

import com.junnyland.stat.boj.bojSvg
import org.junit.jupiter.api.Test

class SvgDataTest{
    @Test
    fun svg(){
        val svg = bojSvg(
            "test",
            "test",
            "test",
            "test",
            "test",
            "test"
        )
        println(svg)
    }
}