package junny.land.xlsx.reader.parseModel

import org.dhatim.fastexcel.reader.ReadableWorkbook
import java.io.InputStream


fun firstSheet(mybook: ReadableWorkbook) = mybook
    .getSheet(0)
    .orElseThrow { Exception("Sheet not found") }

class XlsxParser : Parser {
    override fun toData(type: InputStream) {
        ReadableWorkbook(type)
            .let { firstSheet(it) }
            .let { it.read() }
            .also {
                // 1 ~ 끝까지

                it[0].map { it.rawValue } to
            }


        sheet.read()
            .asSequence()
            .forEach { row ->
                row.forEach { cell ->
                    println(cell.value)
                }
            }
    }
}