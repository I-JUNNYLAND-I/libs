package junny.land.xlsx.reader.model

data class ClassInfo(
    var headerRow: Int = 0,
    var dataRow: Int = 1,
) {
    private var fieldList: MutableList<String> = mutableListOf()

    fun fieldList(response: Class<*>) = response
        .declaredFields
        .forEach {
            fieldList.add(it.name)
        }
}

