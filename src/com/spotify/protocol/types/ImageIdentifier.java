package com.spotify.protocol.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageIdentifier implements Item {

    @JsonProperty("height")
    public final int height;

    @JsonProperty("id")
    public final String id;

    @JsonProperty("width")
    public final int width;

    public ImageIdentifier(String str, Image.Dimension dimension) {
        this.id = str;
        this.width = dimension.getValue();
        this.height = dimension.getValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageIdentifier)) {
            return false;
        }
        ImageIdentifier imageIdentifier = (ImageIdentifier) obj;
        String str = this.id;
        if (str == null ? imageIdentifier.id == null : str.equals(imageIdentifier.id)) {
            return this.height == imageIdentifier.height && this.width == imageIdentifier.width;
        }
        return false;
    }

    public int hashCode() {
        String str = this.id;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.height) * 31) + this.width;
    }
}
