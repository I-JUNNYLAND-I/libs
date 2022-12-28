package junny.land.xlsx.builder.type.xlsx

import junny.land.xlsx.annotation.Column
import org.apache.poi.ss.usermodel.*
import org.apache.poi.ss.usermodel.IndexedColors.BLUE_GREY
import org.apache.poi.ss.util.CellRangeAddress
import java.lang.reflect.Field

class BookMaker(val workbook: Workbook) {
    private fun getColumnName(field: Field): String? {
        val headerName: String = field.getAnnotation(Column::class.java).name
        return if (headerName == "") field.name else headerName
    }

    private fun defaultHeader(): CellStyle = workbook.createCellStyle().apply {
            this.fillForegroundColor = BLUE_GREY.index
            this.fillPattern = FillPatternType.SOLID_FOREGROUND
            this.alignment = HorizontalAlignment.CENTER
            this.verticalAlignment = VerticalAlignment.CENTER
            this.setFont(workbook.createFont().apply {
                this.bold = true
                this.color = IndexedColors.WHITE.index
            })
        }

    private fun createHeader(sheet: Sheet, cellList: List<String>, rowNum: Int) {
        val cellStyle = defaultHeader()
        val size = cellList.size
        sheet.setAutoFilter(CellRangeAddress(0, 0, 0, size - 1))
        val row = sheet.createRow(rowNum)
        for (i in 0 until size) {
            sheet.setColumnWidth(i, sheet.getColumnWidth(i) + 2048.toShort())
            val cell = row.createCell(i)
            cell.setCellValue(cellList[i])
            cell.cellStyle = cellStyle
        }
    }
}