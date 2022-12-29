package junny.land.xlsx.builder

import junny.land.xlsx.builder.output.OutputSelector

class TemporarySelector<T>(
    private val root: Library<T>
) {
    val temporary: OutputSelector<T>
        get() = OutputSelector(root).also { root.temporary(true) }
    val default: OutputSelector<T>
        get() = OutputSelector(root).also { root.temporary(false) }
}