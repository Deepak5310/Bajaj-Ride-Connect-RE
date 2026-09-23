package com.bajajconnect;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(0);

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        if (INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i) {
        return InnerBrLookup.sKeys.get(i);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.mappls.sdk.category.DataBinderMapperImpl());
        arrayList.add(new com.mappls.sdk.direction.ui.DataBinderMapperImpl());
        arrayList.add(new com.mappls.sdk.navigation.ui.DataBinderMapperImpl());
        arrayList.add(new com.mappls.sdk.nearby.plugin.DataBinderMapperImpl());
        return arrayList;
    }

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(17);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "arrival");
            sparseArray.put(2, "destinationRouteLocation");
            sparseArray.put(3, DirectionsCriteria.ANNOTATION_DISTANCE);
            sparseArray.put(4, "onClickGetRoute");
            sparseArray.put(5, "onClickSearchCategory");
            sparseArray.put(6, "onHandleBack");
            sparseArray.put(7, "onNextClick");
            sparseArray.put(8, "onPreviousClick");
            sparseArray.put(9, "onRouteReportClick");
            sparseArray.put(10, "onStartClick");
            sparseArray.put(11, "onclickHandleBack");
            sparseArray.put(12, "retryButtonClick");
            sparseArray.put(13, "routeTime");
            sparseArray.put(14, "sourceRouteLocation");
            sparseArray.put(15, "startButtonClick");
            sparseArray.put(16, "wayPoints");
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys = new HashMap<>(0);

        private InnerLayoutIdLookup() {
        }
    }
}
