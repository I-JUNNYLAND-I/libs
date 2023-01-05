package com.junnyland.stat.converter

import com.junnyland.stat.svgFixture.JunnylandSvg
import org.junit.jupiter.api.Test

class ConverterTest {

    @Test
    fun `converTest`() {
        val run =Converter.convert(JunnylandSvg.data)

        println("run = ${run}")
    }
}