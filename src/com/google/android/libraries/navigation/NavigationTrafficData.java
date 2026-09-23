package com.google.android.libraries.navigation;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class NavigationTrafficData {
    private Status a;
    private final ev b;

    /* JADX INFO: compiled from: PG */
    public enum Status {
        OK,
        UNAVAILABLE
    }

    public NavigationTrafficData() {
        Status status = Status.OK;
        try {
            this.a = Status.UNAVAILABLE;
            int i = ev.d;
            this.b = lv.a;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public boolean equals(Object obj) {
        try {
            if (!(obj instanceof NavigationTrafficData) || ((NavigationTrafficData) obj).getRoadStretchRenderingDataList().size() != getRoadStretchRenderingDataList().size()) {
                return false;
            }
            for (int i = 0; i < getRoadStretchRenderingDataList().size(); i++) {
                if (!((NavigationTrafficData) obj).getRoadStretchRenderingDataList().get(i).equals(getRoadStretchRenderingDataList().get(i))) {
                    return false;
                }
            }
            return true;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public List<NavigationRoadStretchRenderingData> getRoadStretchRenderingDataList() {
        try {
            return this.b;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public Status getStatus() {
        try {
            return this.a;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public int hashCode() {
        try {
            return Objects.hashCode(getRoadStretchRenderingDataList());
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public String toString() {
        try {
            StringBuilder sb = new StringBuilder(1024);
            sb.append("Road Stretch Rendering Data:");
            for (NavigationRoadStretchRenderingData navigationRoadStretchRenderingData : getRoadStretchRenderingDataList()) {
                sb.append("\n");
                sb.append(navigationRoadStretchRenderingData);
            }
            return sb.toString();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public NavigationTrafficData(List<NavigationRoadStretchRenderingData> list) {
        this.a = Status.UNAVAILABLE;
        try {
            com.google.android.libraries.navigation.internal.yx.ar.b(list != null, "Road stretch rendering data list must be non-null.");
            this.a = Status.OK;
            this.b = ev.o(list);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}
