package junny.land.xlsx.builder

import junny.land.xlsx.builder.type.TypeSelector

class ClassSelector<T>(override val root: Changer<T>): Selector<T> {
    fun classType(clazz: Class<T>): TypeSelector<T> = TypeSelector(root.also { it.clazz(clazz) })
}
