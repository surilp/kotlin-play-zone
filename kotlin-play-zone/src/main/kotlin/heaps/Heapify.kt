package `kotlin-play-zone`.src.main.kotlin.heaps

import kotlin.math.ceil

fun heapify(nums: IntArray, ind: Int, value: Int): IntArray {
    val n = nums.size
    val parent = (ceil(ind.toDouble() / 2) - 1).toInt()
    val leftChild = 2 * ind + 1
    val rightChild = 2 * ind + 2

    if (parent < 0) {
        return heapifyDown(nums, ind, value)
    } else if (leftChild > n-1 && rightChild > n-1) {
        return heapifyUp(nums, ind, value)
    } else if (nums[parent] > nums[ind]) {
        return heapifyUp(nums, ind, value)
    } else if (nums[ind] > nums[leftChild] || nums [ind] > nums[rightChild] ) {
        return heapifyDown(nums, ind, value)
    }

    return nums
}

fun heapifyDown(nums: IntArray, ind: Int, value: Int): IntArray {
    var leftChild = 2 * ind + 1
    var rightChild = 2 * ind + 2
    var i = ind
    nums[i] = value
    var childI = 0
    val n = nums.size
    if (leftChild >= n && rightChild >= n) {
        return nums
    } else if (rightChild >= n) {
        childI = leftChild
    } else {
        if (nums[leftChild] <= nums[rightChild]) {
            childI = leftChild
        } else {
            childI = rightChild
        }
    }


    while (i < n && nums[i] > nums[childI]) {
        if (leftChild >= n && rightChild >= n) {
            return nums
        } else if (rightChild >= n) {
            childI = leftChild
        } else {
            if (nums[leftChild] <= nums[rightChild]) {
                childI = leftChild
            } else {
                childI = rightChild
            }
        }
        nums[i] = nums[childI].also { nums[childI] = nums[i] }
        i = childI
        leftChild = 2 * i + 1
        rightChild = 2 * i + 2
    }

    return nums
}


fun heapifyUp(nums: IntArray, ind: Int, value: Int): IntArray {
    var i = ind
    nums[i] = value
    var parent = (ceil(ind.toDouble() / 2) - 1).toInt()


    while (parent >= 0 && nums[parent] > nums[i]) {
        nums[parent] = nums[i].also { nums[i] = nums[parent] }
        i = parent
        parent = (ceil(i.toDouble() / 2) - 1).toInt()
    }

    return nums
}


fun main() {
    val input = listOf(
        listOf(intArrayOf(1, 4, 5, 5, 7, 6), 5, 2),
        listOf(intArrayOf(2, 4, 3, 6, 5, 7, 8, 7), 0, 7),
    )

    input.forEach {
        println(heapify(it[0] as IntArray, it[1] as Int, it[2] as Int).contentToString())
    }
}