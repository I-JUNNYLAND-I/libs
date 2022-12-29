package junny.land.xlsx.builder.output

import java.io.OutputStream
import java.nio.file.Path
import kotlin.io.path.outputStream

interface OutPutType {
    fun response(path: Path): Any;
}

class toPath : OutPutType {
    override fun response(path: Path): Path {
        return path
    }
}

class toOutputStream : OutPutType {
    override fun response(path: Path): OutputStream {
        return path.outputStream()
    }
}

class toByteArray : OutPutType {
    override fun response(path: Path): ByteArray {
        return path.toFile().readBytes()
    }
}

class toFile : OutPutType {
    override fun response(path: Path): ByteArray {
        return path.toFile().readBytes()
    }
}