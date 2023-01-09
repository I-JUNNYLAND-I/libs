package com.junnyland.stat.converter

import java.util.Base64.getEncoder


fun convert(svg: String) = getEncoder()
        .encode(svg.toByteArray())
        .toString(Charsets.UTF_8)
        .run(::toConvert)

private fun toConvert(it: String) = "data:image/svg+xml;base64,${it}"