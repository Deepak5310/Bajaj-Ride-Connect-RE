package com.google.android.libraries.navigation.internal.xy;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.libraries.navigation.internal.yx.bj;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    private final Map a = new HashMap();
    private final Map b = new HashMap();
    private final List c = new ArrayList();

    public f(List list, List list2, List list3) {
        com.google.android.libraries.navigation.internal.yg.a aVar;
        com.google.android.libraries.navigation.internal.yf.a aVar2;
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.yf.a aVar3 = (com.google.android.libraries.navigation.internal.yf.a) it2.next();
            if (!TextUtils.isEmpty(aVar3.e()) && (aVar2 = (com.google.android.libraries.navigation.internal.yf.a) this.a.put(aVar3.e(), aVar3)) != null) {
                throw new IllegalArgumentException("Cannot override Backend " + aVar2.getClass().getCanonicalName() + " with " + aVar3.getClass().getCanonicalName());
            }
        }
        Iterator it3 = list2.iterator();
        while (it3.hasNext()) {
            com.google.android.libraries.navigation.internal.yg.a aVar4 = (com.google.android.libraries.navigation.internal.yg.a) it3.next();
            if (!TextUtils.isEmpty(com.google.android.libraries.navigation.internal.yg.a.b()) && (aVar = (com.google.android.libraries.navigation.internal.yg.a) this.b.put(com.google.android.libraries.navigation.internal.yg.a.b(), aVar4)) != null) {
                throw new IllegalArgumentException("Cannot to override Transform " + aVar.getClass().getCanonicalName() + " with " + aVar4.getClass().getCanonicalName());
            }
        }
        this.c.addAll(list3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final d a(Uri uri) throws IOException {
        int i = ev.d;
        eq eqVar = new eq();
        eq eqVar2 = new eq();
        String encodedFragment = uri.getEncodedFragment();
        ev evVarN = (TextUtils.isEmpty(encodedFragment) || !encodedFragment.startsWith("transform=")) ? lv.a : ev.n(bj.d("+").a().g(encodedFragment.substring(10)));
        int size = evVarN.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str = (String) evVarN.get(i2);
            Matcher matcher = com.google.android.libraries.navigation.internal.yc.e.a.matcher(str);
            if (!matcher.matches()) {
                throw new IllegalArgumentException("Invalid fragment spec: ".concat(String.valueOf(str)));
            }
            eqVar2.h(matcher.group(1));
        }
        ev evVarG = eqVar2.g();
        int i3 = ((lv) evVarG).c;
        for (int i4 = 0; i4 < i3; i4++) {
            String str2 = (String) evVarG.get(i4);
            com.google.android.libraries.navigation.internal.yg.a aVar = (com.google.android.libraries.navigation.internal.yg.a) this.b.get(str2);
            if (aVar == null) {
                throw new com.google.android.libraries.navigation.internal.yb.f("Requested transform isn't registered: " + str2 + ": " + String.valueOf(uri));
            }
            eqVar.h(aVar);
        }
        ev evVarH = eqVar.g().h();
        c cVar = new c();
        cVar.a = this;
        String scheme = uri.getScheme();
        com.google.android.libraries.navigation.internal.yf.a aVar2 = (com.google.android.libraries.navigation.internal.yf.a) this.a.get(scheme);
        if (aVar2 == null) {
            throw new com.google.android.libraries.navigation.internal.yb.f(String.format("Requested backend isn't registered: %s", scheme));
        }
        cVar.b = aVar2;
        cVar.d = this.c;
        cVar.c = evVarH;
        cVar.e = uri;
        if (!evVarH.isEmpty()) {
            ArrayList arrayList = new ArrayList(uri.getPathSegments());
            if (!arrayList.isEmpty() && !uri.getPath().endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                String strA = (String) arrayList.get(arrayList.size() - 1);
                ListIterator<E> listIterator = evVarH.listIterator(evVarH.size());
                while (listIterator.hasPrevious()) {
                    strA = com.google.android.libraries.navigation.internal.yg.a.a(strA);
                }
                arrayList.set(arrayList.size() - 1, strA);
                uri = uri.buildUpon().path(TextUtils.join(RemoteSettings.FORWARD_SLASH_STRING, arrayList)).encodedFragment(null).build();
            }
        }
        cVar.f = uri;
        return new d(cVar);
    }

    public final Object b(Uri uri, e eVar) throws IOException {
        return eVar.a(a(uri));
    }

    public final void c(Uri uri, Uri uri2) throws IOException {
        d dVarA = a(uri);
        com.google.android.libraries.navigation.internal.yf.a aVar = dVarA.a;
        d dVarA2 = a(uri2);
        if (aVar != dVarA2.a) {
            throw new com.google.android.libraries.navigation.internal.yb.f("Cannot rename file across backends");
        }
        dVarA.a.g(dVarA.e, dVarA2.e);
    }

    public final boolean d(Uri uri) throws IOException {
        d dVarA = a(uri);
        return dVarA.a.f(dVarA.e);
    }
}
