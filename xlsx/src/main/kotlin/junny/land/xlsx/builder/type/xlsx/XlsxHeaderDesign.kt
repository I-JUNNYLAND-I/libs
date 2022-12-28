package junny.land.xlsx.builder.type.xlsx

import org.apache.poi.ss.usermodel.*

object XlsxHeaderDesign {
    fun defaultHeader(workbook:Workbook): CellStyle =
        workbook.createCellStyle().apply {
        this.fillForegroundColor = IndexedColors.BLUE_GREY.index
        this.fillPattern = FillPatternType.SOLID_FOREGROUND
        this.alignment = HorizontalAlignment.CENTER
        this.verticalAlignment = VerticalAlignment.CENTER
        this.setFont(workbook.createFont().apply {
            this.bold = true
            this.color = IndexedColors.WHITE.index
        })
    }
}