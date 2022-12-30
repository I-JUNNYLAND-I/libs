package junny.land.xlsx.builder.type.csv

import junny.land.xlsx.builder.type.UseType
import junny.land.xlsx.datas.FieldDatas
import junny.land.xlsx.datas.HeaderDatas
import java.nio.file.Files
import java.nio.file.Files.createTempFile
import java.nio.file.Path
import java.util.*

class CsvType(
    val extension:String = ".csv"
) : UseType {
    override fun convert(headers: HeaderDatas, datas: List<FieldDatas>): Path {
        val content = listOf(headers.csv) + datas.map(FieldDatas::csv)
        return createTempFile("${UUID.randomUUID()}", extension)
            .also { Files.write(it, content) }
    }
}