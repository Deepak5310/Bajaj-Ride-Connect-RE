package com.spotify.protocol.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WelcomeDetails implements Item {

    @SerializedName("roles")
    @JsonProperty("roles")
    public final Roles roles;

    private WelcomeDetails() {
        this(null);
    }

    public WelcomeDetails(Roles roles) {
        this.roles = roles;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WelcomeDetails)) {
            return false;
        }
        Roles roles = this.roles;
        Roles roles2 = ((WelcomeDetails) obj).roles;
        if (roles != null) {
            return roles.equals(roles2);
        }
        return roles2 == null;
    }

    public int hashCode() {
        Roles roles = this.roles;
        if (roles != null) {
            return roles.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "WelcomeDetails{roles=" + this.roles + '}';
    }
}
