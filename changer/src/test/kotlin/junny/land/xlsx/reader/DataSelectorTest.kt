package junny.land.xlsx.reader

import junny.land.xlsx.samples.SampleJC
import junny.land.xlsx.samples.SampleKt
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File

class DataSelectorTest {
    @Test
    fun fileTest() {
        val reader = Reader(SampleJC::class.java).create()
            .type(File("test.xlsx"))

        reader.root.type.fileValue?.let {
            assertEquals("test.xlsx", it.name)
        }
    }

    @Test
    fun test2() {
        val reader = Reader.create(SampleKt::class.java)
            .type(File("test.xlsx").outputStream())

        reader.root.type.outputStreamValue?.let {
             ByteArray(1024)
                .also { bytes -> it.write(bytes) }
                .let { String(it) }
                 .run { println(this) }
        }
    }

    @Test
    fun test3() {
        val reader = Reader.create(SampleKt::class.java)
            .type(File("test.xlsx").toPath())

        reader.root.type.pathValue?.let {
            assertEquals("test.xlsx", it.toString())
        }
    }
}