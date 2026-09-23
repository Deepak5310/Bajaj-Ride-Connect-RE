package com.google.android.libraries.navigation.internal.abm;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class g extends ContextWrapper {
    private final com.google.android.libraries.navigation.internal.abh.be a;
    private final ClassLoader b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(com.google.android.libraries.navigation.internal.abh.be beVar) {
        super(beVar.a);
        ClassLoader classLoader = g.class.getClassLoader();
        com.google.android.libraries.navigation.internal.abf.s.k(beVar, "contextManager");
        this.a = beVar;
        com.google.android.libraries.navigation.internal.abf.s.k(classLoader, "classLoader");
        this.b = classLoader;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return this;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return this.b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return this.a.j();
    }
}
