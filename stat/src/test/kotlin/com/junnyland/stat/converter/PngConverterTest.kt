package com.junnyland.stat.converter

import com.junnyland.stat.svgFixture.JunnylandSvg
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PngConverterTest{
    val converter: PngConverter = PngConverter(JunnylandSvg.data)

    @Test
    fun `converTest`(){
        val run = converter.run()

        println("run = ${run}")
    }
}