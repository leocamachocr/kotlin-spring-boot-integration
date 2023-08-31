package dev.leo.presenter.user.api.types

import  dev.leo.presenter.exceptions.ErrorCode
import dev.leo.presenter.user.jpa.entities.UserEntity

data class UserResponse(
    val name: String,
    val email: String,
    val nickname: String? = null
)

fun UserEntity?.toResponseOrThrow(): UserResponse = this?.let {
    UserResponse(
        name = it.name,
        email = it.email,
        nickname = it.nickname
    )
} ?: throw ErrorCode.USER_NOT_FOUND.toException()