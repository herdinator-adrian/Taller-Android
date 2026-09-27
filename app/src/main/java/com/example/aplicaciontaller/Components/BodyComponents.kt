package com.example.aplicaciontaller.Components

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aplicaciontaller.ui.theme.Red1
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.aplicaciontaller.R
import com.example.aplicaciontaller.ui.theme.ultra_l_blue

@Composable
fun CardViewHome(title: String, description: String, buttonText: String, image: Int){
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Red1
        )
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically
        ){
            Column(
                modifier = Modifier
                    .weight(0.60f)
                    .padding(16.dp)
            ){
                Text(
                    text = title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                spaceV(8)
                Text(
                    text = description,
                    fontSize = 15.sp,
                    color = Color.White
                )
                spaceV(12)
                ElevatedButton(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    )
                ){
                    Text(
                        text = buttonText,
                        color = Red1
                    )
                }
            }
            Image(
                painter = painterResource(id = image),
                contentDescription = stringResource(
                    id = R.string.frutas
                ),
                modifier = Modifier
                    .weight((0.40f))
                    .height(120.dp),
                contentScale = ContentScale.FillHeight
            )
        }
    }
}

@Composable
fun CardCategoryHome(
    category: String,
    image: Int,
    color: Color
){
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .wrapContentWidth(),
        colors = CardDefaults.cardColors(containerColor = color)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = image),
                contentDescription = stringResource(R.string.category_description),
                modifier = Modifier.height(56.dp),
                contentScale = ContentScale.Fit
            )
            spaceV(8)
            Text(
                text = category,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun spaceV(space: Int){
    Spacer(
        Modifier.height(space.dp)
    )
}
@Composable
fun spaceH(space: Int){
    Spacer(
        Modifier.width(space.dp)
    )
}

@Preview
@Composable
fun cardViewPreview(){
    /*
    CardViewHome(
        "Frutas y Verduras Frescas",
        "20% de descuento en tu primera compra",
        "Ver compra",
        0
    )*/
    CardCategoryHome(
        "Lácteos",
        R.drawable.outline_calendar_month_24,
        ultra_l_blue
    )
}