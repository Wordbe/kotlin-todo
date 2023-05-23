package co.wordbe.kotlintodo.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("zookeeper")
class ZookeeperProperty(
    val connectString: String,
)