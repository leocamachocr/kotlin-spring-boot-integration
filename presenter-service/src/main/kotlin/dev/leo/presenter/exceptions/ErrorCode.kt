package dev.leo.presenter.exceptions


enum class ErrorCode(val code: Int, val message: String) {
    // Basic Business Validations 1000 - 1999
    INVALID_NAME(1001, "Invalid name"),
    USER_ALREADY_EXISTS(1002, "User already exists"),
    USER_NOT_FOUND(1003, "User not found"),

    // Not Controlled errors 5000 - 5999
    UNKNOWN_ERROR(5000, "Unknown Error");


    fun toException(vararg params: String = emptyArray()): BusinessException =
        BusinessException(this, *params)
}