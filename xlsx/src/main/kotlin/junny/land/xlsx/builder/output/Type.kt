package junny.land.xlsx.builder.output

enum class Type(val output: OutPutType) {
    PATH(toPath()),
    BYTE(toByteArray()),
    FILE(toFile()),
    OUTPUT_STEAM(toOutputStream())
}