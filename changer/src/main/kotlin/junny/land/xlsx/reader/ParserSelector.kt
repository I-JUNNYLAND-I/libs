package junny.land.xlsx.reader

import junny.land.xlsx.reader.parseModel.ParseType

class ParserSelector<T>(override val root: Reader<T>): ReaderSelector<T> {

    fun auto(): ResponseSelector<T> = ResponseSelector(root)
        .also { it.root.confirmExtension() }

    fun type(type: ParseType) : ResponseSelector<T> = ResponseSelector(root)
        .also { it.root.extension(type) }
        .also { it.root.confirmExtension() }

    fun type(type: String) : ResponseSelector<T> = ResponseSelector(root)
        .also { it.root.extension(type) }
        .also { it.root.confirmExtension() }
}