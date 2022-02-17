package com.example.composerecipeapp.domain.model

import com.google.gson.annotations.SerializedName

data class Coin(
  val id: String,
  val isActive: Boolean,
  val isNew: Boolean,
  val name: String,
  val rank: Int,
  val symbol: String,
  val type: String
)
