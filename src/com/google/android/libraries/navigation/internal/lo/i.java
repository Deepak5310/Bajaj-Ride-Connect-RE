package com.google.android.libraries.navigation.internal.lo;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.libraries.navigation.internal.lh.q;
import java.util.LinkedList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class i {
    public m a;
    public Bundle b;
    public LinkedList c;
    private final a d = new a(this);

    public static void l(FrameLayout frameLayout) {
        com.google.android.libraries.navigation.internal.lc.h hVar = com.google.android.libraries.navigation.internal.lc.h.a;
        Context context = frameLayout.getContext();
        int iE = hVar.e(context);
        String strC = q.c(context, iE);
        String strB = q.b(context, iE);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(strC);
        linearLayout.addView(textView);
        Intent intentG = hVar.g(context, iE, null);
        if (intentG != null) {
            Button button = new Button(context);
            button.setId(R.id.button1);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(strB);
            linearLayout.addView(button);
            button.setOnClickListener(new e(context, intentG));
        }
    }

    private final void n(int i) {
        while (!this.c.isEmpty() && ((h) this.c.getLast()).a() >= i) {
            this.c.removeLast();
        }
    }

    private final void o(Bundle bundle, h hVar) {
        if (this.a != null) {
            hVar.b();
            return;
        }
        if (this.c == null) {
            this.c = new LinkedList();
        }
        this.c.add(hVar);
        if (bundle != null) {
            Bundle bundle2 = this.b;
            if (bundle2 == null) {
                this.b = (Bundle) bundle.clone();
            } else {
                bundle2.putAll(bundle);
            }
        }
        m(this.d);
    }

    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        o(bundle, new d(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.a == null) {
            l(frameLayout);
        }
        return frameLayout;
    }

    public final void b(Bundle bundle) {
        o(bundle, new c(this, bundle));
    }

    public final void c() {
        m mVar = this.a;
        if (mVar != null) {
            mVar.c();
        } else {
            n(1);
        }
    }

    public final void d() {
        m mVar = this.a;
        if (mVar != null) {
            mVar.d();
        } else {
            n(2);
        }
    }

    public final void e(Activity activity, Bundle bundle, Bundle bundle2) {
        o(bundle2, new b(this, activity, bundle, bundle2));
    }

    public final void f() {
        m mVar = this.a;
        if (mVar != null) {
            mVar.f();
        }
    }

    public final void g() {
        m mVar = this.a;
        if (mVar != null) {
            mVar.g();
        } else {
            n(5);
        }
    }

    public final void h() {
        o(null, new g(this));
    }

    public final void i(Bundle bundle) {
        m mVar = this.a;
        if (mVar != null) {
            mVar.i(bundle);
            return;
        }
        Bundle bundle2 = this.b;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    public final void j() {
        o(null, new f(this));
    }

    public final void k() {
        m mVar = this.a;
        if (mVar != null) {
            mVar.k();
        } else {
            n(4);
        }
    }

    protected abstract void m(a aVar);
}
