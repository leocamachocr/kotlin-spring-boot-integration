package dev.leo.presenter.user.handler.commands


import dev.leo.presenter.user.jpa.entities.UserEntity
import dev.leo.presenter.user.jpa.repositories.UserRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class RegisterUserHandler(private val userRepository: UserRepository) {

    data class Command(
        val name: String,
        val email: String,
        val password: String,
    )

    sealed interface Result {
        data class Success(val user: UserEntity) : Result
        data object EmailAlreadyRegistered : Result
        data object InvalidName : Result
    }

    fun handle(command: Command): Result {
        return when {
            command.isValidName() -> Result.InvalidName
            command.existUser() -> Result.EmailAlreadyRegistered
            else -> Result.Success(userRepository.save(command.toEntity()))
        }

    }

    fun Command.toEntity(): UserEntity = UserEntity(
        name = this.name,
        email = this.email,
        password = this.password
    )

    fun Command.isValidName(): Boolean = this.name.length > 3
    fun Command.existUser(): Boolean = userRepository.countByEmail(email) > 0

}