package com.example.composerecipeapp.presentation.coinlist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composerecipeapp.common.Resource.Error
import com.example.composerecipeapp.common.Resource.Loading
import com.example.composerecipeapp.common.Resource.Success
import com.example.composerecipeapp.domain.model.Coin
import com.example.composerecipeapp.domain.usecase.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
  private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

  private val _state = mutableStateOf(CoinListState())
  val state: State<CoinListState> = _state

  init {
    getCoins()
  }

  private fun getCoins() {
    getCoinsUseCase().onEach { result ->
      when (result) {
        is Success -> {
          _state.value = CoinListState(
            coins = result.data ?: emptyList()
          )
        }
        is Error -> {
          _state.value = CoinListState(
            error = result.message ?: "An unexpected error occured."
          )
        }
        is Loading -> {
          _state.value = CoinListState(isLoading = true)
        }
      }

    }.launchIn(viewModelScope)

  }

}