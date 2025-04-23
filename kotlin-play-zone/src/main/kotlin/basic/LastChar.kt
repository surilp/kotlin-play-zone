package basic

class LastChar {
    fun lastChar(s:String):Char {
        return s.last()
    }
}

fun main() {
    val lastChar = LastChar()
    println(lastChar.lastChar("goodforyou"))
}