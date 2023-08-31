package dev.leo.presenter.exceptions

data class BLException(override val message: String = "Invalid State") : Exception(message)