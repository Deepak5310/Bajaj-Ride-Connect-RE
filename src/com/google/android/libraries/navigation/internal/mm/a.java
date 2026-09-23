package com.google.android.libraries.navigation.internal.mm;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class a implements ThreadFactory {
    public final /* synthetic */ int a;
    public final /* synthetic */ ThreadFactory b;

    public /* synthetic */ a(int i, ThreadFactory threadFactory) {
        this.a = i;
        this.b = threadFactory;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(final Runnable runnable) {
        final int i;
        final int i2;
        int[] iArr = c.a;
        int i3 = 0;
        while (true) {
            i = this.a;
            i2 = 10;
            if (i3 >= 10) {
                break;
            }
            i2 = i3 + 1;
            if (i >= c.a[i3]) {
                break;
            }
            i3 = i2;
        }
        Thread threadNewThread = this.b.newThread(new Runnable() { // from class: com.google.android.libraries.navigation.internal.mm.b
            @Override // java.lang.Runnable
            public final void run() {
                int[] iArr2 = c.a;
                int i4 = i2;
                if (i4 <= 0 || i4 > 10) {
                    throw new IllegalArgumentException("Invalid java priority: " + i4);
                }
                int i5 = i;
                if (c.a[i4 - 1] != i5) {
                    Process.setThreadPriority(i5);
                }
                runnable.run();
            }
        });
        threadNewThread.setPriority(i2);
        return threadNewThread;
    }
}
