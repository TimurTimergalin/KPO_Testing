package ru.hse.example_testing.data.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column

data class TodoEntry(
    @Id var id: Int? = null,
    @Column var title: String,
    @Column var description: String
)