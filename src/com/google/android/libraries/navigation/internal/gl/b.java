package com.google.android.libraries.navigation.internal.gl;

import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.ca;
import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.gd.e;
import com.google.android.libraries.navigation.internal.gg.k;
import com.google.android.libraries.navigation.internal.gm.am;
import com.google.android.libraries.navigation.internal.gm.an;
import com.google.android.libraries.navigation.internal.gn.l;
import com.google.android.libraries.navigation.internal.yr.aw;
import com.google.android.libraries.navigation.internal.yr.ax;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.i;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.zx.n;
import com.google.android.libraries.navigation.internal.zx.q;
import com.google.android.libraries.navigation.internal.zx.r;
import com.google.android.libraries.navigation.internal.zx.s;
import com.google.common.net.HttpHeaders;
import java.util.concurrent.Executor;
import org.chromium.net.CronetEngine;
import org.chromium.net.UrlRequest;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements l {
    public static final fy a = fy.r(200, 202, 204);
    public final com.google.android.libraries.navigation.internal.gh.d b;
    private final cy c;
    private final com.google.android.libraries.navigation.internal.afo.a d;
    private final an e;
    private final Executor f;

    public b(cy cyVar, com.google.android.libraries.navigation.internal.gh.d dVar, com.google.android.libraries.navigation.internal.afo.a aVar, an anVar, Executor executor) {
        this.c = cyVar;
        this.b = dVar;
        this.d = aVar;
        this.e = anVar;
        this.f = executor;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00c3 A[Catch: IllegalArgumentException -> 0x012b, TryCatch #0 {IllegalArgumentException -> 0x012b, blocks: (B:7:0x001a, B:9:0x0029, B:11:0x002f, B:13:0x0037, B:41:0x00bd, B:43:0x00c3, B:45:0x00cb, B:49:0x00d6, B:50:0x00db, B:56:0x00e9, B:57:0x00ef, B:58:0x00fe, B:59:0x00ff, B:19:0x004e, B:23:0x0059, B:28:0x006f, B:30:0x0080, B:40:0x00b6, B:31:0x0087, B:35:0x0090, B:36:0x0098, B:38:0x009e, B:39:0x00ae), top: B:74:0x001a, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00cb A[Catch: IllegalArgumentException -> 0x012b, TryCatch #0 {IllegalArgumentException -> 0x012b, blocks: (B:7:0x001a, B:9:0x0029, B:11:0x002f, B:13:0x0037, B:41:0x00bd, B:43:0x00c3, B:45:0x00cb, B:49:0x00d6, B:50:0x00db, B:56:0x00e9, B:57:0x00ef, B:58:0x00fe, B:59:0x00ff, B:19:0x004e, B:23:0x0059, B:28:0x006f, B:30:0x0080, B:40:0x00b6, B:31:0x0087, B:35:0x0090, B:36:0x0098, B:38:0x009e, B:39:0x00ae), top: B:74:0x001a, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:55:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:62:0x0118  */
    public static boolean b(String str) {
        String[] strArr;
        String strSubstring;
        String strSubstring2;
        boolean z;
        boolean z2;
        boolean z3;
        r rVarA = q.a(str);
        String strSubstring3 = rVarA.b;
        if (aq.c(strSubstring3)) {
            throw new IllegalStateException("Uri has no authority: ".concat(rVarA.toString()));
        }
        int iIndexOf = strSubstring3.indexOf("@");
        if (iIndexOf >= 0) {
            strSubstring3 = strSubstring3.substring(iIndexOf + 1);
        }
        try {
            ar.q(strSubstring3);
            int i = -1;
            if (!strSubstring3.startsWith("[")) {
                int iIndexOf2 = strSubstring3.indexOf(58);
                if (iIndexOf2 >= 0) {
                    int i2 = iIndexOf2 + 1;
                    if (strSubstring3.indexOf(58, i2) == -1) {
                        strSubstring2 = strSubstring3.substring(0, iIndexOf2);
                        strSubstring = strSubstring3.substring(i2);
                    }
                    if (!aq.c(strSubstring)) {
                        if (strSubstring.startsWith("+") && i.a.h(strSubstring)) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        ar.f(z2, "Unparseable port number: %s", strSubstring3);
                        try {
                            i = Integer.parseInt(strSubstring);
                            if (i >= 0 || i > 65535) {
                                z3 = false;
                            } else {
                                z3 = true;
                            }
                            ar.f(z3, "Port number out of range: %s", strSubstring3);
                        } catch (NumberFormatException unused) {
                            throw new IllegalArgumentException("Unparseable port number: ".concat(String.valueOf(strSubstring3)));
                        }
                    }
                    n nVar = new n(strSubstring2, i, z);
                    ar.f(!nVar.b, "Possible bracketless IPv6 literal: %s", nVar.a);
                    String str2 = nVar.a;
                    return !str2.equals("www.google.com") || str2.endsWith(".google.com") || str2.equals("www.googleadservices.com");
                }
                strSubstring = null;
                z = iIndexOf2 >= 0;
                strSubstring2 = strSubstring3;
                if (!aq.c(strSubstring)) {
                    if (strSubstring.startsWith("+")) {
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                    ar.f(z2, "Unparseable port number: %s", strSubstring3);
                    i = Integer.parseInt(strSubstring);
                    if (i >= 0) {
                        z3 = false;
                    } else {
                        z3 = false;
                    }
                    ar.f(z3, "Port number out of range: %s", strSubstring3);
                }
                n nVar2 = new n(strSubstring2, i, z);
                ar.f(!nVar2.b, "Possible bracketless IPv6 literal: %s", nVar2.a);
                String str3 = nVar2.a;
                if (str3.equals("www.google.com")) {
                }
            }
            ar.f(strSubstring3.charAt(0) == '[', "Bracketed host-port string must start with a bracket: %s", strSubstring3);
            int iIndexOf3 = strSubstring3.indexOf(58);
            int iLastIndexOf = strSubstring3.lastIndexOf(93);
            ar.f(iIndexOf3 >= 0 && iLastIndexOf > iIndexOf3, "Invalid bracketed host/port: %s", strSubstring3);
            String strSubstring4 = strSubstring3.substring(1, iLastIndexOf);
            int i3 = iLastIndexOf + 1;
            if (i3 == strSubstring3.length()) {
                strArr = new String[]{strSubstring4, ""};
            } else {
                ar.f(strSubstring3.charAt(i3) == ':', "Only a colon may follow a close bracket: %s", strSubstring3);
                int i4 = iLastIndexOf + 2;
                for (int i5 = i4; i5 < strSubstring3.length(); i5++) {
                    ar.f(Character.isDigit(strSubstring3.charAt(i5)), "Port must be numeric: %s", strSubstring3);
                }
                strArr = new String[]{strSubstring4, strSubstring3.substring(i4)};
            }
            String str4 = strArr[0];
            strSubstring = strArr[1];
            strSubstring2 = str4;
            z = false;
            if (!aq.c(strSubstring)) {
                if (strSubstring.startsWith("+")) {
                    z2 = false;
                } else {
                    z2 = false;
                }
                ar.f(z2, "Unparseable port number: %s", strSubstring3);
                i = Integer.parseInt(strSubstring);
                if (i >= 0) {
                    z3 = false;
                } else {
                    z3 = false;
                }
                ar.f(z3, "Port number out of range: %s", strSubstring3);
            }
            n nVar3 = new n(strSubstring2, i, z);
            ar.f(!nVar3.b, "Possible bracketless IPv6 literal: %s", nVar3.a);
            String str5 = nVar3.a;
            if (str5.equals("www.google.com")) {
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("Invalid authority '" + rVarA.b + "' found in URI '" + rVarA.toString() + "'", e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.gn.l
    public final bj a(am amVar, k kVar) {
        String strA;
        ca caVar = new ca();
        if (!(this.c instanceof com.google.android.libraries.navigation.internal.gj.d)) {
            caVar.ap(new IllegalArgumentException("Expected request type HttpRequest"));
            return caVar;
        }
        com.google.android.libraries.navigation.internal.yt.a aVarA = com.google.android.libraries.navigation.internal.yt.d.a("HttpProtocolRpc.send");
        try {
            com.google.android.libraries.navigation.internal.gj.d dVar = (com.google.android.libraries.navigation.internal.gj.d) this.c;
            r rVarA = q.a(this.b.e.c);
            s sVar = new s(rVarA.e);
            ar.i(sVar.a.equals(rVarA.e), "encoding mismatch; expected %s but was %s", sVar.a, rVarA.e);
            String str = rVarA.a;
            if (str != null) {
                sVar.b = str;
            }
            String str2 = rVarA.b;
            if (str2 != null) {
                sVar.c = str2;
            }
            String str3 = rVarA.c;
            if (str3 != null) {
                sVar.d = str3;
            }
            if (!rVarA.a().A()) {
                sVar.a().B(rVarA.a());
            }
            String str4 = rVarA.d;
            if (str4 != null) {
                sVar.e = str4;
            }
            for (com.google.android.libraries.navigation.internal.gj.c cVar : dVar.b) {
                sVar.a().t(cVar.b, cVar.c);
            }
            String string = sVar.toString();
            UrlRequest.Callback aVar = new a(this, caVar);
            if (aw.d(ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS)) {
                aVar = new com.google.android.libraries.navigation.internal.ys.a(aVar);
            }
            UrlRequest.Builder builderAllowDirectExecutor = ((CronetEngine) this.d.a()).newUrlRequestBuilder(string, aVar, this.f).allowDirectExecutor();
            e eVar = this.b.e;
            if ((eVar.b & 2) != 0) {
                int iB = com.google.android.libraries.navigation.internal.gd.d.b(eVar.d);
                if (iB == 0) {
                    iB = com.google.android.libraries.navigation.internal.gd.d.a;
                }
                strA = com.google.android.libraries.navigation.internal.gd.d.a(iB);
                if (iB == 0) {
                    throw null;
                }
            } else {
                strA = "GET";
            }
            UrlRequest.Builder httpMethod = builderAllowDirectExecutor.setHttpMethod(strA);
            this.e.d(amVar);
            boolean z = this.b.b.c;
            com.google.android.libraries.navigation.internal.gh.b bVarA = amVar.a(HttpHeaders.AUTHORIZATION);
            if (z && b(string) && bVarA != null) {
                httpMethod.addHeader(bVarA.b(), "Bearer ".concat(String.valueOf((String) bVarA.a())));
            }
            com.google.android.libraries.navigation.internal.gh.b bVarA2 = amVar.a("ZwiebackCookie");
            if (z && b(string) && bVarA2 != null) {
                httpMethod.addHeader(bVarA2.b(), (String) bVarA2.a());
            }
            httpMethod.build().start();
            aVarA.close();
            return caVar;
        } catch (Throwable th) {
            try {
                aVarA.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
