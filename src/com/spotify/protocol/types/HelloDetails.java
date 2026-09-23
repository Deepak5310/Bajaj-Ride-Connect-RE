package com.spotify.protocol.types;

import app.notifee.core.event.LogEvent;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HelloDetails implements Item {

    @SerializedName("authid")
    @JsonProperty("authid")
    public final String authid;

    @SerializedName("authmethods")
    @JsonProperty("authmethods")
    public final String[] authmethods;

    @SerializedName("extras")
    @JsonProperty("extras")
    public final Map<String, String> extras;

    @SerializedName(LogEvent.LEVEL_INFO)
    @JsonProperty(LogEvent.LEVEL_INFO)
    public final Info info;

    @SerializedName("roles")
    @JsonProperty("roles")
    public final Roles roles;

    private HelloDetails() {
        this(null, null, null, null, null);
    }

    public HelloDetails(Roles roles, Info info, String[] strArr, String str, Map<String, String> map) {
        this.roles = roles;
        this.info = info;
        this.authmethods = strArr;
        this.authid = str;
        this.extras = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HelloDetails)) {
            return false;
        }
        HelloDetails helloDetails = (HelloDetails) obj;
        Roles roles = this.roles;
        if (roles == null ? helloDetails.roles != null : !roles.equals(helloDetails.roles)) {
            return false;
        }
        Info info = this.info;
        if (info == null ? helloDetails.info != null : !info.equals(helloDetails.info)) {
            return false;
        }
        if (!Arrays.equals(this.authmethods, helloDetails.authmethods)) {
            return false;
        }
        String str = this.authid;
        if (str == null ? helloDetails.authid != null : !str.equals(helloDetails.authid)) {
            return false;
        }
        Map<String, String> map = this.extras;
        Map<String, String> map2 = helloDetails.extras;
        if (map != null) {
            return map.equals(map2);
        }
        return map2 == null;
    }

    public int hashCode() {
        Roles roles = this.roles;
        int iHashCode = (roles != null ? roles.hashCode() : 0) * 31;
        Info info = this.info;
        int iHashCode2 = (((iHashCode + (info != null ? info.hashCode() : 0)) * 31) + Arrays.hashCode(this.authmethods)) * 31;
        String str = this.authid;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Map<String, String> map = this.extras;
        return iHashCode3 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "HelloDetails{roles=" + this.roles + ", info=" + this.info + ", authmethods=" + Arrays.toString(this.authmethods) + ", authid='" + this.authid + "', extras=" + this.extras + '}';
    }
}
