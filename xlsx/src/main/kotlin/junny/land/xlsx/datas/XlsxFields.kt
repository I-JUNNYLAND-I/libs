package junny.land.xlsx.datas

data class XlsxFields(val data:List<String>) {
    fun toCsv(): String = data.joinToString(",")

}
