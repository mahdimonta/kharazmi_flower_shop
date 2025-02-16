package com.example.composeapp.dataClasses.dataModel

data class Notification(
    val id: Int, // شناسه اعلان
    val userId: Int, // شناسه کاربر مربوطه
    val title: String, // عنوان اعلان
    val message: String, // متن اعلان
    val date: String, // تاریخ ارسال اعلان
    val isRead: Boolean // وضعیت خوانده‌شدن اعلان
)
