package junny.land.xlsx.builder.type.plain

import junny.land.xlsx.builder.type.UseType
import junny.land.xlsx.datas.FieldDatas
import junny.land.xlsx.datas.HeaderDatas
import java.nio.file.Files
import java.nio.file.Path
import java.util.*

private fun Collection<FieldDatas>.joinToString() = this.joinToString("\n") { it.plain }

class PlainType(
    val extension: String = ".txt"
) : UseType {
    override fun convert(headers: HeaderDatas, datas: Collection<FieldDatas>): Path {
        val content = "${headers.plain}\n${datas.joinToString()}"
        return Files.createTempFile("${UUID.randomUUID()}", extension)
            .also { it.toFile().writeText(content) }
    }
}
