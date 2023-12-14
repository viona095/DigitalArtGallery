package com.example.digitalartgallery.model

class User {
    var name :String="Spray Pic"
     private var email:String ="vilacavis843@gmail.com"
    private var password : String="kk14032022"
    private var phoneNumber : String ="0798504424"

    constructor(name: String, email: String, password: String, phoneNumber: String) {
        this.name = name
        this.email = email
        this.password = password
        this.phoneNumber = phoneNumber
    }
    constructor()
}