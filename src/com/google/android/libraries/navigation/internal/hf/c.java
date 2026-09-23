package com.google.android.libraries.navigation.internal.hf;

import android.app.Application;
import com.google.android.libraries.navigation.internal.adr.bm;
import com.mappls.sdk.services.api.directions.DirectionsCriteria;
import j$.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class c {
    private static final com.google.android.libraries.navigation.internal.zb.j c = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.hf.c");
    private static final Duration d = Duration.ofMillis(200);
    public final Application a;
    public final n b;
    private final bm.a e;
    private final com.google.android.libraries.navigation.internal.wr.a f;

    public c(Application application, com.google.android.libraries.navigation.internal.wr.a aVar) {
        String strReplaceAll = application.getString(com.google.android.libraries.navigation.internal.f.h.f427n).replaceAll("[^\\x00-\\x7F]", "");
        this.a = application;
        this.f = aVar;
        if (DirectionsCriteria.IMPERIAL.equalsIgnoreCase(strReplaceAll)) {
            this.e = bm.a.MILES;
        } else if ("imperial_yards".equalsIgnoreCase(strReplaceAll)) {
            this.e = bm.a.MILES_YARDS;
        } else {
            this.e = bm.a.KILOMETERS;
        }
        this.b = new n(application.getResources());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public static bm.a e(com.google.android.libraries.navigation.internal.wr.a aVar) {
        try {
            bm.a aVar2 = (bm.a) aVar.a().get(d.toMillis(), TimeUnit.MILLISECONDS);
            if (aVar2 == null || aVar2 == bm.a.REGIONAL) {
                return null;
            }
            return aVar2;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return null;
        } catch (ExecutionException | TimeoutException unused2) {
            return null;
        }
    }

    public static int f(int i) {
        if (Math.abs(i) >= 1000) {
            return i < 0 ? 1 : 3;
        }
        return 2;
    }

    private static int i(long j, int i) {
        return (int) ((((j << 8) + ((long) (i << 7))) / ((long) i)) >> 8);
    }

    private static int j(int i, int i2) {
        return ((i + (i2 >> 1)) / i2) * i2;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x008a  */
    private static i k(int i, bm.a aVar, boolean z) {
        h hVar;
        long j = ((long) i) * 32808;
        int i2 = 1000;
        if (aVar == bm.a.MILES_YARDS && j < 5020000) {
            long j2 = j / 3;
            int i3 = ((int) j2) / 10000;
            if (j2 - (((long) i3) * 10000) >= 5000) {
                i3++;
            }
            i2 = 1000 * j(i3, 10);
            hVar = h.YARDS;
        } else if (aVar == bm.a.MILES && j < 5020000) {
            int i4 = ((int) j) / 10000;
            if (j - (((long) i4) * 10000) >= 5000) {
                i4++;
            }
            i2 = 1000 * j(i4, 50);
            hVar = h.FEET;
        } else if (j < 50160000) {
            i2 = i(j, 5280000) * 100;
            hVar = h.MILES_P1;
        } else if (j <= 52800000) {
            hVar = h.MILES_P1;
        } else {
            long j3 = j / 52800000;
            long j4 = j % 52800000;
            long j5 = 0;
            if (j3 < 10 || j4 < 26400000) {
                long jI = i(j4, 5280000);
                if (jI == 10) {
                    j3++;
                } else {
                    j5 = jI;
                }
            } else {
                j3++;
            }
            long j6 = j3 * 1000;
            if (j3 >= 10) {
                hVar = h.MILES;
            } else {
                hVar = h.MILES_P1;
                j6 += j5 * 100;
            }
            i2 = (int) j6;
        }
        double d2 = i;
        int i5 = i.b;
        return new a(hVar, i2, d2);
    }

    public final i a(int i, bm.a aVar, boolean z) {
        int i2;
        int i3;
        h hVar;
        bm.a aVarB = b(aVar);
        if (i < 0) {
            return null;
        }
        bm.a aVar2 = bm.a.KILOMETERS;
        int iOrdinal = aVarB.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return k(i, bm.a.MILES, true);
            }
            if (iOrdinal != 2) {
                return null;
            }
            return k(i, bm.a.MILES_YARDS, true);
        }
        if (i < 975) {
            i = j(i, i >= 300 ? 50 : 10);
            i2 = i * 1000;
            hVar = h.METERS;
        } else {
            i2 = 1000;
            if (i <= 1000) {
                hVar = h.KILOMETERS_P1;
            } else {
                String string = Integer.toString(i);
                int length = string.length() - 3;
                int i4 = 0;
                int i5 = Integer.parseInt(string.substring(0, length));
                int i6 = Integer.parseInt(string.substring(length));
                if ((i5 < 10 || i6 < 500) && (i3 = i(i6, 100)) != 10) {
                    i4 = i3;
                } else {
                    i5++;
                }
                if (i5 >= 10) {
                    i2 = 1000 * i5;
                    hVar = h.KILOMETERS;
                } else {
                    i2 = (i5 * 1000) + (i4 * 100);
                    hVar = h.KILOMETERS_P1;
                }
            }
        }
        int i7 = i.b;
        return new a(hVar, i2, i);
    }

    public final bm.a b(bm.a aVar) {
        bm.a aVar2;
        bm.a aVarE = e(this.f);
        if (aVarE != null) {
            return aVarE;
        }
        if (aVar != null) {
            return (aVar == bm.a.MILES && (aVar2 = this.e) == bm.a.MILES_YARDS) ? aVar2 : aVar;
        }
        return this.e;
    }

    public final CharSequence c(i iVar, boolean z, n.a aVar, n.a aVar2) {
        int i;
        if (iVar == null) {
            return "";
        }
        n nVar = this.b;
        bm.a aVar3 = bm.a.KILOMETERS;
        h hVar = ((a) iVar).a;
        switch (hVar) {
            case METERS:
                i = !z ? com.google.android.libraries.navigation.internal.f.h.k : com.google.android.libraries.navigation.internal.f.h.j;
                break;
            case KILOMETERS:
            case KILOMETERS_P1:
                i = !z ? com.google.android.libraries.navigation.internal.f.h.i : com.google.android.libraries.navigation.internal.f.h.h;
                break;
            case MILES:
            case MILES_P1:
                i = !z ? com.google.android.libraries.navigation.internal.f.h.m : com.google.android.libraries.navigation.internal.f.h.l;
                break;
            case YARDS:
                i = !z ? com.google.android.libraries.navigation.internal.f.h.p : com.google.android.libraries.navigation.internal.f.h.o;
                break;
            case FEET:
                i = !z ? com.google.android.libraries.navigation.internal.f.h.g : com.google.android.libraries.navigation.internal.f.h.f;
                break;
            default:
                ((com.google.android.libraries.navigation.internal.zb.h) c.d(com.google.android.libraries.navigation.internal.nl.a.a).F(631)).s("Unknown RoundedDistance.Units: %s", hVar);
                i = com.google.android.libraries.navigation.internal.f.h.j;
                break;
        }
        l lVarE = nVar.e(i);
        if (aVar2 != null) {
            n.a aVar4 = lVarE.a;
            aVar4.b(aVar2);
            lVarE.a = aVar4;
        }
        if (aVar != null) {
            m mVar = new m(iVar.d());
            mVar.d(aVar);
            lVarE.a(mVar);
        } else {
            lVarE.a(iVar.d());
        }
        return lVarE.b();
    }

    public final String d(int i, bm.a aVar, boolean z, boolean z2) {
        return c(a(i, aVar, true), z2, null, null).toString();
    }

    public final CharSequence g(int i, bm.a aVar, n.a aVar2, n.a aVar3) {
        return c(a(i, aVar, true), true, aVar2, aVar3);
    }

    public final String h(bm bmVar) {
        i iVarA;
        bm.a aVarB;
        int i = bmVar.b;
        if ((i & 1) != 0) {
            if ((i & 4) != 0) {
                aVarB = bm.a.b(bmVar.d);
                if (aVarB == null) {
                    aVarB = bm.a.REGIONAL;
                }
            } else {
                aVarB = null;
            }
            iVarA = a(bmVar.c, aVarB, true);
        } else {
            iVarA = null;
        }
        return c(iVarA, true, null, null).toString();
    }
}
