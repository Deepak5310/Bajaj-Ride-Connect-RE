package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.libraries.places.internal.zzkt;
import com.google.android.libraries.places.internal.zzlx;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AddressComponent implements Parcelable {

    /* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
    public static abstract class Builder {
        public AddressComponent build() {
            AddressComponent addressComponentZzc = zzc();
            zzkt.zzo(!addressComponentZzc.getName().isEmpty(), "Name must not be empty.");
            List<String> types = addressComponentZzc.getTypes();
            Iterator<String> it2 = types.iterator();
            while (it2.hasNext()) {
                zzkt.zzo(!TextUtils.isEmpty(it2.next()), "Types must not contain null or empty values.");
            }
            zzb(zzlx.zzj(types));
            return zzc();
        }

        public abstract String getShortName();

        public abstract Builder setShortName(String str);

        abstract Builder zzb(List list);

        abstract AddressComponent zzc();
    }

    public static Builder builder(String str, List<String> list) {
        zza zzaVar = new zza();
        zzaVar.zza(str);
        zzaVar.zzb(list);
        return zzaVar;
    }

    public abstract String getName();

    public abstract String getShortName();

    public abstract List<String> getTypes();
}
