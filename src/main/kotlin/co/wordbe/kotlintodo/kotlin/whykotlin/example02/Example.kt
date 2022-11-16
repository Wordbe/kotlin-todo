package co.wordbe.kotlintodo.kotlin.whykotlin.example02

fun main() {
    val condition = false
    val name: String? = if (condition) "jacob.jinn" else null // expression 표현문

//    val result = name?.replace("jinn", "jin") // safe call

    if (name != null) {
        // smart cast
        // String? -> String
        println(name.replace("jinn", "jin"))
    }

    val duty = name ?: throw IllegalStateException("jacob 이 없습니다.")
    println(duty)












//    val condition = false
//    val name: String? = if (condition) "jacob.jinn" else null
//
//    val result = name?.replace("jinn", "jin")
//    println(result)
//
//    if (name != null) {
//        println(name.replace("jinn", "jin"))
//    }
//
//    val nonNullName = name ?: "bella"
//    println(nonNullName)
}
