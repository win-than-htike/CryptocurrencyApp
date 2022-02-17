package com.example.composerecipeapp.data.repository

import com.example.composerecipeapp.data.remote.CoinPaprikaApi
import com.example.composerecipeapp.data.remote.dto.CoinDetailDto
import com.example.composerecipeapp.data.remote.dto.CoinDto
import com.example.composerecipeapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
  private val api: CoinPaprikaApi
) : CoinRepository {

  override suspend fun getCoins(): List<CoinDto> {
    return api.getCoins()
  }

  override suspend fun getCoinById(id: String): CoinDetailDto {
    return api.getCoin(id)
  }
}