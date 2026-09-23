package com.google.android.libraries.navigation.internal.yh;

import android.net.Uri;
import androidx.core.os.EnvironmentCompat;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.yx.bq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p {
    private final Map a = new HashMap();
    private final Map b = new HashMap();
    private final Executor c;
    private final com.google.android.libraries.navigation.internal.xy.f d;
    private final com.google.android.libraries.navigation.internal.aac.t e;
    private final Map f;
    private final com.google.android.libraries.navigation.internal.yl.a g;

    public p(Executor executor, com.google.android.libraries.navigation.internal.xy.f fVar, com.google.android.libraries.navigation.internal.yl.a aVar, Map map, com.google.android.libraries.navigation.internal.yn.a aVar2) {
        com.google.android.libraries.navigation.internal.aac.t tVar;
        com.google.android.libraries.navigation.internal.yx.ar.q(executor);
        this.c = executor;
        com.google.android.libraries.navigation.internal.yx.ar.q(fVar);
        this.d = fVar;
        com.google.android.libraries.navigation.internal.yx.ar.q(aVar);
        this.g = aVar;
        this.f = map;
        com.google.android.libraries.navigation.internal.yx.ar.a(!map.isEmpty());
        if (aVar2 != null) {
            final ag agVar = new ag(aVar2, com.google.android.libraries.navigation.internal.zl.aa.a);
            tVar = new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.yh.n
                @Override // com.google.android.libraries.navigation.internal.aac.t
                public final bj a(Object obj) {
                    final ag agVar2 = agVar;
                    final Uri uri = (Uri) obj;
                    return com.google.android.libraries.navigation.internal.aac.j.h(agVar2.a.a(), new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.yh.af
                        @Override // com.google.android.libraries.navigation.internal.yx.aa
                        public final Object ak(Object obj2) {
                            com.google.android.libraries.navigation.internal.zl.l lVarA;
                            long jI;
                            String strValueOf = String.valueOf(String.valueOf(uri));
                            String strValueOf2 = String.valueOf((String) obj2);
                            Charset charset = StandardCharsets.UTF_8;
                            boolean zEquals = StandardCharsets.UTF_8.equals(charset);
                            com.google.android.libraries.navigation.internal.zl.m mVar = agVar2.b;
                            String strConcat = strValueOf.concat(strValueOf2);
                            if (zEquals) {
                                int length = strConcat.length();
                                int i = 0;
                                int iG = 0;
                                int i2 = 0;
                                while (true) {
                                    int i3 = i + 4;
                                    jI = 0;
                                    if (i3 > length) {
                                        break;
                                    }
                                    char cCharAt = strConcat.charAt(i);
                                    char cCharAt2 = strConcat.charAt(i + 1);
                                    char cCharAt3 = strConcat.charAt(i + 2);
                                    char cCharAt4 = strConcat.charAt(i + 3);
                                    if (cCharAt >= 128 || cCharAt2 >= 128 || cCharAt3 >= 128 || cCharAt4 >= 128) {
                                        break;
                                    }
                                    iG = com.google.android.libraries.navigation.internal.zl.aa.g(iG, com.google.android.libraries.navigation.internal.zl.aa.h((cCharAt4 << 24) | (cCharAt2 << '\b') | cCharAt | (cCharAt3 << 16)));
                                    i2 += 4;
                                    i = i3;
                                }
                                int i4 = 0;
                                while (i < length) {
                                    char cCharAt5 = strConcat.charAt(i);
                                    if (cCharAt5 < 128) {
                                        jI |= ((long) cCharAt5) << i4;
                                        i2++;
                                        i4 += 8;
                                    } else if (cCharAt5 < 2048) {
                                        jI |= com.google.android.libraries.navigation.internal.zl.aa.j(cCharAt5) << i4;
                                        i2 += 2;
                                        i4 += 16;
                                    } else if (cCharAt5 < 55296 || cCharAt5 > 57343) {
                                        jI |= com.google.android.libraries.navigation.internal.zl.aa.i(cCharAt5) << i4;
                                        i2 += 3;
                                        i4 += 24;
                                    } else {
                                        int iCodePointAt = Character.codePointAt(strConcat, i);
                                        if (iCodePointAt == cCharAt5) {
                                            lVarA = ((com.google.android.libraries.navigation.internal.zl.b) mVar).a(strConcat.toString().getBytes(charset));
                                        } else {
                                            jI |= com.google.android.libraries.navigation.internal.zl.aa.k(iCodePointAt) << i4;
                                            i2 += 4;
                                            i4 += 32;
                                            i++;
                                        }
                                    }
                                    if (i4 >= 32) {
                                        iG = com.google.android.libraries.navigation.internal.zl.aa.g(iG, com.google.android.libraries.navigation.internal.zl.aa.h((int) jI));
                                        jI >>>= 32;
                                        i4 -= 32;
                                    }
                                    i++;
                                }
                                lVarA = com.google.android.libraries.navigation.internal.zl.aa.l(com.google.android.libraries.navigation.internal.zl.aa.h((int) jI) ^ iG, i2);
                            } else {
                                lVarA = ((com.google.android.libraries.navigation.internal.zl.b) mVar).a(strConcat.toString().getBytes(charset));
                            }
                            return lVarA.toString();
                        }
                    }, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
                }
            };
        } else {
            tVar = new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.yh.o
                @Override // com.google.android.libraries.navigation.internal.aac.t
                public final bj a(Object obj) {
                    return az.h("");
                }
            };
        }
        this.e = tVar;
    }

    public final synchronized k a(m mVar) {
        k kVar;
        Uri uri = ((b) mVar).a;
        kVar = (k) this.a.get(uri);
        boolean z = true;
        if (kVar == null) {
            Uri uri2 = ((b) mVar).a;
            com.google.android.libraries.navigation.internal.yx.ar.f(uri2.isHierarchical(), "Uri must be hierarchical: %s", uri2);
            String strB = com.google.android.libraries.navigation.internal.yx.aq.b(uri2.getLastPathSegment());
            int iLastIndexOf = strB.lastIndexOf(46);
            com.google.android.libraries.navigation.internal.yx.ar.f((iLastIndexOf == -1 ? "" : strB.substring(iLastIndexOf + 1)).equals("pb"), "Uri extension must be .pb: %s", uri2);
            com.google.android.libraries.navigation.internal.yx.ar.b(true, "Proto schema cannot be null");
            com.google.android.libraries.navigation.internal.yx.ar.b(((b) mVar).c != null, "Handler cannot be null");
            au auVar = (au) this.f.get("singleproc");
            if (auVar == null) {
                z = false;
            }
            com.google.android.libraries.navigation.internal.yx.ar.f(z, "No XDataStoreVariantFactory registered for ID %s", "singleproc");
            String strB2 = com.google.android.libraries.navigation.internal.yx.aq.b(((b) mVar).a.getLastPathSegment());
            int iLastIndexOf2 = strB2.lastIndexOf(46);
            String strSubstring = iLastIndexOf2 != -1 ? strB2.substring(0, iLastIndexOf2) : strB2;
            bj bjVarI = com.google.android.libraries.navigation.internal.aac.j.i(az.h(((b) mVar).a), this.e, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
            at atVarA = auVar.a(mVar, strSubstring, this.c, this.d, d.ALLOWED);
            com.google.android.libraries.navigation.internal.yl.a aVar = this.g;
            auVar.b(d.ALLOWED);
            k kVar2 = new k(atVarA, aVar, bjVarI);
            ev evVar = ((b) mVar).d;
            if (!evVar.isEmpty()) {
                kVar2.d(new j(evVar, this.c));
            }
            this.a.put(uri, kVar2);
            this.b.put(uri, mVar);
            kVar = kVar2;
        } else {
            m mVar2 = (m) this.b.get(uri);
            if (!mVar.equals(mVar2)) {
                String strA = bq.a("ProtoDataStoreConfig<%s> doesn't match previous call [uri=%s] [%s]", ((b) mVar).b.getClass().getSimpleName(), ((b) mVar).a);
                com.google.android.libraries.navigation.internal.yx.ar.f(((b) mVar).a.equals(mVar2.a()), strA, ReactNativeBlobUtilConst.DATA_ENCODE_URI);
                com.google.android.libraries.navigation.internal.yx.ar.f(((b) mVar).b.equals(mVar2.e()), strA, "schema");
                com.google.android.libraries.navigation.internal.yx.ar.f(((b) mVar).c.equals(mVar2.c()), strA, "handler");
                com.google.android.libraries.navigation.internal.yx.ar.f(hx.i(((b) mVar).d, mVar2.d()), strA, "migrations");
                com.google.android.libraries.navigation.internal.yx.ar.f(((b) mVar).e.equals(mVar2.b()), strA, "variantConfig");
                com.google.android.libraries.navigation.internal.yx.ar.f(((b) mVar).f == mVar2.f(), strA, "useGeneratedExtensionRegistry");
                mVar2.g();
                com.google.android.libraries.navigation.internal.yx.ar.f(true, strA, "enableTracing");
                throw new IllegalArgumentException(bq.a(strA, EnvironmentCompat.MEDIA_UNKNOWN));
            }
        }
        return kVar;
    }
}
