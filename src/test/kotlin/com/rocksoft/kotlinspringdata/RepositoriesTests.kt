package com.rocksoft.kotlinspringdata

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class RepositoriesTests @Autowired constructor(
        val entityManager: TestEntityManager,
        val esrbRatingRepository: EsrbRatingRepository,
        val systemRepository: SystemRepository,
        val titleRepository: TitleRepository) {

    @Test
    fun `ESRB rating persistence`() {
        val esrbRating = EsrbRating("Everyone", "E")
        entityManager.persist(esrbRating)
        entityManager.flush()
        val ratingFound = esrbRatingRepository.findByIdOrNull(esrbRating.id!!)
        assertThat(ratingFound).isEqualTo(esrbRating)
    }

    @Test
    fun `System persistence`() {
        val system = System("Atari 2600")
        entityManager.persist(system)
        entityManager.flush()
        val systemFound = systemRepository.findByIdOrNull(system.id!!)
        assertThat(systemFound).isEqualTo(systemFound)
    }

    @Test
    fun `Title persistence and relationships`() {
        val esrbRating = EsrbRating("Everyone", "E")
        entityManager.persist(esrbRating)
        val system = System("Atari 2600")
        entityManager.persist(system)
        val title = Title("California Games", esrbRating, system)
        entityManager.persist(title)
        entityManager.flush()
        val titleFound = titleRepository.findByIdOrNull(title.id!!)
        assertThat(title).isEqualTo(titleFound)
    }
}