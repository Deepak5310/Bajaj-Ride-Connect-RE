package com.google.android.libraries.navigation.internal.zn;

import com.google.android.libraries.navigation.internal.yz.fy;
import java.io.File;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p extends h {
    public final File a;
    public final fy b;

    public p(File file, o... oVarArr) {
        this.a = file;
        this.b = fy.p(oVarArr);
    }

    public final String toString() {
        fy fyVar = this.b;
        return "Files.asByteSink(" + String.valueOf(this.a) + ", " + String.valueOf(fyVar) + ")";
    }
}
