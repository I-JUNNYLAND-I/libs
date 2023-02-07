package junny.land.xlsx.reader.model

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class Header(val value: String ="")