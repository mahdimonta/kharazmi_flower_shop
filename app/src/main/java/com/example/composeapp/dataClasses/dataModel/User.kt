package com.example.composeapp.dataClasses.dataModel

data class User(
    val id: Int, // شناسه کاربر
    val name: String, // نام کاربر
    val email: String, // ایمیل کاربر
    val phone: String, // شماره تماس
    val addressList: List<Address>, // لیست آدرس‌های کاربر
    val orders: List<Order> // لیست سفارشات کاربر
)
