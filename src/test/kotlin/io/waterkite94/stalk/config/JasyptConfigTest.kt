package io.waterkite94.stalk.config

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor
import org.junit.jupiter.api.Test
import org.springframework.core.io.ClassPathResource
import org.springframework.util.StreamUtils
import java.nio.charset.StandardCharsets

class JasyptConfigTest {
    @Test
    fun privateKey_encrypt() {
        val resource = ClassPathResource("privateKey.txt")
        val privateKey = StreamUtils.copyToString(resource.inputStream, StandardCharsets.UTF_8)
        val standardPBEStringEncryptor = StandardPBEStringEncryptor()
        standardPBEStringEncryptor.setPassword(JasyptConfig.ALGORITHM)
        standardPBEStringEncryptor.setPassword(JasyptConfig.PASSWORD)

        println(JasyptConfig.PASSWORD)

        val enc = standardPBEStringEncryptor.encrypt(privateKey)
        println(String.format("enc = ENC(%s)", enc))
        println(String.format("dec = %s", standardPBEStringEncryptor.decrypt(enc)))
    }

    @Test
    fun name() {
        val privateKey = "secret key"
        val standardPBEStringEncryptor = StandardPBEStringEncryptor()
        standardPBEStringEncryptor.setPassword(JasyptConfig.ALGORITHM)
        standardPBEStringEncryptor.setPassword(JasyptConfig.PASSWORD)

        println(JasyptConfig.PASSWORD)

        val enc = standardPBEStringEncryptor.encrypt(privateKey)
        println(String.format("enc = ENC(%s)", enc))
        println(String.format("dec = %s", standardPBEStringEncryptor.decrypt(enc)))
    }
}
