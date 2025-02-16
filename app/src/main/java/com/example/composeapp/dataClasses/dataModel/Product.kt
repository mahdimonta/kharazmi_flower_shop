package com.example.composeapp.dataClasses.dataModel

data class Product(
    val id: Int, // شناسه محصول
    val name: String, // نام محصول
    val description: String, // توضیحات محصول
    val price: String, // قیمت محصول
    val discount: String? = null, // مقدار تخفیف (اختیاری)
    val stock: Int, // موجودی محصول
    val category: String, // دسته‌بندی محصول (مثلاً رز، ارکیده)
    val imageUrls: List<String>, // لیست آدرس‌های تصاویر محصول
    val rating: Double, // امتیاز محصول
    val reviewsCount: Int, // تعداد نظرات کاربران
    val availability: String // وضعیت موجودی (موجود، ناموجود و ...)
)
