package junny.land.xlsx.builder

class NameSelector<T>(override val root: Changer<T>): Selector<T> {
    fun name(name: String): TemporarySelector<T> = TemporarySelector(root.also { it.name(name) })
}
