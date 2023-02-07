package junny.land.xlsx.reader.parseModel

import org.dhatim.fastexcel.reader.ReadableWorkbook
import org.dhatim.fastexcel.reader.Sheet
import java.io.InputStream


fun firstSheet(mybook: ReadableWorkbook) = mybook
    .getSheet(0)
    .orElseThrow { Exception("Sheet not found") }

fun Sheet.extract() = this.read()
    .asSequence()
    .map { row ->
        row.map { cell ->
            cell.value
        }
    }

class XlsxParser : Parser {
    override fun toData(type: InputStream, headerRow: Int, dataRow: Int) {
        ReadableWorkbook(type)
            .let { firstSheet(it) }
            .extract()
            }



    }