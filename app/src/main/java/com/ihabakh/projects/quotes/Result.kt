package com.ihabakh.projects.quotes

data class Result(
    val _id: String,
    val author: String,
    val content: String,
    val authorSlug: String,
    val dateAdded: String,
    val dateModified: String,
    val length: Int,
    val tags: List<String>
)
