package com.mappls.sdk.nearby.plugin.model;

import android.os.Parcelable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NearbyOption implements Parcelable {

    public static abstract class Builder {
        public abstract Builder bounds(String str);

        public abstract NearbyOption build();

        public abstract Builder explain(Boolean bool);

        public abstract Builder filter(String str);

        public abstract Builder pod(String str);

        public abstract Builder radius(Integer num);

        public abstract Builder richData(Boolean bool);

        public abstract Builder searchBy(String str);

        public abstract Builder sortBy(String str);

        public abstract Builder userName(String str);
    }

    public static Builder builder() {
        return new b.a().radius(1000);
    }

    public abstract String bounds();

    public abstract Boolean explain();

    public abstract String filter();

    public abstract String pod();

    public abstract Integer radius();

    public abstract Boolean richData();

    public abstract String searchBy();

    public abstract String sortBy();

    public abstract String userName();
}
