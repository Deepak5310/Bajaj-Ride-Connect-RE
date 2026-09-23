package com.mappls.sdk.plugins.places.autocomplete.data.dao;

import androidx.lifecycle.LiveData;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface a {
    LiveData<List<com.mappls.sdk.plugins.places.autocomplete.data.entity.a>> a(String str);

    void a();

    void a(com.mappls.sdk.plugins.places.autocomplete.data.entity.a aVar);

    LiveData<List<com.mappls.sdk.plugins.places.autocomplete.data.entity.a>> getAll();
}
