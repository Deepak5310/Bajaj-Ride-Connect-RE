package com.reactnativecommunity.checkbox;

import android.content.Context;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatCheckBox;

/* JADX INFO: loaded from: classes4.dex */
class ReactCheckBox extends AppCompatCheckBox {
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;

    public ReactCheckBox(Context context) {
        super(context);
        this.mOnCheckedChangeListener = null;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.mOnCheckedChangeListener;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(this, z);
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.mOnCheckedChangeListener = onCheckedChangeListener;
    }

    void setOn(boolean z) {
        if (isChecked() == z) {
            return;
        }
        super.setChecked(z);
    }
}
