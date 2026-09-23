package com.google.android.libraries.navigation.internal.de;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    protected float a;
    private float b = 0.0f;
    private long c = 0;
    private final boolean d;

    public a(boolean z) {
        this.d = z;
    }

    public final float a(long j, float f) {
        float f2 = f;
        long j2 = this.c;
        if (j2 == 0 || j < j2) {
            this.a = f2;
        } else {
            if (this.d) {
                float f3 = this.a;
                float fAbs = Math.abs(f2 - f3);
                if (fAbs + fAbs > 360.0f) {
                    f2 = f2 < f3 ? f2 + 360.0f : f2 - 360.0f;
                }
            }
            float f4 = (j - j2) / 100.0f;
            if (f4 > 10.0f || f4 < 0.0f) {
                this.a = f2;
                this.b = 0.0f;
            } else {
                while (f4 > 0.0f) {
                    float fMin = Math.min(0.5f, f4);
                    float f5 = this.a;
                    float f6 = (f2 - f5) / 10.0f;
                    float fAbs2 = this.b + (Math.abs(f6) * f6 * fMin);
                    this.b = fAbs2;
                    if (fAbs2 != 0.0f) {
                        float f7 = (f6 * 10.0f) / fAbs2;
                        float fExp = (float) (Math.exp((-f7) * f7) + 0.5d);
                        if (fExp * fMin >= 1.0f) {
                            this.b = 0.0f;
                        } else {
                            float f8 = fAbs2 - ((fExp * fAbs2) * fMin);
                            this.b = f8;
                            this.a = f5 + (f8 * fMin);
                        }
                    }
                    f4 -= 0.5f;
                }
            }
        }
        this.c = j;
        if (this.d) {
            while (true) {
                float f9 = this.a;
                if (f9 < 360.0f) {
                    break;
                }
                this.a = f9 - 360.0f;
            }
            while (true) {
                float f10 = this.a;
                if (f10 >= 0.0f) {
                    break;
                }
                this.a = f10 + 360.0f;
            }
        }
        return this.a;
    }
}
