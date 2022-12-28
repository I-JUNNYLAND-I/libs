package junny.land.xlsx.builder

import junny.land.xlsx.builder.output.OutputSelector

class TemporarySelector<T>(
    private val root: Library<T>
) {
    fun isTemporary(boolean: Boolean): OutputSelector<T> {
        root.temporary(boolean)
        return OutputSelector(root)
    }
    fun default(): OutputSelector<T> {
        root.temporary(true)
        return OutputSelector(root)
    }
}