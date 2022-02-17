package com.example.composerecipeapp.presentation.coinlist

import com.example.composerecipeapp.domain.model.Coin

data class CoinListState(
  val isLoading: Boolean = false,
  val coins: List<Coin> = emptyList(),
  val error: String = ""
)
