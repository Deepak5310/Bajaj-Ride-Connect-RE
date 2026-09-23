package com.google.android.libraries.navigation.internal.fy;

import com.facebook.common.util.UriUtil;
import com.google.android.libraries.navigation.internal.afx.be;
import com.google.android.libraries.navigation.internal.afx.bf;
import com.google.android.libraries.navigation.internal.afx.bz;
import com.google.android.libraries.navigation.internal.afx.q;
import com.google.android.libraries.navigation.internal.aga.ao;
import com.google.android.libraries.navigation.internal.aga.az;
import com.google.android.libraries.navigation.internal.aga.cr;
import com.google.android.libraries.navigation.internal.aga.cu;
import com.google.android.libraries.navigation.internal.aga.cw;
import com.google.android.libraries.navigation.internal.aga.cx;
import com.google.android.libraries.navigation.internal.aga.cz;
import com.google.android.libraries.navigation.internal.aga.es;
import com.google.android.libraries.navigation.internal.aga.et;
import com.google.android.libraries.navigation.internal.aga.s;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bv;
import com.google.android.libraries.navigation.internal.yx.bw;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import org.chromium.net.CronetEngine;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements e {
    public b(CronetEngine cronetEngine, URL url) {
        cu cuVar;
        cu cuVar2;
        cu cuVar3;
        int port = url.getPort();
        bf bfVarA = new com.google.android.libraries.navigation.internal.afz.e(url.getHost(), port == -1 ? 80 : port, cronetEngine).a();
        cx cxVar = (cx) bfVarA;
        s sVarA = cxVar.E.a();
        cw cwVarA = cx.a(cxVar.i, cxVar.g, sVarA.b());
        URI uri = cwVarA.a;
        bz bzVar = cwVarA.b;
        ao aoVar = new ao();
        es esVar = new es(az.b);
        br brVar = az.d;
        cwVarA.a.toString();
        ArrayList arrayList = new ArrayList(cxVar.f);
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) instanceof cu) {
                be beVar = ((cu) arrayList.get(i)).a;
                throw null;
            }
        }
        q.a().c();
        if (cxVar.w) {
            Method method = cx.e;
            if (method != null) {
                try {
                    cuVar3 = (cu) method.invoke(null, Boolean.valueOf(((cx) bfVarA).x), Boolean.valueOf(((cx) bfVarA).y), false, Boolean.valueOf(((cx) bfVarA).z));
                } catch (IllegalAccessException e) {
                    cx.a.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e);
                    cuVar3 = null;
                } catch (InvocationTargetException e2) {
                    cx.a.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e2);
                    cuVar3 = null;
                }
            } else {
                cuVar3 = null;
            }
            if (cuVar3 != null) {
                arrayList.add(0, cuVar3);
            }
        }
        if (cxVar.A) {
            try {
                cuVar = null;
                try {
                    cuVar2 = (cu) Class.forName("com.google.android.libraries.navigation.internal.afy.b").getDeclaredMethod("getClientInterceptor", null).invoke(null, null);
                } catch (ClassNotFoundException e3) {
                    e = e3;
                    cx.a.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e);
                    cuVar2 = cuVar;
                } catch (IllegalAccessException e4) {
                    e = e4;
                    cx.a.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e);
                    cuVar2 = cuVar;
                } catch (NoSuchMethodException e5) {
                    e = e5;
                    cx.a.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e);
                    cuVar2 = cuVar;
                } catch (InvocationTargetException e6) {
                    e = e6;
                    cx.a.logp(Level.FINE, "io.grpc.internal.ManagedChannelImplBuilder", "getEffectiveInterceptors", "Unable to apply census stats", (Throwable) e);
                    cuVar2 = cuVar;
                }
            } catch (ClassNotFoundException e7) {
                e = e7;
                cuVar = null;
            } catch (IllegalAccessException e8) {
                e = e8;
                cuVar = null;
            } catch (NoSuchMethodException e9) {
                e = e9;
                cuVar = null;
            } catch (InvocationTargetException e10) {
                e = e10;
                cuVar = null;
            }
            if (cuVar2 != null) {
                arrayList.add(0, cuVar2);
            }
        }
        bw.a(new bv(new cz(new cr(cxVar, sVarA, uri, bzVar, aoVar, esVar, brVar, arrayList, et.a))));
        if (!url.getProtocol().equals(UriUtil.HTTPS_SCHEME)) {
            throw new IllegalStateException("Insecure server URLs are not allowed: ".concat(url.toString()));
        }
    }
}
