package com.rocksoft.kotlinspringdata

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTests(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun `Fetches title using projection`() {
        val entity = restTemplate.getForEntity<Title>("/titles/3?projection={projection}", mapOf("projection" to "fullTitle"))
        val title = entity.body
        assertThat(title?.title).isEqualTo("California Games")
        assertThat(title?.rating?.code).isEqualTo("E")
        assertThat(title?.rating?.name).isEqualTo("Everyone")
        assertThat(title?.system?.name).isEqualTo("Atari 2600")
    }
}