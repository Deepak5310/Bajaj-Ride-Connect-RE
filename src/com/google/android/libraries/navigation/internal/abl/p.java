package com.google.android.libraries.navigation.internal.abl;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.RemoteException;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.libraries.navigation.internal.abh.es;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p extends GestureDetector.SimpleOnGestureListener implements com.google.android.libraries.navigation.internal.abi.h {
    private final l a;
    private final s b;
    private final o c;

    public p(l lVar, s sVar, o oVar) {
        this.a = lVar;
        this.b = sVar;
        this.c = oVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abi.h
    public final void a() {
    }

    @Override // com.google.android.libraries.navigation.internal.abi.h
    public final void b() {
    }

    @Override // com.google.android.libraries.navigation.internal.abi.h
    public final boolean c(com.google.android.libraries.navigation.internal.abi.l lVar) {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.abi.h
    public final boolean d() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.abi.h
    public final boolean e() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.abi.h
    public final void f() {
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
        s sVar = this.b;
        if (sVar.q(motionEvent.getX(), motionEvent.getY())) {
            es esVar = sVar.e;
            esVar.b.h(esVar);
            return;
        }
        l lVar = this.a;
        aa aaVar = lVar.d;
        if (aaVar == null || lVar.f == null) {
            return;
        }
        try {
            lVar.f.a(aaVar.b(new Point((int) motionEvent.getX(), (int) motionEvent.getY())));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        s sVar = this.b;
        if (sVar.q(motionEvent.getX(), motionEvent.getY())) {
            es esVar = sVar.e;
            esVar.b.f(esVar);
            return true;
        }
        sVar.k();
        o oVar = this.c;
        if (oVar.b && oVar.d != null && oVar.g != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            Point point = oVar.h;
            if (point != null && Math.pow(x - point.x, 2.0d) + Math.pow(y - oVar.h.y, 2.0d) < Math.pow(oVar.i + 10.0f, 2.0d) && oVar.g.i()) {
                return true;
            }
        }
        s sVar2 = this.b;
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        es esVarA = sVar2.d.a(sVar2.b, x2, y2);
        if (esVarA != null && esVarA.F()) {
            Rect rectP = esVarA.P();
            Rect rect = new Rect(rectP.left - 10, rectP.top - 10, rectP.right + 10, rectP.bottom + 10);
            if (x2 >= rect.left && x2 <= rect.right && y2 >= rect.top && y2 <= rect.bottom) {
                esVarA.b.q(esVarA);
                return true;
            }
        }
        if (sVar2.o(x2, y2)) {
            return true;
        }
        return this.a.V(motionEvent);
    }
}
