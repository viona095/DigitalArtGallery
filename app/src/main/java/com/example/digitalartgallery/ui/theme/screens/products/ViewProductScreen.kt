package com.example.digitalartgallery.ui.theme.screens.products

import com.example.digitalartgallery.ui.theme.DigitalArtGalleryTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.example.digitalartgallery.R
import ProductViewmodel
import androidx.compose.foundation.lazy.items
import com.example.digitalartgallery.model.Upload

@Composable
fun ViewProductsScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var productRepository = ProductViewmodel(navController, context)


        val emptyProductState = remember{ mutableStateOf(Upload("","","","","")) }
        var emptyProductsListState =remember { mutableStateListOf<Upload>() }

        var products = productRepository.viewUploads(emptyProductState, emptyProductsListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All products",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(20.dp))
            LazyColumn{
                items(products){
                    ProductItem(
                        name = it.name,
                        quantity = it.quantity,
                        price = it.price,
                        id = it.id,
                        navController = navController,
                        productRepository = productRepository,
                        productImage = it.imageUrl
                    )

                    Image(painter = painterResource(id = R.drawable.img), contentDescription ="my pic" )
                    Image(painter = painterResource(id = R.drawable.img_1), contentDescription ="my pic one" )
                }
            }
        }
    }
}


@Composable
fun ProductItem(name:String, quantity:String, price:String, id:String,
                navController:NavHostController, productRepository: ProductViewmodel, productImage:String) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = name)
        Text(text = quantity)
        Text(text = price)
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "MY PIC", modifier = Modifier.size(250.dp))
        Button(onClick = {
            productRepository.deleteProduct(id)
        }) {
            Text(text = "Delete")
        }
        Button(onClick = {
            //navController.navigate(ROUTE_UPDATE_PRODUCTS+"/$id")
        }) {
            Text(text = "Update")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ViewProductsScreenPreview(){
    DigitalArtGalleryTheme{
        ViewProductsScreen(rememberNavController())
    }
}