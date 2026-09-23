package com.google.android.libraries.navigation.internal.tm;

import android.content.ComponentName;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a extends i {
    public final CharSequence a;
    public final ComponentName b;
    private final CharSequence c;
    private final CharSequence d;

    public a(CharSequence charSequence, ComponentName componentName) {
        Objects.requireNonNull(charSequence);
        this.a = charSequence;
        this.c = "";
        this.d = "";
        this.b = componentName;
    }

    @Override // com.google.android.libraries.navigation.internal.tm.i
    public final ComponentName a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.tm.i
    public final CharSequence b() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.tm.i
    public final CharSequence c() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.tm.i
    public final CharSequence d() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        ComponentName componentName;
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (this.a.equals(iVar.d()) && this.c.equals(iVar.c()) && this.d.equals(iVar.b()) && ((componentName = this.b) != null ? componentName.equals(iVar.a()) : iVar.a() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
        ComponentName componentName = this.b;
        return (iHashCode * 1000003) ^ (componentName == null ? 0 : componentName.hashCode());
    }

    public final String toString() {
        ComponentName componentName = this.b;
        return "{" + String.valueOf(this.a) + ", " + ((String) this.c) + ", " + ((String) this.d) + ", " + String.valueOf(componentName) + "}";
    }
}
