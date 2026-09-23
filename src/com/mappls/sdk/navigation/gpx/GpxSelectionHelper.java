package com.mappls.sdk.navigation.gpx;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mappls.sdk.navigation.NavigationContext;
import com.mappls.sdk.navigation.NavigationFormatter;
import com.mappls.sdk.navigation.R;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import com.mappls.sdk.navigation.c;
import com.mappls.sdk.navigation.g;
import com.mappls.sdk.navigation.h;
import com.mappls.sdk.navigation.n;
import com.mappls.sdk.navigation.s;
import com.mappls.sdk.navigation.util.SavingTrackHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class GpxSelectionHelper {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String COLOR = "color";
    private static final String CURRENT_TRACK = "currentTrack";
    private static final String FILE = "file";

    /* JADX INFO: renamed from: app, reason: collision with root package name */
    private Context f710app;
    private SavingTrackHelper savingTrackHelper;
    private List<SelectedGpxFile> selectedGPXFiles = new ArrayList();

    public static class SelectedGpxFile {
        private int color;
        private List<a> displayGroups;
        private GPXUtilities.GPXFile gpxFile;
        private boolean routePoints;
        private boolean showCurrentTrack;
        private GPXUtilities.GPXTrackAnalysis trackAnalysis;
        public boolean notShowNavigationDialog = false;
        private long modifiedTime = -1;
        private List<GPXUtilities.f> processedPointsToDisplay = new ArrayList();

        private void update() {
            GPXUtilities.GPXFile gPXFile = this.gpxFile;
            this.modifiedTime = gPXFile.modifiedTime;
            this.trackAnalysis = gPXFile.getAnalysis(com.mappls.sdk.navigation.util.a.a(gPXFile.path) ? System.currentTimeMillis() : new File(this.gpxFile.path).lastModified());
            this.displayGroups = null;
        }

        public int getColor() {
            return this.color;
        }

        public List<a> getDisplayGroups() {
            if (this.modifiedTime != this.gpxFile.modifiedTime) {
                update();
            }
            return this.displayGroups;
        }

        public GPXUtilities.GPXFile getGpxFile() {
            return this.gpxFile;
        }

        public GPXUtilities.GPXFile getModifiableGpxFile() {
            return this.gpxFile;
        }

        public List<GPXUtilities.f> getModifiablePointsToDisplay() {
            return this.processedPointsToDisplay;
        }

        public List<GPXUtilities.f> getPointsToDisplay() {
            return this.processedPointsToDisplay;
        }

        public GPXUtilities.GPXTrackAnalysis getTrackAnalysis() {
            if (this.modifiedTime != this.gpxFile.modifiedTime) {
                update();
            }
            return this.trackAnalysis;
        }

        public boolean isRoutePoints() {
            return this.routePoints;
        }

        public boolean isShowCurrentTrack() {
            return this.showCurrentTrack;
        }

        public void processPoints() {
            update();
            List<GPXUtilities.f> listProccessPoints = this.gpxFile.proccessPoints();
            this.processedPointsToDisplay = listProccessPoints;
            if (listProccessPoints.isEmpty()) {
                List<GPXUtilities.f> listProcessRoutePoints = this.gpxFile.processRoutePoints();
                this.processedPointsToDisplay = listProcessRoutePoints;
                this.routePoints = !listProcessRoutePoints.isEmpty();
            }
        }

        public void setDisplayGroups(List<a> list) {
            if (this.modifiedTime != this.gpxFile.modifiedTime) {
                update();
            }
            this.displayGroups = list;
        }

        public void setGpxFile(GPXUtilities.GPXFile gPXFile) {
            this.gpxFile = gPXFile;
            if (gPXFile.tracks.size() > 0) {
                this.color = gPXFile.tracks.get(0).getColor(0);
            }
            processPoints();
        }

        public void setShowCurrentTrack(boolean z) {
            this.showCurrentTrack = z;
        }
    }

    public static class a {
        private GPXUtilities.Track b;
        private ArrayList a = new ArrayList();
        private double c = -1.0d;
        private int d = -1;

        public final ArrayList a() {
            return this.a;
        }

        public final void a(GPXUtilities.Track track) {
            this.b = track;
        }

        public final double b() {
            return this.c;
        }

        public final boolean c() {
            return this.c > 0.0d;
        }

        public final boolean d() {
            return this.d > 0;
        }
    }

    public static class b {
        public String a;
    }

    public GpxSelectionHelper(Context context, SavingTrackHelper savingTrackHelper) {
        this.f710app = context;
        this.savingTrackHelper = savingTrackHelper;
    }

    private static String formatSecondarySplitName(double d, a aVar, Context context) {
        return aVar.c() ? com.mappls.sdk.navigation.util.a.a((int) d, NavigationContext.getNavigationContext().a()) : NavigationFormatter.getFormattedDistance((float) d, context);
    }

    private static String formatSplitName(double d, a aVar, Context context) {
        int i;
        if (!aVar.c()) {
            return com.mappls.sdk.navigation.util.a.a((int) d, NavigationContext.getNavigationContext().a());
        }
        if (((s.EnumC0101s) NavigationContext.getNavigationContext().k().C0.get()) != s.EnumC0101s.KILOMETERS_AND_METERS) {
            return NavigationFormatter.getFormattedDistance((float) d, context);
        }
        double dB = aVar.b();
        if (dB < 100.0d) {
            i = 2;
        } else {
            i = dB < 1000.0d ? 1 : 0;
        }
        int i2 = (int) (0.5d + d);
        if (i2 % 1000 > 1 && i < 1) {
            i = 1;
        }
        return NavigationFormatter.getFormattedRoundDistanceKm((float) d, (i2 % 100 <= 1 || i >= 2) ? i : 2, context);
    }

    private String getString(int i, Object... objArr) {
        return this.f710app.getString(i, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:18:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:20:0x00af  */
    /* JADX WARN: Code duplicated, block: B:21:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:24:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:27:0x010c  */
    /* JADX WARN: Code duplicated, block: B:30:0x0114  */
    /* JADX WARN: Code duplicated, block: B:33:0x011b  */
    /* JADX WARN: Code duplicated, block: B:35:0x0121  */
    /* JADX WARN: Code duplicated, block: B:38:0x0129  */
    /* JADX WARN: Code duplicated, block: B:42:0x0153  */
    /* JADX WARN: Code duplicated, block: B:44:0x0159  */
    /* JADX WARN: Code duplicated, block: B:48:0x0178  */
    /* JADX WARN: Code duplicated, block: B:50:0x017e  */
    /* JADX WARN: Code duplicated, block: B:54:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:75:0x0210 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:20:0x00af, please report this as an issue */
    public static void processGroupTrack(Context context, a aVar) {
        GPXUtilities.GPXTrackAnalysis[] gPXTrackAnalysisArr;
        Object[] array;
        int length;
        GPXUtilities.GPXTrackAnalysis gPXTrackAnalysis;
        b bVar;
        String string;
        int i;
        long j;
        ArrayList arrayListA = aVar.a();
        String strA = com.mappls.sdk.navigation.util.a.a(ContextCompat.getColor(context, R.color.mappls_gpx_time_span_color));
        String strA2 = com.mappls.sdk.navigation.util.a.a(ContextCompat.getColor(context, R.color.mappls_gpx_speed));
        String strA3 = com.mappls.sdk.navigation.util.a.a(ContextCompat.getColor(context, R.color.mappls_gpx_altitude_asc));
        String strA4 = com.mappls.sdk.navigation.util.a.a(ContextCompat.getColor(context, R.color.mappls_gpx_altitude_desc));
        String strA5 = com.mappls.sdk.navigation.util.a.a(ContextCompat.getColor(context, R.color.mappls_gpx_distance_color));
        Iterator<GPXUtilities.f> it2 = aVar.b.segments.iterator();
        while (it2.hasNext()) {
            GPXUtilities.f next = it2.next();
            if (next.a.size() != 0) {
                int i2 = 0;
                boolean z = true;
                if (aVar.c > 0.0d) {
                    List<GPXUtilities.GPXTrackAnalysis> listA = next.a(aVar.c);
                    array = listA.toArray(new GPXUtilities.GPXTrackAnalysis[listA.size()]);
                } else {
                    if (aVar.d > 0) {
                        List<GPXUtilities.GPXTrackAnalysis> listA2 = next.a(aVar.d);
                        array = listA2.toArray(new GPXUtilities.GPXTrackAnalysis[listA2.size()]);
                    } else {
                        gPXTrackAnalysisArr = new GPXUtilities.GPXTrackAnalysis[]{GPXUtilities.GPXTrackAnalysis.segment(0L, next)};
                        z = false;
                    }
                    length = gPXTrackAnalysisArr.length;
                    while (i2 < length) {
                        gPXTrackAnalysis = gPXTrackAnalysisArr[i2];
                        bVar = new b();
                        Iterator<GPXUtilities.f> it3 = it2;
                        GPXUtilities.GPXTrackAnalysis[] gPXTrackAnalysisArr2 = gPXTrackAnalysisArr;
                        if (z) {
                            bVar.a = formatSplitName(gPXTrackAnalysis.metricEnd, aVar, context);
                            bVar.a += " (" + formatSecondarySplitName(gPXTrackAnalysis.secondaryMetricEnd, aVar, context) + ") ";
                        }
                        com.mappls.sdk.navigation.helpers.a.a(context, gPXTrackAnalysis);
                        string = "";
                        if (!aVar.c()) {
                            StringBuilder sbA = h.a("");
                            sbA.append(com.mappls.sdk.navigation.helpers.a.b(strA5, NavigationFormatter.getFormattedDistance(gPXTrackAnalysis.totalDistance, context)));
                            string = sbA.toString();
                        }
                        String str = strA5;
                        if (gPXTrackAnalysis.timeSpan <= 0) {
                            i = i2;
                            if (gPXTrackAnalysis.timeMoving > 0) {
                            }
                            if (gPXTrackAnalysis.isSpeedSpecified()) {
                                if (string.length() != 0) {
                                    string = n.a(string, ", ");
                                }
                                StringBuilder sbA2 = h.a(string);
                                sbA2.append(com.mappls.sdk.navigation.helpers.a.b(strA2, NavigationFormatter.getFormattedSpeed(gPXTrackAnalysis.avgSpeed, context)));
                                string = sbA2.toString();
                            }
                            if (gPXTrackAnalysis.isElevationSpecified()) {
                                if (string.length() != 0) {
                                    string = n.a(string, ", ");
                                }
                                StringBuilder sbA3 = h.a(string);
                                sbA3.append(com.mappls.sdk.navigation.helpers.a.b(strA4, NavigationFormatter.getFormattedAlt(gPXTrackAnalysis.minElevation, context)));
                                StringBuilder sbA4 = h.a(n.a(sbA3.toString(), " - "));
                                sbA4.append(com.mappls.sdk.navigation.helpers.a.b(strA3, NavigationFormatter.getFormattedAlt(gPXTrackAnalysis.maxElevation, context)));
                                string = sbA4.toString();
                            }
                            if (!gPXTrackAnalysis.isElevationSpecified() && (gPXTrackAnalysis.diffElevationUp > 3.0d || gPXTrackAnalysis.diffElevationDown > 3.0d)) {
                                if (string.length() != 0) {
                                    string = n.a(string, ", ");
                                }
                                if (gPXTrackAnalysis.diffElevationDown > 3.0d) {
                                    StringBuilder sbA5 = h.a(string);
                                    StringBuilder sbA6 = h.a(" ↓ ");
                                    sbA6.append(NavigationFormatter.getFormattedAlt(gPXTrackAnalysis.diffElevationDown, context));
                                    sbA5.append(com.mappls.sdk.navigation.helpers.a.b(strA4, sbA6.toString()));
                                }
                                if (gPXTrackAnalysis.diffElevationUp > 3.0d) {
                                    StringBuilder sbA7 = h.a(" ↑ ");
                                    sbA7.append(NavigationFormatter.getFormattedAlt(gPXTrackAnalysis.diffElevationUp, context));
                                    com.mappls.sdk.navigation.helpers.a.b(strA3, sbA7.toString());
                                }
                            }
                            arrayListA.add(bVar);
                            i2 = i + 1;
                            it2 = it3;
                            gPXTrackAnalysisArr = gPXTrackAnalysisArr2;
                            length = length;
                            strA5 = str;
                        } else {
                            i = i2;
                        }
                        if (!aVar.d()) {
                            j = gPXTrackAnalysis.timeMoving;
                            if (j == 0) {
                                j = gPXTrackAnalysis.timeSpan;
                            }
                            if (string.length() != 0) {
                                string = n.a(string, ", ");
                            }
                            StringBuilder sbA8 = h.a(string);
                            sbA8.append(com.mappls.sdk.navigation.helpers.a.b(strA, com.mappls.sdk.navigation.util.a.a((int) (j / 1000), NavigationContext.getNavigationContext().a())));
                            string = sbA8.toString();
                        }
                        if (gPXTrackAnalysis.isSpeedSpecified()) {
                            if (string.length() != 0) {
                                string = n.a(string, ", ");
                            }
                            StringBuilder sbA9 = h.a(string);
                            sbA9.append(com.mappls.sdk.navigation.helpers.a.b(strA2, NavigationFormatter.getFormattedSpeed(gPXTrackAnalysis.avgSpeed, context)));
                            string = sbA9.toString();
                        }
                        if (gPXTrackAnalysis.isElevationSpecified()) {
                            if (string.length() != 0) {
                                string = n.a(string, ", ");
                            }
                            StringBuilder sbA10 = h.a(string);
                            sbA10.append(com.mappls.sdk.navigation.helpers.a.b(strA4, NavigationFormatter.getFormattedAlt(gPXTrackAnalysis.minElevation, context)));
                            StringBuilder sbA11 = h.a(n.a(sbA10.toString(), " - "));
                            sbA11.append(com.mappls.sdk.navigation.helpers.a.b(strA3, NavigationFormatter.getFormattedAlt(gPXTrackAnalysis.maxElevation, context)));
                            string = sbA11.toString();
                        }
                        if (!gPXTrackAnalysis.isElevationSpecified()) {
                        }
                        arrayListA.add(bVar);
                        i2 = i + 1;
                        it2 = it3;
                        gPXTrackAnalysisArr = gPXTrackAnalysisArr2;
                        length = length;
                        strA5 = str;
                    }
                }
                gPXTrackAnalysisArr = (GPXUtilities.GPXTrackAnalysis[]) array;
                length = gPXTrackAnalysisArr.length;
                while (i2 < length) {
                    gPXTrackAnalysis = gPXTrackAnalysisArr[i2];
                    bVar = new b();
                    Iterator<GPXUtilities.f> it4 = it2;
                    GPXUtilities.GPXTrackAnalysis[] gPXTrackAnalysisArr3 = gPXTrackAnalysisArr;
                    if (z) {
                        bVar.a = formatSplitName(gPXTrackAnalysis.metricEnd, aVar, context);
                        bVar.a += " (" + formatSecondarySplitName(gPXTrackAnalysis.secondaryMetricEnd, aVar, context) + ") ";
                    }
                    com.mappls.sdk.navigation.helpers.a.a(context, gPXTrackAnalysis);
                    string = "";
                    if (!aVar.c()) {
                        StringBuilder sbA12 = h.a("");
                        sbA12.append(com.mappls.sdk.navigation.helpers.a.b(strA5, NavigationFormatter.getFormattedDistance(gPXTrackAnalysis.totalDistance, context)));
                        string = sbA12.toString();
                    }
                    String str2 = strA5;
                    if (gPXTrackAnalysis.timeSpan <= 0) {
                        i = i2;
                        if (gPXTrackAnalysis.timeMoving > 0) {
                        }
                        if (gPXTrackAnalysis.isSpeedSpecified()) {
                            if (string.length() != 0) {
                                string = n.a(string, ", ");
                            }
                            StringBuilder sbA13 = h.a(string);
                            sbA13.append(com.mappls.sdk.navigation.helpers.a.b(strA2, NavigationFormatter.getFormattedSpeed(gPXTrackAnalysis.avgSpeed, context)));
                            string = sbA13.toString();
                        }
                        if (gPXTrackAnalysis.isElevationSpecified()) {
                            if (string.length() != 0) {
                                string = n.a(string, ", ");
                            }
                            StringBuilder sbA14 = h.a(string);
                            sbA14.append(com.mappls.sdk.navigation.helpers.a.b(strA4, NavigationFormatter.getFormattedAlt(gPXTrackAnalysis.minElevation, context)));
                            StringBuilder sbA15 = h.a(n.a(sbA14.toString(), " - "));
                            sbA15.append(com.mappls.sdk.navigation.helpers.a.b(strA3, NavigationFormatter.getFormattedAlt(gPXTrackAnalysis.maxElevation, context)));
                            string = sbA15.toString();
                        }
                        if (!gPXTrackAnalysis.isElevationSpecified()) {
                        }
                        arrayListA.add(bVar);
                        i2 = i + 1;
                        it2 = it4;
                        gPXTrackAnalysisArr = gPXTrackAnalysisArr3;
                        length = length;
                        strA5 = str2;
                    } else {
                        i = i2;
                    }
                    if (!aVar.d()) {
                        j = gPXTrackAnalysis.timeMoving;
                        if (j == 0) {
                            j = gPXTrackAnalysis.timeSpan;
                        }
                        if (string.length() != 0) {
                            string = n.a(string, ", ");
                        }
                        StringBuilder sbA16 = h.a(string);
                        sbA16.append(com.mappls.sdk.navigation.helpers.a.b(strA, com.mappls.sdk.navigation.util.a.a((int) (j / 1000), NavigationContext.getNavigationContext().a())));
                        string = sbA16.toString();
                    }
                    if (gPXTrackAnalysis.isSpeedSpecified()) {
                        if (string.length() != 0) {
                            string = n.a(string, ", ");
                        }
                        StringBuilder sbA17 = h.a(string);
                        sbA17.append(com.mappls.sdk.navigation.helpers.a.b(strA2, NavigationFormatter.getFormattedSpeed(gPXTrackAnalysis.avgSpeed, context)));
                        string = sbA17.toString();
                    }
                    if (gPXTrackAnalysis.isElevationSpecified()) {
                        if (string.length() != 0) {
                            string = n.a(string, ", ");
                        }
                        StringBuilder sbA18 = h.a(string);
                        sbA18.append(com.mappls.sdk.navigation.helpers.a.b(strA4, NavigationFormatter.getFormattedAlt(gPXTrackAnalysis.minElevation, context)));
                        StringBuilder sbA19 = h.a(n.a(sbA18.toString(), " - "));
                        sbA19.append(com.mappls.sdk.navigation.helpers.a.b(strA3, NavigationFormatter.getFormattedAlt(gPXTrackAnalysis.maxElevation, context)));
                        string = sbA19.toString();
                    }
                    if (!gPXTrackAnalysis.isElevationSpecified()) {
                    }
                    arrayListA.add(bVar);
                    i2 = i + 1;
                    it2 = it4;
                    gPXTrackAnalysisArr = gPXTrackAnalysisArr3;
                    length = length;
                    strA5 = str2;
                }
            }
        }
    }

    private void saveCurrentSelections() {
        JSONArray jSONArray = new JSONArray();
        for (SelectedGpxFile selectedGpxFile : this.selectedGPXFiles) {
            if (selectedGpxFile.gpxFile != null && !selectedGpxFile.notShowNavigationDialog) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (selectedGpxFile.isShowCurrentTrack()) {
                        jSONObject.put(CURRENT_TRACK, true);
                    } else if (!com.mappls.sdk.navigation.util.a.a(selectedGpxFile.gpxFile.path)) {
                        jSONObject.put("file", selectedGpxFile.gpxFile.path);
                        if (selectedGpxFile.gpxFile.getColor(0) != 0) {
                            jSONObject.put("color", com.mappls.sdk.navigation.util.a.a(selectedGpxFile.gpxFile.getColor(0)));
                        }
                    }
                } catch (JSONException e) {
                    NavigationLogger.d(e);
                }
                jSONArray.put(jSONObject);
            }
        }
        NavigationContext.getNavigationContext().k().i0.set(jSONArray.toString());
    }

    private SelectedGpxFile selectGpxFileImpl(GPXUtilities.GPXFile gPXFile, boolean z, boolean z2) {
        SelectedGpxFile currentTrack;
        boolean zContains;
        if (gPXFile == null || !gPXFile.showCurrentTrack) {
            SelectedGpxFile selectedFileByPath = getSelectedFileByPath(gPXFile.path);
            boolean z3 = selectedFileByPath != null;
            if (z && selectedFileByPath == null) {
                selectedFileByPath = new SelectedGpxFile();
                selectedFileByPath.setGpxFile(gPXFile);
                selectedFileByPath.notShowNavigationDialog = z2;
            }
            currentTrack = selectedFileByPath;
            zContains = z3;
        } else {
            currentTrack = this.savingTrackHelper.getCurrentTrack();
            currentTrack.notShowNavigationDialog = z2;
            zContains = this.selectedGPXFiles.contains(currentTrack);
        }
        if (zContains != z) {
            if (z) {
                this.selectedGPXFiles.add(currentTrack);
            } else {
                this.selectedGPXFiles.remove(currentTrack);
            }
        }
        return currentTrack;
    }

    public void clearAllGpxFileToShow() {
        this.selectedGPXFiles.clear();
        saveCurrentSelections();
    }

    public List<a> collectDisplayGroups(GPXUtilities.GPXFile gPXFile) {
        String strReplace;
        ArrayList arrayList = new ArrayList();
        String strSubstring = gPXFile.path;
        int i = 0;
        if (gPXFile.showCurrentTrack) {
            strReplace = getString(R.string.mappls_shared_string_currently_recording_track, new Object[0]);
        } else {
            int iLastIndexOf = strSubstring.lastIndexOf(47);
            if (iLastIndexOf >= 0) {
                strSubstring = strSubstring.substring(iLastIndexOf + 1);
            }
            int iLastIndexOf2 = strSubstring.lastIndexOf(92);
            if (iLastIndexOf2 >= 0) {
                strSubstring = strSubstring.substring(iLastIndexOf2 + 1);
            }
            if (strSubstring.toLowerCase().endsWith(".gpx")) {
                strSubstring = strSubstring.substring(0, strSubstring.length() - 4);
            }
            strReplace = strSubstring.replace('_', ' ');
        }
        if (gPXFile.tracks.size() > 0) {
            int i2 = 1;
            for (GPXUtilities.Track track : gPXFile.tracks) {
                a aVar = new a();
                track.getColor(gPXFile.getColor(0));
                aVar.a(track);
                StringBuilder sb = new StringBuilder();
                int i3 = i2 + 1;
                sb.append(i2);
                sb.append("");
                String string = sb.toString();
                int i4 = R.string.mappls_gpx_selection_track;
                if (gPXFile.tracks.size() == 1) {
                    string = "";
                }
                getString(i4, strReplace, string);
                arrayList.add(aVar);
                processGroupTrack(this.f710app, aVar);
                i2 = i3;
            }
        }
        if (gPXFile.routes.size() > 0) {
            int i5 = 0;
            for (GPXUtilities.Route route : gPXFile.routes) {
                a aVar2 = new a();
                getString(R.string.mappls_gpx_selection_number_of_points, strReplace, Integer.valueOf(route.points.size()));
                StringBuilder sb2 = new StringBuilder();
                int i6 = i5 + 1;
                sb2.append(i5);
                sb2.append("");
                String string2 = sb2.toString();
                int i7 = R.string.mappls_gpx_selection_route_points;
                if (gPXFile.routes.size() == 1) {
                    string2 = "";
                }
                getString(i7, strReplace, string2);
                arrayList.add(aVar2);
                ArrayList arrayListA = aVar2.a();
                int i8 = 0;
                for (GPXUtilities.g gVar : route.points) {
                    b bVar = new b();
                    String str = gVar.f;
                    i8++;
                    if (com.mappls.sdk.navigation.util.a.a(gVar.c)) {
                        getString(R.string.mappls_gpx_selection_point, i8 + "");
                    }
                    arrayListA.add(bVar);
                }
                i5 = i6;
            }
        }
        if (gPXFile.points.size() > 0) {
            a aVar3 = new a();
            getString(R.string.mappls_gpx_selection_number_of_points, Integer.valueOf(gPXFile.points.size()));
            getString(R.string.mappls_gpx_selection_points, strReplace);
            arrayList.add(aVar3);
            ArrayList arrayListA2 = aVar3.a();
            for (GPXUtilities.g gVar2 : gPXFile.points) {
                b bVar2 = new b();
                String str2 = gVar2.f;
                i++;
                if (com.mappls.sdk.navigation.util.a.a(gVar2.c)) {
                    getString(R.string.mappls_gpx_selection_point, i + "");
                }
                arrayListA2.add(bVar2);
            }
        }
        return arrayList;
    }

    public String getGpxDescription() {
        if (this.selectedGPXFiles.size() != 1) {
            if (this.selectedGPXFiles.size() == 0) {
                return null;
            }
            return this.f710app.getResources().getString(R.string.mappls_number_of_gpx_files_selected_pattern, Integer.valueOf(this.selectedGPXFiles.size()));
        }
        if (this.selectedGPXFiles.get(0).getGpxFile() == NavigationContext.getNavigationContext().j().getCurrentGpx()) {
            return this.f710app.getResources().getString(R.string.mappls_current_track);
        }
        String name = new File(this.selectedGPXFiles.get(0).getGpxFile().path).getName();
        int iIndexOf = name.indexOf(46);
        return iIndexOf >= 0 ? name.substring(0, iIndexOf) : name;
    }

    public SelectedGpxFile getSelectedCurrentRecordingTrack() {
        for (SelectedGpxFile selectedGpxFile : this.selectedGPXFiles) {
            if (selectedGpxFile.isShowCurrentTrack()) {
                return selectedGpxFile;
            }
        }
        return null;
    }

    public SelectedGpxFile getSelectedFileByName(String str) {
        for (SelectedGpxFile selectedGpxFile : this.selectedGPXFiles) {
            if (selectedGpxFile.getGpxFile().path.endsWith(RemoteSettings.FORWARD_SLASH_STRING + str)) {
                return selectedGpxFile;
            }
        }
        return null;
    }

    public SelectedGpxFile getSelectedFileByPath(String str) {
        for (SelectedGpxFile selectedGpxFile : this.selectedGPXFiles) {
            if (selectedGpxFile.getGpxFile().path.equals(str)) {
                return selectedGpxFile;
            }
        }
        return null;
    }

    public SelectedGpxFile getSelectedGPXFile(GPXUtilities.g gVar) {
        for (SelectedGpxFile selectedGpxFile : this.selectedGPXFiles) {
            if (selectedGpxFile.getGpxFile().points.contains(gVar)) {
                return selectedGpxFile;
            }
        }
        return null;
    }

    public List<SelectedGpxFile> getSelectedGPXFiles() {
        return this.selectedGPXFiles;
    }

    public boolean isShowingAnyGpxFiles() {
        return !this.selectedGPXFiles.isEmpty();
    }

    public void loadGPXTracks(g gVar) {
        String str = (String) NavigationContext.getNavigationContext().k().i0.get();
        if (com.mappls.sdk.navigation.util.a.a(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            boolean z = false;
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.has("file")) {
                    File file = new File(jSONObject.getString("file"));
                    if (gVar != null) {
                        getString(R.string.mappls_loading_smth, file.getName());
                        ((c) gVar).a(c.d.a);
                    }
                    GPXUtilities.GPXFile gPXFileLoadGPXFile = GPXUtilities.loadGPXFile(this.f710app, file);
                    if (jSONObject.has("color")) {
                        gPXFileLoadGPXFile.setColor(com.mappls.sdk.navigation.util.a.b(jSONObject.getString("color")));
                    }
                    if (gPXFileLoadGPXFile.warning != null) {
                        z = true;
                    } else {
                        selectGpxFile(gPXFileLoadGPXFile, true, false);
                    }
                } else if (jSONObject.has(CURRENT_TRACK)) {
                    this.selectedGPXFiles.add(this.savingTrackHelper.getCurrentTrack());
                }
            }
            if (z) {
                saveCurrentSelections();
            }
        } catch (Exception e) {
            NavigationContext.getNavigationContext().k().i0.set("");
            NavigationLogger.d(e);
        }
    }

    public SelectedGpxFile selectGpxFile(GPXUtilities.GPXFile gPXFile, boolean z, boolean z2) {
        SelectedGpxFile selectedGpxFileSelectGpxFileImpl = selectGpxFileImpl(gPXFile, z, z2);
        saveCurrentSelections();
        return selectedGpxFileSelectGpxFileImpl;
    }

    public void setGpxFileToDisplay(GPXUtilities.GPXFile... gPXFileArr) {
        for (GPXUtilities.GPXFile gPXFile : gPXFileArr) {
            selectGpxFileImpl(gPXFile, true, false);
        }
        saveCurrentSelections();
    }
}
