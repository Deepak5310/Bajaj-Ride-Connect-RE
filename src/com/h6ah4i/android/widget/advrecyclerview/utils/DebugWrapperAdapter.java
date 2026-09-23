package com.h6ah4i.android.widget.advrecyclerview.utils;

import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.adapter.AdapterPathSegment;
import com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter;
import com.h6ah4i.android.widget.advrecyclerview.adapter.UnwrapPositionResult;
import com.h6ah4i.android.widget.advrecyclerview.adapter.WrapperAdapter;

/* JADX INFO: loaded from: classes6.dex */
public class DebugWrapperAdapter extends SimpleWrapperAdapter<RecyclerView.ViewHolder> {
    public static final int FLAGS_ALL_DEBUG_FEATURES = 3;
    public static final int FLAG_VERIFY_UNWRAP_POSITION = 2;
    public static final int FLAG_VERIFY_WRAP_POSITION = 1;
    private int mFlags;

    public DebugWrapperAdapter(RecyclerView.Adapter adapter) {
        super(adapter);
        this.mFlags = 3;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, com.h6ah4i.android.widget.advrecyclerview.adapter.WrapperAdapter
    public int wrapPosition(AdapterPathSegment adapterPathSegment, int i) {
        WrapperAdapter wrapperAdapter;
        int iWrapPosition;
        if ((this.mFlags & 1) != 0 && (getWrappedAdapter() instanceof WrapperAdapter) && (iWrapPosition = (wrapperAdapter = (WrapperAdapter) getWrappedAdapter()).wrapPosition(adapterPathSegment, i)) != -1) {
            UnwrapPositionResult unwrapPositionResult = new UnwrapPositionResult();
            wrapperAdapter.unwrapPosition(unwrapPositionResult, iWrapPosition);
            if (unwrapPositionResult.position != i) {
                throw new IllegalStateException("Found a WrapperAdapter implementation issue while executing wrapPosition(): " + getWrappedAdapter().getClass().getSimpleName() + "\nwrapPosition(" + i + ") returns " + iWrapPosition + ", but unwrapPosition(" + iWrapPosition + ") returns " + unwrapPositionResult.position);
            }
        }
        return super.wrapPosition(adapterPathSegment, i);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, com.h6ah4i.android.widget.advrecyclerview.adapter.WrapperAdapter
    public void unwrapPosition(UnwrapPositionResult unwrapPositionResult, int i) {
        int iWrapPosition;
        if ((this.mFlags & 2) != 0 && (getWrappedAdapter() instanceof WrapperAdapter)) {
            WrapperAdapter wrapperAdapter = (WrapperAdapter) getWrappedAdapter();
            UnwrapPositionResult unwrapPositionResult2 = new UnwrapPositionResult();
            wrapperAdapter.unwrapPosition(unwrapPositionResult2, i);
            if (unwrapPositionResult2.isValid() && i != (iWrapPosition = wrapperAdapter.wrapPosition(new AdapterPathSegment(unwrapPositionResult2.adapter, unwrapPositionResult2.tag), unwrapPositionResult2.position))) {
                throw new IllegalStateException("Found a WrapperAdapter implementation issue while executing unwrapPosition(): " + getWrappedAdapter().getClass().getSimpleName() + "\nunwrapPosition(" + i + ") returns " + unwrapPositionResult2.position + ", but wrapPosition(" + unwrapPositionResult2.position + ") returns " + iWrapPosition);
            }
        }
        super.unwrapPosition(unwrapPositionResult, i);
    }

    public void setSettingFlags(int i) {
        this.mFlags = i;
    }

    public int getSettingFlags() {
        return this.mFlags;
    }
}
