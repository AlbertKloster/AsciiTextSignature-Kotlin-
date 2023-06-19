package signature

import java.io.File
import java.io.IOException
import java.util.*

class FileHandler {
    fun getLettersFromFile(fileName: String): List<Letter> {
        val letters = mutableListOf<Letter>()
        try {
            val sc = Scanner(File("./$fileName"))
            val (height, number) = sc.nextLine().split(" ")
            for (i in 0 until number.toInt()) {
                val (char, _) = sc.nextLine().split(" ")
                val lines = mutableListOf<String>()
                for (j in 0 until height.toInt()) {
                    lines.add(sc.nextLine())
                }
                letters.add(Letter(char, height.toInt(), lines))
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return letters
    }
}