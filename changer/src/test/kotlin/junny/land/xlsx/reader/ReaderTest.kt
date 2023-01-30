package junny.land.xlsx.reader

import junny.land.xlsx.samples.SampleJC
import junny.land.xlsx.samples.SampleKt
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReaderTest {
    @Test
    fun test() {
        val reader = Reader(SampleJC::class.java)
        assertEquals(SampleJC::class.java, reader.response())
    }

    @Test
    fun test2() {
        val reader = Reader.Companion.create(SampleKt::class.java)
        assertEquals(SampleKt::class.java, reader.root.response())
    }
}