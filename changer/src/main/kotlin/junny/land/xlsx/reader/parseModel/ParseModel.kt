package junny.land.xlsx.reader.parseModel

import junny.land.xlsx.reader.model.FileDatas
import java.io.InputStream

interface Parser {
    val type: InputStream
    val headerRow: Int
    val dataRow: Int

    fun toData(): FileDatas

    companion object {
        fun toData(type: ParseType, datas: InputStream,headerRow: Int, dataRow: Int) {
            when (type) {
                ParseType.XLSX -> XlsxParser(datas,headerRow,dataRow).toData()
//                ParseType.CSV -> CsvParser().toData(datas)
//                ParseType.JSON -> JsonParser().toData(datas)
                else -> throw Exception("Not support type")
            }
        }
    }
}


//class CsvParser : Parser {
//    override fun toData(type: InputStream, headerRow: Int, dataRow: Int) {
//
//    }
//}
//
//class JsonParser : Parser {
//    override fun toData(type: InputStream, headerRow: Int, dataRow: Int) {
//
//    }
//}