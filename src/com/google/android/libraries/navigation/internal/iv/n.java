package com.google.android.libraries.navigation.internal.iv;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.ael.cc;
import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.bj;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yz.fw;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n implements SharedPreferences.OnSharedPreferenceChangeListener, f {
    public static final /* synthetic */ int c = 0;
    private static final fy d = fy.u(ab.bq, ab.bs, ab.X, ab.W, ab.ah, ab.am, ab.au, ab.av, ab.an, ab.bA, ab.bz, ab.Y, ab.Z, ab.ai, ab.aj, ab.ak, ab.al, ab.ao, ab.ap, ab.aq, ab.ar, ab.as, ab.bo, ab.bp, ab.bt, ab.bu, ab.bv, ab.bw, ab.bx, ab.by, ab.bB, ab.bC, ab.bG, ab.bP);
    private static final AtomicBoolean e = new AtomicBoolean(true);
    public final SharedPreferences b;
    private final Context f;
    private final com.google.android.libraries.navigation.internal.nt.l g = new com.google.android.libraries.navigation.internal.nt.l();

    static {
        Pattern.compile("^([^#$]+)([#$])(.*)$");
    }

    public n(Context context) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("GmmSettings.ctor");
        try {
            this.b = context.getSharedPreferences(f.a, 0);
            this.f = context;
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static n B(Context context) {
        n nVar = new n(context);
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("GmmSettings.initialize");
        try {
            int iA = nVar.a(ab.b, 0);
            if (iA != 18) {
                SharedPreferences sharedPreferences = nVar.b;
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                if (iA < 4) {
                    editorEdit.clear();
                }
                if (iA < 5 && !nVar.j(ab.T, al.class).isEmpty()) {
                    editorEdit.putBoolean(ab.U.toString(), true);
                }
                if (iA >= 4 && iA < 6) {
                    editorEdit.putBoolean(ab.ab.toString(), !sharedPreferences.getBoolean(ab.aa.toString(), true));
                }
                if (iA < 8) {
                    editorEdit.remove(ab.aW.toString());
                    editorEdit.remove(ab.aX.toString());
                }
                if (iA < 9) {
                    editorEdit.remove(ab.z.toString());
                    editorEdit.remove(ab.ad.toString());
                    editorEdit.remove(ab.ae.toString());
                    editorEdit.remove(ab.af.toString());
                    editorEdit.remove(ab.ag.toString());
                }
                if (iA < 10) {
                    editorEdit.remove(ab.br.toString());
                }
                if (iA < 11) {
                    editorEdit.remove(ab.aw.toString());
                }
                if (iA < 12) {
                    editorEdit.remove(ab.aY.toString());
                    editorEdit.remove(ab.aZ.toString());
                }
                if (iA < 13) {
                    editorEdit.remove(ab.bF.toString());
                }
                if (iA < 14) {
                    nn nnVarListIterator = d.listIterator();
                    while (nnVarListIterator.hasNext()) {
                        editorEdit.remove(((ab) nnVarListIterator.next()).toString());
                    }
                }
                if (iA < 15) {
                    editorEdit.remove(ab.bn.toString());
                }
                if (iA < 16) {
                    editorEdit.remove(ab.aE.toString());
                }
                if (iA < 17) {
                    editorEdit.remove(ab.bW.toString());
                    editorEdit.remove(ab.bX.toString());
                    editorEdit.remove(ab.bY.toString());
                    editorEdit.remove(ab.bZ.toString());
                    editorEdit.remove(ab.ca.toString());
                }
                if (iA < 18) {
                    editorEdit.remove(ab.cd.toString());
                }
                editorEdit.apply();
                sharedPreferences.edit().putInt(ab.b.toString(), 18).apply();
            }
            nVar.b.registerOnSharedPreferenceChangeListener(nVar);
            if (dVarB != null) {
                Trace.endSection();
            }
            return nVar;
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private final com.google.android.libraries.navigation.internal.nt.m E(ab abVar, final br brVar) {
        final String str = abVar.co;
        return abVar.a() ? this.g.a(str, new br() { // from class: com.google.android.libraries.navigation.internal.iv.i
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return this.a.b.contains(str) ? an.i(brVar.a()) : com.google.android.libraries.navigation.internal.yx.a.a;
            }
        }) : this.g.a(str, new br() { // from class: com.google.android.libraries.navigation.internal.iv.j
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return com.google.android.libraries.navigation.internal.yx.a.a;
            }
        });
    }

    private static Enum F(Class cls, String str, Enum r3) {
        if (aq.c(str)) {
            return r3;
        }
        try {
            return Enum.valueOf(cls, str);
        } catch (ClassCastException | IllegalArgumentException unused) {
            return r3;
        }
    }

    private final String G(String str, String str2) {
        return C(str, str2);
    }

    private final void H(String str, String str2) {
        D(str, str2);
    }

    @Override // com.google.android.libraries.navigation.internal.iv.f
    public final void A(ab[] abVarArr) {
        g gVar = new g(abVarArr);
        if (new File(com.google.android.libraries.navigation.internal.id.a.c(this.f), "camera".concat(".xml")).exists()) {
            SharedPreferences sharedPreferences = this.f.getSharedPreferences("camera", 0);
            if (!sharedPreferences.getAll().isEmpty()) {
                synchronized (this) {
                    m mVar = new m(sharedPreferences, this.b);
                    final String str = gVar.a;
                    ab[] abVarArr2 = gVar.b;
                    com.google.android.libraries.navigation.internal.yx.aa aaVar = new com.google.android.libraries.navigation.internal.yx.aa(str) { // from class: com.google.android.libraries.navigation.internal.iv.k
                        public final /* synthetic */ String a = "Camera_";

                        @Override // com.google.android.libraries.navigation.internal.yx.aa
                        public final Object ak(Object obj) {
                            int i = n.c;
                            return ((String) obj).substring(this.a.length());
                        }
                    };
                    boolean z = false;
                    for (int i = 0; i < 7; i++) {
                        ab abVar = abVarArr2[i];
                        ar.k(abVar.toString().startsWith(str));
                        String string = abVar.toString();
                        Object objAk = aaVar.ak(string);
                        boolean z2 = true;
                        if (mVar.a.contains((String) objAk)) {
                            if (abVar instanceof p) {
                                mVar.c.putBoolean(string, mVar.a.getBoolean((String) objAk, false));
                            } else if (abVar instanceof t) {
                                mVar.c.putFloat(string, mVar.a.getFloat((String) objAk, 0.0f));
                            } else if (abVar instanceof u) {
                                mVar.c.putInt(string, mVar.a.getInt((String) objAk, 0));
                            } else if (abVar instanceof v) {
                                mVar.c.putLong(string, mVar.a.getLong((String) objAk, 0L));
                            } else if (abVar instanceof x) {
                                mVar.c.putString(string, mVar.a.getString((String) objAk, null));
                            } else {
                                if (!(abVar instanceof z)) {
                                    throw new IllegalArgumentException("Illegal key type.");
                                }
                                mVar.c.putStringSet(string, mVar.a.getStringSet((String) objAk, null));
                            }
                        } else if (mVar.b.contains(string)) {
                            mVar.c.remove(string);
                        } else {
                            z2 = false;
                        }
                        z |= z2;
                    }
                    if (z) {
                        mVar.c.apply();
                    }
                }
            }
            z();
        }
    }

    final String C(String str, String str2) {
        if (ab.b(str)) {
            try {
                return this.b.getString(str, str2);
            } catch (ClassCastException unused) {
            }
        }
        return str2;
    }

    final void D(String str, String str2) {
        if (ab.b(str)) {
            this.b.edit().putString(str, str2).apply();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.iv.f
    public final int a(u uVar, int i) {
        String str = uVar.co;
        if (!ab.b(str)) {
            return i;
        }
        try {
            return this.b.getInt(str, i);
        } catch (ClassCastException unused) {
            return i;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.iv.f
    public final long b(v vVar, long j) {
        String str = vVar.co;
        if (!ab.b(str)) {
            return j;
        }
        try {
            return this.b.getLong(str, j);
        } catch (ClassCastException unused) {
            return j;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.iv.f
    public final SharedPreferences c() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.iv.f
    public final com.google.android.libraries.navigation.internal.nt.m d(final p pVar) {
        return E(pVar, new br() { // from class: com.google.android.libraries.navigation.internal.iv.h
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return Boolean.valueOf(this.a.y(pVar, false));
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.iv.f
    public final com.google.android.libraries.navigation.internal.nt.m e(final r rVar, final Class cls) {
        return E(rVar, new br() { // from class: com.google.android.libraries.navigation.internal.iv.l
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return this.a.g(rVar, cls, null);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [com.google.android.libraries.navigation.internal.ael.cy, java.lang.Object] */
    @Override // com.google.android.libraries.navigation.internal.iv.f
    public final cy f(w wVar, dg dgVar, cy cyVar) {
        String str = wVar.co;
        if (!ab.b(str)) {
            return cyVar;
        }
        byte[] bArrDecode = null;
        String strC = C(str, null);
        if (strC != null) {
            try {
                bArrDecode = Base64.decode(strC, 0);
            } catch (IllegalArgumentException unused) {
            }
        }
        if (bArrDecode == null) {
            return cyVar;
        }
        try {
            return dgVar.g(bArrDecode);
        } catch (cc unused2) {
            return cyVar;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.iv.f
    public final Enum g(r rVar, Class cls, Enum r4) {
        return rVar.a() ? F(cls, G(rVar.co, null), r4) : r4;
    }

    @Override // com.google.android.libraries.navigation.internal.iv.f
    public final String h(cy cyVar) {
        if (cyVar == null) {
            return null;
        }
        return Base64.encodeToString(cyVar.m(), 0);
    }

    @Override // com.google.android.libraries.navigation.internal.iv.f
    public final String i(x xVar, String str) {
        return G(xVar.co, str);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    @Override // com.google.android.libraries.navigation.internal.iv.f
    public final EnumSet j(s sVar, Class cls) {
        fy fyVarO;
        String str = sVar.co;
        if (ab.b(str)) {
            try {
                Set<String> stringSet = this.b.getStringSet(str, null);
                if (stringSet != null) {
                    fyVarO = fy.o(stringSet);
                } else {
                    fyVarO = null;
                }
            } catch (ClassCastException unused) {
            }
        } else {
            fyVarO = null;
        }
        EnumSet enumSetNoneOf = EnumSet.noneOf(cls);
        if (fyVarO != null) {
            Iterator<E> it2 = fyVarO.iterator();
            while (it2.hasNext()) {
                Enum enumF = F(cls, (String) it2.next(), null);
                if (enumF != null) {
                    enumSetNoneOf.add(enumF);
                }
            }
        }
        return enumSetNoneOf;
    }

    @Override // com.google.android.libraries.navigation.internal.iv.f
    public final List k(y yVar, List list) {
        try {
            String string = yVar.a() ? this.b.getString(yVar.co, null) : null;
            if (string == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = bj.b(',').g(string).iterator();
            while (it2.hasNext()) {
                arrayList.add(new String(Base64.decode((String) it2.next(), 0), StandardCharsets.UTF_8));
            }
            if (!arrayList.isEmpty()) {
                arrayList.remove(arrayList.size() - 1);
            }
            return arrayList;
        } catch (ClassCastException | IllegalArgumentException unused) {
            return list;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.iv.f
    @Deprecated
    public final void l(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.b.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.google.android.libraries.navigation.internal.iv.f
    public final void m(ab abVar) {
        String str = abVar.co;
        if (ab.b(str)) {
            SharedPreferences sharedPreferences = this.b;
            if (sharedPreferences.contains(str)) {
                sharedPreferences.edit().remove(str).apply();
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.iv.f
    public final void n(p pVar, boolean z) {
        String str = pVar.co;
        if (ab.b(str)) {
            this.b.edit().putBoolean(str, z).apply();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.iv.f
    public final void o(r rVar, Enum r2) {
        H(rVar.co, r2 == null ? null : r2.name());
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (e.get() && str != null) {
            this.g.b(str);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.iv.f
    public final void p(s sVar, EnumSet enumSet) {
        fy fyVarI;
        String str = sVar.co;
        if (enumSet == null) {
            fyVarI = null;
        } else {
            fw fwVar = new fw();
            Iterator it2 = enumSet.iterator();
            while (it2.hasNext()) {
                fwVar.c(((Enum) it2.next()).name());
            }
            fyVarI = fwVar.i();
        }
        if (ab.b(str)) {
            this.b.edit().putStringSet(str, fyVarI).apply();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.iv.f
    public final void q(u uVar, int i) {
        String str = uVar.co;
        if (ab.b(str)) {
            this.b.edit().putInt(str, i).apply();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.iv.f
    public final void r(v vVar, long j) {
        String str = vVar.co;
        if (ab.b(str)) {
            this.b.edit().putLong(str, j).apply();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.iv.f
    public final void s(w wVar, cy cyVar) {
        D(wVar.co, h(cyVar));
    }

    @Override // com.google.android.libraries.navigation.internal.iv.f
    public final void t(x xVar, String str) {
        H(xVar.co, str);
    }

    @Override // com.google.android.libraries.navigation.internal.iv.f
    public final void u(y yVar, List list) {
        String string;
        if (yVar.a()) {
            if (list != null) {
                StringBuilder sb = new StringBuilder();
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    sb.append(Base64.encodeToString(((String) it2.next()).getBytes(StandardCharsets.UTF_8), 0));
                    sb.append(',');
                }
                string = sb.toString();
            } else {
                string = null;
            }
            this.b.edit().putString(yVar.co, string).apply();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.iv.f
    @Deprecated
    public final void v(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.b.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.google.android.libraries.navigation.internal.iv.f
    public final boolean w(ab abVar) {
        return abVar.a() && this.b.contains(abVar.co);
    }

    @Override // com.google.android.libraries.navigation.internal.iv.f
    public final boolean x() {
        return this.b.edit().commit();
    }

    @Override // com.google.android.libraries.navigation.internal.iv.f
    public final boolean y(p pVar, boolean z) {
        String str = pVar.co;
        try {
            return ab.b(str) ? this.b.getBoolean(str, z) : z;
        } catch (ClassCastException unused) {
            return z;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.iv.f
    public final void z() {
        new File(com.google.android.libraries.navigation.internal.id.a.c(this.f), "camera".concat(".xml"));
        this.f.deleteSharedPreferences("camera");
    }
}
