package com.google.android.libraries.navigation.internal.xe;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k {
    public GoogleMap a;
    private final Set b = new HashSet();

    public final synchronized void a(final OnMapReadyCallback onMapReadyCallback) {
        if (this.a != null) {
            com.google.android.libraries.navigation.internal.vq.c.a.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xe.i
                @Override // java.lang.Runnable
                public final void run() {
                    onMapReadyCallback.onMapReady(this.a.a);
                }
            });
        } else {
            this.b.add(onMapReadyCallback);
        }
    }

    public final synchronized void b(final GoogleMap googleMap) {
        this.a = googleMap;
        for (final OnMapReadyCallback onMapReadyCallback : this.b) {
            com.google.android.libraries.navigation.internal.vq.c.a.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xe.j
                @Override // java.lang.Runnable
                public final void run() {
                    onMapReadyCallback.onMapReady(googleMap);
                }
            });
        }
        this.b.clear();
    }
}
