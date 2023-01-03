package com.junnyland.stat.converter

import org.apache.batik.transcoder.TranscoderInput
import org.apache.batik.transcoder.TranscoderOutput
import org.apache.batik.transcoder.image.PNGTranscoder
import org.springframework.core.ParameterizedTypeReference
import org.springframework.core.ParameterizedTypeReference.forType
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.toEntity
import java.io.FileOutputStream
import java.nio.file.Files
import java.util.*
import kotlin.io.path.inputStream

@Component
class PngConverter(private val webClient: WebClient) {
    fun run(svg:String): String {
        val svgPath= Files.createTempFile("${UUID.randomUUID()}", ".svg")!!
        val defaultPath= Files.createTempFile("${UUID.randomUUID()}", ".png")!!

        val block: ResponseEntity<Void>? = webClient.get()
            .uri(svg)
            .accept(MediaType.APPLICATION_XML)
            .exchangeToMono { it.toEntity<Void>(forType<Void>(Void::class.java)) }
            .block()
        FileOutputStream(svgPath.toFile())
            .also { it.write(svg.toByteArray()) }
            .also { it.close() }
        FileOutputStream(defaultPath.toFile())
            .use { TranscoderOutput(it)
                .also { PNGTranscoder().transcode(TranscoderInput(svgPath.inputStream()), it) }
                .also { it.outputStream.flush() }
            }

        return Base64.getEncoder().encodeToString(defaultPath.toFile().readBytes())
            ?.let { "data:image/png;base64,$it" }
            ?: ""
    }
}