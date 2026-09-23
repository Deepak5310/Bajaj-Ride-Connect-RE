package com.spotify.protocol.types;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.spotify.protocol.mappers.jackson.ImageUriJson;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@JsonDeserialize(using = ImageUriJson.Deserializer.class)
@JsonSerialize(using = ImageUriJson.Serializer.class)
public class ImageUri implements Item {

    @Nullable
    public final String raw;

    private ImageUri() {
        this(null);
    }

    public ImageUri(String str) {
        this.raw = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageUri)) {
            return false;
        }
        String str = this.raw;
        String str2 = ((ImageUri) obj).raw;
        return str == null ? str2 == null : str.equals(str2);
    }

    public int hashCode() {
        String str = this.raw;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ImageId{" + this.raw + "'}";
    }
}
