package junny.land.xlsx.datas

import org.apache.poi.ss.usermodel.Row

data class FieldDatas(val data:List<String>) {
    val csv: String
        get() = data.joinToString(",")

    fun placeData(row:Row) {
        data.forEachIndexed { index: Int, element: String ->
            row.createCell(index).setCellValue(element)
        }
    }
}
