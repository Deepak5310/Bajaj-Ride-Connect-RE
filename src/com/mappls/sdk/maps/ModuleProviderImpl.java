package com.mappls.sdk.maps;

import com.mappls.sdk.maps.http.HttpRequest;
import com.mappls.sdk.maps.module.http.HttpRequestImpl;
import com.mappls.sdk.maps.module.loader.LibraryLoaderProviderImpl;

/* JADX INFO: loaded from: classes4.dex */
public class ModuleProviderImpl implements ModuleProvider {
    @Override // com.mappls.sdk.maps.ModuleProvider
    public HttpRequest createHttpRequest() {
        return new HttpRequestImpl();
    }

    @Override // com.mappls.sdk.maps.ModuleProvider
    public LibraryLoaderProvider createLibraryLoaderProvider() {
        return new LibraryLoaderProviderImpl();
    }
}
