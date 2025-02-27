package com.example.locationapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.locationapp.ui.theme.LocationAppTheme

@Composable
fun CardComponents(
    modifier: Modifier = Modifier,
    cep: String,
    rua: String,
    bairro: String,
    regiao: String,
    ddd: String
){

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(12.dp))

    ){
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement =Arrangement.spacedBy(5.dp)
        ){
            ItemCard(campo = "Cep", valor = cep)
            ItemCard(campo = "Rua", valor = rua)
            ItemCard(campo = "Bairro", valor = bairro)
            ItemCard(campo = "Região", valor = regiao)
            ItemCard(campo = "DDD", valor = ddd)
        }
    }
}

@Composable
fun ItemCard(
    modifier: Modifier = Modifier,
    valor: String,
    campo: String
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = campo,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = valor,
            fontSize = 18.sp
        )
    }
}

@Preview
@Composable
fun CardPreview(){
    LocationAppTheme {
        CardComponents(
            cep = "",
            rua = "",
            bairro = "",
            regiao = "",
            ddd = ""
        )
    }
}