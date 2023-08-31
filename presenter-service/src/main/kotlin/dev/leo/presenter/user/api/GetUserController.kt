package dev.leo.presenter.user.api

import dev.leo.presenter.exceptions.ErrorCode
import dev.leo.presenter.user.api.types.UserResponse
import dev.leo.presenter.user.handler.queries.GetUserHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GetUserController(
    private val handler: GetUserHandler
) {
    @GetMapping("/user/{email}")
    fun getByEmail(@PathVariable email: String): UserResponse {
        val result = handler.handler(email)
        if (result.isPresent) {
            return UserResponse(
                result.get().name,
                result.get().email,
                result.get().nickname
            )
        } else throw ErrorCode.USER_NOT_FOUND.toException()
    }
}

