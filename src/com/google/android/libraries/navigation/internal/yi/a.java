package com.google.android.libraries.navigation.internal.yi;

import android.net.Uri;
import android.system.Os;
import com.google.android.libraries.navigation.internal.xy.f;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static IOException a(f fVar, Uri uri, IOException iOException, String str) {
        try {
            com.google.android.libraries.navigation.internal.ye.a aVar = new com.google.android.libraries.navigation.internal.ye.a();
            aVar.a = true;
            File file = (File) fVar.b(uri, aVar);
            if (!file.exists()) {
                return c(file, iOException, str);
            }
            if (file.isFile()) {
                if (file.canRead()) {
                    return file.canWrite() ? c(file, iOException, str) : c(file, iOException, str);
                }
                return file.canWrite() ? c(file, iOException, str) : c(file, iOException, str);
            }
            if (file.canRead()) {
                return file.canWrite() ? c(file, iOException, str) : c(file, iOException, str);
            }
            return file.canWrite() ? c(file, iOException, str) : c(file, iOException, str);
        } catch (IOException unused) {
            return new IOException(iOException);
        }
    }

    private static IOException b(File file, IOException iOException, String str) {
        String strConcat;
        try {
            strConcat = "Inoperable file:" + String.format(Locale.US, " canonical[%s] freeSpace[%d] protoName[%s]", file.getCanonicalPath(), Long.valueOf(file.getFreeSpace()), str);
            try {
                strConcat = strConcat + String.format(Locale.US, " mode[%d]", Integer.valueOf(Os.stat(file.getCanonicalPath()).st_mode));
            } catch (Exception unused) {
            }
        } catch (IOException unused2) {
            strConcat = String.valueOf("Inoperable file:").concat(" failed");
        }
        return new IOException(strConcat, iOException);
    }

    private static IOException c(File file, IOException iOException, String str) {
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return b(file, iOException, str);
        }
        if (!parentFile.exists()) {
            return b(file, iOException, str);
        }
        if (parentFile.isDirectory()) {
            if (parentFile.canRead()) {
                return parentFile.canWrite() ? b(file, iOException, str) : b(file, iOException, str);
            }
            return parentFile.canWrite() ? b(file, iOException, str) : b(file, iOException, str);
        }
        if (parentFile.canRead()) {
            return parentFile.canWrite() ? b(file, iOException, str) : b(file, iOException, str);
        }
        return parentFile.canWrite() ? b(file, iOException, str) : b(file, iOException, str);
    }
}
