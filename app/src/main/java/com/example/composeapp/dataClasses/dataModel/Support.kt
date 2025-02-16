package com.example.composeapp.dataClasses.dataModel

data class Support(
    val id: Int, // شناسه پشتیبانی
    val userId: Int, // شناسه کاربر که درخواست پشتیبانی داده
    val message: String, // متن درخواست یا مشکل کاربر
    val response: String, // پاسخ تیم پشتیبانی
    val date: String, // تاریخ درخواست پشتیبانی
    val status: String // وضعیت درخواست (مثلاً "پاسخ داده‌شده"، "در حال بررسی")
)
