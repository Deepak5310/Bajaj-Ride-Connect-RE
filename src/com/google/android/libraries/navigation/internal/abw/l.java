package com.google.android.libraries.navigation.internal.abw;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.libraries.navigation.internal.abf.aj;
import com.google.android.libraries.navigation.internal.afm.am;
import com.google.android.libraries.navigation.internal.afm.an;
import com.google.android.libraries.navigation.internal.afm.aq;
import com.google.android.libraries.navigation.internal.afm.as;
import com.google.android.libraries.navigation.internal.afm.au;
import com.google.android.libraries.navigation.internal.afm.aw;
import com.google.android.libraries.navigation.internal.afm.ay;
import com.google.android.libraries.navigation.internal.afm.ba;
import com.google.android.libraries.navigation.internal.afm.bc;
import com.google.android.libraries.navigation.internal.afm.bd;
import com.google.android.libraries.navigation.internal.afm.bg;
import com.google.android.libraries.navigation.internal.afm.bi;
import com.google.android.libraries.navigation.internal.afm.bk;
import com.google.android.libraries.navigation.internal.afm.bm;
import com.google.android.libraries.navigation.internal.afm.bo;
import com.google.android.libraries.navigation.internal.afm.br;
import com.google.android.libraries.navigation.internal.afm.bs;
import com.google.android.libraries.navigation.internal.afm.bv;
import com.google.android.libraries.navigation.internal.afm.bw;
import com.google.android.libraries.navigation.internal.afm.bx;
import com.google.android.libraries.navigation.internal.afm.ca;
import com.google.android.libraries.navigation.internal.afm.cc;
import com.google.android.libraries.navigation.internal.afm.ce;
import com.google.android.libraries.navigation.internal.afm.cg;
import com.google.android.libraries.navigation.internal.afm.cj;
import com.google.android.libraries.navigation.internal.afm.ck;
import com.google.android.libraries.navigation.internal.afm.cl;
import com.google.android.libraries.navigation.internal.afm.m;
import com.google.android.libraries.navigation.internal.afm.n;
import com.google.android.libraries.navigation.internal.afm.z;
import com.google.maps.android.BuildConfig;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l {
    public static String a(z zVar) {
        return zVar == null ? BuildConfig.TRAVIS : aj.f(zVar).a("latitude", k.c(zVar.c)).a("longitude", k.c(zVar.d)).toString();
    }

    public static void b(bx bxVar) {
        String string;
        if (bxVar == null) {
            return;
        }
        aj ajVarF = aj.f(bxVar);
        if ((bxVar.b & 1) != 0) {
            ajVarF.g("pano_id", bxVar.c);
        }
        if ((bxVar.b & 2) != 0) {
            z zVar = bxVar.d;
            if (zVar == null) {
                zVar = z.a;
            }
            ajVarF.g("lat_lon", a(zVar));
        }
        if ((bxVar.b & 4) != 0) {
            ajVarF.c("search_radius_meters", bxVar.e);
        }
        if ((bxVar.b & 8) != 0) {
            bm bmVarB = bm.b(bxVar.f);
            if (bmVarB == null) {
                bmVarB = bm.UNKNOWN_SEARCH_FILTER;
            }
            ajVarF.g("search_filter", bmVarB);
        }
        if ((bxVar.b & 16) != 0) {
            ajVarF.c("link_skip", bxVar.g);
        }
        int i = bxVar.b & 32;
        String string2 = BuildConfig.TRAVIS;
        if (i != 0) {
            bi biVar = bxVar.h;
            if (biVar == null) {
                biVar = bi.a;
            }
            if (biVar == null) {
                string = BuildConfig.TRAVIS;
            } else {
                aj ajVarF2 = aj.f(biVar);
                if ((biVar.b & 1) != 0) {
                    ajVarF2.e("needs_link_street_range", biVar.c);
                }
                if ((biVar.b & 2) != 0) {
                    ajVarF2.e("fetch_depth_map", biVar.d);
                }
                if ((biVar.b & 4) != 0) {
                    ajVarF2.e("fetch_pano_map", biVar.e);
                }
                string = ajVarF2.toString();
            }
            ajVarF.g("Metadata", string);
        }
        if ((bxVar.b & 64) != 0) {
            bo boVar = bxVar.i;
            if (boVar == null) {
                boVar = bo.a;
            }
            ajVarF.g("SuperTile", boVar);
        }
        if ((bxVar.b & 128) != 0) {
            bw bwVar = bxVar.j;
            if (bwVar == null) {
                bwVar = bw.a;
            }
            if (bwVar != null) {
                aj ajVarF3 = aj.f(bwVar);
                n nVar = bwVar.c;
                if (nVar == null) {
                    nVar = n.a;
                }
                if (nVar != null) {
                    aj ajVarF4 = aj.f(nVar);
                    if ((nVar.b & 1) != 0) {
                        ajVarF4.c("max_image_width", nVar.c);
                    }
                    if ((nVar.b & 2) != 0) {
                        ajVarF4.c("max_image_height", nVar.d);
                    }
                    if ((nVar.b & 4) != 0) {
                        ajVarF4.c("available_image_memory", nVar.e);
                    }
                    for (int i2 = 0; i2 < nVar.f.size(); i2++) {
                        String strB = com.google.android.libraries.navigation.internal.b.b.b(i2, "preferred_image_format$");
                        m mVarB = m.b(nVar.f.d(i2));
                        if (mVarB == null) {
                            mVarB = m.PNG;
                        }
                        ajVarF4.g(strB, mVarB);
                    }
                    if ((nVar.b & 8) != 0) {
                        ajVarF4.e("html_body_only", nVar.g);
                    }
                    if ((nVar.b & 16) != 0) {
                        ajVarF4.e("embed_images", nVar.h);
                    }
                    string2 = ajVarF4.toString();
                }
                ajVarF3.g("client_capabilities", string2);
                aj ajVarC = ajVarF3.c("tile_size", bwVar.d).c("zoom", bwVar.e);
                for (int i3 = 0; i3 < bwVar.f.size(); i3++) {
                    bv bvVar = (bv) bwVar.f.get(i3);
                    aj ajVarC2 = aj.f(bvVar).c("tile_xindex", bvVar.c).c("tile_yindex", bvVar.d);
                    if ((bvVar.b & 4) != 0) {
                        bg bgVarB = bg.b(bvVar.e);
                        if (bgVarB == null) {
                            bgVarB = bg.FRONT;
                        }
                        ajVarC2.g(OptionalModuleUtils.FACE, bgVarB);
                    }
                    ajVarC.g(com.google.android.libraries.navigation.internal.b.b.b(i3, "Index$"), ajVarC2.toString());
                }
                string2 = ajVarC.toString();
            }
            ajVarF.g("Tiles", string2);
        }
        if ((bxVar.b & 256) != 0) {
            bs bsVar = bxVar.k;
            if (bsVar == null) {
                bsVar = bs.a;
            }
            aj ajVarC3 = aj.f(bsVar).c("width", bsVar.c).c("height", bsVar.d);
            if ((bsVar.b & 4) != 0) {
                br brVarB = br.b(bsVar.e);
                if (brVarB == null) {
                    brVarB = br.DEFAULT_THUMBNAIL;
                }
                ajVarC3.g("thumbnail_type", brVarB);
            }
            ajVarF.g("Thumbnail", ajVarC3.toString());
        }
        if ((bxVar.b & 512) != 0) {
            ajVarF.e("request_signature", bxVar.l);
        }
        if ((bxVar.b & 1024) != 0) {
            ajVarF.e("is_prefetch", bxVar.m);
        }
        if ((bxVar.b & 2048) != 0) {
            ajVarF.e("client_side_throttling_supported", bxVar.f327n);
        }
        if ((bxVar.b & 4096) != 0) {
            ajVarF.c("cbk_version", bxVar.o);
        }
        for (int i4 = 0; i4 < bxVar.p.size(); i4++) {
            String strB2 = com.google.android.libraries.navigation.internal.b.b.b(i4, "renderer$");
            bk bkVarB = bk.b(bxVar.p.d(i4));
            if (bkVarB == null) {
                bkVarB = bk.SPHERICAL;
            }
            ajVarF.g(strB2, bkVarB);
        }
        ajVarF.toString();
    }

    public static void c(cl clVar) {
        String string;
        String string2;
        String string3;
        String string4;
        if (clVar == null) {
            return;
        }
        aj ajVarF = aj.f(clVar);
        if ((clVar.b & 1) != 0) {
            ajVarF.g("pano_id", clVar.c);
        }
        int i = clVar.b & 2;
        String string5 = BuildConfig.TRAVIS;
        if (i != 0) {
            bd bdVar = clVar.d;
            if (bdVar == null) {
                bdVar = bd.a;
            }
            if (bdVar == null) {
                string4 = BuildConfig.TRAVIS;
            } else {
                aj ajVarF2 = aj.f(bdVar);
                aq aqVar = bdVar.c;
                if (aqVar == null) {
                    aqVar = aq.a;
                }
                if (aqVar == null) {
                    string = BuildConfig.TRAVIS;
                } else {
                    aj ajVarF3 = aj.f(aqVar);
                    ajVarF3.g("pano_id", aqVar.j);
                    aj ajVarC = ajVarF3.c("image_width", aqVar.f).c("image_height", aqVar.g);
                    z zVar = aqVar.l;
                    if (zVar == null) {
                        zVar = z.a;
                    }
                    ajVarC.g("lat_lon", a(zVar));
                    aj ajVarC2 = ajVarC.c("max_zoom_level", aqVar.p).c("radius", aqVar.q);
                    if ((aqVar.b & 1) != 0) {
                        ajVarC2.e("disabled", aqVar.c);
                    }
                    if ((aqVar.b & 2) != 0) {
                        ajVarC2.c("info_level ", aqVar.d);
                    }
                    if ((aqVar.b & 4) != 0) {
                        ajVarC2.c("info_value", aqVar.e);
                    }
                    if ((aqVar.b & 32) != 0) {
                        ajVarC2.c("tile_width", aqVar.h);
                    }
                    if ((aqVar.b & 64) != 0) {
                        ajVarC2.c("tile_height", aqVar.i);
                    }
                    if ((aqVar.b & 256) != 0) {
                        ajVarC2.c("num_zoom_levels", aqVar.k);
                    }
                    if ((aqVar.b & 1024) != 0) {
                        ajVarC2.g("copyright", aqVar.m);
                    }
                    if ((aqVar.b & 2048) != 0) {
                        ajVarC2.g("text", aqVar.f326n);
                    }
                    if ((aqVar.b & 4096) != 0) {
                        ajVarC2.g("street_range", aqVar.o);
                    }
                    if ((aqVar.b & 32768) != 0) {
                        as asVarB = as.b(aqVar.r);
                        if (asVarB == null) {
                            asVarB = as.GOOGLE;
                        }
                        ajVarC2.g("image_source", asVarB);
                    }
                    if ((aqVar.b & 65536) != 0) {
                        bc bcVarB = bc.b(aqVar.s);
                        if (bcVarB == null) {
                            bcVarB = bc.OUTDOOR;
                        }
                        ajVarC2.g("scene", bcVarB);
                    }
                    string = ajVarC2.toString();
                }
                ajVarF2.g("DataProperties", string);
                ay ayVar = bdVar.d;
                if (ayVar == null) {
                    ayVar = ay.a;
                }
                if (ayVar == null) {
                    string2 = BuildConfig.TRAVIS;
                } else {
                    aj ajVarF4 = aj.f(ayVar);
                    if ((ayVar.b & 1) != 0) {
                        ajVarF4.a("pano_yaw_degree", k.c(ayVar.c));
                    }
                    if ((ayVar.b & 2) != 0) {
                        ajVarF4.a("tilt_yaw_degree", k.c(ayVar.d));
                    }
                    if ((ayVar.b & 4) != 0) {
                        ajVarF4.a("tilt_pitch_degree", k.c(ayVar.e));
                    }
                    if ((ayVar.b & 8) != 0) {
                        ajVarF4.a("camera_pitch_degree", k.c(ayVar.f));
                    }
                    if ((ayVar.b & 16) != 0) {
                        ba baVarB = ba.b(ayVar.g);
                        if (baVarB == null) {
                            baVarB = ba.SPHERICAL;
                        }
                        ajVarF4.g("projection_type", baVarB);
                    }
                    if ((ayVar.b & 32) != 0) {
                        ajVarF4.a("horizontal_fov", k.c(ayVar.h));
                    }
                    if ((ayVar.b & 64) != 0) {
                        ajVarF4.a("min_visible_pitch", k.c(ayVar.i));
                    }
                    if ((ayVar.b & 128) != 0) {
                        ajVarF4.a("max_visible_pitch", k.c(ayVar.j));
                    }
                    string2 = ajVarF4.toString();
                }
                ajVarF2.g("ProjectionProperties", string2);
                an anVar = bdVar.e;
                if (anVar == null) {
                    anVar = an.a;
                }
                if (anVar == null) {
                    string3 = BuildConfig.TRAVIS;
                } else {
                    aj ajVarF5 = aj.f(anVar);
                    if ((anVar.b & 1) != 0) {
                        ajVarF5.a("horizon_height_fraction", k.c(anVar.c));
                    }
                    if ((anVar.b & 2) != 0) {
                        ajVarF5.a("annotation_height_fraction", k.c(anVar.d));
                    }
                    for (int i2 = 0; i2 < anVar.e.size(); i2++) {
                        am amVar = (am) anVar.e.get(i2);
                        aj ajVarF6 = aj.f(amVar);
                        ajVarF6.g("pano_if", amVar.d);
                        if ((amVar.b & 1) != 0) {
                            ajVarF6.a("yaw_degree", k.c(amVar.c));
                        }
                        if ((amVar.b & 4) != 0) {
                            ajVarF6.c("road_argb", amVar.e);
                        }
                        if ((amVar.b & 8) != 0) {
                            ajVarF6.g("link_text", amVar.f);
                        }
                        if ((amVar.b & 16) != 0) {
                            ajVarF6.g("link_street_range", amVar.g);
                        }
                        if ((amVar.b & 32) != 0) {
                            bc bcVarB2 = bc.b(amVar.h);
                            if (bcVarB2 == null) {
                                bcVarB2 = bc.OUTDOOR;
                            }
                            ajVarF6.g("scene", bcVarB2);
                        }
                        ajVarF5.g(com.google.android.libraries.navigation.internal.b.b.b(i2, "Link$"), ajVarF6.toString());
                    }
                    string3 = ajVarF5.toString();
                }
                ajVarF2.g("AnnotationProperties", string3);
                for (int i3 = 0; i3 < bdVar.f.size(); i3++) {
                    au auVar = (au) bdVar.f.get(i3);
                    aj ajVarF7 = aj.f(auVar);
                    if ((auVar.b & 1) != 0) {
                        ajVarF7.g("pano_id", auVar.c);
                    }
                    if ((auVar.b & 2) != 0) {
                        ajVarF7.g("level_id", auVar.d);
                    }
                    if ((auVar.b & 4) != 0) {
                        ajVarF7.b("ordinal", auVar.e);
                    }
                    if ((auVar.b & 8) != 0) {
                        ajVarF7.g("text", auVar.f);
                    }
                    if ((auVar.b & 16) != 0) {
                        ajVarF7.g("abbreviation", auVar.g);
                    }
                    ajVarF2.g(com.google.android.libraries.navigation.internal.b.b.b(i3, "Level$"), ajVarF7.toString());
                }
                if ((bdVar.b & 8) != 0) {
                    aw awVar = bdVar.g;
                    if (awVar == null) {
                        awVar = aw.a;
                    }
                    aj ajVarF8 = aj.f(awVar);
                    if ((awVar.b & 1) != 0) {
                        ajVarF8.c("#depth_map", awVar.c.B().length);
                    }
                    if ((awVar.b & 2) != 0) {
                        ajVarF8.c("#pano_map", awVar.d.B().length);
                    }
                    ajVarF2.g(ExifInterface.TAG_MODEL, ajVarF8.toString());
                }
                string4 = ajVarF2.toString();
            }
            ajVarF.g("metadata", string4);
        }
        if ((clVar.b & 4) != 0) {
            ce ceVar = clVar.e;
            if (ceVar == null) {
                ceVar = ce.a;
            }
            ajVarF.c("#super_tile_data", ceVar.b.B().length);
        }
        if ((clVar.b & 8) != 0) {
            ck ckVar = clVar.f;
            if (ckVar == null) {
                ckVar = ck.a;
            }
            if (ckVar != null) {
                aj ajVarC3 = aj.f(ckVar).c("zoom", ckVar.b).c("num_horizontal_tiles", ckVar.c).c("num_vertical_tiles", ckVar.d);
                for (int i4 = 0; i4 < ckVar.e.size(); i4++) {
                    cj cjVar = (cj) ckVar.e.get(i4);
                    aj ajVarC4 = aj.f(cjVar).c("tile_xindex", cjVar.c).c("tile_yindex", cjVar.d).c("#tile_data", cjVar.f.B().length);
                    if ((cjVar.b & 4) != 0) {
                        ca caVarB = ca.b(cjVar.e);
                        if (caVarB == null) {
                            caVarB = ca.FRONT;
                        }
                        ajVarC4.g(OptionalModuleUtils.FACE, caVarB);
                    }
                    ajVarC3.g(com.google.android.libraries.navigation.internal.b.b.b(i4, "Tile$"), ajVarC4.toString());
                }
                string5 = ajVarC3.toString();
            }
            ajVarF.g("tiles", string5);
        }
        if ((clVar.b & 16) != 0) {
            cg cgVar = clVar.g;
            if (cgVar == null) {
                cgVar = cg.a;
            }
            ajVarF.g("Thumbnail", aj.f(cgVar).c("width", cgVar.b).c("height", cgVar.c).c("#thumbnail_data", cgVar.d.B().length).toString());
        }
        if ((clVar.b & 32) != 0) {
            cc ccVar = clVar.h;
            if (ccVar == null) {
                ccVar = cc.a;
            }
            ajVarF.g("NavigationImage", aj.f(ccVar).c("width", ccVar.b).c("height", ccVar.c).c("#image_data", ccVar.d.B().length).toString());
        }
        if ((clVar.b & 64) != 0) {
            ajVarF.g("signature", clVar.i);
        }
        if ((clVar.b & 128) != 0) {
            ajVarF.e("throttled", clVar.j);
        }
        ajVarF.toString();
    }
}
