package junny.land.xlsx.reader

import junny.land.xlsx.reader.parseModel.ParseType
import junny.land.xlsx.samples.SampleJC
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.File
import java.lang.IllegalArgumentException

@Disabled
class ParserSelectorTest {

    @Test
    fun `auto type`() = Reader.create(SampleJC::class.java)
        .type(File("test.xlsx"))
        .auto()
        .root
        .extension
        .let { assertEquals(it, ParseType.XLSX) }

    @Test
    fun `type enum`() = Reader.create(SampleJC::class.java)
        .type(File("test.xlsx"))
        .type(ParseType.CSV)
        .root
        .extension
        .let { assertEquals(it, ParseType.CSV) }

    @Test
    fun `type string`() = Reader.create(SampleJC::class.java)
        .type(File("test.xlsx"))
        .type("csv")
        .root
        .extension
        .let { assertEquals(it, ParseType.CSV) }

    @Test
    fun `illegal error`() {
        assertThrows<IllegalArgumentException> {
            Reader.create(SampleJC::class.java)
                .type(File("test.xlsx"))
                .type("csv2")
        }
    }
    @Test
    fun `none error`() {
        assertThrows<IllegalArgumentException> {
            Reader.create(String::class.java)
                .type(File("test"))
                .auto()
        }
    }
}