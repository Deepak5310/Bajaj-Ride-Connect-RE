package com.google.android.libraries.navigation.internal.abw;

import android.os.StrictMode;
import com.google.android.libraries.navigation.internal.abf.p;
import com.google.android.libraries.navigation.internal.abf.s;
import com.google.android.libraries.navigation.internal.abf.w;
import com.google.android.libraries.navigation.internal.zn.r;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    private static final String a = "f";
    private final File b;
    private final long c;
    private final com.google.android.libraries.navigation.internal.abf.a d;
    private final w e;
    private final d f;
    private final e g;
    private final a h;

    public f(File file, a aVar, long j, com.google.android.libraries.navigation.internal.abf.a aVar2, w wVar, d dVar, e eVar) {
        this.b = file;
        this.h = aVar;
        this.c = j;
        this.d = aVar2;
        s.k(wVar, "strictModeUtil");
        this.e = wVar;
        this.f = dVar;
        this.g = eVar;
    }

    public static f a(String str, int i, long j, FileFilter fileFilter) {
        f fVar;
        s.k(str, "cacheDirPath");
        StrictMode.ThreadPolicy threadPolicyB = w.a.b();
        try {
            File file = new File(str);
            file.mkdirs();
            if (file.exists() && file.isDirectory()) {
                fVar = new f(file, new a(i), j, com.google.android.libraries.navigation.internal.abf.a.a, w.a, d.a, e.a);
                if (fileFilter != null) {
                    fVar.b(fileFilter);
                }
            } else {
                p.f(a, 6);
                fVar = null;
            }
            return fVar;
        } finally {
            w.a.d(threadPolicyB);
        }
    }

    public final synchronized void b(FileFilter fileFilter) {
        int length;
        String str = a;
        p.f(str, 4);
        StrictMode.ThreadPolicy threadPolicyB = this.e.b();
        try {
            File[] fileArrListFiles = this.b.listFiles(fileFilter);
            if (fileArrListFiles != null && (length = fileArrListFiles.length) != 0) {
                p.f(str, 4);
                b[] bVarArr = new b[length];
                for (int i = 0; i < fileArrListFiles.length; i++) {
                    bVarArr[i] = b.a(fileArrListFiles[i]);
                }
                Arrays.sort(bVarArr, c.a);
                for (int i2 = 0; i2 < length; i2++) {
                    b bVar = bVarArr[i2];
                    this.h.put(bVar.b, bVar);
                }
                if (p.f(a, 4)) {
                    this.h.size();
                    this.h.maxSize();
                }
            }
            this.e.d(threadPolicyB);
        } catch (Throwable th) {
            this.e.d(threadPolicyB);
            throw th;
        }
    }

    public final synchronized void c(String str, byte[] bArr) {
        s.k(str, "filename");
        s.k(bArr, "fileBytes");
        if (p.f(a, 3)) {
            int length = bArr.length;
        }
        StrictMode.ThreadPolicy threadPolicyB = this.e.b();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(this.b, str);
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    this.h.put(str, b.a(file));
                    com.google.android.libraries.navigation.internal.ll.h.a(fileOutputStream2);
                    this.e.d(threadPolicyB);
                } catch (IOException unused) {
                    fileOutputStream = fileOutputStream2;
                    p.f(a, 6);
                    this.h.remove(str);
                    if (fileOutputStream != null) {
                        com.google.android.libraries.navigation.internal.ll.h.a(fileOutputStream);
                    }
                    this.e.d(threadPolicyB);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        com.google.android.libraries.navigation.internal.ll.h.a(fileOutputStream);
                    }
                    this.e.d(threadPolicyB);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused2) {
        }
    }

    public final synchronized void d(String str) {
        s.k(str, "filename");
        String str2 = a;
        p.f(str2, 3);
        StrictMode.ThreadPolicy threadPolicyB = this.e.b();
        try {
            p.f(str2, 3);
            this.e.d(threadPolicyB);
        } catch (Throwable th) {
            this.e.d(threadPolicyB);
            throw th;
        }
    }

    public final synchronized byte[] e(String str) {
        byte[] bArr;
        s.k(str, "filename");
        String str2 = a;
        p.f(str2, 2);
        StrictMode.ThreadPolicy threadPolicyB = this.e.b();
        bArr = null;
        try {
            try {
                b bVar = (b) this.h.get(str);
                if (bVar == null) {
                    p.f(str2, 2);
                } else if (System.currentTimeMillis() - bVar.c > this.c) {
                    p.f(str2, 3);
                    this.h.remove(str);
                } else {
                    byte[] bArrB = r.b(bVar.a);
                    if (bArrB == null) {
                        p.f(str2, 6);
                        this.h.remove(str);
                    } else {
                        p.f(str2, 3);
                        bArr = bArrB;
                    }
                }
            } catch (IOException unused) {
                p.f(a, 6);
                this.h.remove(str);
            }
            this.e.d(threadPolicyB);
        } catch (Throwable th) {
            this.e.d(threadPolicyB);
            throw th;
        }
        return bArr;
    }
}
