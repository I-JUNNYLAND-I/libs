package junny.land.xlsx.builder

import junny.land.xlsx.builder.extract.FieldsGroup
import java.io.File

class Builder<T>(private val root: Library<T>) {

    private val group: FieldsGroup<T> = FieldsGroup(root.raws, root.clazz)
    private val l = File.separator

    fun build() {
        val path = root.path() + l + root.name() + root.type().extension()
        root.output().response(path)
    }

}
