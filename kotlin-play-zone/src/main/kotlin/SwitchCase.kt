/*
Given the integer day denoting the day number, print on the screen which day of the week it is.
Week starts from Monday and for values greater than 7 or less than 1, print Invalid.
Ensure only the 1st letter of the answer is capitalised.
*/

class SwitchCase {
    fun whichWeekDay(day: Int) {
        when (day) {
            1 -> println("Monday")
            2 -> println("Tuesday")
            3 -> println("Wednesday")
            4 -> println("Thursday")
            5 -> println("Friday")
            6 -> println("Saturday")
            7 -> println("Sunday")
            else -> println("Invalid")
        }
    }
}

fun main() {
    val switchCase = SwitchCase()
    switchCase.whichWeekDay(8)
}