package com.example.composeapp.dataClasses.dataModel

data class Address(
    val id: Int, // شناسه آدرس
    val userId: Int, // شناسه کاربر مربوطه
    val recipientName: String, // نام دریافت‌کننده سفارش
    val phone: String, // شماره تماس دریافت‌کننده
    val fullAddress: String,

)
