package com.example.springwebflux.r2dbc

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table
data class Food(
    @Id
    val id: Long = 0,

    @Column
    val name: String,

    @Column
    val price: Int,
)