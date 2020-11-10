package com.caneryilmazapps.travellingdealer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var addCustomerToListBtn: Button
    private lateinit var sumOfNodesBtn: Button
    private lateinit var printList: Button
    private lateinit var printLengthOfListBtn: Button
    private lateinit var deleteNodeBtn: Button
    private lateinit var clearListBtn: Button
    private lateinit var historyOfListTxt: TextView
    private lateinit var clearHistoryBtn: Button

    private var headNode: Node? = null
    private var aListForDeleteNodeFunc = ArrayList<Node>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addCustomerToListBtn = findViewById(R.id.addCustomerToListBtn)
        sumOfNodesBtn = findViewById(R.id.sumOfNodesBtn)
        printList = findViewById(R.id.printListBtn)
        printLengthOfListBtn = findViewById(R.id.printLengthOfListBtn)
        deleteNodeBtn = findViewById(R.id.deleteNodeBtn)
        clearListBtn = findViewById(R.id.clearListBtn)
        historyOfListTxt = findViewById(R.id.historyOfListTxt)
        clearHistoryBtn = findViewById(R.id.clearHistoryBtn)

        addCustomerToListBtn.setOnClickListener {
            addCustomerToList()
        }

        sumOfNodesBtn.setOnClickListener {
            sumOfNodes()
        }

        printList.setOnClickListener {
            printList()
        }

        printLengthOfListBtn.setOnClickListener {
            printLengthOfList()
        }

        deleteNodeBtn.setOnClickListener {
            aListForDeleteNodeFunc.shuffle()
            deleteNode(aListForDeleteNodeFunc[0].x, aListForDeleteNodeFunc[0].y)
        }

        clearListBtn.setOnClickListener {
            clearList()
        }

        clearHistoryBtn.setOnClickListener {
            clearHistory()
        }

        headNode = Node(3, 7)
        headNode?.path = 0.0

        aListForDeleteNodeFunc.add(Node(3, 7))
        aListForDeleteNodeFunc.add(Node(1, 4))
        aListForDeleteNodeFunc.add(Node(6, 5))
        aListForDeleteNodeFunc.add(Node(9, 2))
    }

    private fun clearHistory() {
        historyOfListTxt.text = ""
    }

    private fun clearList() {
        headNode?.following = null
        showAlertDialog("All node deleted.", "Clear List")
        historyOfListTxt.text = "${historyOfListTxt.text}\nClear List\n\nAll node deleted\n\n----------\n"
    }

    private fun deleteNode(x: Int, y: Int) {
        val deleteResultMessage = headNode?.deleteNode(x, y)
        showAlertDialog(deleteResultMessage, "Delete Node")
        historyOfListTxt.text = "${historyOfListTxt.text}\nDelete Node\n\n$deleteResultMessage\n\n----------\n"
    }

    private fun printLengthOfList() {
        val lengthOfList = headNode?.length()
        showAlertDialog(lengthOfList?.toString(), "Length Of List")
        historyOfListTxt.text = "${historyOfListTxt.text}\nPrint Length Of List\n\n$lengthOfList\n\n----------\n"
    }

    private fun printList() {
        val printListString = headNode?.printNodes()
        showAlertDialog(printListString, "Print List")
        historyOfListTxt.text = "${historyOfListTxt.text}\nPrint List\n\n$printListString\n\n----------\n"
    }

    private fun sumOfNodes() {
        val sumOfNodes = headNode?.sumOfNodes()
        val stringSumOfNodes = String.format("%.5f", sumOfNodes)
        val stringTotalDistance = String.format("%.5f", sumOfNodes?.times(2))
        showAlertDialog("The Total Distance: $stringTotalDistance", "Sum Of Nodes")
        historyOfListTxt.text = "${historyOfListTxt.text}\nSum Of Nodes\n\n$stringSumOfNodes\n\nThe Total Distance\n\n$stringTotalDistance\n\n----------\n"
    }

    private fun addCustomerToList() {
        headNode?.appendToEnd(1, 10)
        historyOfListTxt.text = "${historyOfListTxt.text}\nAdd Customer To List\n\nCustomer(1, 10) added\n"

        headNode?.appendToEnd(1, 4)
        historyOfListTxt.text = "${historyOfListTxt.text}Customer(1, 4) added\n"

        headNode?.appendToEnd(2, 1)
        historyOfListTxt.text = "${historyOfListTxt.text}Customer(2, 1) added\n"

        headNode?.appendToEnd(5, 2)
        historyOfListTxt.text = "${historyOfListTxt.text}Customer(5, 2) added\n"

        headNode?.appendToEnd(6, 5)
        historyOfListTxt.text = "${historyOfListTxt.text}Customer(6, 5) added\n"

        headNode?.appendToEnd(8, 4)
        historyOfListTxt.text = "${historyOfListTxt.text}Customer(8, 4) added\n"

        headNode?.appendToEnd(8, 9)
        historyOfListTxt.text = "${historyOfListTxt.text}Customer(8 ,9) added\n"

        headNode?.appendToEnd(9, 2)
        historyOfListTxt.text = "${historyOfListTxt.text}Customer(9, 2) added\n\n----------\n"
    }

    private fun showAlertDialog(message: String?, title: String?) {
        AlertDialog.Builder(this)
                .setMessage(message)
                .setTitle(title)
                .setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }.show()
    }
}