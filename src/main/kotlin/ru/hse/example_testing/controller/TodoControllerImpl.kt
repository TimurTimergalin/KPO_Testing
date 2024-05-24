package ru.hse.example_testing.controller

import org.springframework.web.bind.annotation.*
import ru.hse.example_testing.components.TodoController
import ru.hse.example_testing.components.TodoControllerResponse
import ru.hse.example_testing.components.TodoService

@RestController
@RequestMapping("/todos")
class TodoControllerImpl(val service: TodoService) : TodoController {
    @PostMapping
    override fun add(@RequestParam title: String, @RequestParam description: String): TodoControllerResponse {
        service.addTodo(title, description)
        return TodoControllerResponse(code = 200)
    }

    @DeleteMapping
    override fun delete(@RequestBody id: Int): TodoControllerResponse {
        if (service.deleteTodo(id)) {
            return TodoControllerResponse(code = 200)
        }
        return TodoControllerResponse(code = 404, message = "Todo Not Found")
    }

    @GetMapping
    override fun getAll(): TodoControllerResponse {
        return TodoControllerResponse(code = 200, data = service.getTodoList().toList())
    }

    @GetMapping("/{title}")
    override fun get(@PathVariable title: String): TodoControllerResponse {
        service.getTodo(title)?.let {
            return TodoControllerResponse(code = 200, data = listOf(it))
        }
        return TodoControllerResponse(code = 404, message = "Todo Not Found")
    }
}