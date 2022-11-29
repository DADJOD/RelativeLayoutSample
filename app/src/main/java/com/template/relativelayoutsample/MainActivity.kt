package com.template.relativelayoutsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.template.relativelayoutsample.R.*
import com.template.relativelayoutsample.R.string.*

class MainActivity : AppCompatActivity() {

    // 1st variant - good cause Fragment lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
    }

    fun onClick(view: View) {
        val userName = findViewById<EditText>(id.entry)
        lateinit var text: String

        when (view.id) {
            id.ok -> {
                text = userName.text.toString().trim()

                if (text.isNotEmpty()) {
                    Toast.makeText(this, "Hello, $text", LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, please_write, LENGTH_SHORT).show()
                }

                userName.text = null
            }

            id.cancel -> {
                userName.text = null
            }

            else -> Toast.makeText(this, oops_msg, LENGTH_SHORT).show()
        }
    }
}
    // 2nd variant - not good cause strongly attached our layout

//    lateinit var mUserName: EditText
//    lateinit var text: String
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(layout.activity_main)
//        mUserName = findViewById(id.entry)
//    }
//
//    fun onClick(view: View) = when (view.id) {
//        id.ok     -> {
//            text = mUserName.text.toString().trim()
//
//            if (text.isNotEmpty()) {
//                Toast.makeText(this, "Hello, $text", LENGTH_SHORT).show()
//            }
//
//            mUserName.text = null
//        }
//
//        id.cancel -> {
//            mUserName.text = null
//        }
//
//        else      -> Toast.makeText(this, string.oops_msg, LENGTH_SHORT).show()
//    }
