package com.google.android.libraries.navigation.internal.cj;

import android.app.Application;
import android.content.Context;
import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import com.google.android.libraries.navigation.internal.yx.aa;
import com.google.android.libraries.navigation.internal.zb.an;
import com.google.android.libraries.navigation.internal.zb.h;
import com.google.android.libraries.navigation.internal.zb.j;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    private static final WeakHashMap a = new WeakHashMap();

    public static com.google.android.libraries.navigation.internal.ci.a a(Context context) {
        WeakHashMap weakHashMap = a;
        WeakReference weakReference = (WeakReference) weakHashMap.get(context);
        com.google.android.libraries.navigation.internal.ci.a aVar = null;
        com.google.android.libraries.navigation.internal.ci.a aVar2 = weakReference != null ? (com.google.android.libraries.navigation.internal.ci.a) weakReference.get() : null;
        if (aVar2 == null) {
            if (context instanceof Application) {
                ((h) ((h) j.b.h(an.MEDIUM)).F(PanasonicMakernoteDirectory.TAG_LANDMARK)).p("DarkModeIndicator queried from the Application context instead of activity");
            } else {
                aVar = (com.google.android.libraries.navigation.internal.ci.a) com.google.android.libraries.navigation.internal.ii.a.a(c.class, context).b(new aa() { // from class: com.google.android.libraries.navigation.internal.cj.a
                    @Override // com.google.android.libraries.navigation.internal.yx.aa
                    public final Object ak(Object obj) {
                        return ((c) obj).a();
                    }
                }).f();
            }
            if (aVar != null) {
                weakHashMap.put(context, new WeakReference(aVar));
            }
            aVar2 = aVar;
        }
        return aVar2 != null ? aVar2 : ((d) com.google.android.libraries.navigation.internal.ii.b.a(d.class)).ca();
    }
}
