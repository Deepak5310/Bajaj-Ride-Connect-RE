package com.google.android.libraries.navigation.internal.ky;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class k extends au {
    private final double c;
    private final int d;

    public k(int i, double d) {
        this.d = i;
        this.c = d;
    }

    @Override // com.google.android.libraries.navigation.internal.ky.au
    public final double a() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.ky.au
    public final int b() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof au) {
            au auVar = (au) obj;
            if (this.d == auVar.b() && Double.doubleToLongBits(this.c) == Double.doubleToLongBits(auVar.a())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        double d = this.c;
        return ((int) (Double.doubleToLongBits(d) ^ (Double.doubleToLongBits(d) >>> 32))) ^ ((this.d ^ 1000003) * 1000003);
    }

    public final String toString() {
        String str;
        int i = this.d;
        if (i == 1) {
            str = "NO_UPLOAD";
        } else if (i == 2) {
            str = "UPLOAD";
        } else if (i != 3) {
            str = i != 4 ? "ALWAYS_UPLOAD_NO_SAMPLER" : "SAMPLING_NOT_SUPPORTED_FOR_LOG_EVENT";
        } else {
            str = "ALWAYS_UPLOAD_DUE_TO_ERROR";
        }
        return "LogSamplerResult{samplingDecision=" + str + ", overallEffectiveSamplingRate=" + this.c + "}";
    }
}
