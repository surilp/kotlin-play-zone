package `kotlin-play-zone`.src.main.kotlin.string

import kotlin.math.max

fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
    val result = mutableListOf<String>()
    val n = words.size

    var idx = 0
    while (idx < n) {
        var tempSize = 0
        var resultIdx = idx
        var newLine = true
        for (i in idx until n) {
            val word = words[i]

            if (newLine) {
                tempSize += word.length
                newLine = false
            } else {
                tempSize += word.length + 1
            }

            if (tempSize == maxWidth) {
                resultIdx = i
                break
            } else if (tempSize > maxWidth) {
                resultIdx = i - 1
                tempSize -= word.length + 1
                break
            } else {
                resultIdx = i
            }
        }

        val totalWords = resultIdx - idx + 1
        val wordSize = tempSize - totalWords + 1
        val numOfSpaces = maxWidth - wordSize
        val spaceSize = if (resultIdx == n - 1) {
            1
        } else if (totalWords == 1) {
            maxWidth - wordSize
        } else {
            numOfSpaces / (totalWords - 1)
        }

        val line = words.slice(idx..resultIdx).joinToString(" ".repeat(spaceSize)).padEnd(maxWidth)
        result.add(line)

        idx = resultIdx + 1
    }

    return result
}

fun main() {
    val input = listOf(
        Pair(
            arrayOf("This", "is", "an", "example", "of", "text", "justification."),
            16
        ),
        Pair(
            arrayOf("What", "must", "be", "acknowledgment", "shall", "be"),
            16
        ),
        Pair(
            arrayOf("Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"),
            20
        )
    )

    input.forEach {
        println(fullJustify(it.first, it.second))
    }
}