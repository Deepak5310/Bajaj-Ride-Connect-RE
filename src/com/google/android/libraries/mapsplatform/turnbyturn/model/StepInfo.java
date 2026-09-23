package com.google.android.libraries.mapsplatform.turnbyturn.model;

import android.graphics.Bitmap;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class StepInfo {
    private final int a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final int f;
    private final Integer g;
    private final Integer h;
    private final Integer i;
    private final Integer j;
    private final List k;
    private final Bitmap l;
    private final Bitmap m;

    /* JADX INFO: compiled from: PG */
    public static class Builder {
        private int a;
        private int b;
        private String c;
        private String d;
        private String e;
        private String f;
        private Integer g;
        private Integer h;
        private Integer i;
        private Integer j;
        private List k;
        private Bitmap l;
        private Bitmap m;

        public Builder() {
            this.a = 0;
            this.b = 0;
        }

        public Builder(int i, String str, String str2, String str3, String str4, int i2, Integer num, Integer num2, Integer num3, Integer num4, List list, Bitmap bitmap, Bitmap bitmap2) {
            this.a = i;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.b = i2;
            this.g = num;
            this.h = num2;
            this.i = num3;
            this.j = num4;
            this.k = list;
            this.l = bitmap;
            this.m = bitmap2;
        }

        public StepInfo build() {
            return new StepInfo(this.a, this.c, this.d, this.e, this.f, this.b, this.g, this.h, this.i, this.j, this.k, this.l, this.m);
        }

        public Builder setDistanceFromPrevStepMeters(Integer num) {
            this.i = num;
            return this;
        }

        public Builder setDrivingSide(int i) {
            this.b = i;
            return this;
        }

        public Builder setExitNumber(String str) {
            this.f = str;
            return this;
        }

        public Builder setFullInstructionText(String str) {
            this.e = str;
            return this;
        }

        public Builder setFullRoadName(String str) {
            this.c = str;
            return this;
        }

        public Builder setLanes(ev<Lane> evVar) {
            this.k = evVar;
            return this;
        }

        public Builder setLanesBitmap(Bitmap bitmap) {
            this.m = bitmap;
            return this;
        }

        public Builder setManeuver(int i) {
            this.a = i;
            return this;
        }

        public Builder setManeuverBitmap(Bitmap bitmap) {
            this.l = bitmap;
            return this;
        }

        public Builder setRoundaboutTurnNumber(Integer num) {
            this.g = num;
            return this;
        }

        public Builder setSimpleRoadName(String str) {
            this.d = str;
            return this;
        }

        public Builder setStepNumber(Integer num) {
            this.h = num;
            return this;
        }

        public Builder setTimeFromPrevStepSeconds(Integer num) {
            this.j = num;
            return this;
        }
    }

    public StepInfo(int i, String str, String str2, String str3, String str4, int i2, Integer num, Integer num2, Integer num3, Integer num4, List list, Bitmap bitmap, Bitmap bitmap2) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = i2;
        this.g = num;
        this.h = num2;
        this.i = num3;
        this.j = num4;
        this.k = list;
        this.l = bitmap;
        this.m = bitmap2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Integer getDistanceFromPrevStepMeters() {
        return this.i;
    }

    public int getDrivingSide() {
        return this.f;
    }

    public String getExitNumber() {
        return this.e;
    }

    public String getFullInstructionText() {
        return this.d;
    }

    public String getFullRoadName() {
        return this.b;
    }

    public List<Lane> getLanes() {
        return this.k;
    }

    public Bitmap getLanesBitmap() {
        return this.m;
    }

    public int getManeuver() {
        return this.a;
    }

    public Bitmap getManeuverBitmap() {
        return this.l;
    }

    public Integer getRoundaboutTurnNumber() {
        return this.g;
    }

    public String getSimpleRoadName() {
        return this.c;
    }

    public Integer getStepNumber() {
        return this.h;
    }

    public Integer getTimeFromPrevStepSeconds() {
        return this.j;
    }

    public Builder toBuilder() {
        return new Builder(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m);
    }
}
