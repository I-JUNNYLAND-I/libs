package junny.land.xlsx.builder.type

import junny.land.xlsx.builder.type.csv.CsvType
import junny.land.xlsx.builder.type.plain.PlainType
import junny.land.xlsx.builder.type.xlsx.XlsxType
import junny.land.xlsx.datas.FieldDatas
import junny.land.xlsx.datas.HeaderDatas
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.nio.file.Path

class UseTypeTest {
    private val headers = HeaderDatas(listOf("a", "b", "c", "d", "e", "f"))
    private val datas: List<FieldDatas> = listOf(
        FieldDatas(listOf("1", "2", "3", "4", "5", "6")),
        FieldDatas(listOf("1", "2", "3", "4", "5", "6")),
        FieldDatas(listOf("1", "2", "3", "4", "5", "6")),
        FieldDatas(listOf("1", "2", "3", "4", "5", "6")),
        FieldDatas(listOf("1", "2", "3", "4", "5", "6")),
        FieldDatas(listOf("1", "2", "3", "4", "5", "6")),
    )

    @Test
    fun `CsvExtensionTest`() {
        Assertions.assertThat(CsvType().extension).isEqualTo(".csv")
    }

    @Test
    fun `XlsxExtensionTest`() {
        Assertions.assertThat(XlsxType().extension).isEqualTo(".xlsx")
    }

    @Test
    fun `PlainExtensionTest`() {
        Assertions.assertThat(PlainType().extension).isEqualTo(".txt")
    }

    @Test
    fun `CsvConvertTest`() {
        val type: UseType = CsvType()

        println("path = " + type.convert(headers, datas))
        Assertions.assertThat(type.convert(headers, datas)).isInstanceOf(Path::class.java)
    }

    @Test
    fun `XlsxTest`(){
        val type: UseType = XlsxType()
        val convert = type.convert(headers, datas)

        println("path = " + convert)
        Assertions.assertThat(convert).isInstanceOf(Path::class.java)
    }
}