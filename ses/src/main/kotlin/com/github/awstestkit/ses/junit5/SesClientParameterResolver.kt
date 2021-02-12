package com.github.awstestkit.ses.junit5

import com.github.awstestkit.SdkClientFactory
import com.github.awstestkit.SdkClientParameterResolver
import software.amazon.awssdk.core.SdkClient
import software.amazon.awssdk.services.ses.SesAsyncClient
import software.amazon.awssdk.services.ses.SesClient
import kotlin.reflect.KClass

class SesClientParameterResolver : SdkClientParameterResolver() {
    override val factories: Map<KClass<out SdkClient>, SdkClientFactory<*, out SdkClient>>

    init {
        factories = mapOf(
            SesClient::class to SesClientFactory(SesClient.builder()),
            SesAsyncClient::class to SesAsyncClientFactory(SesAsyncClient.builder())
        )
    }
}
