package com.mappls.sdk.maps;

import com.mappls.sdk.maps.http.HttpRequest;

/* JADX INFO: loaded from: classes4.dex */
public interface ModuleProvider {
    HttpRequest createHttpRequest();

    LibraryLoaderProvider createLibraryLoaderProvider();
}
