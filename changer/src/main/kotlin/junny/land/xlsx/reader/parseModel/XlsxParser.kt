package junny.land.xlsx.reader.parseModel

import junny.land.xlsx.reader.model.FileDatas
import org.dhatim.fastexcel.reader.ReadableWorkbook
import org.dhatim.fastexcel.reader.Row
import org.dhatim.fastexcel.reader.Sheet
import java.io.InputStream


fun firstSheet(mybook: ReadableWorkbook): Sheet = mybook
    .getSheet(0)
    .orElseThrow { Exception("Sheet not found") }

fun Sheet.headers(headerRow: Int): List<String> = this
    .read()[headerRow]
    .toListString()

fun Sheet.fields(dataRow: Int): MutableList<List<String>> = this
    .read()
    .stream()
    .filter { it.rowNum > dataRow }
    .map { it.toListString() }
    .toList()

fun Row.toListString(): List<String> = this
    .stream()
    .map { it.value.toString() }
    .toList()


class XlsxParser(
    override val type: InputStream,
    override val headerRow: Int,
    override val dataRow: Int
) : Parser {
    override fun toData(): FileDatas {
        val sheet = firstSheet(ReadableWorkbook(type))
        val headers: List<String> = sheet.headers(headerRow)
        val datas: List<List<String>> = sheet.fields(dataRow)

        return FileDatas(headers, datas)
    }
}

