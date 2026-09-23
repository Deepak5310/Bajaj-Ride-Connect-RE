package com.google.android.libraries.navigation.internal.pb;

import android.animation.Animator;
import android.animation.ValueAnimator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class w extends ValueAnimator {
    final /* synthetic */ x a;

    protected w(x xVar) {
        this.a = xVar;
    }

    final void a(long j) {
        long startDelay = getStartDelay() + getDuration();
        if (startDelay == 0) {
            super.setDuration(j);
            return;
        }
        long startDelay2 = (long) ((j / startDelay) * getStartDelay());
        super.setStartDelay(startDelay2);
        super.setDuration(j - startDelay2);
    }

    public final void b(long j) {
        super.setDuration(j);
        this.a.q();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final /* bridge */ /* synthetic */ Animator setDuration(long j) {
        b(j);
        return this;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void setStartDelay(long j) {
        super.setStartDelay(j);
        this.a.q();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final /* bridge */ /* synthetic */ ValueAnimator setDuration(long j) {
        b(j);
        return this;
    }
}
