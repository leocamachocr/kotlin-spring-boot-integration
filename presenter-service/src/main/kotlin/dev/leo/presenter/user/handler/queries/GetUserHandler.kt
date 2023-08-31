package dev.leo.presenter.user.handler.queries

import dev.leo.presenter.user.jpa.entities.UserEntity
import dev.leo.presenter.user.jpa.repositories.UserRepository
import org.springframework.stereotype.Component
import java.util.UUID
import kotlin.jvm.optionals.getOrNull

@Component
class GetUserHandler(
    private val repository: UserRepository
) {
    fun handler(email: String): UserEntity? =
        repository.findByEmail(email)
}