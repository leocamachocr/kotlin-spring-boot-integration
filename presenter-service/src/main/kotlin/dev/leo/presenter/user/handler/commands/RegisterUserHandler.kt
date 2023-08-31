package dev.leo.presenter.user.handler.commands


import dev.leo.presenter.user.jpa.entities.UserEntity
import dev.leo.presenter.user.jpa.repositories.UserRepository
import org.springframework.stereotype.Component

@Component
class RegisterUserHandler(private val userRepository: UserRepository) {

    class Command(
        val name: String,
        val email: String,
        val password: String,
    )

    sealed interface Result {
        data class Success(val user: UserEntity) : Result
        data object EmailAlreadyRegistered : Result
        data object InvalidName : Result
    }

    fun handle(command: Command): Result =
        with(command) {
            when {
                isInvalidName() -> Result.InvalidName
                existUser() -> Result.EmailAlreadyRegistered
                else -> Result.Success(userRepository.save(toEntity()))
            }
        }

    private fun Command.toEntity(): UserEntity = UserEntity(
        name = name,
        email = email,
        password = password
    )

    private fun Command.isInvalidName(): Boolean = name.length < 3
    private fun Command.existUser(): Boolean = userRepository.countByEmail(email) > 0
}