
import spark.Spark.get

fun main(args: Array<String>) {
    get("/hello") { request, _ ->
        val name: String? = request.queryParams("name")
        "Hello, ${name ?: "World"}!"
    }
}