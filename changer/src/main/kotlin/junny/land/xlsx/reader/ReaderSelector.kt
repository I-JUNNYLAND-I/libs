package junny.land.xlsx.reader

interface ReaderSelector<T> {
    val root: Reader<T>
}