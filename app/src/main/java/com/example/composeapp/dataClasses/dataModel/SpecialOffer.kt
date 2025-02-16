package com.example.composeapp.dataClasses.dataModel

data class SpecialOffer(
    val product: Product, // محصولی که پیشنهاد ویژه برای آن است
    val offerPercentage: Double, // درصد تخفیف پیشنهاد ویژه
    val offerExpiryDate: String, // تاریخ انقضای پیشنهاد ویژه
)
