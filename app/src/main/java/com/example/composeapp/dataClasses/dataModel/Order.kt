package com.example.composeapp.dataClasses.dataModel

data class Order(
    val id: Int, // شناسه سفارش
    val userId: Int, // شناسه کاربر که این سفارش رو ثبت کرده
    val items: List<ShopBoxItem>, // لیست محصولات در این سفارش
    val totalPrice: Double, // مبلغ کل سفارش
    val status: String, // وضعیت سفارش (مثلاً "در حال پردازش"، "ارسال شده")
    val orderDate: String, // تاریخ ثبت سفارش
    val deliveryDate: String?, // تاریخ تحویل (ممکنه مقدار نداشته باشه)
    val shippingAddress: Address, // آدرس ارسال سفارش
    val paymentMethod: String // روش پرداخت (مثلاً "آنلاین"، "کارت به کارت")
)
