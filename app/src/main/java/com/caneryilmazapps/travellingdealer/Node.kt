package com.caneryilmazapps.travellingdealer

import kotlin.math.pow
import kotlin.math.sqrt

class Node(var x: Int, var y: Int) {

    var path: Double? = null
    var following: Node? = null

    fun appendToEnd(x: Int, y: Int) {

        val head = this
        val newNode = Node(x, y)

        val diffX = (head.x - x).toDouble().pow(2)
        val diffY = (head.y - y).toDouble().pow(2)
        newNode.path = sqrt((diffX + diffY))

        var temp: Node? = this
        while (temp!!.following != null) {
            temp = temp.following
        }
        temp.following = newNode
    }

    fun printNodes(): String {

        var printNodesString = "Factory(3, 7)"

        val head = this

        var tempNode: Node? = head.following
        while (tempNode != null) {
            val stringPath = String.format("%.5f", tempNode.path)
            printNodesString = "$printNodesString\nCustomer(${tempNode.x}, ${tempNode.y}) - $stringPath"
            tempNode = tempNode.following
        }
        return printNodesString
    }

    fun length(): Int {

        var length = 0

        var tempNode: Node? = this
        while (tempNode != null) {
            length++
            tempNode = tempNode.following
        }
        return length
    }

    fun sumOfNodes(): Double {

        var sumOfNodes = 0.0

        val head = this

        var tempNode: Node? = head
        while (tempNode != null) {
            sumOfNodes += tempNode.path!!
            tempNode = tempNode.following
        }
        return sumOfNodes
    }

    fun deleteNode(x: Int, y: Int): String {

        val head = this

        var tempNode: Node? = head
        var prevNode: Node? = null

        if (tempNode != null && tempNode.x == x && tempNode.y == y) {
            return "You can't delete the factory"
        }

        while (tempNode != null && !(tempNode.x == x && tempNode.y == y)) {
            prevNode = tempNode
            tempNode = tempNode.following
        }

        if (tempNode == null)
            return "($x, $y) not found"

        prevNode?.following = tempNode.following
        return "($x, $y) deleted"
    }
}

