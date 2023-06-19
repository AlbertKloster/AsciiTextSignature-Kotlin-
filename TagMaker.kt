package signature

class TagMaker {

    private val fileHandler = FileHandler()
    private val romanLetters = fileHandler.getLettersFromFile("roman.txt")
    private val mediumLetters = fileHandler.getLettersFromFile("medium.txt")

    fun getTagWithText(nameAndStatus: NameAndStatus): String {
        val builder = StringBuilder()
        builder.append(getBorderLine(nameAndStatus))
        builder.append("\n")
        builder.append(getNameLines(nameAndStatus))
        builder.append(getStatusLines(nameAndStatus))
        builder.append(getBorderLine(nameAndStatus))
        return builder.toString()
    }

    private fun getNameLines(nameAndStatus: NameAndStatus): String {
        val builder = StringBuilder()
        for (i in 0 until romanLetters[0].height) {
            builder.append(getLineWithNameString(nameAndStatus, getNameLineByNumber(nameAndStatus.name, i)))
            builder.append("\n")
        }
        return builder.toString()
    }

    private fun getStatusLines(nameAndStatus: NameAndStatus): String {
        val builder = StringBuilder()
        for (i in 0 until mediumLetters[0].height) {
            builder.append(getLineWithStatusString(nameAndStatus, getStatusLineByNumber(nameAndStatus.status, i)))
            builder.append("\n")
        }
        return builder.toString()
    }

    private fun getLineWithStatusString(nameAndStatus: NameAndStatus, statusString: String): String {
        val builder = StringBuilder()
        builder.append("88")
        builder.append(" ".repeat(getPaddingLeftStatus(nameAndStatus)))
        builder.append(statusString)
        builder.append(" ".repeat(getPaddingRightStatus(nameAndStatus)))
        builder.append("88")
        return builder.toString()
    }

    private fun getLineWithNameString(nameAndStatus: NameAndStatus, nameString: String): String {
        val builder = StringBuilder()
        builder.append("88")
        builder.append(" ".repeat(getPaddingLeftName(nameAndStatus)))
        builder.append(nameString)
        builder.append(" ".repeat(getPaddingRightName(nameAndStatus)))
        builder.append("88")
        return builder.toString()
    }

    private fun getBorderLine(nameAndStatus: NameAndStatus): String {
        return "8".repeat(getLength(nameAndStatus) + 8)
    }

    private fun getPaddingLeftName(nameAndStatus: NameAndStatus): Int {
        val nameLength = getNameLineLength(nameAndStatus.name)
        val statusLength = getStatusLineLength(nameAndStatus.status)
        return if (nameLength > statusLength) 2 else (statusLength - nameLength + 4) / 2
    }

    private fun getPaddingRightName(nameAndStatus: NameAndStatus): Int {
        val nameLength = getNameLineLength(nameAndStatus.name)
        val statusLength = getStatusLineLength(nameAndStatus.status)
        return if (nameLength > statusLength) 2 else getLength(nameAndStatus) + 4 - nameLength - getPaddingLeftName(nameAndStatus)
    }

    private fun getPaddingLeftStatus(nameAndStatus: NameAndStatus): Int {
        val nameLength = getNameLineLength(nameAndStatus.name)
        val statusLength = getStatusLineLength(nameAndStatus.status)
        return if (nameLength < statusLength) 2 else (nameLength - statusLength + 4) / 2
    }
    private fun getPaddingRightStatus(nameAndStatus: NameAndStatus): Int {
        val nameLength = getNameLineLength(nameAndStatus.name)
        val statusLength = getStatusLineLength(nameAndStatus.status)
        return if (nameLength < statusLength) 2 else getLength(nameAndStatus) + 4 - statusLength - getPaddingLeftStatus(nameAndStatus)
    }

    private fun getLength(nameAndStatus: NameAndStatus): Int {
        val nameLength = getNameLineLength(nameAndStatus.name)
        val statusLength = getStatusLineLength(nameAndStatus.status)
        return if (nameLength > statusLength) nameLength else statusLength
    }

    private fun getNameLineLength(text: String): Int {
        return getNameLineByNumber(text, 0).length
    }

    private fun getStatusLineLength(text: String): Int {
        return getStatusLineByNumber(text, 0).length
    }

    private fun getNameLineByNumber(text: String, lineNumber: Int): String {
        val builder = StringBuilder()
        for (char in text) {
            builder.append(getRomanLetterByName(char.toString())?.lines?.get(lineNumber) ?: " ".repeat(10))
        }
        return builder.toString()
    }

    private fun getStatusLineByNumber(text: String, lineNumber: Int): String {
        val builder = StringBuilder()
        for (char in text) {
            builder.append(getMediumLetterByName(char.toString())?.lines?.get(lineNumber) ?: " ".repeat(5))
        }
        return builder.toString()
    }

    private fun getRomanLetterByName(char: String): Letter? {
        return romanLetters.find { letter -> letter.char == char }
    }

    private fun getMediumLetterByName(char: String): Letter? {
        return mediumLetters.find { letter -> letter.char == char }
    }

}
