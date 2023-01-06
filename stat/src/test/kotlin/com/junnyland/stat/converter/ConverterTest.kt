package com.junnyland.stat.converter

import com.junnyland.stat.svgFixture.junnylandSvg
import org.junit.jupiter.api.Test

class ConverterTest {

    @Test
    fun `converTest`() {
        val run =convert(junnylandSvg())

        println("run = ${run}")
    }
}