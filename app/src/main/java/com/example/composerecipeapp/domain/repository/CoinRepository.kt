package com.example.composerecipeapp.domain.repository

import com.example.composerecipeapp.data.remote.dto.CoinDetailDto
import com.example.composerecipeapp.data.remote.dto.CoinDto

interface CoinRepository {

  suspend fun getCoins() : List<CoinDto>

  suspend fun getCoinById(
    id: String
  ) : CoinDetailDto

}