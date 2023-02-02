package junny.land.xlsx.reader

import java.io.*
import java.nio.file.Path
import kotlin.io.path.extension
import kotlin.io.path.outputStream

class DataSelector<T>(override val root: Reader<T>): ReaderSelector<T>{

    fun type(type: InputStream): ParserSelector<T> = ParserSelector(root)
        .also { it.root.type(type) }

    fun type(type: File): ParserSelector<T> = ParserSelector(root)
        .also { root.type(FileInputStream(type)) }
        .also { it.root.extension(type.extension) }

    fun type(type: Path): ParserSelector<T> = ParserSelector(root)
        .also { root.type(FileInputStream(type.toFile())) }
        .also { it.root.extension(type.extension) }
}