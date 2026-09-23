package com.afollestad.materialdialogs.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.afollestad.materialdialogs.util.DialogUtils;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes3.dex */
public class MDTintHelper {
    public static void setTint(RadioButton radioButton, ColorStateList colorStateList) {
        radioButton.setButtonTintList(colorStateList);
    }

    public static void setTint(RadioButton radioButton, int i) {
        int disabledColor = DialogUtils.getDisabledColor(radioButton.getContext());
        setTint(radioButton, new ColorStateList(new int[][]{new int[]{R.attr.state_enabled, -16842912}, new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{-16842910, -16842912}, new int[]{-16842910, R.attr.state_checked}}, new int[]{DialogUtils.resolveColor(radioButton.getContext(), com.afollestad.materialdialogs.R.attr.colorControlNormal), i, disabledColor, disabledColor}));
    }

    public static void setTint(CheckBox checkBox, ColorStateList colorStateList) {
        checkBox.setButtonTintList(colorStateList);
    }

    public static void setTint(CheckBox checkBox, int i) {
        int disabledColor = DialogUtils.getDisabledColor(checkBox.getContext());
        setTint(checkBox, new ColorStateList(new int[][]{new int[]{R.attr.state_enabled, -16842912}, new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{-16842910, -16842912}, new int[]{-16842910, R.attr.state_checked}}, new int[]{DialogUtils.resolveColor(checkBox.getContext(), com.afollestad.materialdialogs.R.attr.colorControlNormal), i, disabledColor, disabledColor}));
    }

    public static void setTint(SeekBar seekBar, int i) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i);
        seekBar.setThumbTintList(colorStateListValueOf);
        seekBar.setProgressTintList(colorStateListValueOf);
    }

    public static void setTint(ProgressBar progressBar, int i) {
        setTint(progressBar, i, false);
    }

    private static void setTint(ProgressBar progressBar, int i, boolean z) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i);
        progressBar.setProgressTintList(colorStateListValueOf);
        progressBar.setSecondaryProgressTintList(colorStateListValueOf);
        if (z) {
            return;
        }
        progressBar.setIndeterminateTintList(colorStateListValueOf);
    }

    private static ColorStateList createEditTextColorStateList(Context context, int i) {
        return new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{-16842919, -16842908}, new int[0]}, new int[]{DialogUtils.resolveColor(context, com.afollestad.materialdialogs.R.attr.colorControlNormal), DialogUtils.resolveColor(context, com.afollestad.materialdialogs.R.attr.colorControlNormal), i});
    }

    public static void setTint(EditText editText, int i) {
        ColorStateList colorStateListCreateEditTextColorStateList = createEditTextColorStateList(editText.getContext(), i);
        if (editText instanceof AppCompatEditText) {
            ((AppCompatEditText) editText).setSupportBackgroundTintList(colorStateListCreateEditTextColorStateList);
        } else {
            editText.setBackgroundTintList(colorStateListCreateEditTextColorStateList);
        }
        setCursorTint(editText, i);
    }

    private static void setCursorTint(EditText editText, int i) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            int i2 = declaredField.getInt(editText);
            Field declaredField2 = TextView.class.getDeclaredField("mEditor");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(editText);
            Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
            declaredField3.setAccessible(true);
            Drawable[] drawableArr = {ContextCompat.getDrawable(editText.getContext(), i2), ContextCompat.getDrawable(editText.getContext(), i2)};
            drawableArr[0].setColorFilter(i, PorterDuff.Mode.SRC_IN);
            drawableArr[1].setColorFilter(i, PorterDuff.Mode.SRC_IN);
            declaredField3.set(obj, drawableArr);
        } catch (NoSuchFieldException e) {
            Log.d("MDTintHelper", "Device issue with cursor tinting: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
