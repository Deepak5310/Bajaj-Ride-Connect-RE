package com.spotify.protocol.types;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Track implements Item {

    @SerializedName("album")
    @JsonProperty("album")
    public final Album album;

    @SerializedName("artist")
    @JsonProperty("artist")
    public final Artist artist;

    @SerializedName("artists")
    @JsonProperty("artists")
    public final List<Artist> artists;

    @SerializedName("duration_ms")
    @JsonProperty("duration_ms")
    public final long duration;

    @SerializedName("image_id")
    @JsonProperty("image_id")
    public final ImageUri imageUri;

    @SerializedName("is_episode")
    @JsonProperty("is_episode")
    public final boolean isEpisode;

    @SerializedName("is_podcast")
    @JsonProperty("is_podcast")
    public final boolean isPodcast;

    @SerializedName("name")
    @JsonProperty("name")
    public final String name;

    @SerializedName(ReactNativeBlobUtilConst.DATA_ENCODE_URI)
    @JsonProperty(ReactNativeBlobUtilConst.DATA_ENCODE_URI)
    public final String uri;

    private Track() {
        this(null, null, null, 0L, null, null, null, false, false);
    }

    public Track(Artist artist, List<Artist> list, Album album, long j, String str, String str2, ImageUri imageUri, boolean z, boolean z2) {
        this.artist = artist;
        this.artists = list;
        this.album = album;
        this.duration = j;
        this.name = str;
        this.uri = str2;
        this.imageUri = imageUri;
        this.isEpisode = z;
        this.isPodcast = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Track)) {
            return false;
        }
        Track track = (Track) obj;
        if (this.duration != track.duration) {
            return false;
        }
        Artist artist = this.artist;
        if (artist == null ? track.artist != null : !artist.equals(track.artist)) {
            return false;
        }
        List<Artist> list = this.artists;
        if (list == null ? track.artists != null : !list.equals(track.artists)) {
            return false;
        }
        Album album = this.album;
        if (album == null ? track.album != null : !album.equals(track.album)) {
            return false;
        }
        String str = this.name;
        if (str == null ? track.name != null : !str.equals(track.name)) {
            return false;
        }
        String str2 = this.uri;
        if (str2 == null ? track.uri != null : !str2.equals(track.uri)) {
            return false;
        }
        ImageUri imageUri = this.imageUri;
        if (imageUri == null ? track.imageUri == null : imageUri.equals(track.imageUri)) {
            return this.isEpisode == track.isEpisode && this.isPodcast == track.isPodcast;
        }
        return false;
    }

    public int hashCode() {
        Artist artist = this.artist;
        int iHashCode = (artist != null ? artist.hashCode() : 0) * 31;
        List<Artist> list = this.artists;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        Album album = this.album;
        int iHashCode3 = (iHashCode2 + (album != null ? album.hashCode() : 0)) * 31;
        long j = this.duration;
        int i = (iHashCode3 + ((int) (j ^ (j >>> 32)))) * 31;
        String str = this.name;
        int iHashCode4 = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.uri;
        int iHashCode5 = (iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ImageUri imageUri = this.imageUri;
        return ((((iHashCode5 + (imageUri != null ? imageUri.hashCode() : 0)) * 31) + (this.isEpisode ? 1 : 0)) * 31) + (this.isPodcast ? 1 : 0);
    }

    public String toString() {
        return "Track{artist=" + this.artist + ", artists=" + this.artists + ", album=" + this.album + ", duration=" + this.duration + ", name='" + this.name + "', uri='" + this.uri + "', imageId='" + this.imageUri + "', isEpisode=" + this.isEpisode + ", isPodcast=" + this.isPodcast + '}';
    }
}
