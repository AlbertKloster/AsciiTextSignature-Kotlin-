package signature

fun main() {
    val tagMaker = TagMaker()
    print("Enter name and surname: ")
    val name = readln()
    print("Enter person's status: ")
    val status = readln()
    print(tagMaker.getTagWithText(NameAndStatus(name, status)))
}
