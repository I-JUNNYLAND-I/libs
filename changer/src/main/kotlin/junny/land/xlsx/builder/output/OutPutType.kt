package junny.land.xlsx.builder.output

import java.io.File
import java.io.OutputStream
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.extension
import kotlin.io.path.outputStream

interface OutPutType {
    fun response(temp: Path, absolutePath: String): Any;
}

class toPath : OutPutType {
    override fun response(temp: Path, absolutePath: String): Path {
        var realPath = absolutePath
        if (Files.exists(Paths.get(absolutePath))) {
            val path = Paths.get(absolutePath)
            realPath = "${
                path.fileName.toString().replace(".${path.extension}", "")
            }_${System.currentTimeMillis()}.${path.extension}"
        }
        val createFile = Files.createFile(Paths.get(realPath))
        Files.copy(temp, createFile.outputStream())
        try {
            return createFile
        } finally {
            Files.deleteIfExists(temp)
        }
    }
}

class toOutputStream : OutPutType {
    override fun response(temp: Path, absolutePath: String): OutputStream {
        try {
            return temp.outputStream()
        } finally {
            Files.deleteIfExists(temp)
        }
    }
}

class toByteArray : OutPutType {
    override fun response(temp: Path, absolutePath: String): ByteArray {
        try {
            return temp.toFile().readBytes()
        } finally {
            Files.deleteIfExists(temp)
        }
    }
}

class toFile : OutPutType {
    override fun response(temp: Path, absolutePath: String): File {
        var realPath = absolutePath
        if (Files.exists(Paths.get(absolutePath))) {
            val path = Paths.get(absolutePath)
            realPath = "${
                path.fileName.toString().replace(".${path.extension}", "")
            }_${System.currentTimeMillis()}.${path.extension}"
        }
        val createFile = Files.createFile(Paths.get(realPath))
        Files.copy(temp, createFile.outputStream())
        try {
            return createFile.toFile()
        } finally {
            Files.deleteIfExists(temp)
        }
    }
}