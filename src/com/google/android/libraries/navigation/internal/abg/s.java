package com.google.android.libraries.navigation.internal.abg;

import com.google.android.datatransport.BuildConfig;
import com.google.android.libraries.navigation.internal.abh.ba;
import com.google.android.libraries.navigation.internal.b.ad;
import com.google.android.libraries.navigation.internal.yx.br;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class s implements Runnable {
    public static final String a = "s";
    public final p b;
    public final List c;
    public final f d;
    public final ThreadFactory e;
    public final String f;
    public final String g = BuildConfig.VERSION_NAME;
    private final String h;
    private final com.google.android.libraries.navigation.internal.b.w i;
    private final com.google.android.libraries.navigation.internal.abf.a j;
    private final String k;
    private final br l;

    public s(p pVar, List list, String str, f fVar, com.google.android.libraries.navigation.internal.b.w wVar, com.google.android.libraries.navigation.internal.abf.a aVar, String str2, String str3, String str4, br brVar, ThreadFactory threadFactory) {
        this.b = pVar;
        this.c = list;
        this.h = str;
        this.d = fVar;
        this.i = wVar;
        this.j = aVar;
        this.k = str2;
        this.f = str3;
        this.l = brVar;
        this.e = threadFactory;
    }

    static String a(List list) {
        String[] strArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strArr[i] = String.valueOf(((n) list.get(i)).h());
        }
        return com.google.android.libraries.navigation.internal.abf.x.b(strArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        while (this.b.y() && !this.c.isEmpty()) {
            try {
                long jC = this.b.c();
                if (jC > 0) {
                    try {
                        synchronized (this) {
                            try {
                                wait(jC);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } catch (InterruptedException unused) {
                    }
                }
                try {
                    try {
                        int size = this.c.size();
                        if (!this.b.z()) {
                            throw new IOException("DataRequestDispatcher network disabled.");
                        }
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                        if (this.c.isEmpty() || !(this.c.get(0) instanceof m)) {
                            this.c.add(0, this.b.b);
                        }
                        dataOutputStream.writeShort(23);
                        dataOutputStream.writeLong(this.b.b());
                        dataOutputStream.writeUTF(this.h);
                        dataOutputStream.writeUTF(this.f);
                        dataOutputStream.writeUTF(this.g);
                        dataOutputStream.writeUTF((String) this.l.a());
                        for (n nVar : this.c) {
                            dataOutputStream.writeByte(nVar.h());
                            nVar.i(dataOutputStream);
                        }
                        dataOutputStream.flush();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        t tVar = new t(this.c, this.j);
                        com.google.android.libraries.navigation.internal.c.p pVar = new com.google.android.libraries.navigation.internal.c.p();
                        r rVar = new r(this, byteArray, tVar, this.k, pVar, false);
                        rVar.i = false;
                        this.i.a(rVar);
                        DataInputStream dataInputStream = null;
                        n nVar2 = null;
                        try {
                            try {
                                byte[] bArr = (byte[]) pVar.get();
                                DataInputStream dataInputStream2 = new DataInputStream(new ByteArrayInputStream(bArr));
                                try {
                                    if (dataInputStream2.readUnsignedShort() != 23) {
                                        this.b.n(1);
                                        throw new IOException("Protocol version mismatch with the server");
                                    }
                                    ArrayList arrayList = new ArrayList();
                                    int i = 0;
                                    while (i < this.c.size()) {
                                        try {
                                            try {
                                                n nVar3 = (n) this.c.get(i);
                                                try {
                                                    p pVar2 = this.b;
                                                    String str = a;
                                                    com.google.android.libraries.navigation.internal.abf.p.f(str, 3);
                                                    int unsignedByte = dataInputStream2.readUnsignedByte();
                                                    if (unsignedByte != nVar3.h()) {
                                                        if (com.google.android.libraries.navigation.internal.abf.p.f(str, 3)) {
                                                            nVar3.h();
                                                        }
                                                        throw new IOException("RequestType: " + unsignedByte + " != " + nVar3.h());
                                                    }
                                                    nVar3.j(dataInputStream2);
                                                    Iterator it2 = pVar2.d.iterator();
                                                    while (it2.hasNext()) {
                                                        ((ba) it2.next()).a(nVar3);
                                                    }
                                                    i++;
                                                    nVar2 = nVar3;
                                                } catch (IOException e) {
                                                    e = e;
                                                    nVar2 = nVar3;
                                                    if (com.google.android.libraries.navigation.internal.abf.p.f(a, 6)) {
                                                        nVar2.h();
                                                    }
                                                    if (e instanceof EOFException) {
                                                        nVar2.c();
                                                    }
                                                    throw e;
                                                } catch (RuntimeException e2) {
                                                    e = e2;
                                                    nVar2 = nVar3;
                                                    if (com.google.android.libraries.navigation.internal.abf.p.f(a, 6)) {
                                                        nVar2.h();
                                                    }
                                                    throw e;
                                                }
                                            } catch (Throwable th2) {
                                                if (i < this.c.size()) {
                                                    List list = this.c;
                                                    arrayList.addAll(list.subList(i, list.size()));
                                                }
                                                this.c.clear();
                                                this.c.addAll(arrayList);
                                                throw th2;
                                            }
                                        } catch (IOException e3) {
                                            e = e3;
                                        } catch (RuntimeException e4) {
                                            e = e4;
                                        }
                                    }
                                    if (i < this.c.size()) {
                                        List list2 = this.c;
                                        arrayList.addAll(list2.subList(i, list2.size()));
                                    }
                                    this.c.clear();
                                    this.c.addAll(arrayList);
                                    this.b.r();
                                    int length = byteArray.length;
                                    tVar.b(bArr.length);
                                    try {
                                        dataInputStream2.close();
                                    } catch (IOException unused2) {
                                        com.google.android.libraries.navigation.internal.abf.p.f(a, 3);
                                    }
                                    ArrayList arrayList2 = new ArrayList();
                                    for (n nVar4 : this.c) {
                                        if (nVar4.f()) {
                                            com.google.android.libraries.navigation.internal.abf.p.f(a, 3);
                                            arrayList2.add(nVar4);
                                        } else {
                                            com.google.android.libraries.navigation.internal.abf.p.f(a, 3);
                                            this.b.s(nVar4);
                                        }
                                    }
                                    this.c.clear();
                                    this.c.addAll(arrayList2);
                                    if (this.c.size() == size) {
                                        throw new IOException("No requests were processed: " + this.c.size());
                                    }
                                    this.b.t();
                                } catch (IOException e5) {
                                    e = e5;
                                    com.google.android.libraries.navigation.internal.abf.p.f(a, 5);
                                    throw e;
                                } catch (ExecutionException e6) {
                                    e = e6;
                                    ad adVar = (ad) e.getCause();
                                    if (adVar instanceof com.google.android.libraries.navigation.internal.b.a) {
                                        this.b.q();
                                    }
                                    if (com.google.android.libraries.navigation.internal.abf.p.f(a, 5)) {
                                        adVar.getCause();
                                    }
                                    throw adVar.getCause();
                                } catch (Throwable th3) {
                                    th = th3;
                                    dataInputStream = dataInputStream2;
                                    if (dataInputStream != null) {
                                        try {
                                            dataInputStream.close();
                                        } catch (IOException unused3) {
                                            com.google.android.libraries.navigation.internal.abf.p.f(a, 3);
                                        }
                                    }
                                    ArrayList arrayList3 = new ArrayList();
                                    for (n nVar5 : this.c) {
                                        if (nVar5.f()) {
                                            com.google.android.libraries.navigation.internal.abf.p.f(a, 3);
                                            arrayList3.add(nVar5);
                                        } else {
                                            com.google.android.libraries.navigation.internal.abf.p.f(a, 3);
                                            this.b.s(nVar5);
                                        }
                                    }
                                    this.c.clear();
                                    this.c.addAll(arrayList3);
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } catch (IOException e7) {
                            e = e7;
                        } catch (ExecutionException e8) {
                            e = e8;
                        }
                    } catch (IOException unused4) {
                        this.b.A(3);
                    }
                } catch (u unused5) {
                    this.b.A(4);
                } catch (SecurityException unused6) {
                    p pVar3 = this.b;
                    pVar3.v();
                    pVar3.n(0);
                } catch (Throwable unused7) {
                    this.b.A(5);
                }
            } catch (Throwable th5) {
                this.b.k();
                this.b.h();
                throw th5;
            }
        }
        this.b.k();
        this.b.h();
    }
}
