package com.bajaj.rideconnect.re;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bajaj.rideconnect.re.R;

public class CockpitKeyboard {

    public interface OnSearchSubmitListener {
        void onSearchSubmit(String query);
    }

    private final View rootView;
    private final EditText etTarget;
    private final OnSearchSubmitListener submitListener;

    private LinearLayout layoutKeyboardAlpha;
    private LinearLayout layoutKeyboardNum;
    private FrameLayout keyShift;
    private ImageView ivShiftIcon;

    private boolean isCaps = true; // Capitalized by default for place names

    private final int[] alphaKeyIds = {
        R.id.key_q, R.id.key_w, R.id.key_e, R.id.key_r, R.id.key_t,
        R.id.key_y, R.id.key_u, R.id.key_i, R.id.key_o, R.id.key_p,
        R.id.key_a, R.id.key_s, R.id.key_d, R.id.key_f, R.id.key_g,
        R.id.key_h, R.id.key_j, R.id.key_k, R.id.key_l,
        R.id.key_z, R.id.key_x, R.id.key_c, R.id.key_v, R.id.key_b,
        R.id.key_n, R.id.key_m
    };

    private final int[] numKeyIds = {
        R.id.key_1, R.id.key_2, R.id.key_3, R.id.key_4, R.id.key_5,
        R.id.key_6, R.id.key_7, R.id.key_8, R.id.key_9, R.id.key_0,
        R.id.key_at, R.id.key_hash, R.id.key_dollar, R.id.key_percent, R.id.key_amp,
        R.id.key_minus, R.id.key_plus, R.id.key_open_paren, R.id.key_close_paren, R.id.key_slash,
        R.id.key_asterisk, R.id.key_double_quote, R.id.key_single_quote,
        R.id.key_colon, R.id.key_semicolon, R.id.key_exclamation, R.id.key_question,
        R.id.key_dot
    };

    public CockpitKeyboard(View container, EditText target, OnSearchSubmitListener listener) {
        this.rootView = container;
        this.etTarget = target;
        this.submitListener = listener;
        initViews();
    }

    private void initViews() {
        layoutKeyboardAlpha = rootView.findViewById(R.id.layoutKeyboardAlpha);
        layoutKeyboardNum = rootView.findViewById(R.id.layoutKeyboardNum);
        keyShift = rootView.findViewById(R.id.key_shift);
        ivShiftIcon = rootView.findViewById(R.id.ivShiftIcon);

        // Bind Alpha Keys
        for (int id : alphaKeyIds) {
            View v = rootView.findViewById(id);
            if (v instanceof TextView) {
                TextView tv = (TextView) v;
                tv.setOnClickListener(view -> {
                    String ch = tv.getText().toString();
                    insertText(ch);
                });
            }
        }

        // Bind Num / Symbol Keys
        for (int id : numKeyIds) {
            View v = rootView.findViewById(id);
            if (v instanceof TextView) {
                TextView tv = (TextView) v;
                tv.setOnClickListener(view -> {
                    String ch = tv.getText().toString();
                    insertText(ch);
                });
            }
        }

        // Shift / Caps Key
        if (keyShift != null) {
            keyShift.setOnClickListener(v -> toggleCaps());
            updateCapsVisual();
        }

        // Backspace Keys
        setupBackspace(rootView.findViewById(R.id.key_backspace));
        setupBackspace(rootView.findViewById(R.id.key_backspace_num));

        // Spacebar Keys
        View keySpace = rootView.findViewById(R.id.key_space);
        if (keySpace != null) {
            keySpace.setOnClickListener(v -> insertText(" "));
        }
        View keySpaceNum = rootView.findViewById(R.id.key_space_num);
        if (keySpaceNum != null) {
            keySpaceNum.setOnClickListener(v -> insertText(" "));
        }

        // Mode switch: ?123
        View keyModeNum = rootView.findViewById(R.id.key_mode_num);
        if (keyModeNum != null) {
            keyModeNum.setOnClickListener(v -> switchToNumeric());
        }

        // Mode switch: ABC
        View keyModeAlpha = rootView.findViewById(R.id.key_mode_alpha);
        if (keyModeAlpha != null) {
            keyModeAlpha.setOnClickListener(v -> switchToAlpha());
        }
        View keyModeAlphaRow3 = rootView.findViewById(R.id.key_mode_alpha_row3);
        if (keyModeAlphaRow3 != null) {
            keyModeAlphaRow3.setOnClickListener(v -> switchToAlpha());
        }

        // Search / Go Keys
        View keySearchGo = rootView.findViewById(R.id.key_search_go);
        if (keySearchGo != null) {
            keySearchGo.setOnClickListener(v -> submitSearch());
        }
        View keySearchGoNum = rootView.findViewById(R.id.key_search_go_num);
        if (keySearchGoNum != null) {
            keySearchGoNum.setOnClickListener(v -> submitSearch());
        }
    }

    private void setupBackspace(View backspaceView) {
        if (backspaceView == null) return;
        backspaceView.setOnClickListener(v -> deleteChar());
        backspaceView.setOnLongClickListener(v -> {
            if (etTarget != null && etTarget.getText() != null) {
                etTarget.getText().clear();
            }
            return true;
        });
    }

    private void toggleCaps() {
        isCaps = !isCaps;
        updateCapsVisual();
        for (int id : alphaKeyIds) {
            View v = rootView.findViewById(id);
            if (v instanceof TextView) {
                TextView tv = (TextView) v;
                String current = tv.getText().toString();
                tv.setText(isCaps ? current.toUpperCase() : current.toLowerCase());
            }
        }
    }

    private void updateCapsVisual() {
        if (keyShift != null) {
            keyShift.setSelected(isCaps);
        }
        if (ivShiftIcon != null) {
            ivShiftIcon.setColorFilter(isCaps ? 0xFF38BDF8 : 0xFFFFFFFF);
        }
    }

    private void switchToNumeric() {
        if (layoutKeyboardAlpha != null) layoutKeyboardAlpha.setVisibility(View.GONE);
        if (layoutKeyboardNum != null) layoutKeyboardNum.setVisibility(View.VISIBLE);
    }

    private void switchToAlpha() {
        if (layoutKeyboardNum != null) layoutKeyboardNum.setVisibility(View.GONE);
        if (layoutKeyboardAlpha != null) layoutKeyboardAlpha.setVisibility(View.VISIBLE);
    }

    private void insertText(String str) {
        if (etTarget == null || str == null) return;
        int start = Math.max(etTarget.getSelectionStart(), 0);
        int end = Math.max(etTarget.getSelectionEnd(), 0);
        int selStart = Math.min(start, end);
        int selEnd = Math.max(start, end);
        etTarget.getText().replace(selStart, selEnd, str, 0, str.length());
        etTarget.setSelection(selStart + str.length());
    }

    private void deleteChar() {
        if (etTarget == null || etTarget.getText() == null) return;
        int start = etTarget.getSelectionStart();
        int end = etTarget.getSelectionEnd();
        if (start > 0 || end > start) {
            if (start == end) {
                etTarget.getText().delete(start - 1, start);
                etTarget.setSelection(start - 1);
            } else {
                int selStart = Math.min(start, end);
                int selEnd = Math.max(start, end);
                etTarget.getText().delete(selStart, selEnd);
                etTarget.setSelection(selStart);
            }
        }
    }

    private void submitSearch() {
        if (submitListener != null && etTarget != null) {
            submitListener.onSearchSubmit(etTarget.getText().toString());
        }
    }

    public void show() {
        rootView.setVisibility(View.VISIBLE);
    }

    public void hide() {
        rootView.setVisibility(View.GONE);
    }

    public boolean isVisible() {
        return rootView.getVisibility() == View.VISIBLE;
    }
}
