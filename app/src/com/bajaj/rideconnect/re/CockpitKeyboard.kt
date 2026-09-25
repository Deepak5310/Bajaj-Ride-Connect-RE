package com.bajaj.rideconnect.re

import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import kotlin.math.max
import kotlin.math.min

class CockpitKeyboard(
    private val rootView: View,
    private val etTarget: EditText?,
    private val submitListener: OnSearchSubmitListener?
) {

    fun interface OnSearchSubmitListener {
        fun onSearchSubmit(query: String)
    }

    private var layoutKeyboardAlpha: LinearLayout? = null
    private var layoutKeyboardNum: LinearLayout? = null
    private var keyShift: FrameLayout? = null
    private var ivShiftIcon: ImageView? = null

    private var isCaps = true

    private val alphaKeyIds = intArrayOf(
        R.id.key_q, R.id.key_w, R.id.key_e, R.id.key_r, R.id.key_t,
        R.id.key_y, R.id.key_u, R.id.key_i, R.id.key_o, R.id.key_p,
        R.id.key_a, R.id.key_s, R.id.key_d, R.id.key_f, R.id.key_g,
        R.id.key_h, R.id.key_j, R.id.key_k, R.id.key_l,
        R.id.key_z, R.id.key_x, R.id.key_c, R.id.key_v, R.id.key_b,
        R.id.key_n, R.id.key_m
    )

    private val numKeyIds = intArrayOf(
        R.id.key_1, R.id.key_2, R.id.key_3, R.id.key_4, R.id.key_5,
        R.id.key_6, R.id.key_7, R.id.key_8, R.id.key_9, R.id.key_0,
        R.id.key_at, R.id.key_hash, R.id.key_dollar, R.id.key_percent, R.id.key_amp,
        R.id.key_minus, R.id.key_plus, R.id.key_open_paren, R.id.key_close_paren, R.id.key_slash,
        R.id.key_asterisk, R.id.key_double_quote, R.id.key_single_quote,
        R.id.key_colon, R.id.key_semicolon, R.id.key_exclamation, R.id.key_question,
        R.id.key_dot
    )

    val isVisible: Boolean
        get() = rootView.visibility == View.VISIBLE

    init {
        initViews()
    }

    private fun initViews() {
        layoutKeyboardAlpha = rootView.findViewById(R.id.layoutKeyboardAlpha)
        layoutKeyboardNum = rootView.findViewById(R.id.layoutKeyboardNum)
        keyShift = rootView.findViewById(R.id.key_shift)
        ivShiftIcon = rootView.findViewById(R.id.ivShiftIcon)

        for (id in alphaKeyIds) {
            rootView.findViewById<View>(id)?.let { v ->
                if (v is TextView) {
                    v.setOnClickListener { insertText(v.text.toString()) }
                }
            }
        }

        for (id in numKeyIds) {
            rootView.findViewById<View>(id)?.let { v ->
                if (v is TextView) {
                    v.setOnClickListener { insertText(v.text.toString()) }
                }
            }
        }

        keyShift?.setOnClickListener { toggleCaps() }
        updateCapsVisual()

        setupBackspace(rootView.findViewById(R.id.key_backspace))
        setupBackspace(rootView.findViewById(R.id.key_backspace_num))

        rootView.findViewById<View>(R.id.key_space)?.setOnClickListener { insertText(" ") }
        rootView.findViewById<View>(R.id.key_space_num)?.setOnClickListener { insertText(" ") }

        rootView.findViewById<View>(R.id.key_mode_num)?.setOnClickListener { switchToNumeric() }
        rootView.findViewById<View>(R.id.key_mode_alpha)?.setOnClickListener { switchToAlpha() }
        rootView.findViewById<View>(R.id.key_mode_alpha_row3)?.setOnClickListener { switchToAlpha() }

        rootView.findViewById<View>(R.id.key_search_go)?.setOnClickListener { submitSearch() }
        rootView.findViewById<View>(R.id.key_search_go_num)?.setOnClickListener { submitSearch() }
    }

    private fun setupBackspace(backspaceView: View?) {
        backspaceView ?: return
        backspaceView.setOnClickListener { deleteChar() }
        backspaceView.setOnLongClickListener {
            etTarget?.text?.clear()
            true
        }
    }

    private fun toggleCaps() {
        isCaps = !isCaps
        updateCapsVisual()
        for (id in alphaKeyIds) {
            (rootView.findViewById<View>(id) as? TextView)?.let { tv ->
                val current = tv.text.toString()
                tv.text = if (isCaps) current.uppercase() else current.lowercase()
            }
        }
    }

    private fun updateCapsVisual() {
        keyShift?.isSelected = isCaps
        ivShiftIcon?.setColorFilter(if (isCaps) 0xFF38BDF8.toInt() else 0xFFFFFFFF.toInt())
    }

    private fun switchToNumeric() {
        layoutKeyboardAlpha?.visibility = View.GONE
        layoutKeyboardNum?.visibility = View.VISIBLE
    }

    private fun switchToAlpha() {
        layoutKeyboardNum?.visibility = View.GONE
        layoutKeyboardAlpha?.visibility = View.VISIBLE
    }

    private fun insertText(str: String?) {
        if (etTarget == null || str == null) return
        val start = max(etTarget.selectionStart, 0)
        val end = max(etTarget.selectionEnd, 0)
        val selStart = min(start, end)
        val selEnd = max(start, end)
        etTarget.text.replace(selStart, selEnd, str, 0, str.length)
        etTarget.setSelection(selStart + str.length)
    }

    private fun deleteChar() {
        val target = etTarget ?: return
        val text = target.text ?: return
        val start = target.selectionStart
        val end = target.selectionEnd
        if (start > 0 || end > start) {
            if (start == end) {
                text.delete(start - 1, start)
                target.setSelection(start - 1)
            } else {
                val selStart = min(start, end)
                val selEnd = max(start, end)
                text.delete(selStart, selEnd)
                target.setSelection(selStart)
            }
        }
    }

    private fun submitSearch() {
        submitListener?.onSearchSubmit(etTarget?.text?.toString().orEmpty())
    }

    fun show() {
        rootView.visibility = View.VISIBLE
    }

    fun hide() {
        rootView.visibility = View.GONE
    }
}
