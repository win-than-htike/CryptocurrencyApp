package com.example.composerecipeapp.presentation.coindetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composerecipeapp.common.Constants
import com.example.composerecipeapp.common.Resource.Error
import com.example.composerecipeapp.common.Resource.Loading
import com.example.composerecipeapp.common.Resource.Success
import com.example.composerecipeapp.domain.model.Coin
import com.example.composerecipeapp.domain.usecase.get_coin.GetCoinUseCase
import com.example.composerecipeapp.domain.usecase.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
  private val getCoinUseCase: GetCoinUseCase,
  savedStateHandle: SavedStateHandle
) : ViewModel() {

  private val _state = mutableStateOf(CoinDetailState())
  val state: State<CoinDetailState> = _state

  init {
    savedStateHandle.get<String>(Constants.COIN_ID)?.let { coinId ->
      getCoin(coinId)
    }
  }

  private fun getCoin(coinId: String) {
    getCoinUseCase(coinId).onEach { result ->
      when (result) {
        is Success -> {
          _state.value = CoinDetailState(
            coin = result.data
          )
        }
        is Error -> {
          _state.value = CoinDetailState(
            error = result.message ?: "An unexpected error occured."
          )
        }
        is Loading -> {
          _state.value = CoinDetailState(isLoading = true)
        }
      }

    }.launchIn(viewModelScope)

  }

}