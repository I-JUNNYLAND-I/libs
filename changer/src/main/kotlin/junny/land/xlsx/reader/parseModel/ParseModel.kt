package junny.land.xlsx.reader.parseModel

import org.dhatim.fastexcel.reader.ReadableWorkbook
import java.io.InputStream

interface Parser {
    fun toData(type: InputStream)

    companion object {
        fun toData(type: ParseType, datas: InputStream) {
            when (type) {
                ParseType.XLSX -> XlsxParser().toData(datas)
                ParseType.CSV -> CsvParser().toData(datas)
                ParseType.JSON -> JsonParser().toData(datas)
                else -> throw Exception("Not support type")
            }
        }
    }
}



class CsvParser : Parser {
    override fun toData(type: InputStream) {

    }
}

class JsonParser : Parser {
    override fun toData(type: InputStream) {

    }
}