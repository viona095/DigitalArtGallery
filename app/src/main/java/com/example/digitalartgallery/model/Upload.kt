package com.example.digitalartgallery.model

class Upload{
    var name:String="Spray Pic"
    var quantity:String="medium"
    var price:String="500"
    var imageUrl:String="img"
    var id:String=""

    constructor(name:String,quantity:String,price:String,imageUrl:String,id:String){

        this.name=name
        this.quantity=quantity
        this.price=price
        this.imageUrl=imageUrl
        this.id=id

    }
    constructor()
}
