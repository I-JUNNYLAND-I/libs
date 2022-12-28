package junny.land.xlsx.builder.type

interface UseType {
    fun extension(): String
    companion object{
        val xlsx : UseType = XlsxType()
        val plain : UseType = PlainType()
        val csv : UseType = CsvType()
    }
}

private class XlsxType : UseType {
    private val myType = ExtractType.XLSX
    override fun extension(): String {
        return ".xlsx"
    }
}
private class PlainType : UseType {
    private val myType = ExtractType.PLAIN
    override fun extension(): String {
        return ".txt"
    }
}
private class CsvType : UseType {
    private val myType = ExtractType.CSV
    override fun extension(): String {
        return ".csv"
    }
}
