package junny.land.xlsx.reader

import junny.land.xlsx.reader.model.ClassInfo
import junny.land.xlsx.reader.parseModel.ParseType
import junny.land.xlsx.reader.parseModel.ParseType.NONE
import java.io.InputStream

class Reader<T>(private val response: Class<T>) {
    internal val classInfo: ClassInfo = ClassInfo().also { it.fieldList(response) }
    internal var extension: ParseType = NONE
    internal lateinit var type: InputStream

    fun create(): DataSelector<T> = DataSelector(Reader(response))
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

    fun confirmExtension() {
        require(this.extension != NONE) { IllegalArgumentException("Extension is not valid") }
    }

    companion object {
        fun <T> create(response: Class<T>): DataSelector<T> = DataSelector(Reader(response))
    }
}