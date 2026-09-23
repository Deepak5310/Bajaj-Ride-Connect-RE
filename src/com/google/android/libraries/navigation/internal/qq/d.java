package com.google.android.libraries.navigation.internal.qq;

import android.opengl.GLES20;
import com.google.android.libraries.geo.mapcore.internal.model.bs;
import com.google.android.libraries.geo.mapcore.internal.model.bt;
import com.google.android.libraries.geo.mapcore.renderer.bv;
import com.google.android.libraries.geo.mapcore.renderer.ea;
import com.google.android.libraries.geo.mapcore.renderer.ek;
import com.google.android.libraries.geo.mapcore.renderer.ey;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends j {
    private final ey[] A;
    private List B;
    private boolean C;
    public com.google.android.libraries.geo.mapcore.internal.vector.gl.p a;
    public List b;
    public int c;
    private final Object y;
    private final Set z;

    public d(com.google.android.libraries.geo.mapcore.renderer.af afVar, com.google.android.libraries.geo.mapcore.renderer.ae aeVar) {
        super(afVar, aeVar);
        this.y = new Object();
        this.z = new HashSet();
        this.A = new ey[8];
        this.B = new ArrayList();
        this.b = new ArrayList();
    }

    private final void q(ey eyVar) {
        if (eyVar == null || this.l == null || this.z.contains(eyVar)) {
            return;
        }
        eyVar.b(this.l);
        this.z.add(eyVar);
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.al
    public final void B(int i, ey eyVar) {
        if (this.s) {
            ea eaVar = ea.INVALID;
            ey eyVar2 = this.A[i];
            if (eyVar2 == eyVar) {
                return;
            }
            if (eyVar2 != null && this.z.contains(eyVar2)) {
                this.z.remove(eyVar2);
                eyVar2.c(false);
            }
            this.z.add(eyVar);
            bv bvVar = this.l;
            ar.q(bvVar);
            eyVar.b(bvVar);
        }
        this.A[i] = eyVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qq.j, com.google.android.libraries.geo.mapcore.renderer.al, com.google.android.libraries.geo.mapcore.renderer.aj
    public final void G(com.google.android.libraries.geo.mapcore.renderer.aj ajVar, com.google.android.libraries.geo.mapcore.renderer.aj ajVar2, com.google.android.libraries.geo.mapcore.renderer.u uVar) {
        if (this.l == null) {
            return;
        }
        GLES20.glEnable(2884);
        bv.O();
        synchronized (this.y) {
            int size = this.b.size();
            this.c = 0;
            while (this.c < size) {
                super.G(ajVar, ajVar2, uVar);
                this.c++;
            }
        }
        GLES20.glDisable(2884);
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.al, com.google.android.libraries.geo.mapcore.renderer.aj
    public final ey c(int i) {
        ek ekVarT;
        bv bvVar;
        ek ekVarH = null;
        if (i >= 0 && i < 8) {
            ey eyVar = this.A[i];
            if (eyVar != null) {
                q(eyVar);
                return eyVar;
            }
            if (!this.b.isEmpty()) {
                com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar = ((c) this.b.get(this.c)).a[i];
                com.google.android.libraries.geo.mapcore.internal.vector.gl.p pVar = this.a;
                if (pVar == null || nVar == null || nVar.c()) {
                    ekVarT = null;
                } else {
                    ar.q(pVar);
                    ekVarT = pVar.t(nVar);
                }
                if (ekVarT != null || (bvVar = this.l) == null) {
                    ekVarH = ekVarT;
                } else if (i == 1 || i == 2) {
                    ekVarH = bvVar.h(com.google.android.libraries.navigation.internal.qr.c.i);
                } else if (i == 3) {
                    ekVarH = bvVar.h(com.google.android.libraries.navigation.internal.qr.c.ac);
                }
                q(ekVarH);
            }
        }
        return ekVarH;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.al, com.google.android.libraries.geo.mapcore.renderer.aj
    public final void d(boolean z) {
        super.d(z);
        Iterator it2 = this.z.iterator();
        while (it2.hasNext()) {
            ((ey) it2.next()).c(z);
        }
        this.z.clear();
    }

    public final void e(float f) {
        int i;
        Iterator it2 = this.B.iterator();
        int iMax = 0;
        while (it2.hasNext()) {
            com.google.android.libraries.geo.mapcore.internal.model.ai aiVarG = ((bt) it2.next()).g((int) f);
            iMax = Math.max(iMax, (this.C ? aiVarG.f58n : aiVarG.o).length);
        }
        ArrayList arrayList = new ArrayList(iMax);
        int size = this.B.size();
        for (int i2 = 0; i2 < iMax && i2 < 4; i2++) {
            c cVar = new c();
            arrayList.add(cVar);
            bs bsVar = null;
            for (int i3 = 0; i3 < size && i3 < 8; i3++) {
                com.google.android.libraries.geo.mapcore.internal.model.ai aiVarG2 = ((bt) this.B.get(i3)).g((int) f);
                bs[] bsVarArr = this.C ? aiVarG2.f58n : aiVarG2.o;
                int length = bsVarArr.length;
                if (length > 0 && i2 < length) {
                    bs bsVar2 = bsVarArr[i2];
                    float[] fArr = cVar.b;
                    float f2 = bsVar2.d;
                    fArr[i3] = f2;
                    if (f2 != 0.0f) {
                        bsVar = bsVar2;
                    }
                }
            }
            if (bsVar != null) {
                int i4 = bsVar.g;
                while (true) {
                    i = bsVar.f;
                    if (i / i4 <= 64) {
                        break;
                    } else {
                        i4 += i4;
                    }
                }
                cVar.d = i4;
                cVar.c = i == 0 ? 1.0f : i;
                com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar = bsVar.j;
                com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar2 = bsVar.k;
                com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar3 = bsVar.i;
                com.google.android.libraries.geo.mapcore.internal.vector.gl.n[] nVarArr = cVar.a;
                nVarArr[1] = nVar;
                nVarArr[2] = nVar2;
                nVarArr[3] = nVar3;
            }
        }
        synchronized (this.y) {
            this.b = arrayList;
        }
    }

    public final void f(List list, boolean z) {
        this.B = list;
        this.C = z;
        if (list.size() != 1) {
            return;
        }
        bt btVar = (bt) list.get(0);
        if (btVar.b() == 1) {
            com.google.android.libraries.geo.mapcore.internal.model.ai aiVarD = btVar.d();
            for (bs bsVar : this.C ? aiVarD.f58n : aiVarD.o) {
                if (bsVar.d != 0.0f && (bsVar.c() || bsVar.i != com.google.android.libraries.geo.mapcore.internal.vector.gl.n.b)) {
                    return;
                }
            }
        }
    }
}
