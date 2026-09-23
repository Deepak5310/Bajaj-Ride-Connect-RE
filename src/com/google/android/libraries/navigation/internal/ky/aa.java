package com.google.android.libraries.navigation.internal.ky;

import android.util.Log;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import com.google.android.libraries.navigation.internal.lh.be;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class aa {
    public final String a;
    public final Object b;
    SimpleArrayMap c;
    public int d;
    public int e;
    final /* synthetic */ ap f;

    protected aa(ap apVar, aa aaVar) {
        this(apVar, aaVar.a);
        synchronized (aaVar.b) {
            this.d = aaVar.d;
            SimpleArrayMap simpleArrayMap = this.c;
            this.c = aaVar.c;
            aaVar.c = simpleArrayMap;
            aaVar.d = 0;
        }
    }

    public final void a(final long j, final long j2, ah ahVar) {
        if (ahVar == null) {
            ahVar = ap.b;
        }
        com.google.android.libraries.navigation.internal.yx.aa aaVar = new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.ky.z
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                boolean zValueOf;
                long j3 = j;
                ah ahVar2 = (ah) obj;
                aa aaVar2 = this.a;
                synchronized (aaVar2.b) {
                    LongSparseArray longSparseArray = (LongSparseArray) aaVar2.c.get(ahVar2);
                    if (longSparseArray == null) {
                        longSparseArray = new LongSparseArray();
                        aaVar2.c.put(ahVar2, longSparseArray);
                    }
                    int i = aaVar2.d;
                    boolean z = false;
                    if (i < 50 || aaVar2.f.f) {
                        aaVar2.d = i + 1;
                        long[] jArr = (long[]) longSparseArray.get(j3);
                        long j4 = j2;
                        if (jArr == null) {
                            longSparseArray.put(j3, new long[]{j4});
                        } else {
                            jArr[0] = jArr[0] + j4;
                        }
                        if (aaVar2.f.f && aaVar2.d >= aaVar2.e) {
                            z = true;
                        }
                        zValueOf = Boolean.valueOf(z);
                    } else {
                        if (i == 50) {
                            Log.isLoggable("Counters", 3);
                        }
                        zValueOf = false;
                    }
                }
                return zValueOf;
            }
        };
        be.j(ahVar);
        if (ap.c.equals(ahVar)) {
            ahVar = this.f.k;
        }
        ReentrantReadWriteLock.ReadLock lock = this.f.d.readLock();
        lock.lock();
        try {
            if (!this.f.l.contains(ahVar)) {
                lock.unlock();
                ReentrantReadWriteLock.WriteLock writeLock = this.f.d.writeLock();
                writeLock.lock();
                lock.lock();
                try {
                    this.f.l.add(ahVar);
                    writeLock.unlock();
                } catch (Throwable th) {
                    writeLock.unlock();
                    throw th;
                }
            }
            boolean zBooleanValue = ((Boolean) aaVar.ak(ahVar)).booleanValue();
            Future future = this.f.h;
            lock.unlock();
            if (zBooleanValue) {
                this.f.e();
            }
            int i = this.f.g;
        } catch (Throwable th2) {
            lock.unlock();
            throw th2;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AbstractCounter(");
        sb.append(this.a);
        sb.append(")[");
        synchronized (this.b) {
            for (int i = 0; i < this.c.getSize(); i++) {
                LongSparseArray longSparseArray = (LongSparseArray) this.c.valueAt(i);
                sb.append(this.c.keyAt(i));
                sb.append(" -> [");
                for (int i2 = 0; i2 < longSparseArray.size(); i2++) {
                    sb.append(longSparseArray.keyAt(i2));
                    sb.append(" = ");
                    sb.append(((long[]) longSparseArray.valueAt(i2))[0]);
                    sb.append(", ");
                }
                sb.append("], ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    protected aa(ap apVar, String str) {
        this.f = apVar;
        this.b = new Object();
        this.c = new SimpleArrayMap();
        this.e = 50;
        Object[] objArr = {str};
        if (!apVar.j.containsKey(str)) {
            this.a = str;
            return;
        }
        throw new IllegalStateException(String.format("counter/histogram already exists: %s", objArr));
    }
}
