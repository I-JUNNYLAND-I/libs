package junny.land.xlsx.builder.type.xlsx

import junny.land.xlsx.datas.XlsxHeaders
import org.apache.poi.ss.usermodel.*
import org.apache.poi.ss.usermodel.FillPatternType.SOLID_FOREGROUND
import org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER
import org.apache.poi.ss.usermodel.IndexedColors.BLUE_GREY
import org.apache.poi.ss.util.CellRangeAddress

fun headerGenerator(sheet: Sheet, header: XlsxHeaders) {
    sheet.setAutoFilter(CellRangeAddress(0, 0, 0, header.colSize()))

    header.headers.forEachIndexed { index: Int, element: String ->
        sheet.createRow(0).createCell(index)
            .apply {
                setCellValue(element)
                cellStyle = defaultHeader(sheet.workbook)
                sheet.setColumnWidth(index, sheet.getColumnWidth(index) + 2048.toShort())
            }
    }
}

private fun defaultHeader(workbook: Workbook): CellStyle =
    workbook.createCellStyle()
        .apply {
            fillForegroundColor = BLUE_GREY.index
            fillPattern = SOLID_FOREGROUND
            alignment = CENTER
            verticalAlignment = VerticalAlignment.CENTER
            setFont(workbook.createFont().apply {
                bold = true
                color = IndexedColors.WHITE.index
            })
        }