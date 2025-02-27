package com.example.locationapp.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.locationapp.R

@Composable
fun ImgMapComponents(
    modifier: Modifier = Modifier,
    estado: String,
    cidade: String
){
    val img = painterResource(R.drawable.transferir)
    Box(
        modifier = modifier
            .height(550.dp)
            .width(280.dp)
            .padding(vertical = 30.dp),
        content = {
            Image(
                painter = img,
                contentDescription = "",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .size(500.dp)
                    .clip(RoundedCornerShape(20.dp)),
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart) // Alinha os textos no canto inferior esquerdo
                    .padding(16.dp)
                    .padding(8.dp)
            ) {
                Text(
                    text = estado,
                    color = Color.White,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = cidade,
                    color = Color.White,
                    fontSize = 15.sp
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ImgMapPreview(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ImgMapComponents(
            estado = "Ceará",
            cidade = "Juazeiro do Norte"
        )
    }

}