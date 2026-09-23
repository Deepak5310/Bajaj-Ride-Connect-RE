package com.google.android.libraries.navigation.internal.lp;

import android.content.Context;
import com.google.android.libraries.navigation.internal.lh.az;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e implements k {
    @Override // com.google.android.libraries.navigation.internal.lp.k
    public final int a(Context context) {
        Boolean bool = n.a;
        int i = 0;
        try {
            Class<?> clsLoadClass = context.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors.com.google.android.gms.googlecertificates.ModuleDescriptor");
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (az.a(declaredField.get(null), "com.google.android.gms.googlecertificates")) {
                i = declaredField2.getInt(null);
            } else {
                declaredField.get(null);
            }
        } catch (ClassNotFoundException unused) {
        } catch (Exception e) {
            e.getMessage();
        }
        return i;
    }

    @Override // com.google.android.libraries.navigation.internal.lp.k
    public final int b(Context context, boolean z) throws j {
        return n.c(context, z);
    }
}
