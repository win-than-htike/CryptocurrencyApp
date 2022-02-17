package com.example.composerecipeapp.domain.usecase.get_coin

import com.example.composerecipeapp.common.Resource
import com.example.composerecipeapp.data.remote.dto.toDomain
import com.example.composerecipeapp.domain.model.Coin
import com.example.composerecipeapp.domain.model.CoinDetail
import com.example.composerecipeapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
  private val repository: CoinRepository
) {

  operator fun invoke(id: String) : Flow<Resource<CoinDetail>> = flow {
    try {
      emit(Resource.Loading())
      val coin = repository.getCoinById(id).toDomain()
      emit(Resource.Success(coin))
    } catch (e: HttpException) {
      emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured."))
    } catch (e: IOException) {
      emit(Resource.Error(e.localizedMessage ?: "Couldn't reach server. Check your internet connection."))
    }
  }


}