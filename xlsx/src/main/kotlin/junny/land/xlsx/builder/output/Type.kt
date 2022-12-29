package junny.land.xlsx.builder.output

enum class Type(val output: OutPutType) {
    REST(RestApiType()),
    SERVER(ServerSideType()),
    LOCAL(LocalType()),
    OUTPUT_STEAM(OutputSteamType())
}