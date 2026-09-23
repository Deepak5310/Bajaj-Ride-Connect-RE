package com.google.android.libraries.navigation;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.google.android.libraries.navigation.internal.xe.du;
import com.google.android.libraries.navigation.internal.xe.ej;
import com.google.android.libraries.navigation.internal.xe.ek;
import com.google.android.libraries.navigation.internal.xe.fi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class DirectionsListView extends RelativeLayout {
    public fi a;
    public final du b;
    public boolean c;
    public boolean d;
    public boolean e;
    public final com.google.android.libraries.navigation.internal.uh.n f;
    private ej g;

    public DirectionsListView(Context context) {
        this(context, null);
    }

    public final void a() {
        this.a.g();
    }

    public final void b() {
        this.b.k();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            if (this.a != null) {
                this.b.ay(configuration);
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void onCreate(Bundle bundle) {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            if (this.c) {
                com.google.android.libraries.navigation.internal.gz.f.b("Error: DirectionsListView.onCreate() was called twice!");
                return;
            }
            this.c = true;
            this.g = new e(this, bundle);
            ek.a().d(this.g);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void onDestroy() {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            ek.a().e(this.g);
            if (this.a != null) {
                removeAllViews();
                this.b.aC();
            }
            this.c = false;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void onPause() {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            fi fiVar = this.a;
            if (fiVar != null) {
                fiVar.f();
            }
            this.e = false;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void onResume() {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            if (this.e) {
                com.google.android.libraries.navigation.internal.gz.f.b("Error: DirectionsListView.onResume() was called twice without any calls to onPause()!");
                return;
            }
            if (this.a != null) {
                a();
            }
            this.e = true;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            du duVar = this.b;
            if (duVar != null) {
                duVar.j(bundle);
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void onStart() {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            if (this.d) {
                com.google.android.libraries.navigation.internal.gz.f.b("Error: DirectionsListView.onStart() was called twice without any calls to onStop()!");
                return;
            }
            if (this.a != null) {
                b();
            }
            this.d = true;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void onStop() {
        try {
            com.google.android.libraries.navigation.internal.abf.z.a.a();
            if (this.a != null) {
                this.b.l();
            }
            this.d = false;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public DirectionsListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DirectionsListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new du();
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = new f(this);
    }
}
