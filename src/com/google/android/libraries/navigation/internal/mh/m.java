package com.google.android.libraries.navigation.internal.mh;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m implements e {
    public final AtomicBoolean a = new AtomicBoolean();
    private HashMap f = null;
    private final HashMap g = new HashMap(16, 1.0f);
    public final HashMap b = new HashMap(16, 1.0f);
    public final HashMap c = new HashMap(16, 1.0f);
    private final HashMap h = new HashMap(16, 1.0f);
    public Object d = null;
    private boolean i = false;
    private final String[] j = new String[0];
    public final j e = new j();

    public static final void d(ContentResolver contentResolver) {
        if (contentResolver == null) {
            throw new IllegalStateException("ContentResolver needed with GservicesDelegateSupplier.init()");
        }
    }

    public static final Object e(Map map, String str, Object obj) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj2 = map.get(str);
        return obj2 != null ? obj2 : obj;
    }

    @Override // com.google.android.libraries.navigation.internal.mh.e
    public final String a(ContentResolver contentResolver, String str) {
        String string;
        d(contentResolver);
        synchronized (this) {
            b(contentResolver);
            Object obj = this.d;
            String str2 = null;
            if (this.f.containsKey(str)) {
                String str3 = (String) this.f.get(str);
                if (str3 != null) {
                    str2 = str3;
                }
                return str2;
            }
            try {
                ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(d.a);
                try {
                    if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                        throw new l("Unable to acquire ContentProviderClient");
                    }
                    try {
                        Cursor cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(d.a, null, null, new String[]{str}, null);
                        try {
                            if (cursorQuery == null) {
                                throw new l("ContentProvider query returned null cursor");
                            }
                            if (cursorQuery.moveToFirst()) {
                                string = cursorQuery.getString(1);
                                cursorQuery.close();
                                contentProviderClientAcquireUnstableContentProviderClient.release();
                            } else {
                                cursorQuery.close();
                                contentProviderClientAcquireUnstableContentProviderClient.release();
                                string = null;
                            }
                            if (string != null && string.equals(null)) {
                                string = null;
                            }
                            synchronized (this) {
                                if (obj == this.d) {
                                    this.f.put(str, string);
                                }
                            }
                            if (string != null) {
                                return string;
                            }
                            return null;
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
                    } catch (RemoteException e) {
                        throw new l(e);
                    }
                } catch (Throwable th3) {
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                    throw th3;
                }
            } catch (l unused) {
                return null;
            }
        }
    }

    public final void b(ContentResolver contentResolver) {
        if (this.f == null) {
            this.a.set(false);
            this.f = new HashMap(16, 1.0f);
            this.d = new Object();
            contentResolver.registerContentObserver(d.a, true, new i(this));
            return;
        }
        if (this.a.getAndSet(false)) {
            this.f.clear();
            this.g.clear();
            this.b.clear();
            this.c.clear();
            this.h.clear();
            this.d = new Object();
            this.i = false;
        }
    }

    public final void c(Object obj, Map map, String str, Object obj2) {
        if (obj == this.d) {
            map.put(str, obj2);
            this.f.remove(str);
        }
    }
}
