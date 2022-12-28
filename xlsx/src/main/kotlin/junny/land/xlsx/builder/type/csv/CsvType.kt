package junny.land.xlsx.builder.type.csv

import junny.land.xlsx.builder.type.ExtractType
import junny.land.xlsx.builder.type.UseType
import junny.land.xlsx.datas.XlsxFields
import junny.land.xlsx.datas.XlsxHeaders
import java.nio.file.Files
import java.nio.file.Path
import java.util.*

class CsvType : UseType {
    private val myType = ExtractType.CSV
    override fun extension(): String {
        return ".csv"
    }

    override fun convert(headers: XlsxHeaders, datas: List<XlsxFields>): Path {
        val content = mutableListOf<String>()

        content.add(headers.toCsv())
        datas.forEach {
            content.add(it.toCsv())
        }
        val file = Files.createTempFile("${UUID.randomUUID()}", ".csv")
        Files.write(file, content)

        return file
    }
}