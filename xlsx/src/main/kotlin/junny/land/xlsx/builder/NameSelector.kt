package junny.land.xlsx.builder

class NameSelector<T>(private val root: Library<T>) {
    fun name(name: String): TemporarySelector<T> = TemporarySelector(root.also { it.name(name) })
}