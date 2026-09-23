package com.spotify.protocol.types;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListItems implements Item {

    @SerializedName(FirebaseAnalytics.Param.ITEMS)
    @JsonProperty(FirebaseAnalytics.Param.ITEMS)
    public final ListItem[] items;

    @SerializedName("limit")
    @JsonProperty("limit")
    public final int limit;

    @SerializedName(TypedValues.CycleType.S_WAVE_OFFSET)
    @JsonProperty(TypedValues.CycleType.S_WAVE_OFFSET)
    public final int offset;

    @SerializedName("total")
    @JsonProperty("total")
    public final int total;

    private ListItems() {
        this(0, 0, 0, null);
    }

    public ListItems(int i, int i2, int i3, ListItem[] listItemArr) {
        this.limit = i;
        this.offset = i2;
        this.total = i3;
        this.items = listItemArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListItems)) {
            return false;
        }
        ListItems listItems = (ListItems) obj;
        if (this.limit == listItems.limit && this.offset == listItems.offset && this.total == listItems.total) {
            return Arrays.equals(this.items, listItems.items);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.limit * 31) + this.offset) * 31) + this.total) * 31) + Arrays.hashCode(this.items);
    }

    public String toString() {
        return "ListItems{limit=" + this.limit + ", offset=" + this.offset + ", total=" + this.total + ", items=" + Arrays.toString(this.items) + '}';
    }
}
