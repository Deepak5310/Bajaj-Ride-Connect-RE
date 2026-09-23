package com.google.android.libraries.navigation.internal.b;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.android.volley.DefaultRetryPolicy;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class t implements Comparable {
    public final af a;
    public final int b;
    public final String c;
    public final int d;
    public final Object e;
    public x f;
    public Integer g;
    public w h;
    public boolean i;
    public boolean j;
    public b k;
    public s l;
    public g m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f342n;

    public t(int i, String str, x xVar) {
        Uri uri;
        String host;
        this.a = af.a ? new af() : null;
        this.e = new Object();
        this.i = true;
        int iHashCode = 0;
        this.f342n = false;
        this.j = false;
        this.k = null;
        this.b = i;
        this.c = str;
        this.f = xVar;
        this.m = new g(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 1, 1.0f);
        if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && (host = uri.getHost()) != null) {
            iHashCode = host.hashCode();
        }
        this.d = iHashCode;
    }

    public final int a() {
        return this.m.a;
    }

    protected abstract z b(o oVar);

    public String c() {
        return "application/x-www-form-urlencoded; charset=".concat("UTF-8");
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        t tVar = (t) obj;
        int iP = tVar.p();
        int iP2 = p();
        return iP2 == iP ? this.g.intValue() - tVar.g.intValue() : (iP - 1) - (iP2 - 1);
    }

    public final String d() {
        int i = this.b;
        String str = this.c;
        if (i == 0) {
            return str;
        }
        return Integer.toString(1) + "-" + str;
    }

    public Map e() throws a {
        return Collections.emptyMap();
    }

    public final void f(String str) {
        if (af.a) {
            this.a.a(str, Thread.currentThread().getId());
        }
    }

    public void g() {
        synchronized (this.e) {
            this.f342n = true;
            this.f = null;
        }
    }

    protected abstract void h(Object obj);

    final void i(String str) {
        w wVar = this.h;
        if (wVar != null) {
            synchronized (wVar.a) {
                wVar.a.remove(this);
            }
            synchronized (wVar.i) {
                Iterator it2 = wVar.i.iterator();
                while (it2.hasNext()) {
                    ((v) it2.next()).a();
                }
            }
            wVar.b(this, 5);
        }
        if (af.a) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new r(this, str, id));
            } else {
                this.a.a(str, id);
                this.a.b(toString());
            }
        }
    }

    public final void j() {
        synchronized (this.e) {
            this.j = true;
        }
    }

    final void k() {
        s sVar;
        synchronized (this.e) {
            sVar = this.l;
        }
        if (sVar != null) {
            sVar.a(this);
        }
    }

    final void l(int i) {
        w wVar = this.h;
        if (wVar != null) {
            wVar.b(this, i);
        }
    }

    final void m(s sVar) {
        synchronized (this.e) {
            this.l = sVar;
        }
    }

    public final boolean n() {
        boolean z;
        synchronized (this.e) {
            z = this.f342n;
        }
        return z;
    }

    public byte[] o() throws a {
        return null;
    }

    public int p() {
        return 2;
    }

    public final String toString() {
        String strValueOf = String.valueOf(Integer.toHexString(this.d));
        String str = true != n() ? "[ ] " : "[X] ";
        String str2 = p() != 1 ? "NORMAL" : "LOW";
        return str + this.c + StringUtils.SPACE + "0x".concat(strValueOf) + StringUtils.SPACE + str2 + StringUtils.SPACE + this.g;
    }
}
