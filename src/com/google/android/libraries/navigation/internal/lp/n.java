package com.google.android.libraries.navigation.internal.lp;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.util.zzb$$ExternalSyntheticApiModelOutline0;
import com.google.android.libraries.navigation.internal.lh.be;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n {
    public static Boolean a = null;
    public static r b = null;
    public static int c = -1;
    public static final ThreadLocal d = new ThreadLocal();
    public static final ThreadLocal e = new d();
    public static final k f = new e();
    public static final m g = new f();
    private static p h;
    private static String i;
    private static boolean j;
    private static Boolean k;
    private final Context l;

    public n(Context context) {
        this.l = context;
    }

    public static p a(Context context) {
        p oVar;
        synchronized (n.class) {
            p pVar = h;
            if (pVar != null) {
                return pVar;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    oVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    oVar = iInterfaceQueryLocalInterface instanceof p ? (p) iInterfaceQueryLocalInterface : new o(iBinder);
                }
                if (oVar != null) {
                    h = oVar;
                    return oVar;
                }
            } catch (Exception e2) {
                e2.getMessage();
            }
            return null;
        }
    }

    public static boolean b(Context context) {
        if (Boolean.TRUE.equals(null) || Boolean.TRUE.equals(k)) {
            return true;
        }
        boolean z = false;
        if (k == null) {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", Build.VERSION.SDK_INT < 29 ? 0 : 268435456);
            if (com.google.android.libraries.navigation.internal.lc.i.d.f(context, 10000000) == 0 && providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                z = true;
            }
            Boolean boolValueOf = Boolean.valueOf(z);
            k = boolValueOf;
            boolValueOf.getClass();
            if (z && providerInfoResolveContentProvider.applicationInfo != null && (providerInfoResolveContentProvider.applicationInfo.flags & 129) == 0) {
                j = true;
            }
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x015e A[Catch: all -> 0x0165, TryCatch #5 {all -> 0x0165, blocks: (B:3:0x0002, B:56:0x00be, B:58:0x00c4, B:63:0x00ce, B:85:0x0125, B:92:0x0132, B:109:0x015e, B:110:0x0161, B:105:0x0157, B:61:0x00ca, B:113:0x0164, B:4:0x0003, B:7:0x0009, B:8:0x0025, B:54:0x00bb, B:19:0x0046, B:41:0x009c, B:44:0x009f, B:52:0x00b8, B:55:0x00bd, B:53:0x00b9), top: B:123:0x0002, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x0132 A[Catch: all -> 0x0165, TRY_LEAVE, TryCatch #5 {all -> 0x0165, blocks: (B:3:0x0002, B:56:0x00be, B:58:0x00c4, B:63:0x00ce, B:85:0x0125, B:92:0x0132, B:109:0x015e, B:110:0x0161, B:105:0x0157, B:61:0x00ca, B:113:0x0164, B:4:0x0003, B:7:0x0009, B:8:0x0025, B:54:0x00bb, B:19:0x0046, B:41:0x009c, B:44:0x009f, B:52:0x00b8, B:55:0x00bd, B:53:0x00b9), top: B:123:0x0002, inners: #0, #3 }] */
    public static int c(Context context, boolean z) {
        Throwable th;
        RemoteException e2;
        Cursor cursor;
        try {
            synchronized (n.class) {
                Boolean bool = a;
                Cursor cursor2 = null;
                int iJ = 0;
                if (bool == null) {
                    try {
                        Field declaredField = context.getApplicationContext().getClassLoader().loadClass(h.class.getName()).getDeclaredField("sClassLoader");
                        synchronized (declaredField.getDeclaringClass()) {
                            ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                            if (classLoader == ClassLoader.getSystemClassLoader()) {
                                bool = Boolean.FALSE;
                            } else {
                                if (classLoader == null) {
                                    if (!b(context)) {
                                        return 0;
                                    }
                                    if (j || Boolean.TRUE.equals(null)) {
                                        declaredField.set(null, ClassLoader.getSystemClassLoader());
                                        bool = Boolean.FALSE;
                                    } else {
                                        try {
                                            int iG = g(context, z, true);
                                            String str = i;
                                            if (str != null && !str.isEmpty()) {
                                                ClassLoader classLoaderA = b.a();
                                                if (classLoaderA == null) {
                                                    if (Build.VERSION.SDK_INT >= 29) {
                                                        zzb$$ExternalSyntheticApiModelOutline0.m1448m$1();
                                                        String str2 = i;
                                                        be.j(str2);
                                                        classLoaderA = zzb$$ExternalSyntheticApiModelOutline0.m(str2, ClassLoader.getSystemClassLoader());
                                                    } else {
                                                        String str3 = i;
                                                        be.j(str3);
                                                        classLoaderA = new c(str3, ClassLoader.getSystemClassLoader());
                                                    }
                                                }
                                                e(classLoaderA);
                                                declaredField.set(null, classLoaderA);
                                                a = Boolean.TRUE;
                                                return iG;
                                            }
                                            return iG;
                                        } catch (j unused) {
                                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                                            bool = Boolean.FALSE;
                                        }
                                    }
                                    com.google.android.libraries.navigation.internal.ll.c.a(context);
                                    throw th;
                                }
                                try {
                                    e(classLoader);
                                } catch (j unused2) {
                                }
                                bool = Boolean.TRUE;
                            }
                            a = bool;
                        }
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused3) {
                        bool = Boolean.FALSE;
                    }
                }
                if (bool.booleanValue()) {
                    try {
                        return g(context, z, false);
                    } catch (j e3) {
                        e3.getMessage();
                        return 0;
                    }
                }
                p pVarA = a(context);
                if (pVarA != null) {
                    try {
                        int iE = pVarA.e();
                        if (iE >= 3) {
                            g gVar = (g) d.get();
                            if (gVar == null || (cursor = gVar.a) == null) {
                                Cursor cursor3 = (Cursor) com.google.android.libraries.navigation.internal.lo.n.b(pVarA.k(new com.google.android.libraries.navigation.internal.lo.n(context), z, ((Long) e.get()).longValue()));
                                if (cursor3 != null) {
                                    try {
                                        if (cursor3.moveToFirst()) {
                                            int i2 = cursor3.getInt(0);
                                            cursor2 = (i2 <= 0 || !f(cursor3)) ? cursor3 : null;
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                            iJ = i2;
                                        } else if (cursor3 != null) {
                                            cursor3.close();
                                        }
                                    } catch (RemoteException e4) {
                                        e2 = e4;
                                        cursor2 = cursor3;
                                        try {
                                            e2.getMessage();
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        cursor2 = cursor3;
                                        if (cursor2 != null) {
                                            cursor2.close();
                                        }
                                        throw th;
                                    }
                                } else if (cursor3 != null) {
                                    cursor3.close();
                                }
                            } else {
                                iJ = cursor.getInt(0);
                            }
                        } else {
                            iJ = iE == 2 ? pVarA.j(new com.google.android.libraries.navigation.internal.lo.n(context), z) : pVarA.i(new com.google.android.libraries.navigation.internal.lo.n(context), z);
                        }
                    } catch (RemoteException e5) {
                        e2 = e5;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
                return iJ;
            }
        } catch (Throwable th5) {
            com.google.android.libraries.navigation.internal.ll.c.a(context);
            throw th5;
        }
    }

    private static void e(ClassLoader classLoader) throws j {
        try {
            r qVar = null;
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(null).newInstance(null);
            if (iBinder != null) {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                qVar = iInterfaceQueryLocalInterface instanceof r ? (r) iInterfaceQueryLocalInterface : new q(iBinder);
            }
            b = qVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new j("Failed to instantiate dynamite loader", e2);
        }
    }

    private static boolean f(Cursor cursor) {
        g gVar = (g) d.get();
        if (gVar == null || gVar.a != null) {
            return false;
        }
        gVar.a = cursor;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:76:0x0123 A[PHI: r1
      0x0123: PHI (r1v7 boolean) = (r1v6 boolean), (r1v9 boolean) binds: [B:56:0x00ec, B:71:0x011d] A[DONT_GENERATE, DONT_INLINE]] */
    private static int g(Context context, boolean z, boolean z2) throws Throwable {
        MatrixCursor matrixCursor;
        MatrixCursor matrixCursor2 = null;
        try {
            try {
                boolean z3 = true;
                Uri uriBuild = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").path(true != z ? "api" : "api_force_staging").appendPath("com.google.android.gms.googlecertificates").appendQueryParameter("requestStartUptime", String.valueOf(((Long) e.get()).longValue())).build();
                ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uriBuild);
                boolean z4 = false;
                if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                    matrixCursor = null;
                } else {
                    try {
                        Cursor cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uriBuild, null, null, null, null);
                        if (cursorQuery == null) {
                            contentProviderClientAcquireUnstableContentProviderClient.release();
                            matrixCursor = null;
                        } else {
                            try {
                                int count = cursorQuery.getCount();
                                int columnCount = cursorQuery.getColumnCount();
                                matrixCursor = new MatrixCursor(cursorQuery.getColumnNames(), count);
                                for (int i2 = 0; i2 < count; i2++) {
                                    if (!cursorQuery.moveToPosition(i2)) {
                                        throw new RemoteException("Cursor read incomplete (ContentProvider dead?)");
                                    }
                                    Object[] objArr = new Object[columnCount];
                                    for (int i3 = 0; i3 < columnCount; i3++) {
                                        int type = cursorQuery.getType(i3);
                                        if (type == 0) {
                                            objArr[i3] = null;
                                        } else if (type == 1) {
                                            objArr[i3] = Long.valueOf(cursorQuery.getLong(i3));
                                        } else if (type == 2) {
                                            objArr[i3] = Double.valueOf(cursorQuery.getDouble(i3));
                                        } else if (type == 3) {
                                            objArr[i3] = cursorQuery.getString(i3);
                                        } else {
                                            if (type != 4) {
                                                throw new RemoteException("Unknown column type");
                                            }
                                            objArr[i3] = cursorQuery.getBlob(i3);
                                        }
                                    }
                                    matrixCursor.addRow(objArr);
                                }
                                cursorQuery.close();
                                contentProviderClientAcquireUnstableContentProviderClient.release();
                            } catch (Throwable th) {
                                try {
                                    cursorQuery.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        }
                    } catch (RemoteException unused) {
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                        matrixCursor = null;
                    } catch (Throwable th3) {
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                        throw th3;
                    }
                }
                if (matrixCursor != null) {
                    try {
                        if (matrixCursor.moveToFirst()) {
                            int i4 = matrixCursor.getInt(0);
                            if (i4 > 0) {
                                synchronized (n.class) {
                                    i = matrixCursor.getString(2);
                                    int columnIndex = matrixCursor.getColumnIndex("loaderVersion");
                                    if (columnIndex >= 0) {
                                        c = matrixCursor.getInt(columnIndex);
                                    }
                                    int columnIndex2 = matrixCursor.getColumnIndex("disableStandaloneDynamiteLoader2");
                                    if (columnIndex2 >= 0) {
                                        if (matrixCursor.getInt(columnIndex2) == 0) {
                                            z3 = false;
                                        }
                                        j = z3;
                                        z4 = z3;
                                    }
                                }
                                matrixCursor2 = f(matrixCursor) ? null : matrixCursor;
                            }
                            if (z2 && z4) {
                                throw new j("forcing fallback to container DynamiteLoader impl");
                            }
                            if (matrixCursor2 != null) {
                                matrixCursor2.close();
                            }
                            return i4;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        if (e instanceof j) {
                            throw e;
                        }
                        throw new j("V2 version check failed: " + e.getMessage(), e);
                    } catch (Throwable th4) {
                        th = th4;
                        matrixCursor2 = matrixCursor;
                        if (matrixCursor2 != null) {
                            matrixCursor2.close();
                        }
                        throw th;
                    }
                }
                throw new j("Failed to connect to dynamite module ContentResolver.");
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public final IBinder d() throws j {
        try {
            return (IBinder) this.l.getClassLoader().loadClass("com.google.android.gms.common.GoogleCertificatesImpl").newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            throw new j("Failed to instantiate module class: ".concat("com.google.android.gms.common.GoogleCertificatesImpl"), e2);
        }
    }
}
