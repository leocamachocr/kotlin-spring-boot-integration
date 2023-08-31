package dev.leo.presenter.user.jpa.repositories

import dev.leo.presenter.user.jpa.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<UserEntity, UUID> {

    fun countByEmail(email: String): Long

    fun findByEmail(email: String): UserEntity?
}