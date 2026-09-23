package com.google.android.libraries.navigation.internal.abh;

import com.google.android.gms.maps.model.FeatureType;
import com.google.android.libraries.navigation.internal.yz.ma;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bm {
    static final com.google.android.libraries.navigation.internal.yz.fd a;

    static {
        com.google.android.libraries.navigation.internal.ace.fp fpVar = com.google.android.libraries.navigation.internal.ace.fp.ADMINISTRATIVE_AREA1;
        com.google.android.libraries.navigation.internal.ace.fp fpVar2 = com.google.android.libraries.navigation.internal.ace.fp.ADMINISTRATIVE_AREA2;
        com.google.android.libraries.navigation.internal.ace.fp fpVar3 = com.google.android.libraries.navigation.internal.ace.fp.COUNTRY;
        com.google.android.libraries.navigation.internal.ace.fp fpVar4 = com.google.android.libraries.navigation.internal.ace.fp.LOCALITY;
        com.google.android.libraries.navigation.internal.ace.fp fpVar5 = com.google.android.libraries.navigation.internal.ace.fp.POSTAL_CODE;
        com.google.android.libraries.navigation.internal.ace.fp fpVar6 = com.google.android.libraries.navigation.internal.ace.fp.SCHOOL_DISTRICT_V2;
        com.google.android.libraries.navigation.internal.yz.bs.a(FeatureType.ADMINISTRATIVE_AREA_LEVEL_1, fpVar);
        com.google.android.libraries.navigation.internal.yz.bs.a(FeatureType.ADMINISTRATIVE_AREA_LEVEL_2, fpVar2);
        com.google.android.libraries.navigation.internal.yz.bs.a(FeatureType.COUNTRY, fpVar3);
        com.google.android.libraries.navigation.internal.yz.bs.a(FeatureType.LOCALITY, fpVar4);
        com.google.android.libraries.navigation.internal.yz.bs.a(FeatureType.POSTAL_CODE, fpVar5);
        com.google.android.libraries.navigation.internal.yz.bs.a(FeatureType.SCHOOL_DISTRICT, fpVar6);
        a = ma.a(6, new Object[]{FeatureType.ADMINISTRATIVE_AREA_LEVEL_1, fpVar, FeatureType.ADMINISTRATIVE_AREA_LEVEL_2, fpVar2, FeatureType.COUNTRY, fpVar3, FeatureType.LOCALITY, fpVar4, FeatureType.POSTAL_CODE, fpVar5, FeatureType.SCHOOL_DISTRICT, fpVar6});
    }
}
