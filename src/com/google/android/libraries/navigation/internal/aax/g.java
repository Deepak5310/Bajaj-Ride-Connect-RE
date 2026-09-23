package com.google.android.libraries.navigation.internal.aax;

import com.drew.metadata.exif.makernotes.CanonMakernoteDirectory;
import com.drew.metadata.mp4.media.Mp4VideoDirectory;
import com.drew.metadata.photoshop.PhotoshopDirectory;
import com.google.android.libraries.navigation.internal.ael.bm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum g implements bm {
    RELATION_OVERLAPS(1),
    RELATION_CONTAINED_BY(17),
    RELATION_EQUAL_TO(273),
    RELATION_POLITICAL_DEPRECATED(2),
    RELATION_CAPITAL_OF(3),
    RELATION_DISAMBIGUATED_BY(4),
    RELATION_NEIGHBOR_OF(65),
    RELATION_OPPOSITE_TO(PhotoshopDirectory.TAG_ICC_UNTAGGED_PROFILE),
    RELATION_NEXT_TO(1042),
    RELATION_RIGHT_OF(16673),
    RELATION_LEFT_OF(16674),
    RELATION_BEHIND(1043),
    RELATION_IN_FRONT_OF(PhotoshopDirectory.TAG_SEED_NUMBER),
    RELATION_SAME_BUILDING(66),
    RELATION_ABOVE(PhotoshopDirectory.TAG_VERSION),
    RELATION_BELOW(PhotoshopDirectory.TAG_EXIF_DATA_1),
    RELATION_NEAR(67),
    RELATION_ORGANIZATIONALLY_PART_OF(6),
    RELATION_DEPARTMENT_OF(97),
    RELATION_WORKS_AT(99),
    RELATION_INDEPENDENT_ESTABLISHMENT_IN(100),
    RELATION_ON_LEVEL(7),
    RELATION_OCCUPIES(8),
    RELATION_BUSINESS_LIFE_CYCLE(9),
    RELATION_BUSINESS_MOVED(145),
    RELATION_BUSINESS_REBRANDED(146),
    RELATION_MEMBER_OF_CHAIN(10),
    RELATION_AUTHORIZED_DEALER_FOR_CHAIN(CanonMakernoteDirectory.TAG_TONE_CURVE_TABLE),
    RELATION_SUBSIDIARY_OF(11),
    RELATION_PRIMARILY_OCCUPIED_BY(12),
    RELATION_VARIATION(13),
    RELATION_HAS_VARIANT(Mp4VideoDirectory.TAG_DEPTH),
    RELATION_VARIANT_OF(Mp4VideoDirectory.TAG_COMPRESSION_TYPE),
    RELATION_VARIANT_SIBLING(Mp4VideoDirectory.TAG_GRAPHICS_MODE),
    RELATION_CLIENT_DEFINED(15);

    private final int K;

    g(int i) {
        this.K = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.K;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.K);
    }
}
