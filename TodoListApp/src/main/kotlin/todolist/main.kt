package todolist

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import spark.Spark.get

fun main(args: Array<String>) {
    val objectMapper = ObjectMapper().registerKotlinModule()
    get("/tasks", { _, _ ->
        listOf(
                Task(1, "cleaning", false),
                Task(2, "Post", true)
        )

    }, objectMapper::writeValueAsString

    )
}
