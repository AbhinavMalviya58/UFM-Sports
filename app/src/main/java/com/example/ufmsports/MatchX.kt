package com.example.ufmsports

data class MatchX(
    val id: String,
    val match_format: String,
    val match_offers: List<MatchOffer>,
    val metadata: Metadata,
    val name: String,
    val starts_at: Long,
    val status: String,
    val teams: Teams,
    val tournament_name: String
)