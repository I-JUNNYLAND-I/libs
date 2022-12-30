package junny.land.xlsx.datas

data class HeaderDatas(val headers: List<String>){
    val csv: String get() = headers.joinToString(",")
    val colSize: Int get() = headers.size-1
    val plain:String get() = "|${headers.joinToString("|") { it.padEnd(20) }}|"
}