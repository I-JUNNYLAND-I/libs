package junny.land.xlsx.builder.extract

import junny.land.xlsx.datas.FieldDatas
import java.lang.reflect.Field

class FieldValue<T>(
    private val objects: T,
    private val clazz: Class<T>
) {
    fun extract(): FieldDatas {
        val datas = clazz.declaredFields
            .map { element: Field -> toString(element) }
            .toList()
        return FieldDatas(datas)
    }

    private fun toString(element: Field): String {
        return try {
            element.isAccessible = true
            element[objects].toString()
        } catch (e: IllegalAccessException) {
            ""
        }
    }
}