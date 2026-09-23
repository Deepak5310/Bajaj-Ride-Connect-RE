package com.google.android.libraries.navigation.internal.abv;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c implements FileFilter {
    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return file.isFile() && file.getName().startsWith("config");
    }

    public final String toString() {
        return "PANO_FILE_FILTER";
    }
}
