package com.example.digitalartgallery.model

class Product {

    var id: String = ""
    var name:String = "Spray Pic"
    var quantity:String="medium"
    var price:String="500"
    private var imageUrl:String="img"


    constructor(name: String, quantity: String, price: String, imageUrl: String,id:String) {
        this.name = name
        this.quantity = quantity
        this.price = price
        this.imageUrl = imageUrl
        this.id = id

    }
    constructor()
}