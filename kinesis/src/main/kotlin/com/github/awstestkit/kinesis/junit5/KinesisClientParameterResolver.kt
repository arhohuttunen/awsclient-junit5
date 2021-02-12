package com.github.awstestkit.kinesis.junit5

import com.github.awstestkit.SdkClientFactory
import com.github.awstestkit.SdkClientParameterResolver
import software.amazon.awssdk.core.SdkClient
import software.amazon.awssdk.services.kinesis.KinesisAsyncClient
import software.amazon.awssdk.services.kinesis.KinesisClient
import kotlin.reflect.KClass

class KinesisClientParameterResolver : SdkClientParameterResolver() {
    override val factories: Map<KClass<out SdkClient>, SdkClientFactory<*, out SdkClient>>

    init {
        factories = mapOf(
            KinesisClient::class to KinesisClientFactory(KinesisClient.builder()),
            KinesisAsyncClient::class to KinesisAsyncClientFactory(KinesisAsyncClient.builder())
        )
    }
}
