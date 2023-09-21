package dev.leo.presenter.user.jpa.entities

import dev.leo.presenter.jpa.entities.AbstractEntity
import jakarta.persistence.*
import jakarta.persistence.CascadeType
import java.util.UUID

@Entity
class UserEntity(
    var name: String,
    var email: String,
    var password: String,
    var nickname: String? = "none",
) : AbstractEntity() {
    @Id
    @GeneratedValue(generator = "UUID")
    override lateinit var id: UUID

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var configuration: UserConfigurationEntity? = null

}

fun createUser(name:String ="None"){
    createUser()
    createUser("")
    val user = UserEntity(
        name = "123quesito",
        email = "Leonardo",
        password = "Leo",
        nickname = "leo@email.com",
    )


}