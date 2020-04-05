package com.rocksoft.kotlinspringdata

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Configuration {

    @Bean
    fun testDataLoader(esrbRatingRepository: EsrbRatingRepository, systemRepository: SystemRepository, titleRepository: TitleRepository) =
            ApplicationRunner {
                val esrbRating = esrbRatingRepository.save(EsrbRating("Everyone", "E"))
                val system = systemRepository.save(System("Atari 2600"))
                titleRepository.save(Title("California Games", esrbRating, system))
                titleRepository.save(Title("ET: the Extra-Terrestrial", esrbRating, system))
                titleRepository.save(Title("Pitfall!", esrbRating, system))
            }
}