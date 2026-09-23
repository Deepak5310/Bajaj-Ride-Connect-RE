package com.google.android.libraries.navigation.internal.abh;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ar extends com.google.android.libraries.navigation.internal.ly.d {
    private static final ab a = new ai();
    private static final ab b = new aj();

    @Override // com.google.android.libraries.navigation.internal.ly.e
    public final com.google.android.libraries.navigation.internal.lo.l a(CameraPosition cameraPosition) {
        try {
            return new com.google.android.libraries.navigation.internal.lo.n(new ao(cameraPosition));
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.e
    public final com.google.android.libraries.navigation.internal.lo.l b(LatLng latLng) {
        try {
            return new com.google.android.libraries.navigation.internal.lo.n(new ap(latLng));
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.e
    public final com.google.android.libraries.navigation.internal.lo.l c(LatLngBounds latLngBounds, int i) {
        try {
            return new com.google.android.libraries.navigation.internal.lo.n(new ag(latLngBounds, i));
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.e
    public final com.google.android.libraries.navigation.internal.lo.l d(LatLngBounds latLngBounds, int i, int i2, int i3) {
        try {
            return new com.google.android.libraries.navigation.internal.lo.n(new ah(latLngBounds, i, i2, i3));
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.e
    public final com.google.android.libraries.navigation.internal.lo.l e(LatLng latLng, float f) {
        try {
            return new com.google.android.libraries.navigation.internal.lo.n(new aq(latLng, f));
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.e
    public final com.google.android.libraries.navigation.internal.lo.l f(float f, float f2) {
        try {
            return new com.google.android.libraries.navigation.internal.lo.n(new an(f, f2));
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.e
    public final com.google.android.libraries.navigation.internal.lo.l g(float f) {
        try {
            return new com.google.android.libraries.navigation.internal.lo.n(new al(f));
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.e
    public final com.google.android.libraries.navigation.internal.lo.l h(float f, int i, int i2) {
        try {
            return new com.google.android.libraries.navigation.internal.lo.n(new am(f, i, i2));
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.e
    public final com.google.android.libraries.navigation.internal.lo.l i() {
        try {
            return new com.google.android.libraries.navigation.internal.lo.n(a);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.e
    public final com.google.android.libraries.navigation.internal.lo.l j() {
        try {
            return new com.google.android.libraries.navigation.internal.lo.n(b);
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.e
    public final com.google.android.libraries.navigation.internal.lo.l k(float f) {
        try {
            return new com.google.android.libraries.navigation.internal.lo.n(new ak(f));
        } catch (Throwable th) {
            bi.a(th);
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw new RuntimeException(th);
        }
    }
}
