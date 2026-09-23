package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.libraries.navigation.internal.abh.bi;
import com.google.android.libraries.navigation.internal.abh.ci;
import com.google.android.libraries.navigation.internal.abh.cm;
import com.google.android.libraries.navigation.internal.ly.cp;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class UiSettings {
    private final cp a;

    public UiSettings(cp cpVar) {
        this.a = cpVar;
    }

    public boolean isIndoorLevelPickerEnabled() {
        try {
            cm cmVar = ((ci) this.a).a;
            try {
                cmVar.h.a();
                return cmVar.p;
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
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isMapToolbarEnabled() {
        try {
            cm cmVar = ((ci) this.a).a;
            try {
                cmVar.h.a();
                return cmVar.g.j.b;
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
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isRotateGesturesEnabled() {
        try {
            try {
                return ((ci) this.a).a.b.K();
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
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isScrollGesturesEnabled() {
        try {
            return this.a.au();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isScrollGesturesEnabledDuringRotateOrZoom() {
        try {
            return this.a.au();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isTiltGesturesEnabled() {
        try {
            try {
                return ((ci) this.a).a.b.M();
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
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isZoomGesturesEnabled() {
        try {
            try {
                return ((ci) this.a).a.b.N();
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
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setIndoorLevelPickerEnabled(boolean z) {
        try {
            cm cmVar = ((ci) this.a).a;
            try {
                cmVar.h.a();
                cmVar.i.c(z ? com.google.android.libraries.navigation.internal.abx.b.MAP_ENABLE_INDOOR_LEVEL_PICKER : com.google.android.libraries.navigation.internal.abx.b.MAP_DISABLE_INDOOR_LEVEL_PICKER);
                boolean z2 = z & (!cmVar.l) & (!com.google.android.libraries.navigation.internal.abf.e.b);
                if (cmVar.q) {
                    cmVar.g.i.b.setVisibility(true != z2 ? 8 : 0);
                }
                cmVar.p = z2;
            } catch (Throwable th) {
                bi.a(th);
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                if (!(th instanceof Error)) {
                    throw new RuntimeException(th);
                }
                throw ((Error) th);
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isCompassEnabled() {
        try {
            try {
                return ((ci) this.a).a.o;
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
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isMyLocationButtonEnabled() {
        try {
            try {
                return ((ci) this.a).a.e.g;
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
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isZoomControlsEnabled() {
        try {
            try {
                return ((ci) this.a).a.f115n;
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
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setAllGesturesEnabled(boolean z) {
        try {
            this.a.as(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setCompassEnabled(boolean z) {
        try {
            ((ci) this.a).a.aO(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setMapToolbarEnabled(boolean z) {
        try {
            ((ci) this.a).a.aQ(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setMyLocationButtonEnabled(boolean z) {
        try {
            this.a.at(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setRotateGesturesEnabled(boolean z) {
        try {
            ((ci) this.a).a.aV(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setScrollGesturesEnabled(boolean z) {
        try {
            ((ci) this.a).a.aW(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setScrollGesturesEnabledDuringRotateOrZoom(boolean z) {
        try {
            ((ci) this.a).a.aX(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setTiltGesturesEnabled(boolean z) {
        try {
            ((ci) this.a).a.aY(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZoomControlsEnabled(boolean z) {
        try {
            ((ci) this.a).a.aZ(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZoomGesturesEnabled(boolean z) {
        try {
            ((ci) this.a).a.ba(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
