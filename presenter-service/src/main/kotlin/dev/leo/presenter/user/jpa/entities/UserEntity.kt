package dev.leo.presenter.user.jpa.entities

import dev.leo.presenter.jpa.entities.AbstractEntity
import jakarta.persistence.*
import jakarta.persistence.CascadeType
import java.util.UUID

@Entity
class UserEntity(
    var name: String?,
    var email: String?,
    var password: String?,
    var nickname: String?,
) : AbstractEntity() {
    @Id
    @GeneratedValue(generator = "UUID")
    override lateinit var id: UUID

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var configuration: UserConfigurationEntity? = null


}