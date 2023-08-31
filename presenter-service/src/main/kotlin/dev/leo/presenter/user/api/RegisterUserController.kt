package dev.leo.presenter.user.api

import dev.leo.presenter.user.handler.commands.RegisterUserHandler
import dev.leo.presenter.exceptions.BLException
import dev.leo.presenter.user.api.types.UserRegisterRequest
import dev.leo.presenter.user.api.types.UserResponse
import dev.leo.presenter.user.api.types.toResponseOrThrow
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RegisterUserController(
    private val handler: RegisterUserHandler
) {

    @PostMapping("/register")
    fun register(@RequestBody user: UserRegisterRequest): UserResponse =
        when (val result = handler.handle(
            RegisterUserHandler.Command(
                name = user.name,
                email = user.email,
                password = user.password
            )
        )) {
            is RegisterUserHandler.Result.Success ->
                result.user.toResponseOrThrow()

            is RegisterUserHandler.Result.EmailAlreadyRegistered ->
                throw BLException("Email is already registered")

            is RegisterUserHandler.Result.InvalidName ->
                throw BLException("Invalid name")
        }


}