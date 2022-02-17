package com.example.composerecipeapp.presentation.coindetail.components

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontStyle.Companion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composerecipeapp.data.remote.dto.TeamMember

@Composable
fun TeamListItem(
  teamMember: TeamMember,
  modifier: Modifier = Modifier
) {

  Column(
    modifier = modifier,
    verticalArrangement = Arrangement.Center
  ) {

    Text(
      text = teamMember.name,
      style = MaterialTheme.typography.h4
    )
    Spacer(
      modifier = Modifier.height(4.dp)
    )
    Text(
      text = teamMember.position,
      style = MaterialTheme.typography.body2,
      fontStyle = FontStyle.Italic
    )

  }

}