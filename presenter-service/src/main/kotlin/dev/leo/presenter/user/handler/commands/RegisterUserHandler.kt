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
         class Success(val user: UserEntity) : Result
         data object EmailAlreadyRegistered : Result
         data object InvalidName : Result
    }

    fun handle(command: Command): Result {
        if (isInvalidName(command.name)) return Result.InvalidName
        if (existUser(command.email)) return Result.EmailAlreadyRegistered
        val user = UserEntity(
            command.name,
            command.email,
            command.password,
            null
        )
        val result = userRepository.save(user)

        return Result.Success(result)
    }

    private fun isInvalidName(name: String): Boolean {
        return name.length < 3
    }

    private fun existUser(email: String): Boolean {
        return userRepository.countByEmail(email) > 0
    }
}