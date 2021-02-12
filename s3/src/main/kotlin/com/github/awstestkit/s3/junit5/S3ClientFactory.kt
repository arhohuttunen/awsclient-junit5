package com.github.awstestkit.s3.junit5

import com.github.awstestkit.SdkClientFactory
import software.amazon.awssdk.services.s3.S3AsyncClient
import software.amazon.awssdk.services.s3.S3AsyncClientBuilder
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3.S3ClientBuilder

typealias S3ClientFactory = SdkClientFactory<S3ClientBuilder, S3Client>
typealias S3AsyncClientFactory = SdkClientFactory<S3AsyncClientBuilder, S3AsyncClient>
