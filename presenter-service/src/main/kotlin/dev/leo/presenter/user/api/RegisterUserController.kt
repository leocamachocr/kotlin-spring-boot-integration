package dev.leo.presenter.user.api

import dev.leo.presenter.user.handler.commands.RegisterUserHandler
import dev.leo.presenter.exceptions.ErrorCode
import dev.leo.presenter.user.api.types.UserRegisterRequest
import dev.leo.presenter.user.api.types.UserResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RegisterUserController(
    private val handler: RegisterUserHandler
) {

    @PostMapping("/register")
    fun register(@RequestBody user: UserRegisterRequest): UserResponse {

        val result = handler.handle(
            RegisterUserHandler.Command(
                name = user.name,
                email = user.email,
                password = user.password
            )
        )
        if (result is RegisterUserHandler.Result.Success) {
            return UserResponse(
                result.user.name,
                result.user.email,
                result.user.nickname
            )
        } else if (result is RegisterUserHandler.Result.EmailAlreadyRegistered) {
            throw ErrorCode.USER_ALREADY_EXISTS.toException()
        } else if (result is RegisterUserHandler.Result.EmailAlreadyRegistered) {
            throw ErrorCode.INVALID_NAME.toException()
        } else throw ErrorCode.UNKNOWN_ERROR.toException()
    }


}