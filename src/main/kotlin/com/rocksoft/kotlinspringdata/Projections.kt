package com.rocksoft.kotlinspringdata

import org.springframework.data.rest.core.config.Projection

@Projection(name = "fullTitle", types = [Title::class])
interface FullTitleProjection {
    val title: String
    val rating: EsrbRating
    val system: System
}