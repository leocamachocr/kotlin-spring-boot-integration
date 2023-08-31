package dev.leo.presenter.exceptions

class BusinessException(
    val errorCode: ErrorCode,
    vararg params: String = emptyArray()
) : Exception() {
    override val message: String =
        params.foldIndexed(errorCode.message) { index, acc, param ->
            acc.replace("{$index}", param)
        }
}