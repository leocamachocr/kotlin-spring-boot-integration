package dev.leo.presenter.user.jpa.entities

import dev.leo.presenter.jpa.entities.AbstractEntity
import jakarta.persistence.*
import java.util.*

@Entity
class UserConfigurationEntity(
    var receiveNotifications: Boolean = false,
    @OneToOne(mappedBy = "configuration")
    @MapsId
    @JoinColumn(name = "user_id")

    val user: UserEntity
) : AbstractEntity() {

    @Id
    override lateinit var id: UUID


}