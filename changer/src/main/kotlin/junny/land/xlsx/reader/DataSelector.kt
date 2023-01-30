package junny.land.xlsx.reader

import java.io.File
import java.io.OutputStream
import java.nio.file.Path

class DataSelector<T>(override val root: Reader<T>): ReaderSelector<T>{

    fun type(type: OutputStream): ParserSelector<T> = ParserSelector(root)
        .also { it.root.type(type) }

    fun type(type: File): ParserSelector<T> = ParserSelector(root)
        .also { it.root.type(type) }

    fun type(type: Path): ParserSelector<T> = ParserSelector(root)
        .also { it.root.type(type) }
}