package junny.land.xlsx.reader

import junny.land.xlsx.samples.SampleJC
import junny.land.xlsx.samples.SampleKt
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.File

class DataSelectorTest {
    @Test
    fun fileTest() {
        val reader = Reader(SampleJC::class.java).create()
            .type(File("test.txt"))

        reader.root.type.fileValue?.let {
            assertEquals("test.txt", it.name)
        }
    }

    @Test
    fun test2() {
        val reader = Reader.create(SampleKt::class.java)
            .type(File("test.txt").outputStream())

        reader.root.type.outputStreamValue?.let {
            String(ByteArrayOutputStream().also { bytes -> it.write(bytes.toByteArray()) }.toByteArray())
                 .run { println(this) }
        }
    }

    @Test
    fun test3() {
        val reader = Reader.create(SampleKt::class.java)
            .type(File("test.txt").toPath())

        reader.root.type.pathValue?.let {
            assertEquals("test.txt", it.toString())
        }
    }
}