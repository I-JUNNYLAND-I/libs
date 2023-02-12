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
                ParseType.CSV -> CsvParser(datas,headerRow,dataRow).toData()
//                ParseType.JSON -> JsonParser().toData(datas)
                else -> throw Exception("Not support type")
            }
        }
    }
}
enum class ParseType {
    XLSX, CSV, JSON, NONE;

    companion object{
        fun toType(type: String): ParseType = when(type){
            "xlsx","xls" -> XLSX
            "csv" -> CSV
            "json" -> JSON
            else -> NONE
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