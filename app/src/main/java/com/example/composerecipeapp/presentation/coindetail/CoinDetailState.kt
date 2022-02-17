package com.example.composerecipeapp.presentation.coindetail

import com.example.composerecipeapp.domain.model.Coin
import com.example.composerecipeapp.domain.model.CoinDetail

data class CoinDetailState(
  val isLoading: Boolean = false,
  val coin: CoinDetail? = null,
  val error: String = ""
)
