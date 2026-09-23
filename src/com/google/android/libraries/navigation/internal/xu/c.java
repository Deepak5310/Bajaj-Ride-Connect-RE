package com.google.android.libraries.navigation.internal.xu;

import android.content.Context;
import android.os.Process;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.gs;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    private final Context a;
    private final Set b;

    public c(Context context, Map map) {
        this.a = context;
        this.b = map.keySet();
    }

    public final boolean a() {
        if (a.a == null) {
            a.a = Boolean.valueOf(Process.isApplicationUid(Process.myUid()));
        }
        if (!a.a.booleanValue()) {
            return false;
        }
        String strA = a.a(this.a);
        if (strA == null) {
            return true;
        }
        int size = this.b.size();
        if (size == 0) {
            return strA.equals(this.a.getPackageName());
        }
        if (size != 1) {
            throw new IllegalArgumentException("More than 1 custom main process specified");
        }
        String strA2 = ((b) gs.e(this.b)).a();
        ar.f(strA2.startsWith(":"), "The provided @CustomMainProcess is not an app-private one, i.e. the one staring with colon(':'). @CustomMainProcess value: %s", strA2);
        return strA.equals(String.valueOf(this.a.getPackageName()).concat(String.valueOf(strA2)));
    }
}
