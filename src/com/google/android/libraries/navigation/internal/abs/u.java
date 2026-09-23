package com.google.android.libraries.navigation.internal.abs;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Typeface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextPaint;
import androidx.core.view.ViewCompat;
import com.google.android.libraries.navigation.internal.abf.af;
import com.google.android.libraries.navigation.internal.abf.ah;
import com.google.android.libraries.navigation.internal.abf.z;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class u implements q {
    public static final String a = "u";
    private static final ThreadLocal j;
    private static final int[][] k;
    private static final float[][] l;
    private static final float[][] m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final y f151n;
    private static final ev o;
    public final com.google.android.libraries.navigation.internal.abw.h b;
    public final z c;
    public boolean d;
    boolean e;
    public com.google.android.libraries.navigation.internal.abt.c f;
    final Map g;
    public boolean h;
    public com.google.android.libraries.navigation.internal.abt.c i;
    private final double p;
    private final CharSequence[] q;
    private final y r;
    private final e s;
    private final b t;
    private final t u;
    private int v;
    private int w;
    private g x;
    private com.google.android.libraries.navigation.internal.abt.i y;
    private final List z;

    static {
        ExecutorService executorService = ah.a;
        j = new af();
        k = new int[][]{new int[]{0, 0}, new int[]{1, 0}, new int[]{0, 1}, new int[]{1, 1}};
        l = new float[][]{new float[]{0.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{0.0f, 1.0f}, new float[]{1.0f, 1.0f}};
        m = new float[][]{new float[]{0.0f, 1.0f, 0.0f, 1.0f}, new float[]{2.0f, 1.0f, 0.0f, 1.0f}, new float[]{0.0f, -1.0f, 0.0f, 1.0f}, new float[]{2.0f, -1.0f, 0.0f, 1.0f}};
        f151n = new y(Bitmap.Config.ARGB_8888);
        int i = ev.d;
        o = lv.a;
    }

    public u(double d, com.google.android.libraries.navigation.internal.abw.h hVar, CharSequence[] charSequenceArr) {
        z zVar = z.a;
        y yVar = f151n;
        e eVar = e.a;
        b bVar = b.a;
        t tVar = t.a;
        com.google.android.libraries.navigation.internal.abf.s.h(d, "displayDensityRatio");
        this.p = d;
        com.google.android.libraries.navigation.internal.abf.s.k(hVar, "frameRequestor");
        this.b = hVar;
        com.google.android.libraries.navigation.internal.abf.s.k(charSequenceArr, "compassDirectionSuffixes");
        this.q = charSequenceArr;
        int length = charSequenceArr.length;
        com.google.android.libraries.navigation.internal.abf.s.a(length == 8, String.format("compassDirectionSuffixes#%s != 8", Integer.valueOf(length)));
        com.google.android.libraries.navigation.internal.abf.s.k(zVar, "uiThreadChecker");
        this.c = zVar;
        com.google.android.libraries.navigation.internal.abf.s.k(yVar, "textRenderer");
        this.r = yVar;
        com.google.android.libraries.navigation.internal.abf.s.k(eVar, "glUtils2");
        this.s = eVar;
        this.t = bVar;
        this.u = tVar;
        synchronized (this) {
            this.d = false;
            this.e = false;
            this.v = 0;
            this.w = 0;
            this.x = null;
            this.f = com.google.android.libraries.navigation.internal.abt.c.a;
            this.g = new HashMap();
            this.h = true;
            this.i = com.google.android.libraries.navigation.internal.abt.c.a;
            this.y = null;
            this.z = new ArrayList(11);
        }
    }

    public final void a() {
        this.c.b();
        if (this.g.isEmpty()) {
            return;
        }
        int size = this.g.size();
        int[] iArr = new int[size];
        Iterator it2 = this.g.values().iterator();
        int i = 0;
        while (it2.hasNext()) {
            iArr[i] = ((s) it2.next()).a;
            i++;
        }
        Arrays.sort(iArr);
        this.t.d(size, iArr);
        this.g.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(com.google.android.libraries.navigation.internal.abt.i iVar) {
        boolean z;
        com.google.android.libraries.navigation.internal.abt.c cVar;
        boolean z2;
        ev evVar;
        boolean zA;
        int i;
        ev evVar2;
        boolean z3;
        int i2;
        boolean z4;
        List list;
        int i3;
        s sVar;
        this.c.b();
        com.google.android.libraries.navigation.internal.abf.s.k(iVar, "rendererRaycaster");
        if (this.d || !this.e) {
            com.google.android.libraries.navigation.internal.abf.p.f(a, 6);
            return;
        }
        synchronized (this) {
            z = this.h;
            cVar = this.i;
            z2 = true;
            if (cVar.i()) {
                evVar = o;
            } else {
                com.google.android.libraries.navigation.internal.abt.c cVar2 = this.i;
                com.google.android.libraries.navigation.internal.abf.s.d(!cVar2.i(), "NULL_TARGET");
                evVar = cVar2.f152n;
            }
            zA = com.google.android.libraries.navigation.internal.abf.r.a(this.y, iVar);
        }
        String str = a;
        if (com.google.android.libraries.navigation.internal.abf.p.f(str, 2)) {
            String str2 = this.f.b;
            String str3 = cVar.b;
        }
        if (!com.google.android.libraries.navigation.internal.abf.r.a(cVar, this.f)) {
            a();
        }
        this.f = cVar;
        if (!z || cVar.i() || cVar.h() || evVar.isEmpty()) {
            return;
        }
        this.s.j(String.format("%s.onDrawFrameStart()", str));
        GLES20.glDisable(2929);
        this.t.e();
        GLES20.glDisable(2884);
        GLES20.glUseProgram(this.w);
        this.x.c(this.w);
        int iMin = Math.min(((lv) evVar).c, 10);
        List list2 = (List) j.get();
        list2.clear();
        int i4 = 0;
        while (i4 < iMin) {
            com.google.android.libraries.navigation.internal.abt.j jVar = (com.google.android.libraries.navigation.internal.abt.j) evVar.get(i4);
            if (com.google.android.libraries.navigation.internal.abf.x.a(jVar.a)) {
                i = iMin;
                evVar2 = evVar;
                z3 = zA;
                i2 = i4;
                z4 = z2;
            } else {
                e eVar = this.s;
                String str4 = a;
                eVar.j(String.format("%s.beforeDrawLabel(%s)", str4, jVar));
                try {
                    if (this.g.containsKey(jVar)) {
                        sVar = (s) this.g.get(jVar);
                        i = iMin;
                        evVar2 = evVar;
                        z3 = zA;
                        list = list2;
                        i2 = i4;
                        z4 = z2;
                    } else {
                        if (com.google.android.libraries.navigation.internal.abf.p.f(str4, 3)) {
                            String str5 = cVar.b;
                        }
                        String str6 = String.format("%s (%s)", jVar.a, this.q[com.google.android.libraries.navigation.internal.abw.k.n(jVar.b)]);
                        y yVar = this.r;
                        float f = (float) this.p;
                        int i5 = this.v;
                        com.google.android.libraries.navigation.internal.abf.s.k(str6, "textStr");
                        com.google.android.libraries.navigation.internal.abf.s.i(f, "displayDensityRatio == NaN");
                        try {
                            com.google.android.libraries.navigation.internal.abf.s.b(f > 0.0f ? z2 : false, "illegal displayDensityRatio: %s", Float.valueOf(f));
                            com.google.android.libraries.navigation.internal.abf.s.b(i5 > 0, "illegal maxSize: %s", Integer.valueOf(i5));
                            String[] strArrSplit = str6.split("\\s*\\n+\\s*");
                            TextPaint textPaint = new TextPaint(65);
                            textPaint.setTextAlign(Paint.Align.LEFT);
                            i = iMin;
                            try {
                                textPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
                                textPaint.setTypeface(Typeface.DEFAULT);
                                textPaint.setTextSize(50.0f * f);
                                textPaint.setStrokeWidth(f * 1.5f);
                                int length = strArrSplit.length;
                                int i6 = 0;
                                float fMax = 1.0f;
                                while (i6 < length) {
                                    evVar2 = evVar;
                                    try {
                                        fMax = Math.max(fMax, textPaint.measureText(strArrSplit[i6]));
                                        i6++;
                                        evVar = evVar2;
                                    } catch (Error | RuntimeException unused) {
                                        z3 = zA;
                                        i2 = i4;
                                        z4 = true;
                                        com.google.android.libraries.navigation.internal.abf.p.f(a, 6);
                                        this.s.j(String.format("%s.afterDrawLabel(%s)", a, jVar));
                                        i4 = i2 + 1;
                                        z2 = z4;
                                        zA = z3;
                                        iMin = i;
                                        evVar = evVar2;
                                    }
                                }
                                evVar2 = evVar;
                                int i7 = i4;
                                try {
                                    int iCeil = (int) Math.ceil(fMax);
                                    z3 = zA;
                                    list = list2;
                                    try {
                                        int iCeil2 = (int) Math.ceil(1.5d);
                                        int i8 = iCeil + iCeil2 + iCeil2;
                                        int iCeil3 = ((int) Math.ceil(textPaint.descent())) + ((int) Math.ceil(Math.abs(textPaint.ascent())));
                                        int iCeil4 = (int) Math.ceil(1.5d);
                                        int i9 = iCeil3 + iCeil4 + iCeil4;
                                        int length2 = strArrSplit.length * i9;
                                        com.google.android.libraries.navigation.internal.abf.p.f(y.a, 4);
                                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i8, length2, yVar.b);
                                        Canvas canvas = new Canvas(bitmapCreateBitmap);
                                        canvas.drawColor(0);
                                        int i10 = 0;
                                        while (i10 < strArrSplit.length) {
                                            float fAbs = (i10 * i9) + 1.5f + Math.abs(textPaint.ascent());
                                            int i11 = i9;
                                            textPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
                                            textPaint.setStyle(Paint.Style.STROKE);
                                            i2 = i7;
                                            try {
                                                canvas.drawText(strArrSplit[i10], 1.5f, fAbs, textPaint);
                                                textPaint.setColor(-1);
                                                textPaint.setStyle(Paint.Style.FILL);
                                                canvas.drawText(strArrSplit[i10], 1.5f, fAbs, textPaint);
                                                i10++;
                                                i9 = i11;
                                                i7 = i2;
                                            } catch (Error | RuntimeException unused2) {
                                                list2 = list;
                                                z4 = true;
                                                com.google.android.libraries.navigation.internal.abf.p.f(a, 6);
                                                this.s.j(String.format("%s.afterDrawLabel(%s)", a, jVar));
                                                i4 = i2 + 1;
                                                z2 = z4;
                                                zA = z3;
                                                iMin = i;
                                                evVar = evVar2;
                                            }
                                        }
                                        i2 = i7;
                                        canvas.setBitmap(null);
                                        if (i8 > i5 || length2 > i5) {
                                            int iCeil5 = (int) Math.ceil(Math.max(i8, length2) / i5);
                                            try {
                                                bitmapCreateBitmap = Bitmap.createScaledBitmap(bitmapCreateBitmap, Math.max(i8 / iCeil5, 1), Math.max(length2 / iCeil5, 1), true);
                                            } catch (Error | RuntimeException unused3) {
                                                z4 = true;
                                                list2 = list;
                                                com.google.android.libraries.navigation.internal.abf.p.f(a, 6);
                                                this.s.j(String.format("%s.afterDrawLabel(%s)", a, jVar));
                                                i4 = i2 + 1;
                                                z2 = z4;
                                                zA = z3;
                                                iMin = i;
                                                evVar = evVar2;
                                            }
                                        }
                                        float height = bitmapCreateBitmap.getHeight() / 100.0f;
                                        float width = bitmapCreateBitmap.getWidth() / 100.0f;
                                        e eVar2 = this.s;
                                        com.google.android.libraries.navigation.internal.abf.s.k(bitmapCreateBitmap, "bitmap");
                                        int[] iArr = (int[]) e.c.get();
                                        iArr[0] = 0;
                                        z4 = true;
                                        eVar2.d.g(1, iArr);
                                        int i12 = iArr[0];
                                        if (i12 == 0) {
                                            i3 = 0;
                                        } else {
                                            eVar2.i(i12, bitmapCreateBitmap);
                                            i3 = iArr[0];
                                        }
                                        if (i3 == 0) {
                                            list2 = list;
                                            throw new IllegalStateException(String.format("Unable to acquire glTextureHandle for %s/%s", jVar, str6));
                                        }
                                        float[] fArr = (float[]) cVar.f().e.clone();
                                        Matrix.rotateM(fArr, 0, -jVar.b, 0.0f, 1.0f, 0.0f);
                                        Matrix.translateM(fArr, 0, 0.0f, -5.0f, -5.0f);
                                        Matrix.scaleM(fArr, 0, height, 1.0f, width);
                                        Matrix.rotateM(fArr, 0, 90.0f, 0.0f, 1.0f, 0.0f);
                                        Matrix.rotateM(fArr, 0, -90.0f, 1.0f, 0.0f, 0.0f);
                                        s sVar2 = new s(jVar, str6, i3, fArr);
                                        this.g.put(jVar, sVar2);
                                        if (z3) {
                                            Matrix.multiplyMM(sVar2.c, 0, iVar.g(), 0, sVar2.b, 0);
                                        }
                                        sVar = sVar2;
                                    } catch (Error | RuntimeException unused4) {
                                        i2 = i7;
                                    }
                                } catch (Error | RuntimeException unused5) {
                                    i2 = i7;
                                    z3 = zA;
                                }
                            } catch (Error | RuntimeException unused6) {
                                evVar2 = evVar;
                                z3 = zA;
                                i2 = i4;
                                z4 = true;
                                com.google.android.libraries.navigation.internal.abf.p.f(a, 6);
                                this.s.j(String.format("%s.afterDrawLabel(%s)", a, jVar));
                                i4 = i2 + 1;
                                z2 = z4;
                                zA = z3;
                                iMin = i;
                                evVar = evVar2;
                            }
                        } catch (Error | RuntimeException unused7) {
                            i = iMin;
                        }
                        com.google.android.libraries.navigation.internal.abf.p.f(a, 6);
                        this.s.j(String.format("%s.afterDrawLabel(%s)", a, jVar));
                    }
                    if (sVar != null) {
                        try {
                            int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.w, "u_Texture");
                            this.t.a();
                            this.t.b(sVar.a);
                            this.t.i(iGlGetUniformLocation);
                            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.w, "alpha"), 1.0f);
                            if (!z3) {
                                Matrix.multiplyMM(sVar.c, 0, iVar.g(), 0, sVar.b, 0);
                            }
                            this.t.j(GLES20.glGetUniformLocation(this.w, "uMVPMatrix"), sVar.c);
                            this.x.d();
                            list2 = list;
                            try {
                                list2.add(sVar);
                            } catch (Error | RuntimeException unused8) {
                                com.google.android.libraries.navigation.internal.abf.p.f(a, 6);
                            }
                        } catch (Error | RuntimeException unused9) {
                            list2 = list;
                            com.google.android.libraries.navigation.internal.abf.p.f(a, 6);
                        }
                    } else {
                        list2 = list;
                    }
                } catch (Error | RuntimeException unused10) {
                    i = iMin;
                    evVar2 = evVar;
                    z3 = zA;
                    i2 = i4;
                    z4 = z2;
                }
                this.s.j(String.format("%s.afterDrawLabel(%s)", a, jVar));
            }
            i4 = i2 + 1;
            z2 = z4;
            zA = z3;
            iMin = i;
            evVar = evVar2;
        }
        GLES20.glBindBuffer(34962, 0);
        GLES20.glBindBuffer(34963, 0);
        this.s.j(String.format("%s.onDrawFrameEnd()", a));
        synchronized (this) {
            this.y = iVar;
            this.z.clear();
            this.z.addAll(list2);
        }
    }

    public final synchronized boolean c() {
        this.c.a();
        return this.h;
    }

    public final void d() {
        if (this.d) {
            com.google.android.libraries.navigation.internal.abf.p.f(a, 6);
            return;
        }
        String str = a;
        com.google.android.libraries.navigation.internal.abf.p.f(str, 4);
        this.e = false;
        try {
            this.g.clear();
            this.f = com.google.android.libraries.navigation.internal.abt.c.a;
            int[] iArr = (int[]) e.b.get();
            iArr[0] = 0;
            GLES20.glGetIntegerv(3379, iArr, 0);
            int i = iArr[0];
            this.v = i;
            if (i == 0) {
                throw new IllegalStateException("Failed to load maximum texture size.");
            }
            int iA = g.a(str, this.s);
            this.w = iA;
            if (iA == 0) {
                throw new IllegalStateException("Failed to register GridMesh shader program!");
            }
            this.x = new g("RoadLabels", 1, 1);
            int i2 = 0;
            while (true) {
                int[][] iArr2 = k;
                int length = iArr2.length;
                if (i2 >= 4) {
                    this.x.b();
                    com.google.android.libraries.navigation.internal.abf.p.f(a, 4);
                    this.e = true;
                    return;
                }
                g gVar = this.x;
                int[] iArr3 = iArr2[i2];
                int i3 = iArr3[0];
                int i4 = iArr3[1];
                float[] fArr = m[i2];
                float f = fArr[0];
                float f2 = fArr[1];
                float f3 = fArr[2];
                float[] fArr2 = l[i2];
                gVar.e(i3, i4, f, f2, f3, fArr2[0], fArr2[1]);
                i2++;
            }
        } catch (RuntimeException unused) {
            com.google.android.libraries.navigation.internal.abf.p.f(a, 6);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abs.q
    public final void s(com.google.android.libraries.navigation.internal.abt.i iVar) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.abs.q
    public final void t() {
        throw null;
    }
}
