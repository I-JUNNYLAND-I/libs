package com.junnyland.stat.converter

import java.util.Base64.getEncoder


fun convert(svg: String): String =
    if (svg.isBlank()) ""
    else getEncoder()
        .encode(svg.toByteArray())
        .toString(Charsets.UTF_8)
        .let { "data:image/svg+xml;base64,${it}" }