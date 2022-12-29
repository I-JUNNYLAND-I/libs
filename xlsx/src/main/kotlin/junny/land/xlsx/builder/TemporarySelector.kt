package junny.land.xlsx.builder

import junny.land.xlsx.builder.output.OutputSelector

class TemporarySelector<T>(
    private val root: Library<T>
) {
    fun temporary(): OutputSelector<T> = OutputSelector(root).also { root.temporary(true) }
    fun default(): OutputSelector<T> = OutputSelector(root).also { root.temporary(false) }
}