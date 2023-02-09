package junny.land.xlsx.reader.model

data class ClassInfo(
    var headerRow: Int = 0,
    var dataRow: Int = 1,
) {
    private var headerList: MutableList<String> = mutableListOf()
    private var mappingIndexByFieldList: MutableList<Int> = mutableListOf()

    fun headerList(clazz: Class<*>) = clazz.declaredFields
        .forEach { element -> element.annotations
                .first { it is Header }
                .also { headerList.add((it as Header).value) }
        }

    // 엑셀 헤더에 선언된 값 순서와 맞춰주기 위함
    fun mappingIndexByFieldList(fields: List<String>) = fields
        .forEach { element ->
            mappingIndexByFieldList.add(headerList.indexOf(element))
        }


    fun fieldWithData(index: Int, data: String) =
        mapOf(headerList[mappingIndexByFieldList[index]] to data)

}

