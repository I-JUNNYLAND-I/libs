package junny.land.xlsx.builder.output

import java.nio.file.Path

interface OutPutType {
    fun response(path: Path): Any;
}

class RestApiType : OutPutType {
    private val myType = Type.REST
    override fun response(path: Path): Type {
        return myType
    }
}
class ServerSideType : OutPutType {
    private val myType = Type.SERVER
    override fun response(path: Path): Type {
        return myType
    }
}
class LocalType : OutPutType {
    override fun response(path: Path): Path {
        return path
    }
}
class OutputSteamType : OutPutType {
    private val myType = Type.OUTPUT_STEAM
    override fun response(path: Path): Type {
        return myType
    }
}
