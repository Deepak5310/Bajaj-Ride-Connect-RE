package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ap {
    public final String a = "precision highp float;varying vec4 a;uniform mat4 b;uniform ivec4 c[64];uniform float d;attribute vec4 e;attribute vec4 f;vec4 k(ivec2 g){vec4 h;h.a=floor(float(g.x)*(1./256.))*(1./255.);if(h.a!=0.){h.r=fract(float(g.x)*(1./256.))*(256./255.);h.b=fract(float(g.y)*(1./256.))*(256./255.);h.g=floor(float(g.y)*(1./256.))*(1./255.);}return h;}void main(){ivec4 g=c[int(f.r)];ivec2 h=int(f.g)==1?g.zw:g.xy;float i,j;i=f.b/4.;j=f.a/4.;a=k(h);if(a.a==0.||d<i||d>j){gl_Position=vec4(0);return;}gl_Position=b*e;}";
    public final String b = "precision mediump float;varying vec4 a;void main(){gl_FragColor=a;}";
    public final ao c = new ao();
    public final an d = new an();
}
