package com.google.android.libraries.navigation.internal.qu;

import androidx.tracing.Trace;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileProvider;
import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.navigation.internal.abf.p;
import com.google.android.libraries.navigation.internal.nw.d;
import com.google.android.libraries.navigation.internal.nw.e;
import com.google.android.libraries.navigation.internal.qu.h;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e implements Runnable {
    final /* synthetic */ com.google.android.libraries.geo.mapcore.internal.model.cd a;
    final /* synthetic */ boolean b;
    final /* synthetic */ com.google.android.libraries.navigation.internal.qv.i c;
    final /* synthetic */ k d;

    public e(k kVar, com.google.android.libraries.geo.mapcore.internal.model.cd cdVar, boolean z, com.google.android.libraries.navigation.internal.qv.i iVar) {
        this.a = cdVar;
        this.b = z;
        this.c = iVar;
        this.d = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k kVar = this.d;
        final com.google.android.libraries.geo.mapcore.internal.model.cd cdVar = this.a;
        com.google.android.libraries.navigation.internal.qv.i iVar = this.c;
        com.google.android.libraries.navigation.internal.qv.h hVar = com.google.android.libraries.navigation.internal.qv.h.OK;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("ApiTileStore.getFromMemoryCache");
        try {
            com.google.android.libraries.geo.mapcore.internal.model.cc ccVarB = kVar.d.b(cdVar);
            boolean z = false;
            if (ccVarB == null) {
                boolean zC = kVar.f.c(cdVar);
                boolean z2 = this.b;
                com.google.android.libraries.navigation.internal.qv.h hVar2 = (!z2 || zC) ? com.google.android.libraries.navigation.internal.qv.h.NOT_FOUND_LOCALLY : com.google.android.libraries.navigation.internal.qv.h.NOT_EXIST;
                if (z2 && zC) {
                    z = true;
                }
                hVar = hVar2;
            }
            if (dVarB != null) {
                Trace.endSection();
            }
            com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("ApiTileStore.addTileRequest.notifyTile");
            try {
                kVar.f(cdVar, iVar, com.google.android.libraries.navigation.internal.qv.h.a(hVar, z), ccVarB);
                if (dVarB2 != null) {
                    Trace.endSection();
                }
                com.google.android.libraries.navigation.internal.nw.d dVarB3 = com.google.android.libraries.navigation.internal.nw.e.b("ApiTileStore.addTileRequest.fetchTile");
                if (z) {
                    try {
                        final com.google.android.libraries.navigation.internal.qo.b bVar = kVar.e;
                        final h hVar3 = new h(kVar, cdVar, iVar);
                        bVar.a.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qo.a
                            @Override // java.lang.Runnable
                            public final void run() {
                                Tile tile;
                                b bVar2 = bVar;
                                cd cdVar2 = cdVar;
                                d dVarB4 = e.b("ExternalNetworkTileFetcher.fetchTile");
                                try {
                                    if (bVar2.b.add(cdVar2)) {
                                        com.google.android.libraries.navigation.internal.abm.d dVar = bVar2.c;
                                        int i = cdVar2.b;
                                        int i2 = cdVar2.c;
                                        int i3 = cdVar2.a;
                                        byte[] bArr = null;
                                        try {
                                            tile = dVar.b.getTile(i, i2, i3);
                                        } catch (RuntimeException e) {
                                            p.d(String.format(Locale.US, "Failed to get tile (%d, %d, %d) from TileProvider", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)), e);
                                            tile = null;
                                        }
                                        if (tile != null) {
                                            int i4 = tile.width;
                                            Tile tile2 = TileProvider.NO_TILE;
                                            bArr = (i4 == tile2.width && tile.height == tile2.height && tile.data == tile2.data) ? new byte[0] : tile.data;
                                        }
                                        bVar2.b.remove(cdVar2);
                                        h hVar4 = hVar3;
                                        if (bArr != null) {
                                            hVar4.b(bArr);
                                        } else {
                                            hVar4.a();
                                        }
                                    }
                                    if (dVarB4 != null) {
                                        Trace.endSection();
                                    }
                                } catch (Throwable th) {
                                    if (dVarB4 != null) {
                                        try {
                                            Trace.endSection();
                                        } catch (Throwable th2) {
                                            th.addSuppressed(th2);
                                        }
                                    }
                                    throw th;
                                }
                            }
                        });
                    } catch (Throwable th) {
                        if (dVarB3 != null) {
                            try {
                                Trace.endSection();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                }
                if (dVarB3 != null) {
                }
            } finally {
                if (dVarB2 != null) {
                    try {
                        Trace.endSection();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
            }
        } catch (Throwable th4) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th5) {
                    th4.addSuppressed(th5);
                }
            }
            throw th4;
        }
    }
}
