package junny.land.xlsx.builder.output

import java.nio.file.Files
import java.nio.file.Path

interface OutPutType {
    fun response(path: String) {

    }
    companion object{
        val restApi : OutPutType = RestApiType()
        val serverSide : OutPutType = ServerSideType()
        val local : OutPutType = LocalType()
    }
}

private class RestApiType : OutPutType {
    private val myType = Type.REST
    override fun response(path: String) {

    }
}
private class ServerSideType : OutPutType {
    private val myType = Type.SERVER
    override fun response(path: String) {

    }
}
private class LocalType : OutPutType {
    private val myType = Type.LOCAL
    override fun response(path: String) {
        val file = Files.createFile(Path.of(path))
        println("myType = ${myType}")
    }
}
