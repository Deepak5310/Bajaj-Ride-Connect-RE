package com.google.android.libraries.navigation.internal.abv;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e implements FileFilter {
    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return file.isFile() && file.getName().startsWith("tile") && !file.getName().endsWith("_0_0_0");
    }

    public final String toString() {
        return "NON_ROOT_TILE_FILE_FILTER";
    }
}
