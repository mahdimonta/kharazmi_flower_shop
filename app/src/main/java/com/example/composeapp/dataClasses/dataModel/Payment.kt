package com.example.composeapp.dataClasses.dataModel

data class Payment(
    val id: Int, // شناسه پرداخت
    val userId: Int, // شناسه کاربر که پرداخت رو انجام داده
    val orderId: Int, // شناسه سفارش مربوط به این پرداخت
    val amount: Double, // مبلغ پرداختی
    val paymentMethod: String, // روش پرداخت (مثلاً "آنلاین"، "کارت به کارت")
    val status: String, // وضعیت پرداخت (مثلاً "موفق"، "ناموفق")
    val date: String // تاریخ پرداخت
)
