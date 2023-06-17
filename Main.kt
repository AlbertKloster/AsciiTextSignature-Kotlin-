package signature

fun main() {
    val text = "Hyper Skill"
    val builder = StringBuilder()
    builder
        .append(" ")
        .append("_".repeat(text.length + 2))
        .append(" ")
        .append("\n")
        .append("| ")
        .append(text)
        .append(" |")
        .append("\n")
        .append(" ")
        .append("•".repeat(text.length + 2))
        .append(" ")
    print(builder)
}
