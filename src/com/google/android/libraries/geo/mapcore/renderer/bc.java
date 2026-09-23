package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class bc {
    public final String a;
    public final String b;
    public final bb c;
    public final ba d;

    public bc() {
        String strJ = com.google.android.libraries.navigation.internal.b.b.j(bd.d, "#define _a ", "\n");
        this.a = strJ.concat("precision highp float;varying vec2 a;attribute vec2 b;attribute vec2 c;void main(){gl_Position=vec4(b,0,1);a=c;}");
        this.b = strJ.concat("precision highp float;varying vec2 a;uniform float d,e,i[2],j;uniform sampler2D f;uniform vec4 g[_a],h[2];void main(){for(int k=0;k<2;k++)if(abs(i[k]-a.y)<j){gl_FragColor=h[k];return;}int l;float m,n;m=e*.5;n=0.;for(l=0;l<_a;l++){vec2 o=vec2(m,a.x+d);vec4 p=texture2D(f,o);n+=p.r;if(n>a.y)break;m+=e;}if(l>=_a)discard;else gl_FragColor=vec4(g[l].rgb,.5);}");
        this.c = new bb();
        this.d = new ba();
    }
}
