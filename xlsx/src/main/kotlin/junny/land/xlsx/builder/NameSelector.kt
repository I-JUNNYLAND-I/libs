package junny.land.xlsx.builder

class NameSelector<T>(private val root: Library<T>) {
    fun name(name: String): TemporarySelector<T> {
        root.name(name)
        return TemporarySelector(root)
    }
}