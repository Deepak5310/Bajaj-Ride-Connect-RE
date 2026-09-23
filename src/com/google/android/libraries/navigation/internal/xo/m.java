package com.google.android.libraries.navigation.internal.xo;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import androidx.collection.SimpleArrayMap;
import com.google.android.libraries.navigation.internal.yx.an;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m {
    private static volatile an a;

    private m() {
    }

    public static an a(Context context) {
        an anVarJ;
        an anVarJ2;
        an anVar = a;
        if (anVar == null) {
            synchronized (m.class) {
                anVar = a;
                if (anVar == null) {
                    String str = Build.TYPE;
                    String str2 = Build.TAGS;
                    int i = o.a;
                    if ((str.equals("eng") || str.equals("userdebug")) && (str2.contains("dev-keys") || str2.contains("test-keys"))) {
                        if (com.google.android.libraries.navigation.internal.nd.a.c() && !context.isDeviceProtectedStorage()) {
                            context = context.createDeviceProtectedStorageContext();
                        }
                        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        try {
                            StrictMode.allowThreadDiskWrites();
                            try {
                                File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
                                anVarJ = file.exists() ? an.j(file) : com.google.android.libraries.navigation.internal.yx.a.a;
                            } catch (RuntimeException unused) {
                                anVarJ = com.google.android.libraries.navigation.internal.yx.a.a;
                            }
                            if (anVarJ.g()) {
                                try {
                                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream((File) anVarJ.c())));
                                    try {
                                        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
                                        HashMap map = new HashMap();
                                        while (true) {
                                            String line = bufferedReader.readLine();
                                            if (line == null) {
                                                break;
                                            }
                                            String[] strArrSplit = line.split(StringUtils.SPACE, 3);
                                            if (strArrSplit.length == 3) {
                                                String str3 = new String(strArrSplit[0]);
                                                String strDecode = Uri.decode(new String(strArrSplit[1]));
                                                String strDecode2 = (String) map.get(strArrSplit[2]);
                                                if (strDecode2 == null) {
                                                    String str4 = new String(strArrSplit[2]);
                                                    strDecode2 = Uri.decode(str4);
                                                    if (strDecode2.length() < 1024 || strDecode2 == str4) {
                                                        map.put(str4, strDecode2);
                                                    }
                                                }
                                                SimpleArrayMap simpleArrayMap2 = (SimpleArrayMap) simpleArrayMap.get(str3);
                                                if (simpleArrayMap2 == null) {
                                                    simpleArrayMap2 = new SimpleArrayMap();
                                                    simpleArrayMap.put(str3, simpleArrayMap2);
                                                }
                                                simpleArrayMap2.put(strDecode, strDecode2);
                                            }
                                        }
                                        context.getPackageName();
                                        f fVar = new f(simpleArrayMap);
                                        bufferedReader.close();
                                        anVarJ2 = an.j(fVar);
                                    } catch (Throwable th) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Throwable th2) {
                                            th.addSuppressed(th2);
                                        }
                                        throw th;
                                    }
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            } else {
                                anVarJ2 = com.google.android.libraries.navigation.internal.yx.a.a;
                            }
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        } catch (Throwable th3) {
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                            throw th3;
                        }
                    } else {
                        anVarJ2 = com.google.android.libraries.navigation.internal.yx.a.a;
                    }
                    a = anVarJ2;
                    anVar = anVarJ2;
                }
            }
        }
        return anVar;
    }
}
