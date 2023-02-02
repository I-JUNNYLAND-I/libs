package junny.land.xlsx.reader

import junny.land.xlsx.samples.SampleJC
import junny.land.xlsx.samples.SampleKt
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File
import java.io.FileInputStream

class DataSelectorTest {

    @Test
    fun fileTest() = Reader(SampleJC::class.java)
        .create()
        .type(File("test.xlsx"))
        .root
        .type
        .let { assertEquals("", String(it.readBytes(), Charsets.UTF_8)) }

    @Test
    fun test2() = Reader
        .create(SampleKt::class.java)
        .type(FileInputStream(File("test.xlsx")))
        .root
        .type
        .let { assertEquals("", String(it.readBytes(), Charsets.UTF_8)) }

    @Test
    fun test3() = Reader.create(SampleKt::class.java)
        .type(File("test.xlsx").toPath())
        .root
        .type
        .let { assertEquals("", String(it.readBytes(), Charsets.UTF_8)) }
}
