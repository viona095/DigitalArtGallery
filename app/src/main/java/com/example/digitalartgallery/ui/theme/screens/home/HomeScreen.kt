package com.example.digitalartgallery.ui.theme.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.ktx.R
import com.example.digitalartgallery.navigation.ADD_PRODUCT_URL
import com.example.digitalartgallery.navigation.VIEW_PRODUCTS_URL
import com.example.digitalartgallery.ui.theme.DigitalArtGalleryTheme

@Composable
fun HomeScreen(navController: NavController){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text ="Digital Art Gallery",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = {
            navController.navigate(ADD_PRODUCT_URL)
        }) {
            Text(text = "Add products")
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = { navController.navigate(VIEW_PRODUCTS_URL) }) {
            Text(text = "view products")
        }
    }
    Text(text = "Dashboard Design",
        fontSize = 40.sp,
        modifier = Modifier.padding(start = 20.dp, top = 20.dp, bottom = 20.dp),
        color = Color.White,
        fontWeight = FontWeight.Bold
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly)
        {
            Card (modifier = Modifier
                .width(150.dp)
                .height(200.dp),
                elevation = CardDefaults
                    .cardElevation(defaultElevation = 10.dp),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Green
                )

            ){
                Column {
                    Column (
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ){
                        Column (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(130.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){
                            Icon(
                                painter = painterResource(id =com.example.digitalartgallery.R.drawable.baseline_phone_android_24 ) ,
                                contentDescription = "My icon",
                                tint = Color.White
                            )
                        }
                        Column(modifier = Modifier
                            .background(Color.White)
                            .fillMaxWidth()
                            .height(70.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(text = "Mobile")
                            Divider()
                            Text(text = "New range of mobile")
                        }
                    }

                }
            }


@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    DigitalArtGalleryTheme {
        HomeScreen(rememberNavController())
        }
}
