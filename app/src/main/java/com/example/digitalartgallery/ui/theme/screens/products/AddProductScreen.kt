package com.example.digitalartgallery.ui.theme.screens.products

import com.example.digitalartgallery.ui.theme.DigitalArtGalleryTheme
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ProductViewmodel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddproductsScreen(navController: NavController){
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
        var productName by remember { mutableStateOf("") }
        var productQuantity by remember { mutableStateOf("") }
        var productPrice by remember { mutableStateOf("") }
        val context = LocalContext.current
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = productName,
            onValueChange = { productName = it },
            label = { Text(text = "Product name *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = productQuantity,
            onValueChange = { productQuantity = it },
            label = { Text(text = "Product quantity *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = productPrice,
            onValueChange = { productPrice = it },
            label = { Text(text = "Product price *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))



//---------------------IMAGE PICKER START-----------------------------------//
        var modifier= Modifier
        ImagePicker(modifier,context, navController, productName.trim(), productQuantity.trim(), productPrice.trim())

//---------------------IMAGE PICKER END-----------------------------------//




        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = {  }) {
            Text(text = "Add products")
        }

    }
}

@Composable
fun ImagePicker(
    modifier: Modifier = Modifier, context: Context,
    navController: NavController, name:String, quantity:String, price:String) {
    var hasImage by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            hasImage = uri != null
            imageUri = uri
        }
    )

    Column(modifier = modifier,) {
        if (hasImage && imageUri != null) {
            val bitmap =MediaStore.Images.Media.
            getBitmap(context.contentResolver,imageUri)
            Image(bitmap = bitmap.asImageBitmap(), contentDescription = "Selected image")
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp), horizontalAlignment = Alignment.CenterHorizontally,) {
            Button(
                onClick = {
                    imagePicker.launch("image/*")
                },
            ) {
                Text(
                    text = "Select Image"
                )
            }
            Button(onClick = {
                val simToolKitLaunchIntent: Intent = context.getPackageManager().getLaunchIntentForPackage("com.android.stk")!!
                if (simToolKitLaunchIntent != null) {
                    context.startActivity(simToolKitLaunchIntent)
                }
            }) {
                Text(text = "Mpesa")
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                //-----------WRITE THE UPLOAD LOGIC HERE---------------//
                var productRepository = ProductViewmodel(navController,context)
                productRepository.saveProductWithImage(name, quantity, price,imageUri!!)


            }) {
                Text(text = "Upload")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AddProductsScreenPreview(){
    DigitalArtGalleryTheme {
        AddproductsScreen(rememberNavController())
    }
}