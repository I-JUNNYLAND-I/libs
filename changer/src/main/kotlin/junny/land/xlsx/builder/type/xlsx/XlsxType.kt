package junny.land.xlsx.builder.type.xlsx

import junny.land.xlsx.builder.type.UseType
import junny.land.xlsx.datas.FieldDatas
import junny.land.xlsx.datas.HeaderDatas
import java.nio.file.Files
import java.nio.file.Path
import java.util.*
import kotlin.io.path.outputStream


class XlsxType(
    val extension:String = ".xlsx"
) : UseType {
    override fun convert(headers: HeaderDatas, datas: Collection<FieldDatas>) : Path {
        val tempFile = Files.createTempFile(UUID.randomUUID().toString(), extension);

        tempFile.outputStream().use {
            val workBook = xlsxMake(it)
            val sheet = workBook.newWorksheet("sheet 1");

            headerGenerator(sheet, headers)
            dataGenerator(sheet, datas)
            workBook.finish()
        }
        return tempFile
    }
}