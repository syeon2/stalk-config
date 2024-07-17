package io.waterkite94.stalk.config

import org.jasypt.encryption.StringEncryptor
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JasyptConfig {
    companion object {
        val PASSWORD = System.getenv("ENCRYPT_PASSWORD") ?: "none"
        const val ALGORITHM = "PBEWithMD5AndDES"
    }

    @Bean("jasyptStringEncryptor")
    fun stringEncryptor(): StringEncryptor {
        val encryptor = PooledPBEStringEncryptor()
        val config = SimpleStringPBEConfig()

        config.password = PASSWORD
        config.algorithm = ALGORITHM
        config.setPoolSize("1")
        config.stringOutputType = "base64"
        config.setKeyObtentionIterations("1000")
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator")
        config.setIvGeneratorClassName("org.jasypt.iv.NoIvGenerator")

        encryptor.setConfig(config)

        return encryptor
    }
}
