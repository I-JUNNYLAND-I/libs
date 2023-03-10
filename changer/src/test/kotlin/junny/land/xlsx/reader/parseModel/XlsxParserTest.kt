package junny.land.xlsx.reader.parseModel

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File

class XlsxParserTest {

    @Test
    fun toData() {
        val toData = XlsxParser(
            File("test.xlsx").inputStream(),
            0,
            1
        ).toData()

        assertTrue(toData.datas.isNotEmpty())
        assertTrue(toData.header.isNotEmpty())
    }
}