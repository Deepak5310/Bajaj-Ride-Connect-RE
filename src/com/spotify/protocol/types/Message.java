package com.spotify.protocol.types;

import com.facebook.react.devsupport.StackTraceHelper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message implements Item {

    @SerializedName(StackTraceHelper.MESSAGE_KEY)
    @JsonProperty(StackTraceHelper.MESSAGE_KEY)
    public final String message;

    public Message(String str) {
        this.message = str;
    }

    private Message() {
        this(null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        String str = this.message;
        String str2 = ((Message) obj).message;
        if (str != null) {
            return str.equals(str2);
        }
        return str2 == null;
    }

    public int hashCode() {
        String str = this.message;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "Message{message='" + this.message + "'}";
    }
}
