package com.google.android.libraries.navigation;

import com.google.android.libraries.navigation.internal.adr.im;
import com.google.android.libraries.navigation.internal.adr.in;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class NavigationRoadStretchRenderingData {
    private final Style a;
    private int b;
    private int c;

    /* JADX INFO: compiled from: PG */
    public static final class Builder {
        private Style a;
        private int b;
        private int c;

        public Builder() {
            this.a = Style.UNKNOWN;
            this.b = 0;
            this.c = 0;
        }

        public NavigationRoadStretchRenderingData build() {
            try {
                return new NavigationRoadStretchRenderingData(this.a, this.b, this.c);
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public Builder setLengthMeters(int i) {
            try {
                com.google.android.libraries.navigation.internal.yx.ar.b(i >= 0, "Length must be non-negative.");
                this.c = i;
                return this;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public Builder setOffsetMeters(int i) {
            try {
                com.google.android.libraries.navigation.internal.yx.ar.b(i >= 0, "Offset must be non-negative.");
                this.b = i;
                return this;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public Builder setStyle(Style style) {
            try {
                com.google.android.libraries.navigation.internal.yx.ar.b(style != null, "Rendering style must be non-null.");
                this.a = style;
                return this;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public Builder(in inVar) {
            this.a = Style.UNKNOWN;
            this.b = 0;
            this.c = 0;
            try {
                im imVarB = im.b(inVar.c);
                int iOrdinal = (imVarB == null ? im.UNKNOWN_STYLE : imVarB).ordinal();
                this.a = iOrdinal != 1 ? iOrdinal != 2 ? Style.UNKNOWN : Style.TRAFFIC_JAM : Style.SLOWER_TRAFFIC;
                this.b = inVar.d;
                this.c = inVar.e;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }

        public Builder setStyle(im imVar) {
            try {
                com.google.android.libraries.navigation.internal.yx.ar.b(imVar != null, "Rendering style must be non-null.");
                int iOrdinal = imVar.ordinal();
                if (iOrdinal == 1) {
                    this.a = Style.SLOWER_TRAFFIC;
                } else if (iOrdinal == 2) {
                    this.a = Style.TRAFFIC_JAM;
                } else {
                    this.a = Style.UNKNOWN;
                }
                return this;
            } catch (Error | RuntimeException e) {
                com.google.android.libraries.navigation.environment.b.c(e);
                throw e;
            }
        }
    }

    /* JADX INFO: compiled from: PG */
    public enum Style {
        UNKNOWN,
        SLOWER_TRAFFIC,
        TRAFFIC_JAM
    }

    public NavigationRoadStretchRenderingData(Style style, int i, int i2) {
        Style style2 = Style.UNKNOWN;
        try {
            this.a = style;
            this.b = i;
            this.c = i2;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public boolean equals(Object obj) {
        try {
            if (!(obj instanceof NavigationRoadStretchRenderingData)) {
                return false;
            }
            NavigationRoadStretchRenderingData navigationRoadStretchRenderingData = (NavigationRoadStretchRenderingData) obj;
            return com.google.android.libraries.navigation.internal.yx.am.a(getStyle(), navigationRoadStretchRenderingData.getStyle()) && getOffsetMeters() == navigationRoadStretchRenderingData.getOffsetMeters() && getLengthMeters() == navigationRoadStretchRenderingData.getLengthMeters();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public int getLengthMeters() {
        try {
            return this.c;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public int getOffsetMeters() {
        try {
            return this.b;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public Style getStyle() {
        try {
            return this.a;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(new Object[]{getStyle(), Integer.valueOf(getOffsetMeters()), Integer.valueOf(getLengthMeters())});
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public String toString() {
        try {
            return String.format("Style: %s; Offset meters: %d ; Length meters: %d", getStyle(), Integer.valueOf(getOffsetMeters()), Integer.valueOf(getLengthMeters()));
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}
