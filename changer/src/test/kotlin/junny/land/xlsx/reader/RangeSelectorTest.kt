package junny.land.xlsx.reader

import junny.land.xlsx.samples.SampleJC
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class RangeSelectorTest {
    @Test
    fun `auto type`() {
        Reader.create(SampleJC::class.java)
            .data(File("test.xlsx"))
            .auto()
            .default()
            .classInfo
            .also { assertEquals(it.dataRow, 1) }
            .also { assertEquals(it.headerRow, 0) }
    }

    @Test
    fun `custom type`() {
        Reader.create(SampleJC::class.java)
            .data(File("test.xlsx"))
            .auto()
            .select(2, 3)
            .classInfo
            .also { assertEquals(it.headerRow, 2) }
            .also { assertEquals(it.dataRow, 3) }
    }
}