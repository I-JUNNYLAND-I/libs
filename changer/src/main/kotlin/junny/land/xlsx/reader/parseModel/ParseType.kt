package junny.land.xlsx.reader.parseModel

enum class ParseType {
    XLSX, CSV, JSON, NONE;

    companion object{
        fun toType(type: String): ParseType = when(type){
            "xlsx","xls" -> XLSX
            "csv" -> CSV
            "json" -> JSON
            else -> NONE
        }
    }
}