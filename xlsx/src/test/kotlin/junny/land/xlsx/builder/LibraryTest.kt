package junny.land.xlsx.builder

import junny.land.xlsx.builder.output.Type
import junny.land.xlsx.builder.type.ExtractType
import junny.land.xlsx.samples.SampleKt
import org.junit.jupiter.api.Test

class LibraryTest {
    val lists = listOf(
        SampleKt("junny", 25, 1),
        SampleKt(age = 26, noAnno = 2),
        SampleKt("junny3", 27),
    )

    @Test
    fun extractTest() {
        Library.create(lists)
            .clazz(SampleKt::class.java)
            .type(ExtractType.PLAIN)
            .name("jay")
            .temporary()
            .output(Type.PATH)
            .path("/")
            .build()

    }
}