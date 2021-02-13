package com.github.awstestkit.secretsmanager.junit5

import com.github.awstestkit.AwsClient
import com.github.awstestkit.localstack.junit5.LocalStackTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient

@LocalStackTest
@SecretsManagerTest
@Secrets(Secret(name = "SecretName", value = "SecretValue"))
class SecretsTest {
    @Test
    fun `secrets are created from class annotations`(@AwsClient secretsManagerClient: SecretsManagerClient) {
        val listSecretsResponse = secretsManagerClient.listSecrets()
        assertThat(listSecretsResponse.secretList()).isNotEmpty()
    }

    @Test
    @Secret(name = "AnotherSecretName", value = "AnotherSecretValue")
    fun `topics are created from method annotations`(@AwsClient secretsManagerClient: SecretsManagerClient) {
        val listSecretsResponse = secretsManagerClient.listSecrets()
        assertThat(listSecretsResponse.secretList()).hasSize(2)
    }
}