package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class q {
    public final String a = "precision highp float;varying vec4 a;uniform mat4 b;uniform vec4 c,e[16];uniform float d,f,g,h,i,j;attribute vec4 k;attribute vec4 l;void main(){vec4 m,r;m=e[int(l.r)];float n,o,s;n=l.b/4.;o=l.a/4.;bool p=m.a==0.||f<n||f>o;if(p){gl_Position=vec4(0);return;}vec3 q=k.xyz;q=q*c.w+c.xyz;r=b*vec4(q.xy,q.z*d,1);gl_Position=r+vec4(0,0,h,0);a=m*vec2(l.g/255.,g).xxxy;a.r=min(a.r,1.);a.g=min(a.g,1.);a.b=min(a.b,1.);s=1.-smoothstep(i,j,r.z/r.w);a.a=a.a*s;}";
    public final String b = "precision highp float;varying vec4 a;void main(){gl_FragColor=a;}";
    public final p c = new p();
    public final o d = new o();
}
