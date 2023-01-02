package junny.land.xlsx.builder.extract

import junny.land.xlsx.annotation.Column
import junny.land.xlsx.datas.HeaderDatas
import java.util.*

class HeaderValues<T>(
    private var clazz: Class<T>
) {

    fun extract(): HeaderDatas {
        val headerList = ArrayList<String>()
        for (field in clazz.declaredFields) {
            if (field.name == "this\$0") continue
            val name = Optional.ofNullable(field.getAnnotation(Column::class.java))
                .map(Column::value)
                .orElseGet { field.name }
            headerList.add(name)
        }
        return HeaderDatas(headerList)
    }
}