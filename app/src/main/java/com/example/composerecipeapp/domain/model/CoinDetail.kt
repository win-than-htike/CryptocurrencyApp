package com.example.composerecipeapp.domain.model

import com.example.composerecipeapp.data.remote.dto.TeamMember

data class CoinDetail(
  val coinId: String,
  val name: String,
  val description: String,
  val symbol: String,
  val rank: Int,
  val isActive: Boolean,
  val tags: List<String>,
  val teams: List<TeamMember>
)
