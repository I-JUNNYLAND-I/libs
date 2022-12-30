package junny.land.xlsx.builder.type.xlsx

import junny.land.xlsx.datas.FieldDatas
import junny.land.xlsx.datas.HeaderDatas
import org.dhatim.fastexcel.Workbook
import org.dhatim.fastexcel.Worksheet
import java.io.OutputStream

const val DATA_START = 1

fun xlsxMake(os: OutputStream) = Workbook(os, "application", "1.0")

fun headerGenerator(sheet: Worksheet, header: HeaderDatas) {
    val sheet = sheet
        .let { sheet }
        .also { it.setAutoFilter(0, 0, 0, header.colSize) }
        .also { defaultHeader(it, header.colSize) }

    header.headers.forEachIndexed { index: Int, element: String ->
        sheet
            .also { it.width(index, 20.0) }
            .value(0, index, element)
    }
}

fun dataGenerator(sheet: Worksheet, datas: List<FieldDatas>) =
    datas.forEachIndexed { index: Int, element: FieldDatas ->
        element.data.forEachIndexed { index2: Int, fieldData: String ->
            sheet.value(index + DATA_START, index2, fieldData)
        }
    }

private fun defaultHeader(workbook: Worksheet, colSize: Int) {
    workbook.range(0, 0, 0, colSize)
        .also {
            it.style()
                .fillColor("808080")
                .verticalAlignment("center")
                .horizontalAlignment("center")
                .fontColor("FFFFFFFF")
                .bold()
                .set()
        }
}
