package co.wordbe.kotlintodo.config

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ZookeeperPropertyTest {
    @Autowired
    lateinit var zookeeperProperty: ZookeeperProperty

    @Test
    fun getConnectString() {
        println(zookeeperProperty.connectString)
    }
}