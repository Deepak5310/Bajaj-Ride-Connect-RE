package com.mappls.sdk.maps.module.loader;

import com.mappls.sdk.maps.LibraryLoader;
import com.mappls.sdk.maps.LibraryLoaderProvider;

/* JADX INFO: loaded from: classes4.dex */
public class LibraryLoaderProviderImpl implements LibraryLoaderProvider {
    @Override // com.mappls.sdk.maps.LibraryLoaderProvider
    public LibraryLoader getDefaultLibraryLoader() {
        return new SystemLibraryLoader();
    }

    private static class SystemLibraryLoader extends LibraryLoader {
        private SystemLibraryLoader() {
        }

        @Override // com.mappls.sdk.maps.LibraryLoader
        public void load(String str) {
            System.loadLibrary(str);
        }
    }
}
