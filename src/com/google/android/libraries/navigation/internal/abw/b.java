package com.google.android.libraries.navigation.internal.abw;

import com.google.android.libraries.navigation.internal.abf.r;
import com.google.android.libraries.navigation.internal.abf.s;
import java.io.File;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b {
    public final File a;
    public final String b;
    public final long c;

    public b(File file, String str, long j) {
        s.k(file, "file");
        this.a = file;
        s.k(str, "filename");
        this.b = str;
        this.c = j;
    }

    public static b a(File file) {
        s.k(file, "file");
        return new b(file, file.getName(), file.lastModified());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return r.a(this.a, bVar.a) && r.a(this.b, bVar.b) && r.a(Long.valueOf(this.c), Long.valueOf(bVar.c));
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a});
    }

    public final String toString() {
        return String.format("DiskCacheEntry[%s@%s]", this.b, Long.valueOf(this.c));
    }
}
