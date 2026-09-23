package com.mappls.sdk.category.fragment;

import com.mappls.sdk.nearby.plugin.CategoryCode;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface ICategorySelectionListener {
    void onCancel();

    void onCategorySelected(List<? extends CategoryCode> list);
}
