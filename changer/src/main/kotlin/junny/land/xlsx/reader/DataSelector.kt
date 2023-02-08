package junny.land.xlsx.reader

import java.io.*
import java.nio.file.Path
import kotlin.io.path.extension

class DataSelector<T>(override val root: Reader<T>): ReaderSelector<T>{

    fun data(type: InputStream): ParserSelector<T> = ParserSelector(root)
        .also { it.root.type(type) }

    fun data(type: File): ParserSelector<T> = ParserSelector(root)
        .also { root.type(FileInputStream(type)) }
        .also { it.root.extension(type.extension) }

    fun data(type: Path): ParserSelector<T> = ParserSelector(root)
        .also { root.type(FileInputStream(type.toFile())) }
        .also { it.root.extension(type.extension) }
}