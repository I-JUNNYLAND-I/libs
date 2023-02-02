package junny.land.xlsx.reader

import junny.land.xlsx.reader.parseModel.ParseType

class ParserSelector<T>(override val root: Reader<T>): ReaderSelector<T> {

    fun auto(): ResponseSelector<T> = ResponseSelector(root)
    fun type(type: ParseType) : ResponseSelector<T> = ResponseSelector(root)
        .also { it.root.extension(type) }
}