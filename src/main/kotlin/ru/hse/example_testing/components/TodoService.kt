package ru.hse.example_testing.components

import ru.hse.example_testing.data.entity.TodoEntry


interface TodoService {
    fun addTodo(title: String, description: String)
    fun deleteTodo(id: Int): Boolean
    fun getTodoList(): Iterable<TodoEntry>
    fun getTodo(title: String): TodoEntry?
}