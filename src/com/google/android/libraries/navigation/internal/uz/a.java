package com.google.android.libraries.navigation.internal.uz;

import android.content.Context;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.cy;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class a implements com.google.android.libraries.navigation.internal.va.a {
    protected List a;
    private final Context b;
    private CharSequence c;
    private final int d;
    private boolean e = false;
    private cs f;

    public a(Context context, CharSequence charSequence, int i, List<? extends com.google.android.libraries.navigation.internal.va.b> list) {
        this.b = context;
        this.c = charSequence;
        this.d = i;
        this.a = list;
    }

    @Override // com.google.android.libraries.navigation.internal.va.a
    public int a() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.va.a
    public cs.a b() {
        this.e = !this.e;
        g();
        return cs.a.a;
    }

    @Override // com.google.android.libraries.navigation.internal.va.a
    public Boolean c() {
        return Boolean.valueOf(this.e);
    }

    @Override // com.google.android.libraries.navigation.internal.va.a
    public CharSequence d() {
        return this.b.getString(com.google.android.libraries.navigation.internal.bx.g.a, this.c);
    }

    @Override // com.google.android.libraries.navigation.internal.va.a
    public CharSequence e() {
        return this.b.getString(com.google.android.libraries.navigation.internal.bx.g.t, this.c);
    }

    @Override // com.google.android.libraries.navigation.internal.va.a
    public List<? extends com.google.android.libraries.navigation.internal.va.b> f() {
        return this.a;
    }

    protected final void g() {
        cs csVar = this.f;
        if (csVar != null) {
            cy.a(csVar);
        }
    }

    public void h(cs csVar) {
        this.f = csVar;
    }

    @Override // com.google.android.libraries.navigation.internal.va.a
    public void i(CharSequence charSequence, List<? extends com.google.android.libraries.navigation.internal.va.b> list) {
        this.c = charSequence;
        this.a = list;
        g();
    }
}
