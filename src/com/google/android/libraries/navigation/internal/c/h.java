package com.google.android.libraries.navigation.internal.c;

import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.libraries.navigation.internal.b.ag;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h implements com.google.android.libraries.navigation.internal.b.c {
    private final Map a = new LinkedHashMap(16, 0.75f, true);
    private long b = 0;
    private final int c = 20971520;
    private final e d;

    public h(File file) {
        this.d = new e(file);
    }

    static int e(InputStream inputStream) throws IOException {
        return (n(inputStream) << 24) | n(inputStream) | (n(inputStream) << 8) | (n(inputStream) << 16);
    }

    static long f(InputStream inputStream) throws IOException {
        return (((long) n(inputStream)) & 255) | ((((long) n(inputStream)) & 255) << 8) | ((((long) n(inputStream)) & 255) << 16) | ((((long) n(inputStream)) & 255) << 24) | ((((long) n(inputStream)) & 255) << 32) | ((((long) n(inputStream)) & 255) << 40) | ((((long) n(inputStream)) & 255) << 48) | ((((long) n(inputStream)) & 255) << 56);
    }

    static String h(g gVar) throws IOException {
        return new String(m(gVar, f(gVar)), "UTF-8");
    }

    static void j(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void k(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) j);
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    static void l(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        int length = bytes.length;
        k(outputStream, length);
        outputStream.write(bytes, 0, length);
    }

    static byte[] m(g gVar, long j) throws IOException {
        long jA = gVar.a();
        if (j >= 0 && j <= jA) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(gVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + jA);
    }

    private static int n(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i != -1) {
            return i;
        }
        throw new EOFException();
    }

    private final void o(String str, f fVar) {
        if (this.a.containsKey(str)) {
            this.b += fVar.a - ((f) this.a.get(str)).a;
        } else {
            this.b += fVar.a;
        }
        this.a.put(str, fVar);
    }

    private final void p(String str) {
        f fVar = (f) this.a.remove(str);
        if (fVar != null) {
            this.b -= fVar.a;
        }
    }

    private static final String q(String str) {
        int length = str.length() / 2;
        return String.valueOf(String.valueOf(str.substring(0, length).hashCode())).concat(String.valueOf(String.valueOf(str.substring(length).hashCode())));
    }

    @Override // com.google.android.libraries.navigation.internal.b.c
    public final synchronized com.google.android.libraries.navigation.internal.b.b a(String str) {
        f fVar = (f) this.a.get(str);
        if (fVar == null) {
            return null;
        }
        File fileG = g(str);
        try {
            g gVar = new g(new BufferedInputStream(new FileInputStream(fileG)), fileG.length());
            try {
                f fVarA = f.a(gVar);
                if (!TextUtils.equals(str, fVarA.b)) {
                    ag.b("%s: key=%s, found=%s", fileG.getAbsolutePath(), str, fVarA.b);
                    p(str);
                    gVar.close();
                    return null;
                }
                byte[] bArrM = m(gVar, gVar.a());
                com.google.android.libraries.navigation.internal.b.b bVar = new com.google.android.libraries.navigation.internal.b.b();
                bVar.a = bArrM;
                bVar.b = fVar.c;
                bVar.c = fVar.d;
                bVar.d = fVar.e;
                bVar.e = fVar.f;
                bVar.f = fVar.g;
                List<com.google.android.libraries.navigation.internal.b.k> list = fVar.h;
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                for (com.google.android.libraries.navigation.internal.b.k kVar : list) {
                    treeMap.put(kVar.a, kVar.b);
                }
                bVar.g = treeMap;
                bVar.h = Collections.unmodifiableList(fVar.h);
                gVar.close();
                return bVar;
            } catch (Throwable th) {
                gVar.close();
                throw th;
            }
        } catch (IOException e) {
            ag.b("%s: %s", fileG.getAbsolutePath(), e.toString());
            i(str);
            return null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.b.c
    public final synchronized void b() {
        try {
            File file = this.d.a;
            if (file.exists()) {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null) {
                    for (File file2 : fileArrListFiles) {
                        try {
                            long length = file2.length();
                            g gVar = new g(new BufferedInputStream(new FileInputStream(file2)), length);
                            try {
                                f fVarA = f.a(gVar);
                                fVarA.a = length;
                                o(fVarA.b, fVarA);
                                gVar.close();
                            } catch (Throwable th) {
                                gVar.close();
                                throw th;
                            }
                        } catch (IOException unused) {
                            file2.delete();
                        }
                    }
                }
            } else if (!file.mkdirs()) {
                ag.b("Unable to create cache dir %s", file.getAbsolutePath());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.b.c
    public final synchronized void c(String str, com.google.android.libraries.navigation.internal.b.b bVar) {
        List list;
        long j;
        long j2 = this.b;
        int length = bVar.a.length;
        if (j2 + ((long) length) <= 20971520 || length <= 1.8874368E7f) {
            File fileG = g(str);
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileG));
                String str2 = bVar.b;
                long j3 = bVar.c;
                long j4 = bVar.d;
                long j5 = bVar.e;
                long j6 = bVar.f;
                List list2 = bVar.h;
                if (list2 == null) {
                    Map map = bVar.g;
                    ArrayList arrayList = new ArrayList(map.size());
                    for (Iterator it2 = map.entrySet().iterator(); it2.hasNext(); it2 = it2) {
                        Map.Entry entry = (Map.Entry) it2.next();
                        arrayList.add(new com.google.android.libraries.navigation.internal.b.k((String) entry.getKey(), (String) entry.getValue()));
                    }
                    list = arrayList;
                    j = j5;
                } else {
                    list = list2;
                    j = j5;
                }
                f fVar = new f(str, str2, j3, j4, j, j6, list);
                try {
                    j(bufferedOutputStream, 538247942);
                    l(bufferedOutputStream, fVar.b);
                    String str3 = fVar.c;
                    if (str3 == null) {
                        str3 = "";
                    }
                    l(bufferedOutputStream, str3);
                    k(bufferedOutputStream, fVar.d);
                    k(bufferedOutputStream, fVar.e);
                    k(bufferedOutputStream, fVar.f);
                    k(bufferedOutputStream, fVar.g);
                    List<com.google.android.libraries.navigation.internal.b.k> list3 = fVar.h;
                    if (list3 != null) {
                        j(bufferedOutputStream, list3.size());
                        for (com.google.android.libraries.navigation.internal.b.k kVar : list3) {
                            l(bufferedOutputStream, kVar.a);
                            l(bufferedOutputStream, kVar.b);
                        }
                    } else {
                        j(bufferedOutputStream, 0);
                    }
                    bufferedOutputStream.flush();
                    bufferedOutputStream.write(bVar.a);
                    bufferedOutputStream.close();
                    fVar.a = fileG.length();
                    o(str, fVar);
                    if (this.b >= 20971520) {
                        if (ag.b) {
                            ag.a("Pruning old cache entries.", new Object[0]);
                        }
                        long j7 = this.b;
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        Iterator it3 = this.a.entrySet().iterator();
                        int i = 0;
                        while (it3.hasNext()) {
                            f fVar2 = (f) ((Map.Entry) it3.next()).getValue();
                            if (g(fVar2.b).delete()) {
                                this.b -= fVar2.a;
                            } else {
                                String str4 = fVar2.b;
                                ag.b("Could not delete cache entry for key=%s, filename=%s", str4, q(str4));
                            }
                            it3.remove();
                            i++;
                            if (this.b < 1.8874368E7f) {
                                break;
                            }
                        }
                        if (ag.b) {
                            ag.a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i), Long.valueOf(this.b - j7), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
                        }
                    }
                } catch (IOException e) {
                    ag.b("%s", e.toString());
                    bufferedOutputStream.close();
                    ag.b("Failed to write header for %s", fileG.getAbsolutePath());
                    throw new IOException();
                }
            } catch (IOException unused) {
                if (!fileG.delete()) {
                    ag.b("Could not clean up file %s", fileG.getAbsolutePath());
                }
                if (!this.d.a.exists()) {
                    ag.b("Re-initializing cache after external clearing.", new Object[0]);
                    this.a.clear();
                    this.b = 0L;
                    b();
                }
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.b.c
    public final synchronized void d(String str) {
        com.google.android.libraries.navigation.internal.b.b bVarA = a(str);
        if (bVarA != null) {
            bVarA.f = 0L;
            bVarA.e = 0L;
            c(str, bVarA);
        }
    }

    public final File g(String str) {
        return new File(this.d.a, q(str));
    }

    public final synchronized void i(String str) {
        boolean zDelete = g(str).delete();
        p(str);
        if (zDelete) {
            return;
        }
        ag.b("Could not delete cache entry for key=%s, filename=%s", str, q(str));
    }
}
