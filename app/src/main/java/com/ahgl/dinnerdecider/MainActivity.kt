package com.ahgl.dinnerdecider

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
//AHGL
import java.util.*


class MainActivity : AppCompatActivity() {
    var foodList = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        decideButton.setOnClickListener {
            if(foodList.size>=2) {
                val random = Random()
                val randomFood = random.nextInt(foodList.count())
                selectedItem.text = foodList[randomFood]
                messageView.text = "DECIDED"
            }
            else if(foodList.size==1)
                messageView.text = "ENTER ONE MORE ITEM TO DECIDE"
            else
                messageView.text = "ENTER ITEMS TO DECIDE"
        }
        enterItemButton.setOnClickListener {
            var newFood = addItemButton.text.toString()
            newFood = newFood.toUpperCase()
            newFood = newFood.trim()
            if (newFood.length > 0) {
                foodList.add(newFood)
                addItemButton.text.clear()
                messageView.text = "ADDED"
            }
            else
                messageView.text = "PLEASE ENTER A ITEM"
        }
        itemClear.setOnClickListener {
            foodList.clear()
            messageView.text = "LIST CLEARED"
            selectedItem.text = "WELCOME"
        }
    }
}