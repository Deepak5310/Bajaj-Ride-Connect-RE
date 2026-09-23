package com.google.android.libraries.navigation.internal.tu;

import java.io.File;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class m {
    private final File b;
    private final long e;
    private final long f;
    private final int g;
    private final int h;
    private final Executor k;
    private final com.google.android.libraries.navigation.internal.mj.a l;
    private final com.google.android.libraries.navigation.internal.fz.d m;
    private final long a = 1000;
    private final Map c = new HashMap();
    private final Map d = new HashMap();
    private int i = -1;
    private long j = -1;

    public m(Executor executor, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.fz.d dVar, String str, long j, int i) {
        this.k = executor;
        this.l = aVar;
        this.m = dVar;
        this.b = new File(str);
        this.e = j;
        this.f = j >> 1;
        this.g = i;
        this.h = i >> 1;
    }

    private final long h() {
        return this.l.f().toEpochMilli();
    }

    private static String i(String str, long j) {
        return str + "_" + j;
    }

    private final String j(String str) {
        if (str == null || !this.b.exists()) {
            return null;
        }
        return this.b.getAbsolutePath() + File.separator + str;
    }

    private static Map.Entry k(String str) {
        String[] strArrSplit = str.split("_");
        if (strArrSplit.length != 2) {
            return null;
        }
        try {
            return new AbstractMap.SimpleImmutableEntry(strArrSplit[0], Long.valueOf(Long.parseLong(strArrSplit[1])));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private final synchronized void l(String str) {
        Map.Entry entryK = k(str);
        if (entryK != null) {
            this.d.put((String) entryK.getKey(), (Long) entryK.getValue());
        }
    }

    private final synchronized void m(int i, long j) {
        this.i += i;
        this.j += j;
    }

    final synchronized void b(String str) {
        Integer num = (Integer) this.c.get(str);
        this.c.put(str, num == null ? 1 : Integer.valueOf(num.intValue() + 1));
    }

    final synchronized void c(String str) {
        Integer num = (Integer) this.c.get(str);
        if (num == null) {
            this.c.remove(str);
        } else if (num.intValue() == 1) {
            this.c.remove(str);
        } else if (num.intValue() > 1) {
            this.c.put(str, Integer.valueOf(num.intValue() - 1));
        }
    }

    public final synchronized void d() {
        if (this.i < 0 || this.j < 0) {
            this.i = 0;
            this.j = 0L;
            File[] fileArrListFiles = this.b.listFiles();
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    if (file.isFile()) {
                        m(1, file.length());
                        l(file.getName());
                    }
                }
            }
        }
    }

    public final synchronized void e() {
        if (this.j > this.e || this.i > this.g) {
            long j = this.f;
            int i = this.h;
            File[] fileArrListFiles = this.b.listFiles();
            if (fileArrListFiles != null) {
                int length = fileArrListFiles.length;
                l[] lVarArr = new l[length];
                for (int i2 = 0; i2 < fileArrListFiles.length; i2++) {
                    lVarArr[i2] = new l(fileArrListFiles[i2]);
                }
                Arrays.sort(lVarArr);
                long jA = this.l.a();
                for (int i3 = 0; i3 < length; i3++) {
                    File file = lVarArr[i3].a;
                    if (file.isFile()) {
                        if (!this.c.containsKey(file.getAbsolutePath())) {
                            long length2 = file.length();
                            if (file.delete()) {
                                m(-1, -length2);
                                Map.Entry entryK = k(file.getName());
                                String str = entryK == null ? null : (String) entryK.getKey();
                                if (str != null) {
                                    this.d.remove(str);
                                }
                                file.getName();
                            } else {
                                file.getName();
                            }
                            if ((this.j <= j && this.i <= i) || (this.l.a() - jA > 1000 && this.j <= this.e && this.i <= this.g)) {
                                break;
                            }
                        } else {
                            file.getAbsolutePath();
                            this.c.get(file.getAbsolutePath());
                        }
                    }
                }
            }
        }
    }

    final synchronized boolean f(String str) {
        Long l;
        String strA = a(str);
        boolean z = false;
        if (strA == null) {
            return false;
        }
        try {
            b(strA);
            File file = new File(strA);
            if (file.exists() && file.length() != 0 && ((l = (Long) this.d.get(str)) == null || l.longValue() >= this.l.f().toEpochMilli() - TimeUnit.DAYS.toMillis(this.m.R().f))) {
                file.setLastModified(h());
                z = true;
            }
            c(strA);
            return z;
        } catch (Throwable th) {
            c(strA);
            throw th;
        }
    }

    final synchronized boolean g(File file, String str) {
        d();
        long jH = h();
        String strJ = j(i(str, jH));
        boolean z = false;
        if (strJ == null) {
            return false;
        }
        try {
            b(strJ);
            String strA = a(str);
            if (this.d.get(str) != null && strA != null) {
                File file2 = new File(strA);
                m(-1, -file2.length());
                file2.delete();
            }
            File file3 = new File(strJ);
            if (file.renameTo(file3)) {
                this.d.put(str, Long.valueOf(jH));
                file3.setLastModified(jH);
                z = true;
                m(1, file3.length());
                this.k.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.tu.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.e();
                    }
                });
            } else {
                file.getAbsolutePath();
            }
            c(strJ);
            return z;
        } catch (Throwable th) {
            c(strJ);
            throw th;
        }
    }

    final synchronized String a(String str) {
        String strI;
        strI = null;
        if (str != null) {
            Long l = (Long) this.d.get(str);
            if (l != null) {
                strI = i(str, l.longValue());
            }
        }
        return j(strI);
    }
}
