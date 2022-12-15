package junny.land.xlsx.annotation

import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.FIELD


@Target(FIELD)
@Retention(RUNTIME)
annotation class Column(val name: String ="")
