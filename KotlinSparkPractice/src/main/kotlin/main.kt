
import spark.Spark.get

fun main(args: Array<String>) {
    get("/hello") { _, _ ->
        "Hello, World!"
    }
}