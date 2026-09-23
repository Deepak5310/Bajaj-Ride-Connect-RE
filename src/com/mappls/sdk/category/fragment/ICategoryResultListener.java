package com.mappls.sdk.category.fragment;

import com.mappls.sdk.category.model.PoiResult;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface ICategoryResultListener {
    void onCategoryResult(List<PoiResult> list);

    void onCategorySelectedResult(PoiResult poiResult);

    void onResultCancel();
}
