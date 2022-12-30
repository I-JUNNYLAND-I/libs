package junny.land.xlsx.builder

import junny.land.xlsx.builder.extract.FieldsGroup
import junny.land.xlsx.builder.output.Type
import kotlin.io.path.extension

class Builder<T>(val root: Changer<T>) {

    val group: FieldsGroup<T> = FieldsGroup(root.raws, root.clazz)

    inline fun <reified R> build(): R {
            val tempPath = root.type.convert(group.headers(), group.valueList())
            val absolutePath = "${root.path}/${root.name}.${tempPath.extension}"

            val result =  root.output.response(tempPath,absolutePath)

        if (result !is R){
            val message =when(root.responseType){
                Type.BYTE -> "Please use ByteArray"
                Type.FILE -> "Please use File"
                Type.PATH -> "Please use PATHS"
                Type.OUTPUT_STEAM -> "Please use OutputStream"
            }
            throw IllegalArgumentException(message)
        }
        root.temporary(absolutePath)
        return result
    }
}
