package todolist

import spark.Request
import spark.Response
import spark.Route

class TaskController {
    fun index(): Route = Route { _, _ ->
        listOf(
                Task(1, "cleaning", false),
                Task(2, "Post", true)
        )
    }
}