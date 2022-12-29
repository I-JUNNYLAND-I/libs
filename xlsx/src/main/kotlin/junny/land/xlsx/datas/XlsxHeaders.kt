package junny.land.xlsx.datas

data class XlsxHeaders(val headers: List<String>){
    val csv: String
        get() = headers.joinToString(",")
    fun toCsv(): String {
        return headers.joinToString(",")
    }

    fun colSize()= headers.size-1

}