package junny.land.xlsx.builder

import junny.land.xlsx.builder.output.OutPutType
import junny.land.xlsx.builder.output.Type
import junny.land.xlsx.builder.type.ExtractType
import junny.land.xlsx.builder.type.UseType
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

class Changer<T>(val raws: List<T>) {
    lateinit var clazz: Class<T>
    lateinit var type: UseType
    lateinit var responseType: Type
    lateinit var output: OutPutType
    lateinit var name: String
    lateinit var path: String
    lateinit var extractType: ExtractType

    var temporary: Boolean = false;

    companion object {
        fun <T> create(raws: List<T>): ClassSelector<T> {
            val lib = Changer(raws);
            return ClassSelector(lib)
        }
    }

    fun clazz(newClazz: Class<T>) {
        this.clazz = newClazz
    }

    fun type(newType: UseType) {
        this.type = newType
    }

    fun name(newName: String) {
        this.name = newName
    }

    fun output(type: Type) {
        this.output = type.output
        this.responseType = type
    }

    fun temporary(boolean: Boolean) {
        this.temporary = boolean
    }

    fun path(path: String) {
        this.path = path
    }

    fun extractType(type: ExtractType) {
        this.extractType = type
    }

    fun path(): String {
        return this.path
    }

    fun name(): String {
        return this.name
    }

    fun type(): UseType {
        return this.type
    }

    fun output(): OutPutType {
        return this.output
    }

    fun temporary(path: String) {
        if (this.temporary) {
            if (this.responseType == Type.FILE) {
                throw IllegalArgumentException("Temporary file can not be used with File,Path")
            }
            Paths.get(path).toFile().deleteOnExit()
        }
    }
}