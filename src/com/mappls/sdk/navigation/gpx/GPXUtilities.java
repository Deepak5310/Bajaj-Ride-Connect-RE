package com.mappls.sdk.navigation.gpx;

import android.content.Context;
import android.graphics.Color;
import android.util.Xml;
import com.mappls.sdk.navigation.NavLocation;
import com.mappls.sdk.navigation.R;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import com.mappls.sdk.navigation.data.LocationPoint;
import com.mappls.sdk.navigation.h;
import com.mappls.sdk.navigation.util.SavingTrackHelper;
import com.mappls.sdk.navigation.y;
import j$.util.DesugarTimeZone;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;
import org.apache.commons.lang3.StringUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes4.dex */
public class GPXUtilities {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String GPX_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static final NumberFormat latLonFormat = new DecimalFormat("0.00#####", new DecimalFormatSymbols(new Locale("EN", "US")));
    private static Charset UTF_8 = Charset.forName("UTF-8");

    public static class GPXFile extends c {
        public String author;
        public boolean showCurrentTrack;
        public List<Track> tracks = new ArrayList();
        public List<g> points = new ArrayList();
        public List<Route> routes = new ArrayList();
        public String warning = null;
        public String path = "";
        public long modifiedTime = 0;

        public g addWptPt(double d, double d2, long j, String str, String str2, String str3, int i) {
            g gVar = new g(Double.parseDouble(GPXUtilities.latLonFormat.format(d)), Double.parseDouble(GPXUtilities.latLonFormat.format(d2)), j, Double.NaN, 0.0d, Double.NaN);
            gVar.c = str2;
            gVar.e = str3;
            gVar.f = str;
            if (i != 0) {
                gVar.setColor(i);
            }
            this.points.add(gVar);
            this.modifiedTime = System.currentTimeMillis();
            return gVar;
        }

        public boolean deleteWptPt(g gVar) {
            this.modifiedTime = System.currentTimeMillis();
            return this.points.remove(gVar);
        }

        public g findPointToShow() {
            List<g> list;
            Object obj;
            Iterator<Track> it2 = this.tracks.iterator();
            while (it2.hasNext()) {
                for (f fVar : it2.next().segments) {
                    if (fVar.a.size() > 0) {
                        obj = fVar.a.get(0);
                        return (g) obj;
                    }
                }
            }
            Iterator<Route> it3 = this.routes.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    if (this.points.size() <= 0) {
                        return null;
                    }
                    list = this.points;
                    break;
                }
                Route next = it3.next();
                if (next.points.size() > 0) {
                    list = next.points;
                    break;
                }
            }
            obj = list.get(0);
            return (g) obj;
        }

        public GPXTrackAnalysis getAnalysis(long j) {
            GPXTrackAnalysis gPXTrackAnalysis = new GPXTrackAnalysis();
            gPXTrackAnalysis.wptPoints = this.points.size();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.tracks.size(); i++) {
                for (f fVar : this.tracks.get(i).segments) {
                    gPXTrackAnalysis.totalTracks++;
                    if (fVar.a.size() > 1) {
                        arrayList.add(new e(fVar));
                    }
                }
            }
            gPXTrackAnalysis.prepareInformation(j, (e[]) arrayList.toArray(new e[arrayList.size()]));
            return gPXTrackAnalysis;
        }

        public g getLastPoint() {
            if (this.tracks.size() <= 0) {
                return null;
            }
            List<Track> list = this.tracks;
            Track track = list.get(list.size() - 1);
            if (track.segments.size() <= 0) {
                return null;
            }
            List<f> list2 = track.segments;
            f fVar = list2.get(list2.size() - 1);
            if (fVar.a.size() <= 0) {
                return null;
            }
            ArrayList arrayList = fVar.a;
            return (g) arrayList.get(arrayList.size() - 1);
        }

        public boolean hasRtePt() {
            Iterator<Route> it2 = this.routes.iterator();
            while (it2.hasNext()) {
                if (it2.next().points.size() > 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasTrkPt() {
            Iterator<Track> it2 = this.tracks.iterator();
            while (it2.hasNext()) {
                Iterator<f> it3 = it2.next().segments.iterator();
                while (it3.hasNext()) {
                    if (it3.next().a.size() > 0) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean hasWptPt() {
            return this.points.size() > 0;
        }

        public boolean isCloudmadeRouteFile() {
            return "cloudmade".equalsIgnoreCase(this.author);
        }

        public boolean isEmpty() {
            Iterator<Track> it2 = this.tracks.iterator();
            while (it2.hasNext()) {
                List<f> list = it2.next().segments;
                if (list != null) {
                    Iterator<f> it3 = list.iterator();
                    while (it3.hasNext()) {
                        if (!it3.next().a.isEmpty()) {
                            return false;
                        }
                    }
                }
            }
            return this.points.isEmpty() && this.routes.isEmpty();
        }

        public List<f> proccessPoints() {
            ArrayList arrayList = new ArrayList();
            for (Track track : this.tracks) {
                int color = track.getColor(getColor(0));
                for (f fVar : track.segments) {
                    if (fVar.a.size() > 0) {
                        f fVar2 = new f();
                        arrayList.add(fVar2);
                        fVar2.a.addAll(fVar.a);
                        fVar2.setColor(color);
                    }
                }
            }
            return arrayList;
        }

        public List<f> processRoutePoints() {
            ArrayList arrayList = new ArrayList();
            if (this.routes.size() > 0) {
                for (Route route : this.routes) {
                    int color = route.getColor(getColor(0));
                    if (route.points.size() > 0) {
                        f fVar = new f();
                        arrayList.add(fVar);
                        fVar.a.addAll(route.points);
                        fVar.setColor(color);
                    }
                }
            }
            return arrayList;
        }

        public void updateWptPt(g gVar, double d, double d2, long j, String str, String str2, String str3, int i) {
            int iIndexOf = this.points.indexOf(gVar);
            double d3 = Double.parseDouble(GPXUtilities.latLonFormat.format(d));
            double d4 = Double.parseDouble(GPXUtilities.latLonFormat.format(d2));
            gVar.a = d3;
            gVar.b = d4;
            gVar.h = j;
            gVar.f = str;
            gVar.c = str2;
            gVar.e = str3;
            if (i != 0) {
                gVar.setColor(i);
            }
            if (iIndexOf != -1) {
                this.points.set(iIndexOf, gVar);
            }
            this.modifiedTime = System.currentTimeMillis();
        }
    }

    public static class GPXTrackAnalysis {
        public float avgSpeed;
        public g locationEnd;
        public g locationStart;
        public double metricEnd;
        public int points;
        public double secondaryMetricEnd;
        public float totalDistance = 0.0f;
        public int totalTracks = 0;
        public long startTime = Long.MAX_VALUE;
        public long endTime = Long.MIN_VALUE;
        public long timeSpan = 0;
        public long timeMoving = 0;
        public float totalDistanceMoving = 0.0f;
        public double diffElevationUp = 0.0d;
        public double diffElevationDown = 0.0d;
        public double avgElevation = 0.0d;
        public double minElevation = 99999.0d;
        public double maxElevation = -100.0d;
        public float maxSpeed = 0.0f;
        public int wptPoints = 0;

        public static GPXTrackAnalysis segment(long j, f fVar) {
            return new GPXTrackAnalysis().prepareInformation(j, new e(fVar));
        }

        public boolean isElevationSpecified() {
            return this.maxElevation != -100.0d;
        }

        public boolean isSpeedSpecified() {
            return this.avgSpeed > 0.0f;
        }

        public boolean isTimeMoving() {
            return this.timeMoving != 0;
        }

        public boolean isTimeSpecified() {
            long j = this.startTime;
            return (j == Long.MAX_VALUE || j == 0) ? false : true;
        }

        public GPXTrackAnalysis prepareInformation(long j, e... eVarArr) {
            float f;
            double d;
            boolean z;
            int i;
            e eVar;
            int i2;
            double dMax;
            e[] eVarArr2 = eVarArr;
            float[] fArr = new float[1];
            this.points = 0;
            int length = eVarArr2.length;
            double d2 = 0.0d;
            int i3 = 0;
            int i4 = 0;
            boolean z2 = false;
            int i5 = 0;
            float f2 = 0.0f;
            while (i5 < length) {
                e eVar2 = eVarArr2[i5];
                int i6 = eVar2.e - eVar2.c;
                int i7 = i6 + 2;
                int i8 = i5;
                this.metricEnd += eVar2.f;
                this.secondaryMetricEnd += eVar2.g;
                this.points += i7;
                z2 = z2;
                d2 = d2;
                double d3 = 99999.0d;
                double d4 = 99999.0d;
                double d5 = 99999.0d;
                double d6 = 5.0d;
                int i9 = 0;
                while (i9 < i7) {
                    g gVarA = eVar2.a(i9);
                    int i10 = i7;
                    if (i9 == 0 && this.locationStart == null) {
                        this.locationStart = gVarA;
                    }
                    int i11 = i6 + 1;
                    if (i9 == i11) {
                        this.locationEnd = gVarA;
                    }
                    long j2 = gVarA.h;
                    int i12 = length;
                    float[] fArr2 = fArr;
                    if (j2 != 0) {
                        this.startTime = Math.min(this.startTime, j2);
                        this.endTime = Math.max(this.endTime, j2);
                    }
                    double d7 = gVarA.i;
                    if (!Double.isNaN(d7)) {
                        f2 = (float) (((double) f2) + d7);
                        i3++;
                        this.minElevation = Math.min(d7, this.minElevation);
                        this.maxElevation = Math.max(d7, this.maxElevation);
                    }
                    int i13 = i3;
                    float f3 = f2;
                    float f4 = (float) gVarA.j;
                    if (f4 > 0.0f) {
                        d2 += (double) f4;
                        this.maxSpeed = Math.max(f4, this.maxSpeed);
                        i4++;
                    }
                    double d8 = d2;
                    int i14 = i4;
                    if (Double.isNaN(gVarA.i)) {
                        d = d8;
                        z = true;
                    } else {
                        if (d3 == 99999.0d) {
                            d3 = gVarA.i;
                            d4 = d3;
                            d5 = d4;
                            dMax = 5.0d;
                        } else {
                            dMax = d6;
                        }
                        double d9 = gVarA.i;
                        d = d8;
                        if (d9 > d4) {
                            if (!Double.isNaN(gVarA.k)) {
                                dMax = Math.max(dMax, gVarA.k * 2.0d);
                            }
                            d4 = d9;
                        } else if (d9 < d5) {
                            if (!Double.isNaN(gVarA.k)) {
                                dMax = Math.max(dMax, gVarA.k * 2.0d);
                            }
                            d5 = d9;
                        }
                        double d10 = gVarA.i;
                        z = true;
                        if (d10 <= d4 - dMax && z2) {
                            double d11 = d4 - d3;
                            if (d11 >= dMax) {
                                this.diffElevationUp += d11;
                            }
                            d5 = d10;
                            d6 = 5.0d;
                            d3 = d4;
                            z2 = false;
                        } else if (d10 < d5 + dMax || z2) {
                            d6 = dMax;
                        } else {
                            double d12 = d3 - d5;
                            if (d12 >= dMax) {
                                this.diffElevationDown += d12;
                            }
                            d4 = d10;
                            z2 = true;
                            d6 = 5.0d;
                            d3 = d5;
                        }
                        if (i9 == i11) {
                            double d13 = d4 - d3;
                            if (d13 >= d6) {
                                this.diffElevationUp += d13;
                            }
                            double d14 = d3 - d5;
                            if (d14 >= d6) {
                                this.diffElevationDown += d14;
                            }
                        }
                    }
                    boolean z3 = z2;
                    if (i9 > 0) {
                        g gVarA2 = eVar2.a(i9 - 1);
                        i = i9;
                        eVar = eVar2;
                        i2 = i12;
                        NavLocation.distanceBetween(gVarA2.a, gVarA2.b, gVarA.a, gVarA.b, fArr2);
                        float f5 = this.totalDistance;
                        float f6 = fArr2[0];
                        this.totalDistance = f5 + f6;
                        if (f4 > 0.0f) {
                            double d15 = f6;
                            long j3 = gVarA.h;
                            long j4 = gVarA2.h;
                            long j5 = j3 - j4;
                            if (d15 > j5 * 1.0E-4d && j3 != 0 && j4 != 0) {
                                this.timeMoving = j5 + this.timeMoving;
                                this.totalDistanceMoving += f6;
                            }
                        }
                    } else {
                        i = i9;
                        eVar = eVar2;
                        i2 = i12;
                    }
                    z2 = z3;
                    i9 = i + 1;
                    length = i2;
                    i3 = i13;
                    i7 = i10;
                    fArr = fArr2;
                    f2 = f3;
                    i4 = i14;
                    d2 = d;
                    eVar2 = eVar;
                }
                eVarArr2 = eVarArr;
                fArr = fArr;
                i5 = i8 + 1;
            }
            double d16 = d2;
            if (!isTimeSpecified()) {
                this.startTime = j;
                this.endTime = j;
            }
            this.timeSpan = this.endTime - this.startTime;
            if (i3 > 0) {
                this.avgElevation = f2 / i3;
            }
            if (i4 > 0) {
                long j6 = this.timeMoving;
                if (j6 > 0) {
                    this.avgSpeed = (this.totalDistanceMoving / j6) * 1000.0f;
                } else {
                    f = ((float) d16) / i4;
                }
                return this;
            }
            f = -1.0f;
            this.avgSpeed = f;
            return this;
        }
    }

    public static class Route extends c {
        public String name = null;
        public String desc = null;
        public List<g> points = new ArrayList();
    }

    public static class Track extends c {
        public String name = null;
        public String desc = null;
        public List<f> segments = new ArrayList();
    }

    final class a extends d {
        private float[] a;

        a() {
            super(0);
            this.a = new float[1];
        }

        @Override // com.mappls.sdk.navigation.gpx.GPXUtilities.d
        public final double a(g gVar, g gVar2) {
            NavLocation.distanceBetween(gVar.a, gVar.b, gVar2.a, gVar2.b, this.a);
            return this.a[0];
        }
    }

    final class b extends d {
        b() {
            super(0);
        }

        @Override // com.mappls.sdk.navigation.gpx.GPXUtilities.d
        public final double a(g gVar, g gVar2) {
            long j = gVar.h;
            if (j == 0) {
                return 0.0d;
            }
            long j2 = gVar2.h;
            if (j2 != 0) {
                return (int) Math.abs((j2 - j) / 1000);
            }
            return 0.0d;
        }
    }

    public static class c {
        Map<String, String> extensions = null;

        public int getColor(int i) {
            Map<String, String> map = this.extensions;
            if (map != null && map.containsKey("color")) {
                try {
                    return Color.parseColor(this.extensions.get("color").toUpperCase());
                } catch (IllegalArgumentException e) {
                    NavigationLogger.d(e);
                }
            }
            return i;
        }

        public Map<String, String> getExtensionsToRead() {
            Map<String, String> map = this.extensions;
            return map == null ? Collections.emptyMap() : map;
        }

        public Map<String, String> getExtensionsToWrite() {
            if (this.extensions == null) {
                this.extensions = new LinkedHashMap();
            }
            return this.extensions;
        }

        public void setColor(int i) {
            getExtensionsToWrite().put("color", com.mappls.sdk.navigation.util.a.a(i));
        }
    }

    private static abstract class d {
        private d() {
        }

        /* synthetic */ d(int i) {
            this();
        }

        public abstract double a(g gVar, g gVar2);
    }

    private static class e {
        f a;
        double b;
        int c;
        double d;
        int e;
        double f;
        double g;

        public e(f fVar) {
            this.d = 0.0d;
            this.c = 0;
            this.b = 0.0d;
            this.e = fVar.a.size() - 2;
            this.d = 1.0d;
            this.a = fVar;
        }

        public e(f fVar, int i, double d) {
            this.d = 0.0d;
            this.a = fVar;
            this.c = i;
            this.b = d;
        }

        private static double a(double d, double d2, double d3, double d4) {
            if (d == d3 || Double.isNaN(d)) {
                return d2;
            }
            return (d2 == d3 || Double.isNaN(d2)) ? d : ((d2 - d) * d4) + d;
        }

        private static g a(g gVar, g gVar2, double d) {
            long j = gVar.h;
            long j2 = gVar2.h;
            if (j == 0) {
                j = j2;
            } else if (j2 != 0) {
                j += (long) ((j2 - j) * d);
            }
            return new g(a(gVar.a, gVar2.a, -360.0d, d), a(gVar.b, gVar2.b, -360.0d, d), j, a(gVar.i, gVar2.i, 0.0d, d), a(gVar.j, gVar2.j, 0.0d, d), a(gVar.k, gVar2.k, 0.0d, d));
        }

        public final g a(int i) {
            int i2 = this.c;
            int i3 = i + i2;
            if (i == 0) {
                return this.b == 0.0d ? (g) this.a.a.get(i3) : a((g) this.a.a.get(i3), (g) this.a.a.get(i3 + 1), this.b);
            }
            if (i == (this.e - i2) + 1 && this.d != 1.0d) {
                return a((g) this.a.a.get(i3 - 1), (g) this.a.a.get(i3), this.d);
            }
            return (g) this.a.a.get(i3);
        }
    }

    public static class f extends c {
        public ArrayList a = new ArrayList();

        public final List<GPXTrackAnalysis> a(double d) {
            d distanceMetric = GPXUtilities.getDistanceMetric();
            d timeSplit = GPXUtilities.getTimeSplit();
            ArrayList arrayList = new ArrayList();
            GPXUtilities.splitSegment(distanceMetric, timeSplit, d, arrayList, this);
            return GPXUtilities.convert(arrayList);
        }

        public final List<GPXTrackAnalysis> a(int i) {
            d timeSplit = GPXUtilities.getTimeSplit();
            d distanceMetric = GPXUtilities.getDistanceMetric();
            double d = i;
            ArrayList arrayList = new ArrayList();
            GPXUtilities.splitSegment(timeSplit, distanceMetric, d, arrayList, this);
            return GPXUtilities.convert(arrayList);
        }
    }

    public static class g extends c implements LocationPoint {
        public double a;
        public double b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public long h;
        public double i;
        public double j;
        public double k;

        public g() {
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = 0L;
            this.i = Double.NaN;
            this.j = 0.0d;
            this.k = Double.NaN;
        }

        public g(double d, double d2, long j, double d3, double d4, double d5) {
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.a = d;
            this.b = d2;
            this.h = j;
            this.i = d3;
            this.j = d4;
            this.k = d5;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || g.class != obj.getClass()) {
                return false;
            }
            g gVar = (g) obj;
            return com.mappls.sdk.navigation.util.a.a(gVar.c, this.c) && com.mappls.sdk.navigation.util.a.a(gVar.e, this.e) && com.mappls.sdk.navigation.util.a.a(Double.valueOf(gVar.a), Double.valueOf(this.a)) && com.mappls.sdk.navigation.util.a.a(Double.valueOf(gVar.b), Double.valueOf(this.b)) && com.mappls.sdk.navigation.util.a.a(gVar.f, this.f);
        }

        @Override // com.mappls.sdk.navigation.data.LocationPoint
        public final double getLatitude() {
            return this.a;
        }

        @Override // com.mappls.sdk.navigation.data.LocationPoint
        public final double getLongitude() {
            return this.b;
        }

        @Override // com.mappls.sdk.navigation.data.LocationPoint
        public final com.mappls.sdk.navigation.data.a getPointDescription(Context context) {
            return new com.mappls.sdk.navigation.data.a("wpt", this.c);
        }

        public final int hashCode() {
            String str = this.c;
            int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            String str2 = this.e;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.g;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            double d = this.a;
            int iHashCode5 = (iHashCode4 + (d == 0.0d ? 0 : Double.valueOf(d).hashCode())) * 31;
            double d2 = this.b;
            return iHashCode5 + (d2 != 0.0d ? Double.valueOf(d2).hashCode() : 0);
        }
    }

    public static String asString(GPXFile gPXFile, Context context) {
        StringWriter stringWriter = new StringWriter();
        writeGpx(stringWriter, gPXFile, context);
        return stringWriter.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<GPXTrackAnalysis> convert(List<e> list) {
        ArrayList arrayList = new ArrayList();
        for (e eVar : list) {
            GPXTrackAnalysis gPXTrackAnalysis = new GPXTrackAnalysis();
            gPXTrackAnalysis.prepareInformation(0L, eVar);
            arrayList.add(gPXTrackAnalysis);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static d getDistanceMetric() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static d getTimeSplit() {
        return new b();
    }

    private static Reader getUTF8Reader(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        bufferedInputStream.mark(3);
        byte[] bArr = new byte[3];
        bufferedInputStream.read(bArr);
        if (bArr[0] != -17 || bArr[1] != -69 || bArr[2] != -65) {
            bufferedInputStream.reset();
        }
        return new InputStreamReader(bufferedInputStream, UTF_8);
    }

    public static GPXFile loadGPXFile(Context context, File file) {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    try {
                        GPXFile gPXFileLoadGPXFile = loadGPXFile(context, fileInputStream2);
                        gPXFileLoadGPXFile.path = file.getAbsolutePath();
                        try {
                            fileInputStream2.close();
                        } catch (IOException e2) {
                            NavigationLogger.e(e2);
                        }
                        try {
                            fileInputStream2.close();
                        } catch (IOException e3) {
                            NavigationLogger.e(e3);
                        }
                        return gPXFileLoadGPXFile;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                                NavigationLogger.e(e4);
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e5) {
                    e = e5;
                    fileInputStream = fileInputStream2;
                    NavigationLogger.e(e);
                    GPXFile gPXFile = new GPXFile();
                    gPXFile.path = file.getAbsolutePath();
                    NavigationLogger.e(e, "BadRequestError reading gpx", new Object[0]);
                    gPXFile.warning = context.getString(R.string.mappls_error_reading_gpx);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e6) {
                            NavigationLogger.e(e6);
                        }
                    }
                    return gPXFile;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e7) {
            e = e7;
        }
    }

    public static GPXFile loadGPXFile(Context context, InputStream inputStream) {
        Context context2;
        String str;
        String str2;
        GPXFile gPXFile;
        String str3;
        StringBuilder sb;
        String string;
        SimpleDateFormat simpleDateFormat;
        String str4;
        String str5;
        boolean z;
        String str6;
        String str7;
        SimpleDateFormat simpleDateFormat2;
        Throwable e2;
        String text;
        g gVar;
        String str8;
        c wptAttributes;
        List list;
        String str9 = "time";
        String str10 = SavingTrackHelper.TRACK_COL_HDOP;
        String str11 = StringUtils.SPACE;
        String str12 = "BadRequestError reading gpx";
        GPXFile gPXFile2 = new GPXFile();
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat(GPX_TIME_FORMAT, Locale.US);
        simpleDateFormat3.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        try {
            try {
                XmlPullParser xmlPullParserA = com.mappls.sdk.navigation.util.e.a();
                try {
                    xmlPullParserA.setInput(getUTF8Reader(inputStream));
                    Stack stack = new Stack();
                    stack.push(gPXFile2);
                    boolean z2 = false;
                    while (true) {
                        boolean z3 = z2;
                        while (true) {
                            int next = xmlPullParserA.next();
                            if (next == 1) {
                                return gPXFile2;
                            }
                            gPXFile2 = gPXFile2;
                            str11 = str11;
                            str12 = str12;
                            simpleDateFormat = simpleDateFormat3;
                            str4 = str9;
                            str5 = str10;
                            if (next == 2) {
                                try {
                                    Object objPeek = stack.peek();
                                    String name = xmlPullParserA.getName();
                                    if (z3) {
                                        z = z3;
                                        if (objPeek instanceof c) {
                                            String text2 = readText(xmlPullParserA, name);
                                            if (text2 != null) {
                                                ((c) objPeek).getExtensionsToWrite().put(name, text2);
                                                if (name.equals("speed") && (objPeek instanceof g)) {
                                                    try {
                                                        ((g) objPeek).j = Float.parseFloat(text2);
                                                    } catch (NumberFormatException e3) {
                                                        e2 = e3;
                                                        simpleDateFormat2 = simpleDateFormat;
                                                        str6 = str4;
                                                        str7 = str5;
                                                        NavigationLogger.e(e2);
                                                        simpleDateFormat = simpleDateFormat2;
                                                        str5 = str7;
                                                    }
                                                }
                                            }
                                            str6 = str4;
                                        }
                                    } else {
                                        z = z3;
                                    }
                                    if ((objPeek instanceof c) && name.equals("extensions")) {
                                        simpleDateFormat3 = simpleDateFormat;
                                        str9 = str4;
                                        str10 = str5;
                                        z3 = true;
                                    } else if (objPeek instanceof GPXFile) {
                                        if (xmlPullParserA.getName().equals("gpx")) {
                                            ((GPXFile) objPeek).author = xmlPullParserA.getAttributeValue("", "creator");
                                        }
                                        if (xmlPullParserA.getName().equals("trk")) {
                                            Track track = new Track();
                                            ((GPXFile) objPeek).tracks.add(track);
                                            stack.push(track);
                                        }
                                        if (xmlPullParserA.getName().equals("rte")) {
                                            Route route = new Route();
                                            ((GPXFile) objPeek).routes.add(route);
                                            stack.push(route);
                                        }
                                        if (xmlPullParserA.getName().equals("wpt")) {
                                            wptAttributes = parseWptAttributes(xmlPullParserA);
                                            list = ((GPXFile) objPeek).points;
                                            list.add(wptAttributes);
                                            break;
                                        }
                                        str6 = str4;
                                    } else {
                                        if (objPeek instanceof Route) {
                                            if (xmlPullParserA.getName().equals("name")) {
                                                ((Route) objPeek).name = readText(xmlPullParserA, "name");
                                            }
                                            if (xmlPullParserA.getName().equals("desc")) {
                                                ((Route) objPeek).desc = readText(xmlPullParserA, "desc");
                                            }
                                            if (xmlPullParserA.getName().equals("rtept")) {
                                                wptAttributes = parseWptAttributes(xmlPullParserA);
                                                list = ((Route) objPeek).points;
                                                list.add(wptAttributes);
                                                break;
                                            }
                                        } else if (objPeek instanceof Track) {
                                            if (xmlPullParserA.getName().equals("name")) {
                                                ((Track) objPeek).name = readText(xmlPullParserA, "name");
                                            }
                                            if (xmlPullParserA.getName().equals("desc")) {
                                                ((Track) objPeek).desc = readText(xmlPullParserA, "desc");
                                            }
                                            if (xmlPullParserA.getName().equals("trkseg")) {
                                                wptAttributes = new f();
                                                ((Track) objPeek).segments.add((f) wptAttributes);
                                                break;
                                            }
                                        } else if (objPeek instanceof f) {
                                            if (xmlPullParserA.getName().equals("trkpt")) {
                                                wptAttributes = parseWptAttributes(xmlPullParserA);
                                                ((f) objPeek).a.add(wptAttributes);
                                                break;
                                            }
                                        } else if (objPeek instanceof g) {
                                            if (xmlPullParserA.getName().equals("name")) {
                                                ((g) objPeek).c = readText(xmlPullParserA, "name");
                                            } else if (xmlPullParserA.getName().equals("desc")) {
                                                ((g) objPeek).f = readText(xmlPullParserA, "desc");
                                            } else if (xmlPullParserA.getName().equals("cmt")) {
                                                ((g) objPeek).g = readText(xmlPullParserA, "cmt");
                                            } else if (xmlPullParserA.getName().equals("link")) {
                                                ((g) objPeek).d = xmlPullParserA.getAttributeValue("", "href");
                                            } else {
                                                if (name.equals(SavingTrackHelper.POINT_COL_CATEGORY)) {
                                                    gVar = (g) objPeek;
                                                    str8 = SavingTrackHelper.POINT_COL_CATEGORY;
                                                } else if (name.equals("type")) {
                                                    if (((g) objPeek).e == null) {
                                                        gVar = (g) objPeek;
                                                        str8 = "type";
                                                    }
                                                } else if (xmlPullParserA.getName().equals("ele")) {
                                                    String text3 = readText(xmlPullParserA, "ele");
                                                    if (text3 != null) {
                                                        ((g) objPeek).i = Float.parseFloat(text3);
                                                    }
                                                } else {
                                                    str7 = str5;
                                                    if (xmlPullParserA.getName().equals(str7)) {
                                                        String text4 = readText(xmlPullParserA, str7);
                                                        if (text4 != null) {
                                                            try {
                                                                ((g) objPeek).k = Float.parseFloat(text4);
                                                            } catch (NumberFormatException e4) {
                                                                e2 = e4;
                                                                simpleDateFormat2 = simpleDateFormat;
                                                                str6 = str4;
                                                                NavigationLogger.e(e2);
                                                                simpleDateFormat = simpleDateFormat2;
                                                                str5 = str7;
                                                            }
                                                        }
                                                        str5 = str7;
                                                    } else {
                                                        str6 = str4;
                                                        if (xmlPullParserA.getName().equals(str6) && (text = readText(xmlPullParserA, str6)) != null) {
                                                            try {
                                                                simpleDateFormat2 = simpleDateFormat;
                                                                try {
                                                                    ((g) objPeek).h = simpleDateFormat2.parse(text).getTime();
                                                                } catch (ParseException e5) {
                                                                    e2 = e5;
                                                                    NavigationLogger.e(e2);
                                                                }
                                                            } catch (ParseException e6) {
                                                                e2 = e6;
                                                                simpleDateFormat2 = simpleDateFormat;
                                                            }
                                                            simpleDateFormat = simpleDateFormat2;
                                                        }
                                                        str5 = str7;
                                                    }
                                                    NavigationLogger.e(e2);
                                                    simpleDateFormat = simpleDateFormat2;
                                                    str5 = str7;
                                                }
                                                gVar.e = readText(xmlPullParserA, str8);
                                            }
                                        }
                                        str6 = str4;
                                    }
                                } catch (IOException e7) {
                                    e = e7;
                                    NavigationLogger.e(e, str12, new Object[0]);
                                    string = context.getString(R.string.mappls_error_reading_gpx) + str11 + e.getMessage();
                                    gPXFile = gPXFile2;
                                    gPXFile.warning = string;
                                    return gPXFile;
                                } catch (RuntimeException e8) {
                                    e = e8;
                                    context2 = context;
                                    gPXFile = gPXFile2;
                                    str = str11;
                                    str3 = str12;
                                    NavigationLogger.e(e, str3, new Object[0]);
                                    sb = new StringBuilder();
                                    sb.append(context2.getString(R.string.mappls_error_reading_gpx));
                                    sb.append(str);
                                    sb.append(e.getMessage());
                                    string = sb.toString();
                                    gPXFile.warning = string;
                                    return gPXFile;
                                } catch (XmlPullParserException e9) {
                                    e = e9;
                                    context2 = context;
                                    gPXFile = gPXFile2;
                                    str = str11;
                                    str2 = str12;
                                    NavigationLogger.e(e, str2, new Object[0]);
                                    sb = new StringBuilder();
                                    sb.append(context2.getString(R.string.mappls_error_reading_gpx));
                                    sb.append(str);
                                    sb.append(e.getMessage());
                                    string = sb.toString();
                                    gPXFile.warning = string;
                                    return gPXFile;
                                }
                            } else {
                                z = z3;
                                str6 = str4;
                                if (next == 3) {
                                    Object objPeek2 = stack.peek();
                                    String name2 = xmlPullParserA.getName();
                                    if ((objPeek2 instanceof c) && name2.equals("extensions")) {
                                        z = false;
                                    }
                                    if (name2.equals("trkpt") || name2.equals("wpt") || name2.equals("rtept") || name2.equals("trk") || name2.equals("rte") || name2.equals("trkseg")) {
                                        stack.pop();
                                    }
                                }
                            }
                            str9 = str6;
                            z3 = z;
                            simpleDateFormat3 = simpleDateFormat;
                            str10 = str5;
                        }
                        stack.push(wptAttributes);
                        z2 = z;
                        gPXFile2 = gPXFile2;
                        str11 = str11;
                        str12 = str12;
                        simpleDateFormat3 = simpleDateFormat;
                        str9 = str4;
                        str10 = str5;
                    }
                } catch (RuntimeException e10) {
                    e = e10;
                    str11 = str11;
                    str12 = str12;
                    gPXFile2 = gPXFile2;
                } catch (XmlPullParserException e11) {
                    e = e11;
                    str11 = str11;
                    str12 = str12;
                    gPXFile2 = gPXFile2;
                }
            } catch (IOException e12) {
                e = e12;
                str11 = str11;
                str12 = str12;
                gPXFile2 = gPXFile2;
            }
        } catch (RuntimeException e13) {
            e = e13;
            context2 = context;
            str = StringUtils.SPACE;
            str3 = "BadRequestError reading gpx";
            gPXFile = gPXFile2;
        } catch (XmlPullParserException e14) {
            e = e14;
            context2 = context;
            str = StringUtils.SPACE;
            str2 = "BadRequestError reading gpx";
            gPXFile = gPXFile2;
        }
    }

    public static GPXFile loadGPXFile(Context context, String str) {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(str.getBytes(UTF_8));
                try {
                    GPXFile gPXFileLoadGPXFile = loadGPXFile(context, byteArrayInputStream);
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e2) {
                        NavigationLogger.e(e2);
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e3) {
                        NavigationLogger.d(e3);
                    }
                    return gPXFileLoadGPXFile;
                } catch (Exception e4) {
                    e = e4;
                    byteArrayInputStream2 = byteArrayInputStream;
                    GPXFile gPXFile = new GPXFile();
                    NavigationLogger.e(e, "BadRequestError reading gpx", new Object[0]);
                    gPXFile.warning = context.getString(R.string.mappls_error_reading_gpx);
                    if (byteArrayInputStream2 != null) {
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException e5) {
                            NavigationLogger.d(e5);
                        }
                    }
                    return gPXFile;
                } catch (Throwable th) {
                    th = th;
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e6) {
                            NavigationLogger.d(e6);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayInputStream = byteArrayInputStream2;
            }
        } catch (Exception e7) {
            e = e7;
        }
    }

    public static void mergeGPXFileInto(GPXFile gPXFile, GPXFile gPXFile2) {
        if (gPXFile2 == null) {
            return;
        }
        if (gPXFile2.showCurrentTrack) {
            gPXFile.showCurrentTrack = true;
        }
        List<g> list = gPXFile2.points;
        if (list != null) {
            gPXFile.points.addAll(list);
        }
        List<Track> list2 = gPXFile2.tracks;
        if (list2 != null) {
            gPXFile.tracks.addAll(list2);
        }
        List<Route> list3 = gPXFile2.routes;
        if (list3 != null) {
            gPXFile.routes.addAll(list3);
        }
        String str = gPXFile2.warning;
        if (str != null) {
            gPXFile.warning = str;
        }
    }

    private static g parseWptAttributes(XmlPullParser xmlPullParser) {
        g gVar = new g();
        try {
            gVar.a = Double.parseDouble(xmlPullParser.getAttributeValue("", "lat"));
            gVar.b = Double.parseDouble(xmlPullParser.getAttributeValue("", "lon"));
        } catch (NumberFormatException e2) {
            NavigationLogger.e(e2);
        }
        return gVar;
    }

    private static String readText(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String text = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || (next == 3 && xmlPullParser.getName().equals(str))) {
                break;
            }
            if (next == 4) {
                if (text == null) {
                    text = xmlPullParser.getText();
                } else {
                    StringBuilder sbA = h.a(text);
                    sbA.append(xmlPullParser.getText());
                    text = sbA.toString();
                }
            }
        }
        return text;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void splitSegment(d dVar, d dVar2, double d2, List<e> list, f fVar) {
        double d3;
        double dA = 0.0d;
        e eVar = new e(fVar, 0, 0.0d);
        double d4 = d2;
        g gVar = null;
        double d5 = 0.0d;
        for (int i = 0; i < fVar.a.size(); i++) {
            g gVar2 = (g) fVar.a.get(i);
            if (i > 0) {
                double dA2 = dVar.a(gVar, gVar2);
                dA += dVar2.a(gVar, gVar2);
                while (true) {
                    d3 = d5 + dA2;
                    if (d3 <= d4) {
                        break;
                    }
                    g gVar3 = gVar2;
                    double d6 = (d4 - d5) / dA2;
                    int i2 = i - 1;
                    eVar.d = d6;
                    eVar.e = i2;
                    eVar.f = d4;
                    eVar.g = dA;
                    list.add(eVar);
                    eVar = new e(fVar, i2, d6);
                    d4 += d2;
                    eVar.a(0);
                    gVar2 = gVar3;
                }
                gVar = gVar2;
                d5 = d3;
            } else {
                gVar = gVar2;
            }
        }
        if (fVar.a.size() > 0) {
            if (eVar.e == fVar.a.size() - 1 && eVar.b == 1.0d) {
                return;
            }
            eVar.f = d5;
            eVar.g = dA;
            int size = fVar.a.size() - 2;
            eVar.d = 1.0d;
            eVar.e = size;
            list.add(eVar);
        }
    }

    private static void writeExtensions(XmlSerializer xmlSerializer, c cVar) throws IOException {
        if (cVar.getExtensionsToRead().isEmpty()) {
            return;
        }
        xmlSerializer.startTag(null, "extensions");
        for (Map.Entry<String, String> entry : cVar.getExtensionsToRead().entrySet()) {
            writeNotNullText(xmlSerializer, entry.getKey(), entry.getValue());
        }
        xmlSerializer.endTag(null, "extensions");
    }

    public static String writeGpx(Writer writer, GPXFile gPXFile, Context context) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(GPX_TIME_FORMAT, Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
            XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
            xmlSerializerNewSerializer.setOutput(writer);
            xmlSerializerNewSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
            xmlSerializerNewSerializer.startDocument("UTF-8", Boolean.TRUE);
            xmlSerializerNewSerializer.startTag(null, "gpx");
            xmlSerializerNewSerializer.attribute(null, "version", "1.1");
            String strA = gPXFile.author;
            if (strA == null) {
                strA = y.a(context);
            }
            xmlSerializerNewSerializer.attribute(null, "creator", strA);
            xmlSerializerNewSerializer.attribute(null, "xmlns", "http://www.topografix.com/GPX/1/1");
            xmlSerializerNewSerializer.attribute(null, "xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            xmlSerializerNewSerializer.attribute(null, "xsi:schemaLocation", "http://www.topografix.com/GPX/1/1 http://www.topografix.com/GPX/1/1/gpx.xsd");
            Iterator<Track> it2 = gPXFile.tracks.iterator();
            while (it2.hasNext()) {
                Track next = it2.next();
                Iterator<Track> it3 = it2;
                xmlSerializerNewSerializer.startTag(null, "trk");
                writeNotNullText(xmlSerializerNewSerializer, "name", next.name);
                writeNotNullText(xmlSerializerNewSerializer, "desc", next.desc);
                Iterator<f> it4 = next.segments.iterator();
                while (it4.hasNext()) {
                    f next2 = it4.next();
                    xmlSerializerNewSerializer.startTag(null, "trkseg");
                    for (g gVar : next2.a) {
                        xmlSerializerNewSerializer.startTag(null, "trkpt");
                        writeWpt(simpleDateFormat, xmlSerializerNewSerializer, gVar);
                        xmlSerializerNewSerializer.endTag(null, "trkpt");
                        it4 = it4;
                    }
                    xmlSerializerNewSerializer.endTag(null, "trkseg");
                    it4 = it4;
                }
                writeExtensions(xmlSerializerNewSerializer, next);
                xmlSerializerNewSerializer.endTag(null, "trk");
                it2 = it3;
            }
            for (Route route : gPXFile.routes) {
                xmlSerializerNewSerializer.startTag(null, "rte");
                writeNotNullText(xmlSerializerNewSerializer, "name", route.name);
                writeNotNullText(xmlSerializerNewSerializer, "desc", route.desc);
                for (g gVar2 : route.points) {
                    xmlSerializerNewSerializer.startTag(null, "rtept");
                    writeWpt(simpleDateFormat, xmlSerializerNewSerializer, gVar2);
                    xmlSerializerNewSerializer.endTag(null, "rtept");
                }
                writeExtensions(xmlSerializerNewSerializer, route);
                xmlSerializerNewSerializer.endTag(null, "rte");
            }
            for (g gVar3 : gPXFile.points) {
                xmlSerializerNewSerializer.startTag(null, "wpt");
                writeWpt(simpleDateFormat, xmlSerializerNewSerializer, gVar3);
                xmlSerializerNewSerializer.endTag(null, "wpt");
            }
            xmlSerializerNewSerializer.endTag(null, "gpx");
            xmlSerializerNewSerializer.flush();
            xmlSerializerNewSerializer.endDocument();
            return null;
        } catch (IOException e2) {
            NavigationLogger.e(e2, "BadRequestError saving gpx", new Object[0]);
            return context.getString(R.string.mappls_error_occurred_saving_gpx);
        } catch (RuntimeException e3) {
            NavigationLogger.e(e3, "BadRequestError saving gpx", new Object[0]);
            return context.getString(R.string.mappls_error_occurred_saving_gpx);
        }
    }

    public static String writeGpxFile(File file, GPXFile gPXFile, Context context) throws Throwable {
        OutputStreamWriter outputStreamWriter;
        OutputStreamWriter outputStreamWriter2 = null;
        try {
            try {
                outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), UTF_8);
                try {
                    String strWriteGpx = writeGpx(outputStreamWriter, gPXFile, context);
                    try {
                        outputStreamWriter.close();
                    } catch (IOException e2) {
                        NavigationLogger.d(e2);
                    }
                    return strWriteGpx;
                } catch (IOException e3) {
                    e = e3;
                    outputStreamWriter2 = outputStreamWriter;
                    NavigationLogger.e(e, "BadRequestError saving gpx", new Object[0]);
                    String string = context.getString(R.string.mappls_error_occurred_saving_gpx);
                    if (outputStreamWriter2 != null) {
                        try {
                            outputStreamWriter2.close();
                        } catch (IOException e4) {
                            NavigationLogger.d(e4);
                        }
                    }
                    return string;
                } catch (Throwable th) {
                    th = th;
                    if (outputStreamWriter != null) {
                        try {
                            outputStreamWriter.close();
                        } catch (IOException e5) {
                            NavigationLogger.d(e5);
                        }
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
            outputStreamWriter = outputStreamWriter2;
        }
    }

    private static void writeNotNullText(XmlSerializer xmlSerializer, String str, String str2) throws IOException {
        if (str2 != null) {
            xmlSerializer.startTag(null, str);
            xmlSerializer.text(str2);
            xmlSerializer.endTag(null, str);
        }
    }

    private static void writeWpt(SimpleDateFormat simpleDateFormat, XmlSerializer xmlSerializer, g gVar) throws IOException {
        NumberFormat numberFormat = latLonFormat;
        xmlSerializer.attribute(null, "lat", numberFormat.format(gVar.a));
        xmlSerializer.attribute(null, "lon", numberFormat.format(gVar.b));
        if (!Double.isNaN(gVar.i)) {
            writeNotNullText(xmlSerializer, "ele", ((float) gVar.i) + "");
        }
        if (gVar.h != 0) {
            writeNotNullText(xmlSerializer, "time", simpleDateFormat.format(new Date(gVar.h)));
        }
        writeNotNullText(xmlSerializer, "name", gVar.c);
        writeNotNullText(xmlSerializer, "desc", gVar.f);
        if (gVar.d != null) {
            xmlSerializer.startTag(null, "link");
            xmlSerializer.attribute(null, "href", gVar.d);
            xmlSerializer.endTag(null, "link");
        }
        writeNotNullText(xmlSerializer, "type", gVar.e);
        String str = gVar.g;
        if (str != null) {
            writeNotNullText(xmlSerializer, "cmt", str);
        }
        if (!Double.isNaN(gVar.k)) {
            writeNotNullText(xmlSerializer, SavingTrackHelper.TRACK_COL_HDOP, gVar.k + "");
        }
        if (gVar.j > 0.0d) {
            gVar.getExtensionsToWrite().put("speed", gVar.j + "");
        }
        writeExtensions(xmlSerializer, gVar);
    }
}
