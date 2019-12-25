package com.example.textinputedittextstylespinner

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class SpinnerFragment : DialogFragment() {

    companion object {
        private val TITLEID = "titleId"
        private val LISTID = "listId"
        private val EDITTEXTID = "editTextId"

        fun newInstance(titleId: Int, listId: Int, editTextId: Int): SpinnerFragment? {
            val bundle = Bundle()
            bundle.putInt(TITLEID, titleId)
            bundle.putInt(LISTID, listId)
            bundle.putInt(EDITTEXTID, editTextId)
            val spinnerFragment = SpinnerFragment()
            spinnerFragment.arguments = bundle
            return spinnerFragment
        }

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val titleId = arguments!!.getInt(TITLEID)
        val listId = arguments!!.getInt(LISTID)
        val editTextId = arguments!!.getInt(EDITTEXTID)
        val builder: AlertDialog.Builder = AlertDialog.Builder(this!!.activity)
        try {
            val items = resources.getStringArray(listId)
            builder.setItems(listId, DialogInterface.OnClickListener { dialog, pos ->
                val et =
                    activity!!.findViewById<View>(editTextId) as EditText
                val selectedText = items[pos]
                if (!TextUtils.isEmpty(selectedText)) {
                    et.setText(selectedText)
                    MainActivity.control_carga = et.text.toString()
                } else {
                    et.text.clear()
                }
            })
        } catch (e: Throwable) {
            Log.e(
                javaClass.toString(),
                "Failed to select option in " + activity.toString() + " as there are no references for passed in resource Ids in Bundle",
                e
            )
            Toast.makeText(
                activity,
                "Erro ao selecionar!",
                Toast.LENGTH_LONG
            ).show()
        }
        return builder.create()
    }
}