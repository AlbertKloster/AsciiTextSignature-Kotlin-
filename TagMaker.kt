package signature

class TagMaker {
    fun getTagWithText(text: String): String {
        val builder = StringBuilder()
        builder
            .append("*".repeat(text.length + 4))
            .append("\n")
            .append("* ")
            .append(text)
            .append(" *")
            .append("\n")
            .append("*".repeat(text.length + 4))
        return builder.toString()
    }
}