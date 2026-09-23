package com.google.android.libraries.navigation.internal.c;

import com.google.android.libraries.navigation.internal.b.t;
import com.google.android.libraries.navigation.internal.b.x;
import com.google.android.libraries.navigation.internal.b.y;
import com.google.android.libraries.navigation.internal.b.z;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class q extends t {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Object f365n;
    private y o;

    public q(String str, y yVar, x xVar) {
        super(0, str, xVar);
        this.f365n = new Object();
        this.o = yVar;
    }

    @Override // com.google.android.libraries.navigation.internal.b.t
    public final void g() {
        super.g();
        synchronized (this.f365n) {
            this.o = null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.b.t
    protected final /* bridge */ /* synthetic */ void h(Object obj) {
        y yVar;
        String str = (String) obj;
        synchronized (this.f365n) {
            yVar = this.o;
        }
        if (yVar != null) {
            yVar.b(str);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.b.t
    protected final z b(com.google.android.libraries.navigation.internal.b.o oVar) {
        String str;
        String str2;
        try {
            byte[] bArr = oVar.b;
            Map map = oVar.c;
            String str3 = CharEncoding.ISO_8859_1;
            if (map != null && (str2 = (String) map.get("Content-Type")) != null) {
                String[] strArrSplit = str2.split(";", 0);
                for (int i = 1; i < strArrSplit.length; i++) {
                    String[] strArrSplit2 = strArrSplit[i].trim().split("=", 0);
                    if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                        str3 = strArrSplit2[1];
                        break;
                    }
                }
            }
            str = new String(bArr, str3);
        } catch (UnsupportedEncodingException unused) {
            str = new String(oVar.b);
        }
        return new z(str, i.b(oVar));
    }
}
