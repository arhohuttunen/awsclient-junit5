package com.github.awstest.secretsmanager.junit5

import com.github.awstest.AwsClientFactory
import com.github.awstest.SdkClientParameterResolver
import software.amazon.awssdk.core.SdkClient
import software.amazon.awssdk.services.secretsmanager.SecretsManagerAsyncClient
import software.amazon.awssdk.services.secretsmanager.SecretsManagerAsyncClientBuilder
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClientBuilder
import kotlin.reflect.KClass

class SecretsManagerClientParameterResolver : SdkClientParameterResolver() {
    override val factories: Map<KClass<out SdkClient>, AwsClientFactory<*, out SdkClient>>

    init {
        factories = mapOf(
            SecretsManagerClient::class to AwsClientFactory<SecretsManagerClientBuilder, SecretsManagerClient>(SecretsManagerClient.builder()),
            SecretsManagerAsyncClient::class to AwsClientFactory<SecretsManagerAsyncClientBuilder, SecretsManagerAsyncClient>(SecretsManagerAsyncClient.builder())
        )
    }
}