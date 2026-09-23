package com.ammarahmed.mmkv;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class MMKV {
    public static final int MULTI_PROCESS_MODE = 2;
    public static final int SINGLE_PROCESS_MODE = 1;
    private static final Set<Long> checkedHandleSet = Collections.synchronizedSet(new HashSet());
    private static final HashMap<String, Parcelable.Creator<?>> mCreators = new HashMap<>();
    private long nativeHandle;
    private String rootDir;

    private static native boolean checkProcessMode(long j);

    private native boolean containsKey(long j, String str);

    private native byte[] decodeBytes(long j, String str);

    private native double decodeDouble(long j, String str, double d);

    private native int decodeInt(long j, String str, int i);

    private native String decodeString(long j, String str, String str2);

    private native String[] decodeStringSet(long j, String str);

    private native boolean encodeDouble(long j, String str, double d);

    private native boolean encodeInt(long j, String str, int i);

    private native boolean encodeSet(long j, String str, String[] strArr);

    private native boolean encodeString(long j, String str, String str2);

    private static native long getMMKVWithID(String str, int i, String str2, String str3);

    private static native void jniInitialize(String str, int i);

    private native void removeValueForKey(long j, String str);

    public native String[] getAllKeys(long j);

    public static String initialize(Context context) {
        return initialize(context.getFilesDir().getAbsolutePath() + "/mmkv");
    }

    public static String initialize(String str) {
        jniInitialize(str, 0);
        return str;
    }

    public static MMKV mmkvWithID(String str) {
        return checkProcessMode(getMMKVWithID(str, 1, null, null), str, 1);
    }

    public static MMKV mmkvWithID(String str, int i, String str2) {
        return checkProcessMode(getMMKVWithID(str, i, str2, null), str, i);
    }

    public static MMKV mmkvWithID(String str, int i) {
        return checkProcessMode(getMMKVWithID(str, i, null, null), str, i);
    }

    private static MMKV checkProcessMode(long j, String str, int i) {
        String str2;
        if (j == 0) {
            return null;
        }
        Set<Long> set = checkedHandleSet;
        if (!set.contains(Long.valueOf(j))) {
            if (!checkProcessMode(j)) {
                if (i == 1) {
                    str2 = "Opening a multi-process MMKV instance [" + str + "] with SINGLE_PROCESS_MODE!";
                } else {
                    str2 = ("Opening a MMKV instance [" + str + "] with MULTI_PROCESS_MODE, ") + "while it's already been opened with SINGLE_PROCESS_MODE by someone somewhere else!";
                }
                throw new IllegalArgumentException(str2);
            }
            set.add(Long.valueOf(j));
        }
        return new MMKV(j);
    }

    private MMKV(long j) {
        this.nativeHandle = j;
    }

    public boolean containsKey(String str) {
        return containsKey(this.nativeHandle, str);
    }

    public <T extends Parcelable> T decodeParcelable(String str, Class<T> cls) {
        return (T) decodeParcelable(str, cls, null);
    }

    public <T extends Parcelable> T decodeParcelable(String str, Class<T> cls, T t) {
        byte[] bArrDecodeBytes;
        Parcelable.Creator<?> creator;
        if (cls == null || (bArrDecodeBytes = decodeBytes(this.nativeHandle, str)) == null) {
            return t;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArrDecodeBytes, 0, bArrDecodeBytes.length);
        parcelObtain.setDataPosition(0);
        try {
            String string = cls.toString();
            HashMap<String, Parcelable.Creator<?>> map = mCreators;
            synchronized (map) {
                creator = map.get(string);
                if (creator == null && (creator = (Parcelable.Creator) cls.getField("CREATOR").get(null)) != null) {
                    map.put(string, creator);
                }
            }
            if (creator != null) {
                T t2 = (T) creator.createFromParcel(parcelObtain);
                parcelObtain.recycle();
                return t2;
            }
            throw new Exception("Parcelable protocol requires a non-null static Parcelable.Creator object called CREATOR on class " + string);
        } catch (Exception unused) {
            parcelObtain.recycle();
            return t;
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }

    public void removeValueForKey(String str) {
        removeValueForKey(this.nativeHandle, str);
    }

    public Set<String> decodeStringSet(String str) {
        return decodeStringSet(str, (Set<String>) null);
    }

    public Set<String> decodeStringSet(String str, Set<String> set) {
        return decodeStringSet(str, set, HashSet.class);
    }

    public Set<String> decodeStringSet(String str, Set<String> set, Class<? extends Set> cls) {
        String[] strArrDecodeStringSet = decodeStringSet(this.nativeHandle, str);
        if (strArrDecodeStringSet == null) {
            return set;
        }
        try {
            Set<String> setNewInstance = cls.newInstance();
            setNewInstance.addAll(Arrays.asList(strArrDecodeStringSet));
            return setNewInstance;
        } catch (IllegalAccessException | InstantiationException unused) {
            return set;
        }
    }

    public int decodeInt(String str) {
        return decodeInt(this.nativeHandle, str, 0);
    }

    public int decodeInt(String str, int i) {
        return decodeInt(this.nativeHandle, str, i);
    }

    public double decodeDouble(String str) {
        return decodeDouble(this.nativeHandle, str, 0.0d);
    }

    public double decodeDouble(String str, double d) {
        return decodeDouble(this.nativeHandle, str, d);
    }

    public boolean encode(String str, String str2) {
        return encodeString(this.nativeHandle, str, str2);
    }

    public boolean encode(String str, double d) {
        return encodeDouble(this.nativeHandle, str, d);
    }

    public boolean encode(String str, int i) {
        return encodeInt(this.nativeHandle, str, i);
    }

    public boolean encode(String str, Set<String> set) {
        return encodeSet(this.nativeHandle, str, set == null ? null : (String[]) set.toArray(new String[0]));
    }

    public Set<String> getAllKeys() {
        String[] allKeys = getAllKeys(this.nativeHandle);
        if (allKeys == null) {
            return Collections.emptySet();
        }
        return new HashSet(Arrays.asList(allKeys));
    }

    public String decodeString(String str, String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }
}
