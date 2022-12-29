package junny.land.xlsx.builder.type

import junny.land.xlsx.datas.FieldDatas
import junny.land.xlsx.datas.HeaderDatas
import java.nio.file.Files
import java.nio.file.Path
import java.util.*

interface UseType {
    fun convert(headers: HeaderDatas, datas: List<FieldDatas>): Path
}






