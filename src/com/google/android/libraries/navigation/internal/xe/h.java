package com.google.android.libraries.navigation.internal.xe;

import android.content.Context;
import j$.time.Instant;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class h {
    private final Context a;

    public h(Context context) {
        this.a = com.google.android.libraries.navigation.internal.abf.b.a(context);
    }

    public final synchronized File a(String str) {
        if (com.google.android.libraries.navigation.internal.yx.aq.c(str)) {
            return null;
        }
        try {
            File fileCreateTempFile = File.createTempFile("eventtrack-" + String.valueOf(Instant.now()), ".xml", this.a.getCacheDir());
            fileCreateTempFile.deleteOnExit();
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            try {
                fileOutputStream.write(str.getBytes());
                fileOutputStream.close();
                return fileCreateTempFile;
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception unused) {
            return null;
        }
    }
}
