package co.wordbe.kotlintodo.kotlin.syntax

enum class Tool {
    JIRA,
    AGIT,
    KAKAOTALK,
    SLACK
}

fun canIUse(tool: Tool): String {
    val message = when (tool) {
        Tool.JIRA -> "jira ok"
        Tool.AGIT -> "agit ok"
        Tool.KAKAOTALK -> "kakaotalk ok"
        Tool.SLACK -> ""
//        else -> "생각해볼게"
    }
    return message
}
