package todolist

import com.fasterxml.jackson.databind.ObjectMapper
import spark.Route
import spark.Spark.halt

class TaskController(private val taskRepository: TaskRepository, private val objectMapper: ObjectMapper) {
    fun index(): Route = Route { _, _ ->
        taskRepository.findAll()
    }

    fun create(): Route = Route { req, res ->
        val request: TaskCreateRequest = objectMapper.readValue(req.bodyAsBytes()) ?: throw halt(400)
        val task = taskRepository.create(request.content)
        res.status(201)
        task
    }
}