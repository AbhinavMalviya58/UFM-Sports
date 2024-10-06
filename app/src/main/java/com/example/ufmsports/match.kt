package com.example.ufmsports

data class match(
    val match_list: List<MatchX>,
    val next_page: Int,
    val previous_page: Any
)