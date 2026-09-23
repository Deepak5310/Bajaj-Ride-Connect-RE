package com.google.android.libraries.navigation.internal.tu;

import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ad {
    public final Executor a;
    public final File b;
    public final File c;
    private final AtomicInteger d = new AtomicInteger(0);

    public ad(File file, com.google.android.libraries.navigation.internal.mj.a aVar, Executor executor) {
        this.b = file;
        this.a = executor;
        File file2 = new File(file, "tts-" + aVar.f().toEpochMilli());
        this.c = file2;
        file2.mkdir();
    }

    final File a() {
        return new File(this.c, String.valueOf(this.d.getAndIncrement()));
    }
}
