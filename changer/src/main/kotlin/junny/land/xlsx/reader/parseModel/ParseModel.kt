package junny.land.xlsx.reader.parseModel

import java.io.InputStream

interface Parser {
    fun toData(type: InputStream, headerRow: Int, dataRow: Int)

    companion object {
        fun toData(type: ParseType, datas: InputStream,headerRow: Int, dataRow: Int) {
            when (type) {
                ParseType.XLSX -> XlsxParser().toData(datas,headerRow,dataRow)
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