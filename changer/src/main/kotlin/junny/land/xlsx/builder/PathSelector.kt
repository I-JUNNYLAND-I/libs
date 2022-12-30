package junny.land.xlsx.builder

import java.nio.file.Files
import java.nio.file.Path

private fun Path.toAbsolutePathString(): String = this.toAbsolutePath().toString()

class PathSelector<T>(private val root: Changer<T>) {
    fun path(root: String): Builder<T> = Builder(this.root.also { it.path(root) })
    fun defaultPath(): Builder<T> = Files
        .createTempDirectory(DEFAULT_PATH)
        .toAbsolutePathString()
        .also { root.path(it) }
        .let{ Builder(root) }

    companion object {
        private const val DEFAULT_PATH = "junnyland"
    }
}