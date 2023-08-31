package dev.leo.presenter

import dev.leo.presenter.user.jpa.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TransactionsApplicationTests(
    @Autowired
    private val userRepository: UserRepository
) {



}
