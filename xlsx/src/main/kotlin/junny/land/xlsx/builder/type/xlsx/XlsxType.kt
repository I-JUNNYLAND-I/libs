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
    override fun convert(headers: HeaderDatas, datas: List<FieldDatas>) : Path {
        val workBook = xlsxMake()
        val sheet = workBook.createSheet();

        headerGenerator(sheet, headers)
        dataGenerator(sheet, datas)

        val tempFile = Files.createTempFile(UUID.randomUUID().toString(), extension);
        workBook.write(tempFile.outputStream())

        return tempFile
    }
}