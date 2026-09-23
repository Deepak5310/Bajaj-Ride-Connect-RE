package com.h6ah4i.android.widget.advrecyclerview.adapter;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes6.dex */
public class UnwrapPositionResult {
    public RecyclerView.Adapter adapter;
    public int position = -1;
    public Object tag;

    public void clear() {
        this.adapter = null;
        this.tag = null;
        this.position = -1;
    }

    public boolean isValid() {
        return (this.adapter == null || this.position == -1) ? false : true;
    }
}
