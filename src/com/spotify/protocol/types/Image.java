package com.spotify.protocol.types;

import com.bajajconnect.wifi.StreamingImageHandler;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Image implements Item {

    @SerializedName("height")
    @JsonProperty("height")
    public final int height;

    @SerializedName("image_data")
    @JsonProperty("image_data")
    public final byte[] imageData;

    @SerializedName("width")
    @JsonProperty("width")
    public final int width;

    public enum Dimension {
        LARGE(720),
        MEDIUM(StreamingImageHandler.TFT_HEIGHT),
        SMALL(360),
        X_SMALL(240),
        THUMBNAIL(144);

        private final int mValue;

        Dimension(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    private Image() {
        this(null, 0, 0);
    }

    public Image(byte[] bArr, int i, int i2) {
        this.imageData = bArr;
        this.width = i;
        this.height = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Image)) {
            return false;
        }
        Image image = (Image) obj;
        if (this.width == image.width && this.height == image.height) {
            return Arrays.equals(this.imageData, image.imageData);
        }
        return false;
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.imageData) * 31) + this.width) * 31) + this.height;
    }

    public String toString() {
        return "Image{imageData=" + Arrays.toString(this.imageData) + ", width=" + this.width + ", height=" + this.height + '}';
    }
}
