package com.google.android.libraries.navigation.internal.ms;

import android.view.View;
import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bn {
    public com.google.android.libraries.navigation.internal.yx.an a;
    public com.google.android.libraries.navigation.internal.yx.an b;
    public com.google.android.libraries.navigation.internal.yx.an c;
    public final Class d;

    public bn(Class cls) {
        this.d = cls;
    }

    public static final View b(Constructor constructor, Object... objArr) {
        try {
            return (View) constructor.newInstance(objArr);
        } catch (ReflectiveOperationException e) {
            throw new com.google.android.libraries.navigation.internal.yx.cb(e);
        }
    }

    public final com.google.android.libraries.navigation.internal.yx.an a(Class[] clsArr) {
        try {
            return com.google.android.libraries.navigation.internal.yx.an.j(this.d.getConstructor(clsArr));
        } catch (NoSuchMethodException unused) {
            return com.google.android.libraries.navigation.internal.yx.a.a;
        }
    }
}
