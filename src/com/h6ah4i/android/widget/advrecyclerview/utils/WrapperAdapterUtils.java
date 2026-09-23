package com.h6ah4i.android.widget.advrecyclerview.utils;

import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.adapter.AdapterPath;
import com.h6ah4i.android.widget.advrecyclerview.adapter.AdapterPathSegment;
import com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter;
import com.h6ah4i.android.widget.advrecyclerview.adapter.UnwrapPositionResult;
import com.h6ah4i.android.widget.advrecyclerview.adapter.WrapperAdapter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class WrapperAdapterUtils {
    private WrapperAdapterUtils() {
    }

    public static <T> T findWrappedAdapter(RecyclerView.Adapter adapter, Class<T> cls) {
        if (cls.isInstance(adapter)) {
            return cls.cast(adapter);
        }
        if (adapter instanceof SimpleWrapperAdapter) {
            return (T) findWrappedAdapter(((SimpleWrapperAdapter) adapter).getWrappedAdapter(), cls);
        }
        return null;
    }

    public static <T> T findWrappedAdapter(RecyclerView.Adapter adapter, Class<T> cls, int i) {
        AdapterPath adapterPath = new AdapterPath();
        if (unwrapPosition(adapter, null, null, i, adapterPath) == -1) {
            return null;
        }
        for (AdapterPathSegment adapterPathSegment : adapterPath.segments()) {
            if (cls.isInstance(adapterPathSegment.adapter)) {
                return cls.cast(adapterPathSegment.adapter);
            }
        }
        return null;
    }

    public static RecyclerView.Adapter releaseAll(RecyclerView.Adapter adapter) {
        return releaseCyclically(adapter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static RecyclerView.Adapter releaseCyclically(RecyclerView.Adapter adapter) {
        if (!(adapter instanceof WrapperAdapter)) {
            return adapter;
        }
        WrapperAdapter wrapperAdapter = (WrapperAdapter) adapter;
        ArrayList arrayList = new ArrayList();
        wrapperAdapter.getWrappedAdapters(arrayList);
        wrapperAdapter.release();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            releaseCyclically(arrayList.get(size));
        }
        arrayList.clear();
        return adapter;
    }

    public static int unwrapPosition(RecyclerView.Adapter adapter, int i) {
        return unwrapPosition(adapter, null, i);
    }

    public static int unwrapPosition(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2, int i) {
        return unwrapPosition(adapter, adapter2, null, i, null);
    }

    public static int unwrapPosition(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2, Object obj, int i) {
        return unwrapPosition(adapter, adapter2, obj, i, null);
    }

    public static int unwrapPosition(RecyclerView.Adapter adapter, AdapterPathSegment adapterPathSegment, int i, AdapterPath adapterPath) {
        return unwrapPosition(adapter, adapterPathSegment.adapter, adapterPathSegment.tag, i, adapterPath);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.recyclerview.widget.RecyclerView$Adapter] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v5, types: [androidx.recyclerview.widget.RecyclerView$Adapter] */
    public static int unwrapPosition(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2, Object obj, int i, AdapterPath adapterPath) {
        UnwrapPositionResult unwrapPositionResult = new UnwrapPositionResult();
        if (adapterPath != null) {
            adapterPath.clear();
        }
        if (adapter == 0) {
            return -1;
        }
        Object obj2 = null;
        if (adapterPath != null) {
            adapterPath.append(new AdapterPathSegment(adapter, null));
        }
        while (i != -1 && adapter != adapter2) {
            if (!(adapter instanceof WrapperAdapter)) {
                if (adapter2 == null) {
                    break;
                }
                i = -1;
                break;
            }
            unwrapPositionResult.clear();
            ((WrapperAdapter) adapter).unwrapPosition(unwrapPositionResult, i);
            i = unwrapPositionResult.position;
            obj2 = unwrapPositionResult.tag;
            if (unwrapPositionResult.isValid() && adapterPath != null) {
                adapterPath.append(unwrapPositionResult);
            }
            adapter = unwrapPositionResult.adapter;
            if (adapter == 0) {
                break;
            }
        }
        if (adapter2 != null && adapter != adapter2) {
            i = -1;
        }
        if (obj != null && obj2 != obj) {
            i = -1;
        }
        if (i == -1 && adapterPath != null) {
            adapterPath.clear();
        }
        return i;
    }

    public static int wrapPosition(AdapterPath adapterPath, RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2, int i) {
        List<AdapterPathSegment> listSegments = adapterPath.segments();
        int size = listSegments.size();
        int i2 = adapter == null ? size - 1 : -1;
        int i3 = adapter2 == null ? 0 : -1;
        if (adapter != null || adapter2 != null) {
            for (int i4 = 0; i4 < size; i4++) {
                AdapterPathSegment adapterPathSegment = listSegments.get(i4);
                if (adapter != null && adapterPathSegment.adapter == adapter) {
                    i2 = i4;
                }
                if (adapter2 != null && adapterPathSegment.adapter == adapter2) {
                    i3 = i4;
                }
            }
        }
        if (i2 == -1 || i3 == -1 || i3 > i2) {
            return -1;
        }
        return wrapPosition(adapterPath, i2, i3, i);
    }

    public static int wrapPosition(AdapterPath adapterPath, int i, int i2, int i3) {
        List<AdapterPathSegment> listSegments = adapterPath.segments();
        while (i > i2) {
            i3 = ((WrapperAdapter) listSegments.get(i - 1).adapter).wrapPosition(listSegments.get(i), i3);
            if (i3 == -1) {
                break;
            }
            i--;
        }
        return i3;
    }
}
