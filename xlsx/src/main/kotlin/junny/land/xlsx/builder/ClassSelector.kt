package junny.land.xlsx.builder

import junny.land.xlsx.builder.type.TypeSelector

class ClassSelector<T>(private val root: Library<T>) {
    fun clazz(clazz: Class<T>): TypeSelector<T> = TypeSelector(root.also { clazz(clazz) })
}
