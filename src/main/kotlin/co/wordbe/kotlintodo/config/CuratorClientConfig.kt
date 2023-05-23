package co.wordbe.kotlintodo.config

import org.apache.curator.framework.CuratorFramework
import org.apache.curator.framework.CuratorFrameworkFactory
import org.apache.curator.retry.ExponentialBackoffRetry
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CuratorClientConfig(
    private val zookeeperProperty: ZookeeperProperty,
) {

    @Bean
    fun curatorFramework(): CuratorFramework {
        val curatorFramework = CuratorFrameworkFactory.builder()
            .connectString(zookeeperProperty.connectString)
            .retryPolicy(ExponentialBackoffRetry(50, 10, 500))
            .build()

        println("connected to zookeeper")
        return curatorFramework
    }
}