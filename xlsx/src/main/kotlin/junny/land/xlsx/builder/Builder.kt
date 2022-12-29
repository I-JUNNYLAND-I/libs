package junny.land.xlsx.builder

import junny.land.xlsx.builder.extract.FieldsGroup
import java.io.File

class Builder<T>(private val root: Library<T>) {

    private val group: FieldsGroup<T> = FieldsGroup(root.raws, root.clazz)
    private val l = File.separator

    fun build() {
    }

    private infix fun String.with(name:String) = "${this}/${name}"
}
