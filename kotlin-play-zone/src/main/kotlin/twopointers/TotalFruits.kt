package `kotlin-play-zone`.src.main.kotlin.twopointers

fun totalFruits(fruits: IntArray): Int{

    var fruit1 = 0
    var fruit2 = 0

    var fruit1Count = 0
    var fruit2Count = 0

    var l = 0
    var r = 0

    val n = fruits.size
    var result = 0

    while (r < n) {
        val fruit = fruits[r]

        if (fruit1 != 0 && fruit2 != 0 && fruit != fruit1 && fruit != fruit2) {
            val lastFruit = fruits[l]
            if (lastFruit == fruit1) {
                while (fruit1Count != 0) {
                    if (fruits[l] == fruit1) {
                        fruit1Count--
                    }
                    l++
                }
            } else {
                while (fruit2Count != 0) {
                    if (fruits[l] == fruit2) {
                        fruit2Count--
                    }
                    l++
                }
            }
        }

        if (fruit1Count == 0) {
            fruit1 = fruit
            fruit1Count++
        } else {
            fruit2 = fruit
            fruit2Count++
        }

        result = maxOf(result, r-l + 1)

        r++
    }

    return result
}

fun totalFruitsII(fruits: IntArray): Int{
    val map = HashMap<Int, Int>()

    var l = 0
    var r = 0

    val n = fruits.size
    var result = 0
    while (r < n) {
        val fruit = fruits[r]
        map[fruit] = map.getOrDefault(fruit, 0) + 1

        if (map.size > 2) {
            map[fruits[l]] = map[fruits[l]]!! - 1
            if (map[fruits[l]] == 0) {
                map.remove(fruits[l])
            }
            l++
        }


        if (map.size <= 2) {
            result = maxOf(result, r-l+1)
        }

        r++
    }

    return result
}

fun main() {
    val input = listOf(
        intArrayOf(1, 2, 1),
        intArrayOf(1, 2, 3, 2, 2),
        intArrayOf(1, 2, 3, 4, 5),
        intArrayOf(3, 3, 3, 3, 3, 3),
    )

    input.forEach {
        println(totalFruitsII(it))
    }

}