package com.google.android.libraries.navigation.internal.po;

import android.content.Context;
import android.view.Choreographer;
import androidx.tracing.Trace;
import com.adobe.internal.xmp.options.PropertyOptions;
import com.google.android.libraries.geo.mapcore.renderer.GLSurfaceView;
import com.google.android.libraries.geo.mapcore.renderer.GLTextureView;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fy implements com.google.android.libraries.navigation.internal.yx.br {
    final /* synthetic */ gm a;

    public fy(gm gmVar) {
        this.a = gmVar;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0057  */
    /* JADX WARN: Code duplicated, block: B:18:0x005a  */
    /* JADX WARN: Code duplicated, block: B:19:0x005c  */
    /* JADX WARN: Code duplicated, block: B:25:0x006a A[Catch: all -> 0x00cd, TryCatch #4 {all -> 0x00cd, blocks: (B:20:0x005d, B:24:0x0064, B:26:0x0072, B:25:0x006a), top: B:55:0x005d }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0077 A[Catch: all -> 0x00da, TRY_ENTER, TryCatch #3 {all -> 0x00da, blocks: (B:3:0x0008, B:28:0x0077, B:29:0x007a, B:40:0x00d9, B:39:0x00d6, B:36:0x00d1), top: B:54:0x0008, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x00c9  */
    @Override // com.google.android.libraries.navigation.internal.yx.br
    public final /* bridge */ /* synthetic */ Object a() {
        boolean z;
        boolean z2;
        Throwable th;
        boolean z3;
        com.google.android.libraries.geo.mapcore.renderer.bg gLTextureView;
        gm gmVar = this.a;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("PhoenixGoogleMapActivityEnvironment.createGLView");
        try {
            com.google.android.libraries.navigation.internal.qq.al alVar = (com.google.android.libraries.navigation.internal.qq.al) gmVar.k.a();
            alVar.p = gmVar.l.d();
            gj gjVar = new gj(alVar);
            Context context = gmVar.e;
            gmVar.l.c();
            com.google.android.libraries.navigation.internal.ob.n.h().booleanValue();
            boolean zE = gmVar.l.e();
            String strD = gmVar.l.d();
            com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("GLViewFactory.createGLView");
            if (zE) {
                z = true;
                if (dVarB2 != null) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                try {
                    if (com.google.android.libraries.navigation.internal.rq.d.b && z) {
                        gLTextureView = new GLTextureView(context, gjVar, strD);
                    } else {
                        GLSurfaceView gLSurfaceView = new GLSurfaceView(context, gjVar, strD);
                        gLSurfaceView.setZOrderOnTop(false);
                        gLTextureView = gLSurfaceView;
                    }
                    gLTextureView.setTransparent(true);
                    if (dVarB2 != null) {
                        Trace.endSection();
                    }
                    gLTextureView.setRenderer(alVar);
                    gLTextureView.a().setFocusable(true);
                    gLTextureView.a().setImportantForAccessibility(2);
                    com.google.android.libraries.navigation.internal.ox.a aVar = new com.google.android.libraries.navigation.internal.ox.a(alVar.d, alVar.q, gmVar.d(), new gk(gmVar), ((Integer) alVar.m.a()).intValue(), alVar.k, alVar.l, Choreographer.getInstance());
                    alVar.o = new com.google.android.libraries.navigation.internal.pk.c(aVar, alVar.l, alVar.c, alVar.p);
                    alVar.e = gLTextureView;
                    alVar.i = aVar;
                    aVar.f();
                    if (dVarB != null) {
                        Trace.endSection();
                    }
                    return gLTextureView;
                } catch (Throwable th2) {
                    th = th2;
                    z2 = z3;
                }
            } else {
                z2 = dVarB2 == null;
                try {
                    if ((context.getApplicationInfo().flags & PropertyOptions.DELETE_EXISTING) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (dVarB2 != null) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (com.google.android.libraries.navigation.internal.rq.d.b) {
                        GLSurfaceView gLSurfaceView2 = new GLSurfaceView(context, gjVar, strD);
                        gLSurfaceView2.setZOrderOnTop(false);
                        gLTextureView = gLSurfaceView2;
                    } else {
                        GLSurfaceView gLSurfaceView3 = new GLSurfaceView(context, gjVar, strD);
                        gLSurfaceView3.setZOrderOnTop(false);
                        gLTextureView = gLSurfaceView3;
                    }
                    gLTextureView.setTransparent(true);
                    if (dVarB2 != null) {
                        Trace.endSection();
                    }
                    gLTextureView.setRenderer(alVar);
                    gLTextureView.a().setFocusable(true);
                    gLTextureView.a().setImportantForAccessibility(2);
                    com.google.android.libraries.navigation.internal.ox.a aVar2 = new com.google.android.libraries.navigation.internal.ox.a(alVar.d, alVar.q, gmVar.d(), new gk(gmVar), ((Integer) alVar.m.a()).intValue(), alVar.k, alVar.l, Choreographer.getInstance());
                    alVar.o = new com.google.android.libraries.navigation.internal.pk.c(aVar2, alVar.l, alVar.c, alVar.p);
                    alVar.e = gLTextureView;
                    alVar.i = aVar2;
                    aVar2.f();
                    if (dVarB != null) {
                        Trace.endSection();
                    }
                    return gLTextureView;
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            if (true != z2) {
                try {
                    Trace.endSection();
                } catch (Throwable th4) {
                    th.addSuppressed(th4);
                }
            }
            throw th;
        } catch (Throwable th5) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th6) {
                    th5.addSuppressed(th6);
                }
            }
            throw th5;
        }
    }
}
