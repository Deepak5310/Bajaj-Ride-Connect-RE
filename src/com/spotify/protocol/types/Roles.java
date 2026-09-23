package com.spotify.protocol.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Roles implements Item {

    @SerializedName("broker")
    @JsonProperty("broker")
    public final Empty broker;

    @SerializedName("caller")
    @JsonProperty("caller")
    public final Empty caller;

    @SerializedName("dealer")
    @JsonProperty("dealer")
    public final Empty dealer;

    @SerializedName("subscriber")
    @JsonProperty("subscriber")
    public final Empty subscriber;

    public Roles() {
        this(null, null, null, null);
    }

    public Roles(Empty empty, Empty empty2, Empty empty3, Empty empty4) {
        this.dealer = empty;
        this.broker = empty2;
        this.subscriber = empty3;
        this.caller = empty4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Roles)) {
            return false;
        }
        Roles roles = (Roles) obj;
        Empty empty = this.dealer;
        if (empty == null ? roles.dealer != null : !empty.equals(roles.dealer)) {
            return false;
        }
        Empty empty2 = this.broker;
        if (empty2 == null ? roles.broker != null : !empty2.equals(roles.broker)) {
            return false;
        }
        Empty empty3 = this.subscriber;
        if (empty3 == null ? roles.subscriber != null : !empty3.equals(roles.subscriber)) {
            return false;
        }
        Empty empty4 = this.caller;
        Empty empty5 = roles.caller;
        if (empty4 != null) {
            return empty4.equals(empty5);
        }
        return empty5 == null;
    }

    public int hashCode() {
        Empty empty = this.dealer;
        int iHashCode = (empty != null ? empty.hashCode() : 0) * 31;
        Empty empty2 = this.broker;
        int iHashCode2 = (iHashCode + (empty2 != null ? empty2.hashCode() : 0)) * 31;
        Empty empty3 = this.subscriber;
        int iHashCode3 = (iHashCode2 + (empty3 != null ? empty3.hashCode() : 0)) * 31;
        Empty empty4 = this.caller;
        return iHashCode3 + (empty4 != null ? empty4.hashCode() : 0);
    }

    public String toString() {
        return "Roles{dealer=" + this.dealer + ", broker=" + this.broker + ", subscriber=" + this.subscriber + ", caller=" + this.caller + '}';
    }
}
