package dev.leo.presenter.jpa.entities

import dev.leo.presenter.user.jpa.entities.UserEntity
import org.hibernate.annotations.GenericGenerator
import java.util.UUID

@GenericGenerator(
    name = "UUID",
    strategy = "org.hibernate.id.UUIDGenerator"
)
abstract class AbstractEntity {

    open val id: UUID?
        get() {
            return null
        }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AbstractEntity

        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}