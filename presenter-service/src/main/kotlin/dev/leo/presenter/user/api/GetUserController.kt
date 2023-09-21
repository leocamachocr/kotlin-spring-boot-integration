package dev.leo.presenter.user.api

import dev.leo.presenter.user.api.types.UserResponse
import dev.leo.presenter.user.api.types.toResponseOrThrow
import dev.leo.presenter.user.handler.queries.GetUserHandler
import dev.leo.presenter.user.jpa.entities.UserEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GetUserController(
    private val handler: GetUserHandler
) {
    @GetMapping("/user/{email}")
    fun getByEmail(@PathVariable email: String): UserResponse =
        handler.handler(email).toResponseOrThrow()


}

