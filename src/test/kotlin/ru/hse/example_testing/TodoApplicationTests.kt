package ru.hse.example_testing

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import ru.hse.example_testing.components.TodoControllerResponse
import ru.hse.example_testing.controller.TodoControllerImpl
import ru.hse.example_testing.data.entity.TodoEntry
import ru.hse.example_testing.data.repo.TodoRepo
import ru.hse.example_testing.service.TodoServiceImpl
import java.util.*

class TodoApplicationTests {
	@Mock
	val repo: TodoRepo = Mockito.mock(TodoRepo::class.java)

	@Test
	fun testEmptyRepo() {
		// Самый простой тест
		// Больше не придумал(( - уж больно система простая
		Mockito.`when`(repo.findAll()).thenReturn(listOf())
		Mockito.`when`(repo.findById(Mockito.anyInt())).thenReturn(Optional.empty())
		Mockito.`when`(repo.findByTitle(Mockito.anyString())).thenReturn(null)

		val service = TodoServiceImpl(repo)

		Assertions.assertEquals(service.getTodo(""), null)
		Assertions.assertEquals(service.getTodoList().toList(), listOf<TodoEntry>())
		Assertions.assertEquals(service.deleteTodo(0), false)
	}
}
