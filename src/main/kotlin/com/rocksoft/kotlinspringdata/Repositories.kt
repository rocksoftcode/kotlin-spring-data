package com.rocksoft.kotlinspringdata

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

interface EsrbRatingRepository : PagingAndSortingRepository<EsrbRating, Long>
interface SystemRepository : PagingAndSortingRepository<System, Long>

@RepositoryRestResource(excerptProjection = FullTitleProjection::class)
interface TitleRepository : PagingAndSortingRepository<Title, Long>
