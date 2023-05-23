package co.wordbe.kotlintodo.api

import co.wordbe.kotlintodo.config.ZookeeperProperty
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class CuratorController(
    private val zookeeperProperty: ZookeeperProperty,
) {

    @GetMapping("/zookeepers")
    fun getConnectString() = zookeeperProperty.connectString
}