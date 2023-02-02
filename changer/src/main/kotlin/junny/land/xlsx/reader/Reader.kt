package junny.land.xlsx.reader

import junny.land.xlsx.reader.parseModel.ParseType
import java.io.InputStream

class Reader<T>(val response: Class<T>){
    lateinit var type: InputStream
    lateinit var extension: ParseType
    fun create(): DataSelector<T> = DataSelector(Reader(response))

    companion object {
        fun <T> create(response: Class<T>): DataSelector<T> = DataSelector(Reader(response))
    }

    fun response(): Class<T> = response

    fun type(type: InputStream) {
        this.type = type
    }
    fun extension(extension: String) {
        this.extension = ParseType.toType(extension)
    }
    fun extension(extension: ParseType) {
        this.extension = extension
    }
}