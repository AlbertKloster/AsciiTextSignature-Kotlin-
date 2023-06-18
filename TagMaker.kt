package signature

class TagMaker {
    fun getTagWithText(nameAndStatus: NameAndStatus): String {
        val builder = StringBuilder()
        builder.append(getAsteriskLine(nameAndStatus))
        builder.append("\n")
        builder.append(getLineWithFirstLineNameString(nameAndStatus))
        builder.append("\n")
        builder.append(getLineWithSecondLineNameString(nameAndStatus))
        builder.append("\n")
        builder.append(getLineWithThirdLineNameString(nameAndStatus))
        builder.append("\n")
        builder.append(getStatus(nameAndStatus))
        builder.append("\n")
        builder.append(getAsteriskLine(nameAndStatus))
        return builder.toString()
    }

    private fun getStatus(nameAndStatus: NameAndStatus): String {
        val builder = StringBuilder()
        builder.append("*")
        builder.append(" ".repeat(getPaddingLeftStatus(nameAndStatus)))
        builder.append(nameAndStatus.status)
        builder.append(" ".repeat(getPaddingRightStatus(nameAndStatus)))
        builder.append("*")
        return builder.toString()
    }

    private fun getLineWithFirstLineNameString(nameAndStatus: NameAndStatus): String {
        return getLineWithNameString(nameAndStatus, getNameFirstLine(nameAndStatus.name))
    }

    private fun getLineWithSecondLineNameString(nameAndStatus: NameAndStatus): String {
        return getLineWithNameString(nameAndStatus, getNameSecondLine(nameAndStatus.name))
    }

    private fun getLineWithThirdLineNameString(nameAndStatus: NameAndStatus): String {
        return getLineWithNameString(nameAndStatus, getNameThirdLine(nameAndStatus.name))
    }

    private fun getLineWithNameString(nameAndStatus: NameAndStatus, nameString: String): String {
        val builder = StringBuilder()
        builder.append("*")
        builder.append(" ".repeat(getPaddingLeftName(nameAndStatus)))
        builder.append(nameString)
        builder.append(" ".repeat(getPaddingRightName(nameAndStatus)))
        builder.append("*")
        return builder.toString()
    }

    private fun getAsteriskLine(nameAndStatus: NameAndStatus): String {
        return "*".repeat(getLength(nameAndStatus) + 5)
    }

    private fun getPaddingLeftName(nameAndStatus: NameAndStatus): Int {
        val nameLength = getNameFirstLine(nameAndStatus.name).length
        val statusLength = nameAndStatus.status.length
        return if (nameLength > statusLength) 1 else (statusLength - nameLength + 3) / 2
    }

    private fun getPaddingRightName(nameAndStatus: NameAndStatus): Int {
        val nameLength = getNameFirstLine(nameAndStatus.name).length
        val statusLength = nameAndStatus.status.length
        return if (nameLength > statusLength) 2 else getLength(nameAndStatus) + 3 - nameLength - getPaddingLeftName(nameAndStatus)
    }

    private fun getPaddingLeftStatus(nameAndStatus: NameAndStatus): Int {
        val nameLength = getNameFirstLine(nameAndStatus.name).length
        val statusLength = nameAndStatus.status.length
        return if (nameLength < statusLength) 2 else (nameLength - statusLength + 3) / 2
    }
    private fun getPaddingRightStatus(nameAndStatus: NameAndStatus): Int {
        val nameLength = getNameFirstLine(nameAndStatus.name).length
        val statusLength = nameAndStatus.status.length
        return if (nameLength < statusLength) 2 else getLength(nameAndStatus) + 3 - statusLength - getPaddingLeftStatus(nameAndStatus)
    }

    private fun getLength(nameAndStatus: NameAndStatus): Int {
        val nameLength = getNameFirstLine(nameAndStatus.name).length
        val statusLength = nameAndStatus.status.length
        return if (nameLength > statusLength) nameLength else statusLength + 1
    }

    private fun getNameFirstLine(text: String): String {
        return getNameLineByNumber(text, 0)
    }

    private fun getNameSecondLine(text: String): String {
        return getNameLineByNumber(text, 1)
    }

    private fun getNameThirdLine(text: String): String {
        return getNameLineByNumber(text, 2)
    }

    private fun getNameLineByNumber(text: String, lineNumber: Int): String {
        val builder = StringBuilder()
        for (char in text) {
            builder.append(" ")
            builder.append(AsciiFont.getFont(char).lines[lineNumber])
        }
        return builder.toString()
    }

}