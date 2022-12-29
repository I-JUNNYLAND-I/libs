//package junny.land.xlsx.builder.type
//
//import junny.land.xlsx.builder.type.csv.CsvType
//import junny.land.xlsx.builder.type.xlsx.XlsxType
//import junny.land.xlsx.datas.XlsxFields
//import junny.land.xlsx.datas.XlsxHeaders
//import org.assertj.core.api.Assertions
//import org.junit.jupiter.api.Test
//import java.nio.file.Path
//
//class UseTypeTest {
//
//    @Test
//    fun `CsvExtensionTest`() {
//        val type: UseType = CsvType()
//        Assertions.assertThat(type.extension()).isEqualTo(".csv")
//    }
//
//    @Test
//    fun `XlsxExtensionTest`() {
//        val type: UseType = XlsxType()
//        Assertions.assertThat(type.extension()).isEqualTo(".xlsx")
//    }
//
//    @Test
//    fun `PlainExtensionTest`() {
//        val type: UseType = PlainType()
//        Assertions.assertThat(type.extension()).isEqualTo(".txt")
//    }
//
//    @Test
//    fun `CsvConvertTest`() {
//        val type: UseType = CsvType()
//        //a~ f
//        val headers = XlsxHeaders(listOf("a", "b", "c", "d", "e", "f"))
//        val datas: List<XlsxFields> = listOf(
//            XlsxFields(listOf("1", "2", "3", "4", "5", "6")),
//            XlsxFields(listOf("1", "2", "3", "4", "5", "6")),
//            XlsxFields(listOf("1", "2", "3", "4", "5", "6")),
//            XlsxFields(listOf("1", "2", "3", "4", "5", "6")),
//            XlsxFields(listOf("1", "2", "3", "4", "5", "6")),
//            XlsxFields(listOf("1", "2", "3", "4", "5", "6")),
//        )
//        println("path = " + type.convert(headers, datas))
//        Assertions.assertThat(type.convert(headers, datas)).isInstanceOf(Path::class.java)
//    }
//}