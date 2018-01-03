package todolist

import com.fasterxml.jackson.databind.ObjectMapper
import spark.Route
import spark.Spark.halt

class TaskController(private val taskRepository: TaskRepository, private val objectMapper: ObjectMapper) {
    fun index(): Route = Route { _, _ ->
        taskRepository.findAll()
    }

    fun create(): Route = Route { req, res ->
        val request: TaskCreateRequest =
                try {
                    objectMapper.readValue(req.bodyAsBytes(), TaskCreateRequest::class.java)
                } catch (e: Exception) {
                    throw halt(400)
                }
        val task = taskRepository.create(request.content)
        res.status(200)
        task
    }
}