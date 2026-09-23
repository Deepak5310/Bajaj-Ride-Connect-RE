package com.mappls.sdk.plugins.places.autocomplete;

import android.text.TextUtils;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.mappls.sdk.plugins.places.autocomplete.data.SearchHistoryDatabase;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static a c;
    private final SearchHistoryDatabase a;
    private final MediatorLiveData<List<com.mappls.sdk.plugins.places.autocomplete.data.entity.a>> b;

    /* JADX INFO: renamed from: com.mappls.sdk.plugins.places.autocomplete.a$a, reason: collision with other inner class name */
    final class C0111a implements Observer<List<com.mappls.sdk.plugins.places.autocomplete.data.entity.a>> {
        final /* synthetic */ SearchHistoryDatabase a;

        C0111a(SearchHistoryDatabase searchHistoryDatabase) {
            this.a = searchHistoryDatabase;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(List<com.mappls.sdk.plugins.places.autocomplete.data.entity.a> list) {
            List<com.mappls.sdk.plugins.places.autocomplete.data.entity.a> list2 = list;
            if (this.a.a().getValue() != 0) {
                a.this.b.postValue(list2);
            }
        }
    }

    private a(SearchHistoryDatabase searchHistoryDatabase) {
        this.a = searchHistoryDatabase;
        MediatorLiveData<List<com.mappls.sdk.plugins.places.autocomplete.data.entity.a>> mediatorLiveData = new MediatorLiveData<>();
        this.b = mediatorLiveData;
        mediatorLiveData.addSource(searchHistoryDatabase.b().getAll(), new C0111a(searchHistoryDatabase));
    }

    public static a a(SearchHistoryDatabase searchHistoryDatabase) {
        if (c == null) {
            c = new a(searchHistoryDatabase);
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list) {
        if (this.a.a().getValue() != 0) {
            this.b.postValue(list);
        }
    }

    public final MediatorLiveData a() {
        return this.b;
    }

    public final void a(com.mappls.sdk.plugins.places.autocomplete.data.entity.a aVar) {
        SearchHistoryDatabase.a(this.a, aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(String str) {
        this.b.addSource(TextUtils.isEmpty(str) ? this.a.b().getAll() : this.a.b().a(str), new Observer() { // from class: com.mappls.sdk.plugins.places.autocomplete.a$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.a((List) obj);
            }
        });
    }
}
