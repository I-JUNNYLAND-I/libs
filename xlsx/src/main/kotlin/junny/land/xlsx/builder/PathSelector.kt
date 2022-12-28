package junny.land.xlsx.builder

import java.nio.file.Files

class PathSelector<T>(val root: Library<T>) {
    fun path(path: String): Builder<T> {
        root.path(path)
        return Builder(root)
    }
    fun defaultPath(): Builder<T> {
        val path = Files.createTempDirectory("junnyland").toAbsolutePath().toString()
        root.path(path)
        return Builder(root)
    }
}