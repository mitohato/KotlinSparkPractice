package todolist

import spark.Request
import spark.Response
import spark.Route

class TaskController(private val taskRepository: TaskRepository) {
    fun index(): Route = Route { _, _ ->
        taskRepository.findAll()
    }
}