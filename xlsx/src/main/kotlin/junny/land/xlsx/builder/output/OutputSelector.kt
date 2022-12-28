package junny.land.xlsx.builder.output

import junny.land.xlsx.builder.Library
import junny.land.xlsx.builder.PathSelector
import org.springframework.http.ResponseEntity
import org.springframework.web.servlet.ModelAndView
import java.nio.file.Path


class OutputSelector<T>(private val root: Library<T>) {
    fun output(type: Type): PathSelector<T> {
        root.output(type)
        return PathSelector(root)
    }
}

enum class Type(val output: OutPutType, val reponse: Any) {
    REST(OutPutType.restApi, ResponseEntity::class.java),
    SERVER(OutPutType.serverSide, ModelAndView::class.java),
    LOCAL(OutPutType.local, Path::class.java);
}