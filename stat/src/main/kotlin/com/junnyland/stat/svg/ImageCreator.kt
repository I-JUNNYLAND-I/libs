package com.junnyland.stat.svg

interface ImageCreator {
    fun with();

    class Svg : ImageCreator {
        override fun with() {
            val apiClient = ApiClient(
                "####-####-####-####-####",
                "##################", null
            )
            val wordsApi = WordsApi(apiClient)

            val doc: ByteArray = Files.readAllBytes(Paths.get("Input.txt").toAbsolutePath())
            val request = SplitDocumentOnlineRequest(
                doc, "svg", null, null, null, null, null, null, true, null
            )
            val split: SplitDocumentOnline = wordsApi.splitDocumentOnline(request)
        }
    }
}