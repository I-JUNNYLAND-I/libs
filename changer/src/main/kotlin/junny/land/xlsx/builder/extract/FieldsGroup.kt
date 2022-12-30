package junny.land.xlsx.builder.extract

import junny.land.xlsx.datas.FieldDatas
import junny.land.xlsx.datas.HeaderDatas

class FieldsGroup<T>(
    private val raws:Collection<T>,
    private val format: Class<T>
){
    private val headerValues=  HeaderValues(format)

    fun headers(): HeaderDatas = headerValues.extract()
    fun valueList(): Collection<FieldDatas> = raws.map { FieldValue(it).extract() }
}
