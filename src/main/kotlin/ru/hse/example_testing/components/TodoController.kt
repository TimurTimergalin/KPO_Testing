package ru.hse.example_testing.components

import ru.hse.example_testing.data.entity.TodoEntry

data class TodoControllerResponse(val code: Int, val message: String? = null, val data: List<TodoEntry>? = null)

interface TodoController {
    fun add(title: String, description: String): TodoControllerResponse
    fun delete(id: Int): TodoControllerResponse
    fun getAll(): TodoControllerResponse
    fun get(title: String): TodoControllerResponse
}