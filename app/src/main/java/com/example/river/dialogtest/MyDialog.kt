package com.example.river.dialogtest

import android.app.AlertDialog
import android.content.Context
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast

class MyDialog : AlertDialog.Builder {

    var ctx: Context
    var itemEditText: EditText

    constructor(context: Context) : super(context) {
        this.ctx = context
        itemEditText = EditText(ctx)
    }

    override fun create(): AlertDialog {
        this.setMessage("Add New Item")
                .setTitle("Enter To Do Item Text")
                .setView(itemEditText)
                .setPositiveButton("OK") { dialog, positiveButton ->
                    println("*** Press OK ***")
                }

        var dlg = super.create()
        dlg.setOnShowListener {
            Toast.makeText(ctx, "Dialog Shown", Toast.LENGTH_SHORT).show()

            itemEditText.requestFocus()
            val imm =
                    ctx.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(itemEditText, InputMethod.SHOW_FORCED)

//            dlg.window.setSoftInputMode(
//                    WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
        }
        return dlg
    }
}