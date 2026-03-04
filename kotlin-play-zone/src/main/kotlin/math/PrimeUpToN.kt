package `kotlin-play-zone`.src.main.kotlin.math

fun primeUptoN(n: Int):Int {
    var result = 0

    for (num in 2..n){
        if (isPrime(num)) {
            result += 1
        }
    }
    return result
}

fun main() {
    val input = listOf(6, 10, 20)

    input.forEach {
        println("For input $it, result is ${primeUptoN(it)}")
    }
}