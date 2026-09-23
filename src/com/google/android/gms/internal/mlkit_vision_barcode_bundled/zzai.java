package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import com.drew.metadata.mp4.media.Mp4VideoDirectory;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;

/* JADX INFO: compiled from: com.google.mlkit:barcode-scanning@@17.0.2 */
/* JADX INFO: loaded from: classes2.dex */
final class zzai implements zzeg {
    static final zzeg zza = new zzai();

    private zzai() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeg
    public final boolean zza(int i) {
        if (i == 129 || i == 161 || i == 209 || i == 2705 || i == 20753 || i == 20769 || i == 215 || i == 216 || i == 1297 || i == 1298) {
            return true;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                switch (i) {
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                        return true;
                    default:
                        switch (i) {
                            case PanasonicMakernoteDirectory.TAG_LENS_TYPE /* 81 */:
                            case 82:
                            case PanasonicMakernoteDirectory.TAG_ACCESSORY_TYPE /* 83 */:
                            case 84:
                            case JpegTranscoderUtils.DEFAULT_JPEG_QUALITY /* 85 */:
                                return true;
                            default:
                                switch (i) {
                                    case 163:
                                    case 164:
                                    case NikonType2MakernoteDirectory.TAG_IMAGE_COUNT /* 165 */:
                                    case NikonType2MakernoteDirectory.TAG_DELETED_IMAGE_COUNT /* 166 */:
                                    case NikonType2MakernoteDirectory.TAG_EXPOSURE_SEQUENCE_NUMBER /* 167 */:
                                    case 168:
                                    case 169:
                                        return true;
                                    default:
                                        switch (i) {
                                            case Mp4VideoDirectory.TAG_GRAPHICS_MODE /* 211 */:
                                            case Mp4VideoDirectory.TAG_OPCOLOR /* 212 */:
                                            case Mp4VideoDirectory.TAG_COLOR_TABLE /* 213 */:
                                                return true;
                                            default:
                                                return false;
                                        }
                                }
                        }
                }
        }
    }
}
