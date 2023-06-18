package signature

enum class AsciiFont(val char: Char, val lines: Array<String>) {
    A('A', arrayOf("____", "|__|", "|  |")),
    B('B', arrayOf("___ ", "|__]", "|__]")),
    C('C', arrayOf("____", "|   ", "|___")),
    D('D', arrayOf("___ ", "|  \\", "|__/")),
    E('E', arrayOf("____", "|___", "|___")),
    F('F', arrayOf("____", "|___", "|   ")),
    G('G', arrayOf("____", "| __", "|__]")),
    H('H', arrayOf("_  _", "|__|", "|  |")),
    I('I', arrayOf("_", "|", "|")),
    J('J', arrayOf(" _", " |", "_|")),
    K('K', arrayOf("_  _", "|_/ ", "| \\_")),
    L('L', arrayOf("_   ", "|   ", "|___")),
    M('M', arrayOf("_  _", "|\\/|", "|  |")),
    N('N', arrayOf("_  _", "|\\ |", "| \\|")),
    O('O', arrayOf("____", "|  |", "|__|")),
    P('P', arrayOf("___ ", "|__]", "|   ")),
    Q('Q', arrayOf("____", "|  |", "|_\\|")),
    R('R', arrayOf("____", "|__/", "|  \\")),
    S('S', arrayOf("____", "[__ ", "___]")),
    T('T', arrayOf("___", " | ", " | ")),
    U('U', arrayOf("_  _", "|  |", "|__|")),
    V('V', arrayOf("_  _", "|  |", " \\/ ")),
    W('W', arrayOf("_ _ _", "| | |", "|_|_|")),
    X('X', arrayOf("_  _", " \\/ ", "_/\\_")),
    Y('Y', arrayOf("_   _", " \\_/ ", "  |  ")),
    Z('Z', arrayOf("___ ", "  / ", " /__")),
    SPACE(' ', arrayOf("    ", "    ", "    "));

    companion object {
        fun getFont(char: Char): AsciiFont {
            for (font in AsciiFont.values()) {
                if (font.char == char.uppercaseChar()) {
                    return font
                }
            }
            throw RuntimeException("Wrong character $char")
        }
    }

}