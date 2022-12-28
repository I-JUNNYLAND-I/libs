package junny.land.xlsx.builder.output

import org.springframework.http.ResponseEntity
import org.springframework.web.servlet.ModelAndView
import java.nio.file.Path

enum class Type(val output: OutPutType, val response: Any) {
    REST(OutPutType.restApi, ResponseEntity::class.java),
    SERVER(OutPutType.serverSide, ModelAndView::class.java),
    LOCAL(OutPutType.local, Path::class.java);
}