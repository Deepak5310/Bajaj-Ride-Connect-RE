package com.google.android.libraries.navigation.internal.lc;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.StrictMode;
import android.os.SystemClock;
import com.google.android.libraries.navigation.internal.lh.at;
import com.google.android.libraries.navigation.internal.lh.au;
import com.google.android.libraries.navigation.internal.lh.be;
import com.google.common.base.Ascii;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class u {
    public static volatile au g;
    public static Context h;
    static final s a = new k(q.e("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u007f¢fú§p\u0085xb±"));
    static final s b = new l(q.e("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014QÕÛ\u0004÷XçB\u0086<"));
    static final s c = new m(q.e("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));
    static final s d = new n(q.e("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));
    static final s e = new o(q.e("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));
    static final s f = new p(q.e("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));
    private static final Object i = new Object();

    static ac a(String str, q qVar, boolean z, boolean z2) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return b(str, qVar, z, z2);
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    public static ac b(final String str, final q qVar, final boolean z, boolean z2) {
        try {
            d();
            be.j(h);
            try {
                return g.f(new z(str, qVar, z, z2), new com.google.android.libraries.navigation.internal.lo.n(h.getPackageManager())) ? ac.a : new ab(new Callable() { // from class: com.google.android.libraries.navigation.internal.lc.j
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        au auVar = u.g;
                        String str2 = str;
                        boolean z3 = z;
                        q qVar2 = qVar;
                        String str3 = (z3 || !u.b(str2, qVar2, true, false).b) ? "not allowed" : "debug cert rejected";
                        MessageDigest messageDigestA = com.google.android.libraries.navigation.internal.ll.a.a();
                        be.j(messageDigestA);
                        byte[] bArrDigest = messageDigestA.digest(qVar2.f());
                        char[] cArr = com.google.android.libraries.navigation.internal.ll.g.a;
                        int length = bArrDigest.length;
                        char[] cArr2 = new char[length + length];
                        int i2 = 0;
                        for (byte b2 : bArrDigest) {
                            int i3 = i2 + 1;
                            char[] cArr3 = com.google.android.libraries.navigation.internal.ll.g.a;
                            cArr2[i2] = cArr3[(b2 & 255) >>> 4];
                            i2 += 2;
                            cArr2[i3] = cArr3[b2 & Ascii.SI];
                        }
                        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", str3, str2, new String(cArr2), Boolean.valueOf(z3), "245125000.false");
                    }
                });
            } catch (RemoteException e2) {
                return ac.c("module call", e2);
            }
        } catch (com.google.android.libraries.navigation.internal.lp.j e3) {
            return ac.c("module init: ".concat(String.valueOf(e3.getMessage())), e3);
        }
    }

    static synchronized void c(Context context) {
        if (h != null || context == null) {
            return;
        }
        h = context.getApplicationContext();
    }

    public static void d() throws com.google.android.libraries.navigation.internal.lp.j {
        long j;
        com.google.android.libraries.navigation.internal.lp.n nVar;
        ThreadLocal threadLocal;
        Boolean bool;
        com.google.android.libraries.navigation.internal.lo.l lVarH;
        com.google.android.libraries.navigation.internal.lp.n nVar2;
        com.google.android.libraries.navigation.internal.lp.r rVar;
        boolean z;
        Boolean boolValueOf;
        au atVar;
        if (g != null) {
            return;
        }
        be.j(h);
        synchronized (i) {
            if (g == null) {
                Context context = h;
                com.google.android.libraries.navigation.internal.lp.m mVar = com.google.android.libraries.navigation.internal.lp.n.g;
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    throw new com.google.android.libraries.navigation.internal.lp.j("null application Context");
                }
                com.google.android.libraries.navigation.internal.lp.g gVar = (com.google.android.libraries.navigation.internal.lp.g) com.google.android.libraries.navigation.internal.lp.n.d.get();
                com.google.android.libraries.navigation.internal.lp.g gVar2 = new com.google.android.libraries.navigation.internal.lp.g();
                com.google.android.libraries.navigation.internal.lp.n.d.set(gVar2);
                Long l = (Long) com.google.android.libraries.navigation.internal.lp.n.e.get();
                long jLongValue = l.longValue();
                try {
                    com.google.android.libraries.navigation.internal.lp.n.e.set(Long.valueOf(SystemClock.uptimeMillis()));
                    com.google.android.libraries.navigation.internal.lp.l lVarA = mVar.a(context, com.google.android.libraries.navigation.internal.lp.n.f);
                    int i2 = lVarA.c;
                    if (i2 != 0) {
                        if (i2 == -1) {
                            try {
                                if (lVarA.a != 0) {
                                }
                            } catch (Throwable th) {
                                th = th;
                                j = 0;
                                if (jLongValue == j) {
                                    com.google.android.libraries.navigation.internal.lp.n.e.remove();
                                } else {
                                    com.google.android.libraries.navigation.internal.lp.n.e.set(l);
                                }
                                Cursor cursor = gVar2.a;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                com.google.android.libraries.navigation.internal.lp.n.d.set(gVar);
                                throw th;
                            }
                        }
                        if (i2 != 1 || lVarA.b != 0) {
                            if (i2 == -1) {
                                nVar = new com.google.android.libraries.navigation.internal.lp.n(applicationContext);
                                if (jLongValue == 0) {
                                    com.google.android.libraries.navigation.internal.lp.n.e.remove();
                                } else {
                                    com.google.android.libraries.navigation.internal.lp.n.e.set(l);
                                }
                                Cursor cursor2 = gVar2.a;
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                threadLocal = com.google.android.libraries.navigation.internal.lp.n.d;
                            } else {
                                if (i2 != 1) {
                                    throw new com.google.android.libraries.navigation.internal.lp.j(com.google.android.libraries.navigation.internal.b.b.b(0, "VersionPolicy returned invalid code:"));
                                }
                                try {
                                    int i3 = lVarA.b;
                                    try {
                                        synchronized (com.google.android.libraries.navigation.internal.lp.n.class) {
                                            if (!com.google.android.libraries.navigation.internal.lp.n.b(context)) {
                                                throw new com.google.android.libraries.navigation.internal.lp.j("Remote loading disabled");
                                            }
                                            bool = com.google.android.libraries.navigation.internal.lp.n.a;
                                        }
                                        if (bool == null) {
                                            throw new com.google.android.libraries.navigation.internal.lp.j("Failed to determine which loading route to use.");
                                        }
                                        if (bool.booleanValue()) {
                                            synchronized (com.google.android.libraries.navigation.internal.lp.n.class) {
                                                rVar = com.google.android.libraries.navigation.internal.lp.n.b;
                                            }
                                            if (rVar == null) {
                                                throw new com.google.android.libraries.navigation.internal.lp.j("DynamiteLoaderV2 was not cached.");
                                            }
                                            com.google.android.libraries.navigation.internal.lp.g gVar3 = (com.google.android.libraries.navigation.internal.lp.g) com.google.android.libraries.navigation.internal.lp.n.d.get();
                                            if (gVar3 == null || gVar3.a == null) {
                                                throw new com.google.android.libraries.navigation.internal.lp.j("No result cursor");
                                            }
                                            Context applicationContext2 = context.getApplicationContext();
                                            Cursor cursor3 = gVar3.a;
                                            new com.google.android.libraries.navigation.internal.lo.n(null);
                                            synchronized (com.google.android.libraries.navigation.internal.lp.n.class) {
                                                z = com.google.android.libraries.navigation.internal.lp.n.c >= 2;
                                                boolValueOf = Boolean.valueOf(z);
                                            }
                                            boolValueOf.getClass();
                                            Context context2 = (Context) com.google.android.libraries.navigation.internal.lo.n.b(z ? rVar.f(new com.google.android.libraries.navigation.internal.lo.n(applicationContext2), i3, new com.google.android.libraries.navigation.internal.lo.n(cursor3)) : rVar.e(new com.google.android.libraries.navigation.internal.lo.n(applicationContext2), i3, new com.google.android.libraries.navigation.internal.lo.n(cursor3)));
                                            if (context2 == null) {
                                                throw new com.google.android.libraries.navigation.internal.lp.j("Failed to get module context");
                                            }
                                            nVar2 = new com.google.android.libraries.navigation.internal.lp.n(context2);
                                        } else {
                                            com.google.android.libraries.navigation.internal.lp.p pVarA = com.google.android.libraries.navigation.internal.lp.n.a(context);
                                            if (pVarA == null) {
                                                throw new com.google.android.libraries.navigation.internal.lp.j("Failed to create IDynamiteLoader.");
                                            }
                                            int iE = pVarA.e();
                                            if (iE >= 3) {
                                                com.google.android.libraries.navigation.internal.lp.g gVar4 = (com.google.android.libraries.navigation.internal.lp.g) com.google.android.libraries.navigation.internal.lp.n.d.get();
                                                if (gVar4 == null) {
                                                    throw new com.google.android.libraries.navigation.internal.lp.j("No cached result cursor holder");
                                                }
                                                lVarH = pVarA.g(new com.google.android.libraries.navigation.internal.lo.n(context), i3, new com.google.android.libraries.navigation.internal.lo.n(gVar4.a));
                                            } else {
                                                lVarH = iE == 2 ? pVarA.h(new com.google.android.libraries.navigation.internal.lo.n(context), i3) : pVarA.f(new com.google.android.libraries.navigation.internal.lo.n(context), i3);
                                            }
                                            Object objB = com.google.android.libraries.navigation.internal.lo.n.b(lVarH);
                                            if (objB == null) {
                                                throw new com.google.android.libraries.navigation.internal.lp.j("Failed to load remote module.");
                                            }
                                            nVar2 = new com.google.android.libraries.navigation.internal.lp.n((Context) objB);
                                        }
                                        nVar = nVar2;
                                        if (jLongValue == 0) {
                                            com.google.android.libraries.navigation.internal.lp.n.e.remove();
                                        } else {
                                            com.google.android.libraries.navigation.internal.lp.n.e.set(l);
                                        }
                                        Cursor cursor4 = gVar2.a;
                                        if (cursor4 != null) {
                                            cursor4.close();
                                        }
                                        threadLocal = com.google.android.libraries.navigation.internal.lp.n.d;
                                    } catch (RemoteException e2) {
                                        throw new com.google.android.libraries.navigation.internal.lp.j("Failed to load remote module.", e2);
                                    } catch (com.google.android.libraries.navigation.internal.lp.j e3) {
                                        throw e3;
                                    } catch (Throwable th2) {
                                        com.google.android.libraries.navigation.internal.ll.c.a(context);
                                        throw new com.google.android.libraries.navigation.internal.lp.j("Failed to load remote module.", th2);
                                    }
                                } catch (com.google.android.libraries.navigation.internal.lp.j e4) {
                                    e4.getMessage();
                                    int i4 = lVarA.a;
                                    if (i4 == 0 || mVar.a(context, new com.google.android.libraries.navigation.internal.lp.i(i4)).c != -1) {
                                        throw new com.google.android.libraries.navigation.internal.lp.j("Remote load failed. No local fallback found.", e4);
                                    }
                                    nVar = new com.google.android.libraries.navigation.internal.lp.n(applicationContext);
                                    if (jLongValue == 0) {
                                        com.google.android.libraries.navigation.internal.lp.n.e.remove();
                                    } else {
                                        com.google.android.libraries.navigation.internal.lp.n.e.set(l);
                                    }
                                    Cursor cursor5 = gVar2.a;
                                    if (cursor5 != null) {
                                        cursor5.close();
                                    }
                                    threadLocal = com.google.android.libraries.navigation.internal.lp.n.d;
                                }
                            }
                            threadLocal.set(gVar);
                            IBinder iBinderD = nVar.d();
                            if (iBinderD == null) {
                                atVar = null;
                            } else {
                                IInterface iInterfaceQueryLocalInterface = iBinderD.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
                                atVar = iInterfaceQueryLocalInterface instanceof au ? (au) iInterfaceQueryLocalInterface : new at(iBinderD);
                            }
                            g = atVar;
                        }
                    }
                    throw new com.google.android.libraries.navigation.internal.lp.j("No acceptable module com.google.android.gms.googlecertificates found. Local version is " + lVarA.a + " and remote version is " + lVarA.b + ".");
                } catch (Throwable th3) {
                    th = th3;
                    j = 0;
                }
            }
        }
    }
}
