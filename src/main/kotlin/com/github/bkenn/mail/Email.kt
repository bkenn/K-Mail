package com.github.bkenn.mail

data class Email(
        val from: String,
        val tos: List<String>,
        val password: String,
        val subject: String,
        val message: String,
        val files: List<Pair<String, String>>? = null)