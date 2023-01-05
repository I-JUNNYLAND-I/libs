package com.junnyland.stat.converter

import com.junnyland.stat.svgFixture.JunnylandSvg
import org.junit.jupiter.api.Test

class ConverterTest {
    val converter: Converter = Converter(JunnylandSvg.data)

    @Test
    fun `converTest`() {
        val run = converter.run()

        println("run = ${run}")
    }
}