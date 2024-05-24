package ru.hse.example_testing.data.repo

import org.springframework.data.repository.CrudRepository
import ru.hse.example_testing.data.entity.TodoEntry

interface TodoRepo : CrudRepository<TodoEntry, Int> {
    fun findByTitle(title: String): TodoEntry?
    fun insert(todoEntry: TodoEntry): Boolean
}