package junny.land.xlsx.extract

import junny.land.xlsx.builder.extract.FieldValue
import junny.land.xlsx.builder.extract.FieldsGroup
import junny.land.xlsx.builder.extract.HeaderValues
import junny.land.xlsx.samples.SampleJC
import junny.land.xlsx.samples.SampleKt
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class FieldsGroupTest {
    val lists = listOf(
        SampleKt("junny", 25, 1),
        SampleKt(age = 26, noAnno = 2),
        SampleKt("junny3", 27),
    )

    @Test
    fun `toListTest`() {
        val valueList = FieldsGroup(lists, SampleKt::class.java).valueList()

        Assertions.assertThat(valueList).size().isEqualTo(3)
    }

    @Test
    fun `extractHeaderKTTest`() {
        val headers = SampleKt("junny", 25, 1)
        val extract = HeaderValues(headers::class.java).extract()

        Assertions.assertThat(extract.headers).containsExactly("annoName", "annoAge", "noAnno")
    }

    @Test
    fun `extractHeaderJCTest`() {
        val data = SampleJC("junny", 25, 1)
        val extract = HeaderValues(data::class.java).extract()

        Assertions.assertThat(extract.headers).containsExactly("annoName", "annoAge", "noAnno")
    }


    @Test
    fun `extractFieldKTTest`() {
        val data = SampleKt("junny", 25, 1)
        val extract = FieldValue(data,SampleKt::class.java).extract()

        Assertions.assertThat(extract.data).containsExactly("junny", "25", "1")
    }

    @Test
    fun `extractFieldJCTest`() {
        val data = SampleJC("junny", 25, 1)
        val extract = FieldValue(data,SampleJC::class.java).extract()

        Assertions.assertThat(extract.data)
            .containsExactly("junny", "25", "1")
    }

}
