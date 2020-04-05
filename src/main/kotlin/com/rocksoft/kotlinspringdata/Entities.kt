package com.rocksoft.kotlinspringdata

import javax.persistence.*

@Entity
class EsrbRating(var name: String, var code: String, @Id @GeneratedValue var id: Long? = null)

@Entity
class System(var name: String, @Id @GeneratedValue var id: Long? = null)

@Entity
class Title(
        var title: String,
        @OneToOne var rating: EsrbRating,
        @ManyToOne var system: System,
        @Id @GeneratedValue var id: Long? = null
)