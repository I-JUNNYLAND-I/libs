package junny.land.xlsx.reader.model

import junny.land.xlsx.samples.SampleHeader
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ClassInfoTest {

    @Test
    fun findHeaderTest() {
        val classInfo = ClassInfo()
            .fieldList(SampleHeader::class.java)

        println("javaClass = ${javaClass}")
    }

    @Test
    fun findHeaderIndexTest() {
    }

    @Test
    fun findHeaderExtract() {
    }
}