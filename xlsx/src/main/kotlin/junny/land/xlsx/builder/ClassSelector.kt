package junny.land.xlsx.builder

import junny.land.xlsx.builder.type.TypeSelector

class ClassSelector<T>(private val root: Changer<T>) {
    fun classType(clazz: Class<T>): TypeSelector<T> = TypeSelector(root.also { it.clazz(clazz) })
}
