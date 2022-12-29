package junny.land.xlsx.builder.extract

import junny.land.xlsx.datas.FieldDatas
import junny.land.xlsx.datas.HeaderDatas

class FieldsGroup<T>(
    private val raws:List<T>,
    private val format: Class<T>
){
    private val headerValues=  HeaderValues(format)

    fun headers(): HeaderDatas = headerValues.extract()
    fun valueList(): List<FieldDatas> = raws.map { FieldValue(it).extract() }
}
