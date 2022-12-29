package junny.land.xlsx.datas

data class XlsxFields(val data:List<String>) {
    val csv: String
        get() = data.joinToString(",")

}
