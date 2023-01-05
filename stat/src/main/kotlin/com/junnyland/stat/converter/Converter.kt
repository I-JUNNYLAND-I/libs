package com.junnyland.stat.converter

import java.util.Base64.getEncoder


object Converter{
    fun convert(svg: String): String = getEncoder()
        .encode(svg.toByteArray())
        .toString(Charsets.UTF_8)
        .let { "data:image/svg+xml;base64,${it}" }
}