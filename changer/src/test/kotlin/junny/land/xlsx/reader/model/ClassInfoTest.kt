package junny.land.xlsx.reader.model

import junny.land.xlsx.samples.SampleHeader
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ClassInfoTest {

    @Test
    fun findHeaderTest() {
        val classInfo = ClassInfo()
            .headerList(SampleHeader::class.java)

        println("javaClass = ${javaClass}")
    }

    @Test
    fun findHeaderIndexTest() {
        val classInfo = ClassInfo()
            .also { it.headerList(SampleHeader::class.java) }
            .also { it.mappingIndexByFieldList(listOf("data2", "data3", "data1")) }
    }

    @Test
    fun findHeaderExtract() {
        ClassInfo()
            .also { it.headerList(SampleHeader::class.java) }
            .also { it.mappingIndexByFieldList(listOf("data2", "data3", "data1")) }
            .fieldWithData(1, "test-data1")
            .apply { assertEquals(this["data3"], "test-data1") }
    }
}