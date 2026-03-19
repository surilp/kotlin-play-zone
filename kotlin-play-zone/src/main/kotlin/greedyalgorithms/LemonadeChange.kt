package `kotlin-play-zone`.src.main.kotlin.greedyalgorithms

fun lemonadeChange(bills: IntArray): Boolean {
    var five = 0
    var ten = 0
    var twenty = 0

    for (bill in bills) {
        if (bill == 5) {
            five++
        }else if (bill == 10) {
            if (five <= 0) {
                return false
            } else {
                ten++
                five--
            }
        } else {
            if (ten >= 1 && five >= 1) {
                ten--
                five--
                twenty++
            } else if (five >= 3) {
                five -= 3
                twenty++
            } else {
                return false
            }
        }
    }

    return true
}

fun main() {
    val input = listOf(
        intArrayOf(5, 5, 10, 5, 20),
        intArrayOf(5, 5, 10, 10, 20),
        intArrayOf(5, 5, 10, 20),
    )

    input.forEach {
        println("For input ${it.contentToString()}, result is ${lemonadeChange(it)}")
    }
}