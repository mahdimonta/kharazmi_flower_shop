package com.example.composeapp.dataClasses.dataModel


data class Category(
    val id: Int, // شناسه دسته‌بندی
    val name: String, // نام دسته‌بندی (مثلاً "گل‌های آپارتمانی")
    val imageUrl: String, // تصویر مرتبط با دسته‌بندی
    val listOfProduct: List<Product>
)

