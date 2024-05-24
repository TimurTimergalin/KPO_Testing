package ru.hse.example_testing.service

import org.springframework.stereotype.Service
import ru.hse.example_testing.components.TodoService
import ru.hse.example_testing.data.entity.TodoEntry
import ru.hse.example_testing.data.repo.TodoRepo
import java.util.*

fun <T> Optional<T>.unwrap(): T? = orElse(null)

@Service
class TodoServiceImpl(val rep: TodoRepo) : TodoService {
    override fun addTodo(title: String, description: String) {
        rep.insert(TodoEntry(title = title, description = description))
    }

    override fun deleteTodo(id: Int): Boolean {
        val entity = rep.findById(id).unwrap()
        return entity?.let {
            rep.delete(it)
            true
        } ?: false
    }

    override fun getTodoList(): Iterable<TodoEntry> {
        return rep.findAll()
    }

    override fun getTodo(title: String): TodoEntry? {
        return rep.findByTitle(title)
    }
}