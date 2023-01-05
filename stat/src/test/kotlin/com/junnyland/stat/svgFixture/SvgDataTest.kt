package com.junnyland.stat.svgFixture

import org.junit.jupiter.api.Test

class SvgDataTest{
    @Test
    fun svg(){
        val svg = SvgData.data(
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