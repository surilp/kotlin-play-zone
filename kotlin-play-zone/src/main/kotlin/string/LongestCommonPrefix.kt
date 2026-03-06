package `kotlin-play-zone`.src.main.kotlin.string

fun longestCommonPrefix(strArr: Array<String>): String {
    var index = 0
    val firstStr = strArr[0]

    outer@while (index < firstStr.length) {
        inner@for(str in strArr) {
            if (index >= str.length - 1 || str[index] != firstStr[index]) {
                break@outer
            }
        }
        index++
    }

    return firstStr.substring(0, index)
}

fun main() {
    val input = listOf(
        arrayOf("flowers" , "flow" , "fly", "flight" ),
        arrayOf("dog" , "cat" , "animal", "monkey" ),
        arrayOf("lady" , "lazy")
    )

    input.forEach {
        println("For input ${it.contentToString()} result is ${longestCommonPrefix(it)}")
    }
}
