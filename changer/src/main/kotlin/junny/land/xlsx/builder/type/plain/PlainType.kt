package junny.land.xlsx.builder.type.plain

import junny.land.xlsx.builder.type.UseType
import junny.land.xlsx.datas.FieldDatas
import junny.land.xlsx.datas.HeaderDatas
import java.nio.file.Files
import java.nio.file.Path
import java.util.*

class PlainType(
    val extension:String = ".txt"
) : UseType {
    override fun convert(headers: HeaderDatas, datas: List<FieldDatas>) : Path {
        val datas = headers.plain +"\n"+ datas.map { it.plain }.joinToString("\n")
        return Files.createTempFile("${UUID.randomUUID()}", extension)
            .also { it.toFile().writeText(datas) }
    }
}