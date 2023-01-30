package junny.land.xlsx.builder

import junny.land.xlsx.builder.output.Type
import junny.land.xlsx.builder.type.ExtractType
import junny.land.xlsx.samples.SampleKt
import org.junit.jupiter.api.Test
import java.io.File

class ChangerTest {
    val lists = listOf(
        SampleKt("junny", 25, 1),
        SampleKt(age = 26, noAnno = 2),
        SampleKt("junny3", 27),
    )

    @Test
    fun extractTest() {
        val build= Changer.create(lists)
            .classType(SampleKt::class.java)
            .type(ExtractType.CSV)
            .name("jay")
            .temporary()
            .output(Type.BYTE)
            .path("./")
            .build<ByteArray>()
    }
    @Test
    fun extractTest2() {
        val build= Changer.create(lists)
            .classType(SampleKt::class.java)
            .type(ExtractType.XLSX)
            .name("test")
            .defaultTemporary()
            .output(Type.FILE)
            .path("./")
            .build<File>();
    }

}