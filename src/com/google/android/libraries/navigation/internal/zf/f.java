package com.google.android.libraries.navigation.internal.zf;

import com.google.android.libraries.navigation.internal.zd.ag;
import com.google.android.libraries.navigation.internal.zd.ah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ServiceLoader;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class f extends ah {
    private final d a;
    private final com.google.android.libraries.navigation.internal.zg.a b;
    private final e c;
    private final ag d;

    public f() {
        d dVar = (d) p(d.class, "flogger.backend_factory");
        this.a = dVar == null ? g.a : dVar;
        com.google.android.libraries.navigation.internal.zg.a aVar = (com.google.android.libraries.navigation.internal.zg.a) p(com.google.android.libraries.navigation.internal.zg.a.class, "flogger.logging_context");
        this.b = aVar == null ? com.google.android.libraries.navigation.internal.zg.c.a : aVar;
        e eVar = (e) p(e.class, "flogger.clock");
        this.c = eVar == null ? k.a : eVar;
        this.d = j.a;
    }

    @Override // com.google.android.libraries.navigation.internal.zd.ah
    protected final long c() {
        return this.c.a();
    }

    @Override // com.google.android.libraries.navigation.internal.zd.ah
    protected final com.google.android.libraries.navigation.internal.zd.j e(String str) {
        return this.a.a(str);
    }

    @Override // com.google.android.libraries.navigation.internal.zd.ah
    protected final ag h() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.zd.ah
    protected final com.google.android.libraries.navigation.internal.zg.a j() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.zd.ah
    protected final String m() {
        return "Platform: " + getClass().getName() + "\nBackendFactory: " + this.a.toString() + "\nClock: " + this.c.toString() + "\nContextDataProvider: " + String.valueOf(this.b) + "\nLogCallerFinder: Default stack-based caller finder\n";
    }

    private static Object p(Class cls, String str) {
        String property;
        Object objCast;
        try {
            property = System.getProperty(str, null);
        } catch (SecurityException e) {
            com.google.android.libraries.navigation.internal.zj.f.a("cannot read property name %s: %s", str, e);
            property = null;
        }
        if (property == null) {
            objCast = null;
        } else {
            int iIndexOf = property.indexOf(35);
            String strSubstring = iIndexOf == -1 ? property : property.substring(0, iIndexOf);
            String strSubstring2 = iIndexOf == -1 ? "getInstance" : property.substring(iIndexOf + 1);
            String str2 = strSubstring + "#" + strSubstring2 + "()";
            try {
                Class<?> cls2 = Class.forName(strSubstring);
                try {
                    objCast = cls.cast(cls2.getMethod(strSubstring2, null).invoke(null, null));
                } catch (NoSuchMethodException e2) {
                    if (iIndexOf == -1 || !strSubstring2.equals("getInstance")) {
                        com.google.android.libraries.navigation.internal.zj.f.a("method '%s' does not exist: %s\n", property, e2);
                        objCast = null;
                    } else {
                        com.google.android.libraries.navigation.internal.b.b.g(strSubstring, "new ", "()");
                        objCast = cls.cast(cls2.getConstructor(null).newInstance(null));
                    }
                }
            } catch (ClassCastException e3) {
                com.google.android.libraries.navigation.internal.zj.f.a("cannot cast result of calling '%s' to '%s': %s\n", str2, cls.getName(), e3);
            } catch (ClassNotFoundException unused) {
            } catch (Exception e4) {
                com.google.android.libraries.navigation.internal.zj.f.a("cannot call expected no-argument constructor or static method '%s': %s\n", str2, e4);
            }
        }
        if (objCast != null) {
            return objCast;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = ServiceLoader.load(cls).iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next());
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return arrayList.get(0);
        }
        System.err.printf("Multiple implementations of service %s found on the classpath: %s%nEnsure only the service implementation you want to use is included on the classpath or else specify the service class at startup with the '%s' system property. The default implementation will be used instead.%n", cls.getName(), arrayList, str);
        return null;
    }
}
