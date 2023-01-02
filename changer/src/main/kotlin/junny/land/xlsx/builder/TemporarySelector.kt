package junny.land.xlsx.builder

import junny.land.xlsx.builder.output.OutputSelector

class TemporarySelector<T>(
    override val root: Changer<T>
): Selector<T> {
    fun temporary(): OutputSelector<T> = OutputSelector(root).also { root.temporary(true) }
    fun defaultTemporary(): OutputSelector<T> = OutputSelector(root).also { root.temporary(false) }
}
