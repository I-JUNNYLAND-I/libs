package junny.land.xlsx.datas

data class XlsxHeaders(val headers: List<String>){
    fun toCsv(): String {
        return headers.joinToString(",")
    }
}