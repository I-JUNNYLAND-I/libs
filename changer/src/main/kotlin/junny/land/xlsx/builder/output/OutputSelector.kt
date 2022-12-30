package junny.land.xlsx.builder.output

import junny.land.xlsx.builder.Changer
import junny.land.xlsx.builder.PathSelector

class OutputSelector<T>(private val root: Changer<T>) {
    fun output (type: Type): PathSelector<T> {
        root.output(type)
        return PathSelector(root)
    }
}

