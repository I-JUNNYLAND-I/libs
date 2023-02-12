package junny.land.xlsx.reader.parseModel

import java.io.InputStream


class CsvParser(
    override val type: InputStream,
    override val headerRow: Int,
    override val dataRow: Int
) : Parser {
}