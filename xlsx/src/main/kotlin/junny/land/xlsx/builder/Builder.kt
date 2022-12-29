package junny.land.xlsx.builder

import junny.land.xlsx.builder.extract.FieldsGroup
import kotlin.io.path.extension

class Builder<T>(private val root: Changer<T>) {

    private val group: FieldsGroup<T> = FieldsGroup(root.raws, root.clazz)

    fun <R> build(): R {
        val tempPath = root.type.convert(group.headers(), group.valueList())
        val absolutePath = "${root.path}/${root.name}.${tempPath.extension}"
        return root.output.response(tempPath,absolutePath) as R
    }

    private infix fun String.with(name: String) = "${this}/${name}"
}
