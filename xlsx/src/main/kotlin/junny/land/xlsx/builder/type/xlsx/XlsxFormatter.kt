package junny.land.xlsx.builder.type.xlsx

import junny.land.xlsx.datas.FieldDatas
import junny.land.xlsx.datas.HeaderDatas
import org.apache.poi.ss.usermodel.*
import org.apache.poi.ss.usermodel.FillPatternType.SOLID_FOREGROUND
import org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER
import org.apache.poi.ss.util.CellRangeAddress
import org.apache.poi.xssf.streaming.SXSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook

const val DATA_START = 1

fun xlsxMake() = SXSSFWorkbook(XSSFWorkbook(), 500)
        .also { it.isCompressTempFiles = true }

fun headerGenerator(sheet: Sheet, header: HeaderDatas) {
    val headerRow = sheet
        .also { it.setAutoFilter(CellRangeAddress(0, 0, 0, header.colSize)) }
        .let { sheet.createRow(0) }

    header.headers.forEachIndexed { index: Int, element: String ->
        headerRow.createCell(index)
            .apply {
                cellStyle = defaultHeader(sheet.workbook)
                setCellValue(element)
                sheet.setColumnWidth(index, sheet.getColumnWidth(index) + 2048.toShort())
            }
    }
}

fun dataGenerator(sheet: Sheet, datas: List<FieldDatas>) =
    datas.forEachIndexed { index: Int, element: FieldDatas ->
        sheet.createRow(index + DATA_START)
            .also { element.placeData(it) }
    }

private fun defaultHeader(workbook: Workbook): CellStyle =
    workbook.createCellStyle()
        .apply {
            fillForegroundColor = IndexedColors.GREY_40_PERCENT.index
            fillPattern = SOLID_FOREGROUND
            alignment = CENTER
            verticalAlignment = VerticalAlignment.CENTER
            setFont(workbook.createFont().apply {
                bold = true
                color = IndexedColors.WHITE.index
            })
        }