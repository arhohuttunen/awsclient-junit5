package com.github.awstestkit.s3.junit5

import com.github.awstestkit.SdkClientFactory
import com.github.awstestkit.SdkClientParameterResolver
import software.amazon.awssdk.core.SdkClient
import software.amazon.awssdk.services.s3.S3AsyncClient
import software.amazon.awssdk.services.s3.S3Client
import kotlin.reflect.KClass

class S3ClientParameterResolver : SdkClientParameterResolver() {
    override val factories: Map<KClass<out SdkClient>, SdkClientFactory<*, out SdkClient>>

    init {
        factories = mapOf(
            S3Client::class to S3ClientFactory(S3Client.builder()),
            S3AsyncClient::class to S3AsyncClientFactory(S3AsyncClient.builder())
        )
    }
}
