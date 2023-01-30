package junny.land.xlsx.reader

import junny.land.xlsx.reader.model.DataType
import java.io.File
import java.io.OutputStream
import java.nio.file.Path

class Reader<T>(val response: Class<T>){
    lateinit var type: DataType
    fun create(): DataSelector<T> = DataSelector(Reader(response))

    companion object {
        fun <T> create(response: Class<T>): DataSelector<T> = DataSelector(Reader(response))
    }

    fun response(): Class<T> = response

    fun type(type: File) {
        this.type = DataType.file(type)
    }

    fun type(type: OutputStream) {
        this.type = DataType.outputStream(type)
    }

    fun type(type: Path) {
        this.type = DataType.path(type)
    }
}