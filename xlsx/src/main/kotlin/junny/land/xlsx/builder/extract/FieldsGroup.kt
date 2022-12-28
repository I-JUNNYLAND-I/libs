package junny.land.xlsx.builder.extract

import junny.land.xlsx.datas.XlsxFields
import junny.land.xlsx.datas.XlsxHeaders

class FieldsGroup<T>(
    private val raws:List<T>,
    private val format: Class<T>
){
    private val headerValues=  HeaderValues(format)

    fun headers():XlsxHeaders = headerValues.extract()
    fun valueList(): List<XlsxFields> = raws.map { FieldValue(it).extract() }
}
