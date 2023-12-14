package com.example.digitalartgallery.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import com.example.digitalartgallery.model.User
import com.example.digitalartgallery.navigation.HOME_URL
import com.example.digitalartgallery.navigation.LOGIN_URL
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class AuthViewModel (var navController: NavController,var context: Context){
    val mAuth:FirebaseAuth
    val Progress:ProgressDialog

    init {
        mAuth=FirebaseAuth.getInstance()
        Progress = ProgressDialog(context)
        Progress . setTitle("Loading")
        Progress .setMessage("Please wait...")
    }
    fun signup(name:String, email:String, Password:String){
        Progress.show()
        mAuth.createUserWithEmailAndPassword(email,Password).addOnCompleteListener {
            Progress.dismiss()
            var userId = mAuth.currentUser!!.uid
            var userProfile = User(name,email,Password , userId)
            // create a reference table called User inside of the Firebase database
            var usersRef = FirebaseDatabase.getInstance().getReference().child("Users/$userId")

            usersRef. setValue(userProfile).addOnCompleteListener {
                Progress.dismiss()
                if (it.isSuccessful){
                    Toast.makeText(this.context ,"success", Toast.LENGTH_SHORT).show()
                    navController.navigate(LOGIN_URL)
                }else{
                    Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    fun login(email:String,Password: String){
        Progress.show()
        mAuth.signInWithEmailAndPassword(email,Password).addOnCompleteListener {
            Progress.dismiss()
            if (it.isSuccessful){
                Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
                navController.navigate(HOME_URL)
            }else{
                Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun logout(){
        mAuth.signOut()
        navController.navigate(LOGIN_URL)
    }
    fun isLoggedIn():Boolean= mAuth.currentUser!=null
}
