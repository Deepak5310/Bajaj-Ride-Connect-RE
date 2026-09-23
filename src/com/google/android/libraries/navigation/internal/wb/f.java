package com.google.android.libraries.navigation.internal.wb;

import com.google.android.libraries.navigation.internal.yz.kc;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    private static final Map a;
    private e b = null;

    static {
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.ON_CREATE, EnumSet.of(e.ON_START, e.ON_DESTROY));
        enumMap.put(e.ON_START, EnumSet.of(e.ON_RESUME, e.ON_STOP));
        enumMap.put(e.ON_RESUME, EnumSet.of(e.ON_PAUSE));
        enumMap.put(e.ON_PAUSE, EnumSet.of(e.ON_RESUME, e.ON_STOP));
        enumMap.put(e.ON_STOP, EnumSet.of(e.ON_DESTROY, e.ON_START));
        enumMap.put(e.ON_DESTROY, EnumSet.noneOf(e.class));
        a = kc.b(enumMap);
    }

    public final String a(e eVar) {
        e eVar2 = this.b;
        if (eVar2 == null) {
            if (eVar != e.ON_CREATE) {
                return eVar.a() + " is invalid. Expecting " + e.ON_CREATE.a();
            }
        } else {
            if (eVar == eVar2) {
                return String.valueOf(eVar2.a()).concat(" was already called");
            }
            Map map = a;
            if (!map.containsKey(eVar2)) {
                return String.valueOf(this.b.a()).concat(" is an unknown state");
            }
            if (!((Set) map.get(this.b)).contains(eVar)) {
                return eVar.a() + " cannot follow a " + this.b.a();
            }
        }
        this.b = eVar;
        return null;
    }
}
