package junny.land.xlsx.builder.type

import junny.land.xlsx.builder.type.csv.CsvType
import junny.land.xlsx.datas.XlsxFields
import junny.land.xlsx.datas.XlsxHeaders
import java.nio.file.Files
import java.nio.file.Path
import java.util.*

interface UseType {
    fun extension(): String
    fun convert(headers: XlsxHeaders, datas: List<XlsxFields>): Path
}

class XlsxType : UseType {
    private val myType = ExtractType.XLSX
    override fun extension(): String {
        return ".xlsx"
    }

    override fun convert(headers: XlsxHeaders, datas: List<XlsxFields>) : Path {
        return Files.createTempFile(UUID.randomUUID().toString(), extension())
    }
}

class PlainType : UseType {
    private val myType = ExtractType.PLAIN
    override fun extension(): String {
        return ".txt"
    }

    override fun convert(headers: XlsxHeaders, datas: List<XlsxFields>) : Path {
        return Files.createTempFile(UUID.randomUUID().toString(), extension())
    }
}


