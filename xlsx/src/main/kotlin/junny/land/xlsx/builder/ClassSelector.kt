package junny.land.xlsx.builder

import junny.land.xlsx.builder.type.TypeSelector

class ClassSelector<T>(val root: Library<T>) {
    fun clazz(clazz: Class<T>): TypeSelector<T> {
        root.clazz(clazz)
        return TypeSelector(root)
    }
}
