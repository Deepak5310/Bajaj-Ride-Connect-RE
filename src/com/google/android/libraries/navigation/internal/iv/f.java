package com.google.android.libraries.navigation.internal.iv;

import android.content.SharedPreferences;
import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.ael.dg;
import java.util.EnumSet;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public interface f {
    public static final String a = "com.google.android.libraries.navigation.PREFERENCES_FILE";

    void A(ab[] abVarArr);

    int a(u uVar, int i);

    long b(v vVar, long j);

    SharedPreferences c();

    com.google.android.libraries.navigation.internal.nt.m d(p pVar);

    com.google.android.libraries.navigation.internal.nt.m e(r rVar, Class cls);

    cy f(w wVar, dg dgVar, cy cyVar);

    Enum g(r rVar, Class cls, Enum r3);

    String h(cy cyVar);

    String i(x xVar, String str);

    EnumSet j(s sVar, Class cls);

    List k(y yVar, List list);

    @Deprecated
    void l(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener);

    void m(ab abVar);

    void n(p pVar, boolean z);

    void o(r rVar, Enum r2);

    void p(s sVar, EnumSet enumSet);

    void q(u uVar, int i);

    void r(v vVar, long j);

    void s(w wVar, cy cyVar);

    void t(x xVar, String str);

    void u(y yVar, List list);

    @Deprecated
    void v(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener);

    boolean w(ab abVar);

    boolean x();

    boolean y(p pVar, boolean z);

    void z();
}
