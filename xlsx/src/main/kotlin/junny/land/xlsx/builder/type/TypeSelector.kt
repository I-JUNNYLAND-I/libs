package junny.land.xlsx.builder.type

import junny.land.xlsx.builder.Library
import junny.land.xlsx.builder.NameSelector
import junny.land.xlsx.builder.TemporarySelector
import java.util.UUID

class TypeSelector<T>(val root: Library<T>) {
    fun type(type: ExtractType): NameSelector<T> {
        root.type(type.useType)
        root.extractType(type)
        return NameSelector(root)
    }
    fun typeSkipName(type: ExtractType): TemporarySelector<T> {
        root.type(type.useType)
        root.extractType(type)
        return NameSelector(root).name(UUID.randomUUID().toString())
    }
}

enum class ExtractType(val useType: UseType) {
    CSV(UseType.csv),
    XLSX(UseType.xlsx),
    PLAIN(UseType.plain);
}
