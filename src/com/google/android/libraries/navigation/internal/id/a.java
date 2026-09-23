package com.google.android.libraries.navigation.internal.id;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import java.io.File;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static File a(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            return filesDir;
        }
        try {
            File file = new File(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.dataDir, "files");
            file.mkdirs();
            return file;
        } catch (PackageManager.NameNotFoundException e) {
            throw new AssertionError(e);
        }
    }

    public static File b(File file) {
        return (file == null || !file.getName().equals("files")) ? file : file.getParentFile();
    }

    public static File c(Context context) {
        File file = new File(a(context).getParentFile(), "shared_prefs");
        file.mkdirs();
        return file;
    }

    public static void d(File file) {
        File[] fileArrListFiles;
        if (file.exists()) {
            if (file.isDirectory() && file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    d(file2);
                }
            }
            file.delete();
        }
    }

    public static boolean e() {
        return Environment.getExternalStorageState().equals("mounted");
    }
}
