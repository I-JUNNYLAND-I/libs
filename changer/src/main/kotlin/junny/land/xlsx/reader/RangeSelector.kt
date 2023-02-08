package junny.land.xlsx.reader

class RangeSelector<T>(override val root: Reader<T>): ReaderSelector<T> {
    fun default(): Reader<T> = root
    fun select(headerRow:Int, dataRow:Int): Reader<T> = root
        .also { it.classInfo.headerRow = headerRow }
        .also { it.classInfo.dataRow = dataRow }
}