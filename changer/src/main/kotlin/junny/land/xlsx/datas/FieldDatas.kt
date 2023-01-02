package junny.land.xlsx.datas


data class FieldDatas(val data:List<String>) {
    val csv: String
        get() = data.joinToString(",")
    val plain:String
        get() = "|${data.joinToString("|") { it.padEnd(20) }}|"
}
