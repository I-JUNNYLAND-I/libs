package junny.land.xlsx.builder.type

enum class ExtractType(val useType: UseType) {
    CSV(UseType.csv),
    XLSX(UseType.xlsx),
    PLAIN(UseType.plain);
}