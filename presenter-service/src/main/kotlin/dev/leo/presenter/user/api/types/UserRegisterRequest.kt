package dev.leo.presenter.user.api.types

data class UserRegisterRequest(
    val email: String,
    val name: String,
    val password: String,
    val nickname: String
)