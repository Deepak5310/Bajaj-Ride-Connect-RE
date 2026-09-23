package com.google.android.libraries.navigation.internal.yr;

import android.os.Build;
import android.os.Trace;
import android.text.TextUtils;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.mb;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i {
    public static final int a = 4;
    static final com.google.android.libraries.navigation.internal.xw.a b;
    public static final WeakHashMap c;
    public static final ThreadLocal d;
    public static final Deque e;
    public static final Deque f;
    public static final Object g;
    public static final Runnable h;
    private static final fy i;
    private static final fy j;
    private static final AtomicReference k;

    /* JADX INFO: compiled from: PG */
    final class a {
        public static boolean a() {
            return Trace.isEnabled();
        }
    }

    static {
        fy fyVarT = fy.t("androidx.fragment.app.FragmentViewLifecycleOwner.handleLifecycleEvent", "com.google.android.libraries.logging.logger.transmitters.clearcut", "com.google.android.libraries.performance.primes.transmitter.clearcut", "com.google.android.libraries.performance.primes.metrics.crash.CrashMetricServiceImpl", "com.google.android.libraries.performance.primes.metrics.crash.applicationexit.ApplicationExitMetricServiceImpl");
        i = fyVarT;
        j = fyVarT;
        k = new AtomicReference(mb.a);
        b = new com.google.android.libraries.navigation.internal.xw.a();
        c = new WeakHashMap();
        new l();
        d = new h();
        e = new ArrayDeque();
        f = new ArrayDeque();
        g = new Object();
        h = new Runnable() { // from class: com.google.android.libraries.navigation.internal.yr.g
            @Override // java.lang.Runnable
            public final void run() {
                Object objRemove = i.e.remove();
                if (objRemove == i.g) {
                    i.f.pop();
                } else {
                    i.f.push((ag) objRemove);
                }
            }
        };
    }

    public static ae a() {
        return (ae) d.get();
    }

    public static ag b() {
        return a().b;
    }

    public static ag c() {
        ae aeVarA = a();
        ag agVar = aeVarA.b;
        if (agVar != null) {
            return agVar;
        }
        int i2 = q.c;
        UUID uuidB = m.a.b();
        if (!ah.a()) {
            q.k(uuidB, null);
            return new q(uuidB, q.b, false, aeVarA);
        }
        b bVar = new b();
        q.k(uuidB, bVar);
        return new q(uuidB, bVar, h(bVar), aeVarA);
    }

    static ag d(ag agVar) {
        return e(a(), agVar);
    }

    public static ag e(ae aeVar, ag agVar) {
        ag agVar2;
        boolean zEquals;
        au auVar = aeVar.c;
        ag agVar3 = aeVar.b;
        if (agVar3 == agVar) {
            return agVar;
        }
        if (agVar3 == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                zEquals = a.a();
            } else {
                String str = b.a;
                Method method = com.google.android.libraries.navigation.internal.xx.b.a;
                String str2 = "false";
                try {
                    str2 = (String) com.google.android.libraries.navigation.internal.xx.b.a.invoke(null, str, "false");
                } catch (Exception unused) {
                }
                zEquals = "true".equals(str2);
            }
            aeVar.a = zEquals;
        }
        au auVar2 = aeVar.c;
        if (aeVar.a) {
            if (agVar3 != null) {
                if (agVar == null) {
                    agVar2 = null;
                } else if (agVar3.a() == agVar && !af.d(agVar3)) {
                    Trace.endSection();
                } else if (agVar3 != agVar.a() || af.d(agVar)) {
                    agVar2 = agVar;
                } else {
                    af.a(agVar);
                }
                af.c(agVar3);
            } else {
                agVar2 = agVar;
            }
            if (agVar2 != null) {
                af.b(agVar2);
            }
        }
        if (agVar3 == agVar) {
            return agVar;
        }
        if (agVar == null) {
            agVar = null;
        }
        aeVar.b = agVar;
        return agVar3;
    }

    static fy f() {
        return (fy) k.get();
    }

    /* JADX WARN: Code duplicated, block: B:55:0x019f  */
    public static String g(String[] strArr) {
        int length;
        aa aaVar;
        ez ezVar = new ez();
        nn nnVarListIterator = fy.p(strArr).listIterator();
        int i2 = 0;
        int i3 = 0;
        while (nnVarListIterator.hasNext()) {
            ezVar.f(nnVarListIterator.next(), Integer.valueOf(i3));
            i3++;
        }
        fd fdVarD = ezVar.d();
        int size = fdVarD.size();
        int length2 = strArr.length;
        ac acVar = null;
        if (size <= (length2 >> 2)) {
            int i4 = length2 + 1;
            int[] iArr = new int[i4];
            int i5 = 0;
            while (true) {
                length = strArr.length;
                if (i5 >= length) {
                    break;
                }
                iArr[i5] = ((Integer) fdVarD.get(strArr[i5])).intValue();
                i5++;
            }
            iArr[length] = fdVarD.size();
            ad adVar = new ad(iArr);
            for (int i6 = 0; i6 < i4; i6++) {
                adVar.f++;
                int i7 = adVar.a[i6];
                while (true) {
                    ab abVar = null;
                    while (true) {
                        if (adVar.f <= 0) {
                            break;
                        }
                        if (adVar.e == 0) {
                            break;
                        }
                        int[] iArr2 = adVar.a;
                        int i8 = ((ab) adVar.c.d.get(Integer.valueOf(iArr2[adVar.d]))).a;
                        int i9 = adVar.e;
                        if (iArr2[i8 + i9] == i7) {
                            if (abVar != null) {
                                abVar.c = adVar.c;
                            }
                            adVar.e = i9 + 1;
                            adVar.b();
                            break;
                        }
                        ab abVar2 = (ab) adVar.c.d.get(Integer.valueOf(adVar.a[adVar.d]));
                        int i10 = abVar2.a;
                        ab abVar3 = new ab(i10, (adVar.e + i10) - 1);
                        adVar.c.d.put(Integer.valueOf(adVar.a[adVar.d]), abVar3);
                        abVar3.d.put(Integer.valueOf(adVar.a[abVar3.b + 1]), abVar2);
                        abVar2.a = abVar3.b + 1;
                        if (abVar != null) {
                            abVar.c = abVar3;
                        }
                        abVar3.d.put(Integer.valueOf(i7), new ab(i6, 1073741824));
                        adVar.f--;
                        adVar.a();
                        abVar = abVar3;
                    }
                    Map map = adVar.c.d;
                    Integer numValueOf = Integer.valueOf(i7);
                    if (map.containsKey(numValueOf)) {
                        if (abVar != null) {
                            abVar.c = adVar.c;
                        }
                        adVar.d = i6;
                        adVar.e++;
                        adVar.b();
                        break;
                    }
                    adVar.c.d.put(numValueOf, new ab(i6, 1073741824));
                    if (abVar != null) {
                        abVar.c = adVar.c;
                    }
                    adVar.f--;
                    adVar.a();
                }
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            aa aaVar2 = new aa(adVar.b, 0, -1, -1);
            arrayDeque.push(aaVar2);
            while (!arrayDeque.isEmpty()) {
                aa aaVar3 = (aa) arrayDeque.pop();
                for (ab abVar4 : aaVar3.d.d.values()) {
                    if (adVar.c(aaVar3.b, aaVar3.c, abVar4.a, abVar4.b)) {
                        aaVar = new aa(abVar4, aaVar3.a + 1, aaVar3.b, aaVar3.c);
                    } else {
                        if (abVar4.d.isEmpty()) {
                            int i11 = aaVar3.b;
                            int i12 = aaVar3.c;
                            int i13 = abVar4.a;
                            if (adVar.c(i11, i12, i13, (i13 + i12) - i11)) {
                                aaVar = new aa(abVar4, aaVar3.a + 1, aaVar3.b, aaVar3.c);
                            }
                        }
                        aaVar = new aa(abVar4, 1, abVar4.a, abVar4.b);
                    }
                    if (aaVar2.a < aaVar.a) {
                        aaVar2 = aaVar;
                    }
                    arrayDeque.push(aaVar);
                }
            }
            int[] iArr3 = adVar.a;
            int i14 = aaVar2.c + 1;
            ab abVar5 = adVar.b;
            int iMin = Math.min(iArr3.length, i14);
            loop7: while (true) {
                int[] iArr4 = adVar.a;
                int i15 = aaVar2.b;
                abVar5 = (ab) abVar5.d.get(Integer.valueOf(iArr4[i15 + (i2 % (iMin - i15))]));
                if (abVar5 == null) {
                    break;
                }
                for (int i16 = abVar5.a; i16 < abVar5.b + 1; i16++) {
                    int[] iArr5 = adVar.a;
                    if (i16 >= iArr5.length) {
                        break;
                    }
                    int i17 = aaVar2.b;
                    if (iArr5[i17 + (i2 % (iMin - i17))] != iArr5[i16]) {
                        break loop7;
                    }
                    i2++;
                }
            }
            int i18 = aaVar2.b;
            ac acVar2 = new ac(i18, iMin, i2 / (iMin - i18));
            if (acVar2.c * (acVar2.b - acVar2.a) >= (strArr.length >> 2)) {
                acVar = acVar2;
            }
        }
        if (acVar == null) {
            return "";
        }
        int i19 = acVar.a;
        String strConcat = i19 > 0 ? String.valueOf(TextUtils.join(" -> ", Arrays.copyOf(strArr, i19))).concat(" -> ") : "";
        int i20 = acVar.a;
        int i21 = acVar.b;
        int i22 = acVar.c;
        int length3 = strArr.length;
        int i23 = i20 + ((i21 - i20) * i22);
        return String.format(Locale.US, "%s{%s}x%d%s", strConcat, TextUtils.join(" -> ", Arrays.copyOfRange(strArr, acVar.a, acVar.b)), Integer.valueOf(acVar.c), i23 < length3 ? " -> ".concat(String.valueOf(TextUtils.join(" -> ", Arrays.copyOfRange(strArr, i23, length3)))) : "");
    }

    static boolean h(Throwable th) {
        if (j.isEmpty()) {
            return false;
        }
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            nn nnVarListIterator = j.listIterator();
            while (nnVarListIterator.hasNext()) {
                if (stackTraceElement.toString().startsWith((String) nnVarListIterator.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean i() {
        ag agVarB = b();
        return (agVarB == null || agVarB == u.b) ? false : true;
    }

    static void j() {
        IllegalStateException illegalStateException;
        if (ah.a()) {
            ag agVarB = b();
            if (agVarB == null || (agVarB instanceof u)) {
                illegalStateException = new IllegalStateException("Was supposed to have a trace - did you forget to propagate or create one? See http://go/tiktok-tracing for more details.");
            } else {
                illegalStateException = agVarB instanceof d ? new IllegalStateException("Was supposed to have a trace - did you forget to propagate or create one? See this exception's cause for the last place a trace was missing. See http://go/tiktok-tracing for more details.", ((d) agVarB).f()) : null;
            }
            if (illegalStateException != null) {
                if (agVarB instanceof d) {
                    ((d) agVarB).g();
                } else {
                    h(illegalStateException);
                }
            }
        }
    }
}
