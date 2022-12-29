package junny.land.xlsx.builder

import junny.land.xlsx.builder.extract.FieldsGroup
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths.get
import kotlin.io.path.extension
import kotlin.io.path.outputStream

class Builder<T>(private val root: Library<T>) {

    private val group: FieldsGroup<T> = FieldsGroup(root.raws, root.clazz)

    fun build() {
        val tempPath = root.type.convert(group.headers(), group.valueList())
//        Files.copy(get("${File(root.path).name}.${tempPath.extension}"), tempPath.outputStream())
    }

    private infix fun String.with(name: String) = "${this}/${name}"
}
