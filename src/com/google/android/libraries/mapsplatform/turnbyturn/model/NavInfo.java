package com.google.android.libraries.mapsplatform.turnbyturn.model;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class NavInfo {
    private final int a;
    private final StepInfo b;
    private final StepInfo[] c;
    private final boolean d;
    private final Integer e;
    private final Integer f;
    private final Integer g;
    private final Integer h;
    private final Integer i;
    private final Integer j;

    /* JADX INFO: compiled from: PG */
    public static class Builder {
        private int a;
        private StepInfo b;
        private StepInfo[] c;
        private boolean d;
        private Integer e;
        private Integer f;
        private Integer g;
        private Integer h;
        private Integer i;
        private Integer j;

        public Builder() {
            this.a = 0;
            this.c = new StepInfo[0];
            this.d = false;
        }

        public Builder(int i, StepInfo stepInfo, StepInfo[] stepInfoArr, boolean z, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6) {
            this.a = i;
            this.b = stepInfo;
            this.c = stepInfoArr;
            this.d = z;
            this.e = num;
            this.f = num2;
            this.g = num3;
            this.h = num4;
            this.i = num5;
            this.j = num6;
        }

        public NavInfo build() {
            return new NavInfo(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
        }

        public Builder setCurrentStep(StepInfo stepInfo) {
            this.b = stepInfo;
            return this;
        }

        public Builder setDistanceToCurrentStepMeters(Integer num) {
            this.f = num;
            return this;
        }

        public Builder setDistanceToFinalDestinationMeters(Integer num) {
            this.j = num;
            return this;
        }

        public Builder setDistanceToNextDestinationMeters(Integer num) {
            this.h = num;
            return this;
        }

        public Builder setNavState(int i) {
            this.a = i;
            return this;
        }

        public Builder setRemainingSteps(StepInfo[] stepInfoArr) {
            this.c = stepInfoArr;
            return this;
        }

        public Builder setRouteChanged(boolean z) {
            this.d = z;
            return this;
        }

        public Builder setTimeToCurrentStepSeconds(Integer num) {
            this.e = num;
            return this;
        }

        public Builder setTimeToFinalDestinationSeconds(Integer num) {
            this.i = num;
            return this;
        }

        public Builder setTimeToNextDestinationSeconds(Integer num) {
            this.g = num;
            return this;
        }
    }

    public NavInfo(int i, StepInfo stepInfo, StepInfo[] stepInfoArr, boolean z, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6) {
        this.a = i;
        this.b = stepInfo;
        this.c = stepInfoArr;
        this.d = z;
        this.e = num;
        this.f = num2;
        this.g = num3;
        this.h = num4;
        this.i = num5;
        this.j = num6;
    }

    public static Builder builder() {
        return new Builder();
    }

    public StepInfo getCurrentStep() {
        return this.b;
    }

    public Integer getDistanceToCurrentStepMeters() {
        return this.f;
    }

    @Deprecated
    public Integer getDistanceToDestinationMeters() {
        return getDistanceToFinalDestinationMeters();
    }

    public Integer getDistanceToFinalDestinationMeters() {
        return this.j;
    }

    public Integer getDistanceToNextDestinationMeters() {
        return this.h;
    }

    public int getNavState() {
        return this.a;
    }

    public StepInfo[] getRemainingSteps() {
        return this.c;
    }

    public boolean getRouteChanged() {
        return this.d;
    }

    public Integer getTimeToCurrentStepSeconds() {
        return this.e;
    }

    @Deprecated
    public Integer getTimeToDestinationSeconds() {
        return getTimeToFinalDestinationSeconds();
    }

    public Integer getTimeToFinalDestinationSeconds() {
        return this.i;
    }

    public Integer getTimeToNextDestinationSeconds() {
        return this.g;
    }

    public Builder toBuilder() {
        return new Builder(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
    }
}
