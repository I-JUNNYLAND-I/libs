package junny.land.xlsx.builder

import junny.land.xlsx.builder.extract.FieldsGroup
import kotlin.io.path.extension

class Builder<T>(override val root: Changer<T>) : Selector<T> {
    private val group: FieldsGroup<T> = FieldsGroup(root.raws, root.clazz)

    fun <R> build(): R {
        val tempPath = root.type.convert(group.headers(), group.valueList())
        val absolutePath = "${root.path}/${root.name}.${tempPath.extension}"

        return root.output.response(tempPath, absolutePath)
            .also { root.temporary(absolutePath) }
            .let { it as R }
    }
}
