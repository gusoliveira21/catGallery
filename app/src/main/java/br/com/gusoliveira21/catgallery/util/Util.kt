package br.com.gusoliveira21.catgallery.util

import android.content.Context
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.FragmentActivity
import com.google.android.material.textfield.TextInputLayout

object Util {
    fun hideKeyBoard(requireActivity: FragmentActivity, textInputLayout: TextInputLayout) {
        if (!textInputLayout.isFocused) {
            val inputMethodManager: InputMethodManager =
                requireActivity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            try {
                inputMethodManager.hideSoftInputFromWindow(
                    requireActivity.currentFocus!!.windowToken,
                    0)
            } catch (e: Throwable) {
                Log.e("hideKeyBoard error:",
                    "$e \n\n " +
                            "$inputMethodManager \n\n " +
                            "${textInputLayout.isFocusable}")
            }
        }
    }
}
