package junny.land.xlsx.reader.model

import java.io.File
import java.io.OutputStream
import java.nio.file.Path

data class DataType(
    val type: ReaderType,
    val fileValue : File? = null,
    val outputStreamValue : OutputStream? = null,
    val pathValue : Path? = null
){
    companion object {
        fun file(file: File) = DataType(ReaderType.FILE, fileValue = file)
        fun outputStream(outputStream: OutputStream) = DataType(ReaderType.OUTPUT_STREAM, outputStreamValue = outputStream)
        fun path(path: Path) = DataType(ReaderType.PATH, pathValue = path)
    }
}

enum class ReaderType {
    FILE, OUTPUT_STREAM, PATH
}