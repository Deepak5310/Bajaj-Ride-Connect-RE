package com.mappls.sdk.navigation.apis;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements c {
    private Context a;

    final class a implements c.a {
        final /* synthetic */ SharedPreferences.Editor a;

        a(SharedPreferences.Editor editor) {
            this.a = editor;
        }

        @Override // com.mappls.sdk.navigation.apis.c.a
        public final c.a a(int i, String str) {
            this.a.putInt(str, i);
            return this;
        }

        @Override // com.mappls.sdk.navigation.apis.c.a
        public final boolean commit() {
            return this.a.commit();
        }

        @Override // com.mappls.sdk.navigation.apis.c.a
        public final c.a putBoolean(String str, boolean z) {
            this.a.putBoolean(str, z);
            return this;
        }

        @Override // com.mappls.sdk.navigation.apis.c.a
        public final c.a putFloat(String str, float f) {
            this.a.putFloat(str, f);
            return this;
        }

        @Override // com.mappls.sdk.navigation.apis.c.a
        public final c.a putLong(String str, long j) {
            this.a.putLong(str, j);
            return this;
        }

        @Override // com.mappls.sdk.navigation.apis.c.a
        public final c.a putString(String str, String str2) {
            this.a.putString(str, str2);
            return this;
        }

        @Override // com.mappls.sdk.navigation.apis.c.a
        public final c.a remove(String str) {
            this.a.remove(str);
            return this;
        }
    }

    public d(Context context) {
        this.a = context;
    }

    public final float a(SharedPreferences sharedPreferences, String str) {
        return sharedPreferences.getFloat(str, 0.0f);
    }

    public final SharedPreferences a(String str) {
        return this.a.getSharedPreferences(str, 0);
    }

    public final c.a a(Object obj) {
        return new a(((SharedPreferences) obj).edit());
    }
}
