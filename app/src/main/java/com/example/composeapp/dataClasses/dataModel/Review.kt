package com.example.composeapp.dataClasses.dataModel

data class Review(
    val id: Int, // شناسه نظر
    val productId: Int, // شناسه محصولی که نظر براش داده شده
    val userId: Int, // شناسه کاربری که نظر رو داده
    val rating: Double, // امتیاز (مثلاً 5 ستاره)
    val comment: String, // متن نظر
    val date: String // تاریخ ثبت نظر
)
