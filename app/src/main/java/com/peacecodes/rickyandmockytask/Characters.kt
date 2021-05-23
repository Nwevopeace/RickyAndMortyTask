package com.peacecodes.rickyandmockytask

data class ResponseData(
    val info: Info,
    val results: List<Characters>
)

data class Info(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String
)

data class Characters(
    val name: String,
    val status: String,
    val species: String,
    val image: String
)
