package com.google.android.libraries.navigation.internal.sh;

import androidx.profileinstaller.ProfileVerifier;
import com.drew.metadata.exif.ExifDirectoryBase;
import com.drew.metadata.exif.makernotes.CasioType2MakernoteDirectory;
import com.drew.metadata.exif.makernotes.OlympusImageProcessingMakernoteDirectory;
import com.drew.metadata.mp4.media.Mp4VideoDirectory;
import com.facebook.imageutils.JfifUtil;
import com.google.android.libraries.navigation.internal.adr.dv;
import com.google.android.libraries.navigation.internal.rz.aa;
import com.google.android.libraries.navigation.internal.rz.ab;
import com.google.android.libraries.navigation.internal.rz.y;
import com.google.android.libraries.navigation.internal.rz.z;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.zb.j;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemConstants;
import java.util.EnumMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static final j a = j.e("com.google.android.libraries.navigation.internal.sh.a");
    public static final int[][] b = {new int[]{0}, new int[]{2, 1}, new int[]{16, 8}, new int[]{17}, new int[]{JfifUtil.MARKER_SOFn, 128}, new int[]{194, 129}, new int[]{208, 136}, new int[]{Mp4VideoDirectory.TAG_DEPTH}, new int[]{1536, 1024}, new int[]{1538}, new int[]{OlympusImageProcessingMakernoteDirectory.TagGainBase}, new int[]{1553}, new int[]{1664}, new int[]{1665}, new int[]{1672}, new int[]{1672, 1665, 1553, Mp4VideoDirectory.TAG_DEPTH}, new int[]{12288, 8192}, new int[]{CasioType2MakernoteDirectory.TAG_QUALITY, 8194}, new int[]{12304, 8208}, new int[]{12305, 8209}, new int[]{12480, 12416, 8384, 8320}, new int[]{12482, 12417, 8386, 8321}, new int[]{12496, 12424, 8400, 8328}, new int[]{12497, 8401}, new int[]{9728}, new int[]{9730}, new int[]{9744}, new int[]{9745}, new int[]{9856}, new int[]{9857}, new int[]{9864}, new int[]{9864, 9857, 9745, 12497, 8401}, new int[]{65536, 32768}, new int[]{65538}, new int[]{65552}, new int[]{65553}, new int[]{65728, 65664}, new int[]{65730, 65665}, new int[]{65744, 65672}, new int[]{65745}, new int[]{67072}, new int[]{67074}, new int[]{67088}, new int[]{67089}, new int[]{67200}, new int[]{67201}, new int[]{67208}, new int[]{67208, 67201, 67089, 65745}, new int[]{77824, ExifDirectoryBase.TAG_FLASHPIX_VERSION}, new int[]{77826, ExifDirectoryBase.TAG_EXIF_IMAGE_WIDTH}, new int[]{77840, 40976}, new int[]{77841, 40977}, new int[]{78016, 77952, 41152, 41088}, new int[]{78018, 77953, 41154, 41089}, new int[]{78032, 77960, 41168, 41096}, new int[]{78033, 41169}, new int[]{42496}, new int[]{42498}, new int[]{42512}, new int[]{42513}, new int[]{42624}, new int[]{42625}, new int[]{42632}, new int[]{42632, 42625, 42513, 78033, 41169}, new int[]{524288, 262144}, new int[]{524290}, new int[]{524304}, new int[]{524305}, new int[]{524480, SwipeableItemConstants.REACTION_CAN_SWIPE_BOTH_V}, new int[]{524482, 524417}, new int[]{524496, 524424}, new int[]{524497}, new int[]{525824}, new int[]{525826}, new int[]{525840}, new int[]{525841}, new int[]{525952}, new int[]{525953}, new int[]{525960}, new int[]{525960, 525953, 525841, 524497}, new int[]{536576, 270336}, new int[]{536578, 270338}, new int[]{536592, 270352}, new int[]{536593, 270353}, new int[]{536768, 536704, 270528, 270464}, new int[]{536770, 536705, 270530, 270465}, new int[]{536784, 536712, 270544, 270472}, new int[]{536785, 270545}, new int[]{271872}, new int[]{271874}, new int[]{271888}, new int[]{271889}, new int[]{272000}, new int[]{272001}, new int[]{272008}, new int[]{272008, 272001, 271889, 536785, 270545}, new int[]{ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_NO_PROFILE_EMBEDDED}, new int[]{327682}, new int[]{327696}, new int[]{327697}, new int[]{327872, 327808}, new int[]{327874, 327809}, new int[]{327888, 327816}, new int[]{327889}, new int[]{329216}, new int[]{329218}, new int[]{329232}, new int[]{329233}, new int[]{329344}, new int[]{329345}, new int[]{329352}, new int[]{329352, 329345, 329233, 327889}, new int[]{339968}, new int[]{339970}, new int[]{339984}, new int[]{339985}, new int[]{340160, 340096}, new int[]{340162, 340097}, new int[]{340176, 340104}, new int[]{340177}, new int[]{339968, 329216, 271872, 42496}, new int[]{339970, 329218, 271874, 42498}, new int[]{339984, 329232, 271888, 42512}, new int[]{339985, 329233, 271889, 42513}, new int[]{340160, 340096, 329344, 272000, 42624}, new int[]{340162, 340097, 329345, 272001, 42625}, new int[]{340176, 340104, 329352, 272008, 42632}, new int[]{340176, 340104, 340162, 340097, 339985, 329352, 329345, 329233, 327889, 272008, 272001, 271889, 536785, 270545, 42632, 42625, 42513, 78033, 41169}};
    public static final EnumMap c;
    private static final z[][] d;

    static {
        ez ezVar = new ez();
        ezVar.f(dv.STRAIGHT, 3);
        ezVar.f(dv.SLIGHT, 2);
        ezVar.f(dv.NORMAL, 1);
        ezVar.f(dv.SHARP, 0);
        ezVar.f(dv.U_TURN, 0);
        ezVar.f(dv.MERGE, -1);
        c = new EnumMap(ezVar.d());
        z zVar = z.SHARP;
        z[] zVarArr = {null, z.SHARP_SHORT, zVar, null};
        z zVar2 = z.NORMAL_SHORT;
        z zVar3 = z.NORMAL;
        z zVar4 = z.SLIGHT;
        z zVar5 = z.SLIGHT_TALL;
        d = new z[][]{zVarArr, new z[]{null, zVar2, zVar3, null}, new z[]{null, null, zVar4, zVar5}, new z[]{null, null, z.STRAIGHT, z.STRAIGHT_TALL}, new z[]{null, null, zVar4, zVar5}, new z[]{null, zVar2, zVar3, null}, new z[]{null, z.SHARP_SHORT, zVar, null}};
    }

    public static ab a(int i, int i2, boolean z, boolean z2) {
        int i3 = (i2 >> (i * 3)) & 7;
        z zVar = d[i][i3];
        if (z2) {
            zVar = i3 == 2 ? z.UTURN : z.UTURN_SHORT;
        }
        aa aaVar = i > 3 ? aa.SIDE_LEFT : aa.SIDE_RIGHT;
        y yVarD = ab.d();
        yVarD.c(zVar);
        yVarD.d(aaVar);
        yVarD.b(z);
        return yVarD.a();
    }

    public static ab[] b() {
        y yVarD = ab.d();
        yVarD.c(z.STUB);
        yVarD.d(aa.SIDE_RIGHT);
        yVarD.b(false);
        return new ab[]{yVarD.a()};
    }
}
