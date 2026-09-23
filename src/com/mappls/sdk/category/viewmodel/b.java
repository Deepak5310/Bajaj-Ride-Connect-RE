package com.mappls.sdk.category.viewmodel;

import androidx.lifecycle.ViewModel;
import com.mappls.sdk.category.model.SearchCategoryOption;
import com.mappls.sdk.category.model.SearchCategoryUIOption;
import com.mappls.sdk.nearby.plugin.CategoryCode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class b extends ViewModel {
    private List<? extends CategoryCode> a;
    private SearchCategoryOption b = com.mappls.sdk.category.a.c();
    private SearchCategoryUIOption c = com.mappls.sdk.category.a.d();

    public final List<CategoryCode> a() {
        return this.a;
    }

    public final void a(SearchCategoryUIOption searchCategoryUIOption) {
        Intrinsics.checkNotNullParameter(searchCategoryUIOption, "<set-?>");
        this.c = searchCategoryUIOption;
    }

    public final void a(List<? extends CategoryCode> list) {
        this.a = list;
    }

    public final SearchCategoryOption b() {
        return this.b;
    }

    public final SearchCategoryUIOption c() {
        return this.c;
    }
}
