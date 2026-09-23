package com.google.android.libraries.navigation.internal.abf;

import android.content.Context;
import android.os.StrictMode;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g {
    private final Context a;
    private final f b;
    private final w c;

    public g(Context context) {
        f fVar = f.a;
        w wVar = w.a;
        this.a = context;
        this.b = fVar;
        this.c = wVar;
    }

    public final synchronized void a(String str, byte[] bArr) {
        if (bArr == null) {
            StrictMode.ThreadPolicy threadPolicyC = this.c.c();
            try {
                this.a.deleteFile(str);
                this.c.d(threadPolicyC);
                return;
            } catch (Throwable th) {
                this.c.d(threadPolicyC);
                throw th;
            }
        }
        StrictMode.ThreadPolicy threadPolicyC2 = this.c.c();
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        try {
            try {
                fileOutputStreamOpenFileOutput = this.a.openFileOutput(str, 0);
                fileOutputStreamOpenFileOutput.write(bArr);
            } catch (IOException unused) {
                this.a.deleteFile(str);
            }
            this.c.d(threadPolicyC2);
            com.google.android.libraries.navigation.internal.ll.h.a(fileOutputStreamOpenFileOutput);
            return;
        } catch (Throwable th2) {
            this.c.d(threadPolicyC2);
            com.google.android.libraries.navigation.internal.ll.h.a(fileOutputStreamOpenFileOutput);
            throw th2;
        }
        throw th;
    }

    public final synchronized byte[] b(String str) {
        FileInputStream fileInputStreamOpenFileInput;
        byte[] bArrB;
        StrictMode.ThreadPolicy threadPolicyB = this.c.b();
        FileInputStream fileInputStream = null;
        bArrB = null;
        bArrB = null;
        try {
            fileInputStreamOpenFileInput = this.a.openFileInput(str);
            if (fileInputStreamOpenFileInput != null) {
                try {
                    try {
                        bArrB = com.google.android.libraries.navigation.internal.ll.h.b(fileInputStreamOpenFileInput, false);
                    } catch (IOException unused) {
                        this.a.deleteFile(str);
                        this.c.d(threadPolicyB);
                        com.google.android.libraries.navigation.internal.ll.h.a(fileInputStreamOpenFileInput);
                        return bArrB;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStreamOpenFileInput;
                    this.c.d(threadPolicyB);
                    com.google.android.libraries.navigation.internal.ll.h.a(fileInputStream);
                    throw th;
                }
            }
        } catch (IOException unused2) {
            fileInputStreamOpenFileInput = null;
        } catch (Throwable th2) {
            th = th2;
            this.c.d(threadPolicyB);
            com.google.android.libraries.navigation.internal.ll.h.a(fileInputStream);
            throw th;
        }
        this.c.d(threadPolicyB);
        com.google.android.libraries.navigation.internal.ll.h.a(fileInputStreamOpenFileInput);
        return bArrB;
    }
}
