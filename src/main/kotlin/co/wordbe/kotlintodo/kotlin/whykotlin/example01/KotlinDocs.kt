package co.wordbe.kotlintodo.kotlin.whykotlin.example01

data class Employee(
    val name: String,
    val email: String,
    val company: String
) // + automatically generated equals(), hashCode(), toString(), and copy()

object MyCompany {                                // A singleton
    const val name: String = "MyCompany"
}

fun main() {                                      // Function at the top level
    val employee = Employee(
        name = "Alice",
        email = "alice@mycompany.com",
        company = MyCompany.name
    )
    println(employee)
}
