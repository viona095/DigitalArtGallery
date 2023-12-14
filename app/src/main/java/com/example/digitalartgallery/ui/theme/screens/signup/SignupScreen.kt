package com.example.digitalartgallery.ui.theme.screens.signup

import com.example.digitalartgallery.data.AuthViewModel
import com.example.digitalartgallery.ui.theme.DigitalArtGalleryTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.digitalartgallery.navigation.HOME_URL


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(navController: NavController){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text ="Signup Here",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive
        )
        Spacer(modifier = Modifier.height(10.dp))
        var name by remember { mutableStateOf("") }
        OutlinedTextField(
            value =name , onValueChange = {name=it},
            label = { Text(text = "Enter name")},
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        var email by remember { mutableStateOf("") }
        OutlinedTextField(
            value = email,
            onValueChange = {email =it},
            label = { Text(text = "Enter email")},
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        var phoneNumber by remember { mutableStateOf("") }
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = {phoneNumber =it},
            label = { Text(text = "Enter PhoneNumber")},
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Next
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        var password by remember { mutableStateOf("") }
        OutlinedTextField(
            value = password,
            onValueChange = {password =it},
            label = { Text(text = "Enter password")},
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.None
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        val context = LocalContext.current
        val authViewModel= AuthViewModel(navController,context)
        Button(onClick = {
            authViewModel.signup(name,email,password)
        }) {
            Text(text = "Register")
        }
        Button(onClick = {
            navController.navigate(HOME_URL)
        }) {
            Text(text = "Login instead")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SignupScreenPreview(){
    DigitalArtGalleryTheme {
        SignupScreen(rememberNavController())
    }
}
