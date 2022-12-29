package junny.land.xlsx.builder.type.xlsx

import junny.land.xlsx.builder.type.ExtractType
import junny.land.xlsx.builder.type.UseType
import junny.land.xlsx.datas.XlsxFields
import junny.land.xlsx.datas.XlsxHeaders
import java.nio.file.Files
import java.nio.file.Path
import java.util.*

class XlsxType(
    val extension:String = ".xlsx"
) : UseType {
    private val myType = ExtractType.XLSX
    override fun convert(headers: XlsxHeaders, datas: List<XlsxFields>) : Path {
        return Files.createTempFile(UUID.randomUUID().toString(), extension)
    }
}