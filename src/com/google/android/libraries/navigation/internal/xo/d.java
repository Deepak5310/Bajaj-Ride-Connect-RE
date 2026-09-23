package com.google.android.libraries.navigation.internal.xo;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.RemoteException;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements i {
    public static final Map a = new ArrayMap();
    public static final String[] b = {"key", "value"};
    public final ContentResolver c;
    public final Uri d;
    public final Object e;
    public volatile Map f;
    public final List g;
    private final Runnable h;
    private final ContentObserver i;

    public d(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        c cVar = new c(this);
        this.i = cVar;
        this.e = new Object();
        this.g = new ArrayList();
        ar.q(contentResolver);
        ar.q(uri);
        this.c = contentResolver;
        this.d = uri;
        this.h = runnable;
        contentResolver.registerContentObserver(uri, false, cVar);
    }

    static synchronized void b() {
        for (d dVar : a.values()) {
            dVar.c.unregisterContentObserver(dVar.i);
        }
        a.clear();
    }

    @Override // com.google.android.libraries.navigation.internal.xo.i
    public final /* bridge */ /* synthetic */ Object a(String str) {
        Map mapEmptyMap;
        Map mapEmptyMap2 = this.f;
        if (mapEmptyMap2 == null) {
            synchronized (this.e) {
                mapEmptyMap2 = this.f;
                if (mapEmptyMap2 == null) {
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        try {
                            mapEmptyMap = (Map) g.a(new h() { // from class: com.google.android.libraries.navigation.internal.xo.b
                                @Override // com.google.android.libraries.navigation.internal.xo.h
                                public final Object a() {
                                    Map mapEmptyMap3;
                                    Map mapEmptyMap4;
                                    d dVar = this.a;
                                    ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = dVar.c.acquireUnstableContentProviderClient(dVar.d);
                                    try {
                                        if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                                            return Collections.emptyMap();
                                        }
                                        try {
                                            Cursor cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(dVar.d, d.b, null, null, null);
                                            try {
                                                if (cursorQuery == null) {
                                                    mapEmptyMap3 = Collections.emptyMap();
                                                    contentProviderClientAcquireUnstableContentProviderClient.release();
                                                    return mapEmptyMap3;
                                                }
                                                int count = cursorQuery.getCount();
                                                if (count == 0) {
                                                    mapEmptyMap4 = Collections.emptyMap();
                                                } else {
                                                    Map arrayMap = count <= 256 ? new ArrayMap(count) : new HashMap(count, 1.0f);
                                                    while (cursorQuery.moveToNext()) {
                                                        arrayMap.put(cursorQuery.getString(0), cursorQuery.getString(1));
                                                    }
                                                    if (cursorQuery.isAfterLast()) {
                                                        cursorQuery.close();
                                                        contentProviderClientAcquireUnstableContentProviderClient.release();
                                                        return arrayMap;
                                                    }
                                                    mapEmptyMap4 = Collections.emptyMap();
                                                }
                                                cursorQuery.close();
                                                contentProviderClientAcquireUnstableContentProviderClient.release();
                                                return mapEmptyMap4;
                                            } catch (Throwable th) {
                                                if (cursorQuery != null) {
                                                    try {
                                                        cursorQuery.close();
                                                    } catch (Throwable th2) {
                                                        th.addSuppressed(th2);
                                                    }
                                                }
                                                throw th;
                                            }
                                        } catch (RemoteException unused) {
                                            mapEmptyMap3 = Collections.emptyMap();
                                        }
                                    } catch (Throwable th3) {
                                        contentProviderClientAcquireUnstableContentProviderClient.release();
                                        throw th3;
                                    }
                                }
                            });
                        } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                            mapEmptyMap = Collections.emptyMap();
                        }
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        this.f = mapEmptyMap;
                        mapEmptyMap2 = mapEmptyMap;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        throw th;
                    }
                }
            }
        }
        if (mapEmptyMap2 == null) {
            mapEmptyMap2 = Collections.emptyMap();
        }
        return (String) mapEmptyMap2.get(str);
    }
}
