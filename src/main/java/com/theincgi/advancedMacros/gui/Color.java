package com.theincgi.advancedMacros.gui;

import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;

public class Color {
	int a,r,g,b;
	//public boolean quoteMode;
	public static final Color WHITE = new Color(255, 255, 255);
	public static final Color BLACK = new Color(  0,   0,   0);
	/**0-Black<br>
	 * 1-Dark Blue<br>
	 * 2-Dark Green<br>
	 * 3-Dark Aqua<br>
	 * 4-Dark Red<br>
	 * 5-Dark Purple<br>
	 * 6-Orange<br>
	 * 7-Light Gray<br>
	 * 8-Gray<br>
	 * 9-Blue<br>
	 * A-Lime<br>
	 * B-Sky Blue<br>
	 * C-Red<br>
	 * D-Light Purple<br>
	 * E-Yellow<br>
	 * F-White<br>*/
	public static final Color
		
		TEXT_0 = new Color(  0,   0,   0),
		TEXT_1 = new Color(  0,   0, 170),
		TEXT_2 = new Color(  0, 170,   0),
		TEXT_3 = new Color(  0, 170, 170),
		TEXT_4 = new Color(170,   0,   0),
		TEXT_5 = new Color(170,   0, 170),
		TEXT_6 = new Color(255, 170,   0),
		TEXT_7 = new Color(170, 170, 170),
		TEXT_8 = new Color(85,85,85),
		TEXT_9 = new Color(85,85,255),
		TEXT_a = new Color(85,255,85),
		TEXT_b = new Color(85,255,255),
		TEXT_c = new Color(255,85,85),
		TEXT_d = new Color(255,85,255),
		TEXT_e = new Color(255,255,85),
		TEXT_f = new Color(255,255,255);
	
	
	public Color(int a, int r, int g, int b) {
		this.a = a;
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public Color(int r, int g, int b) {
		a = 0xff;
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public Color(int hexCode){
		fromHex(hexCode);
	}

	private void fromHex(int hexCode) {
		this.r = (hexCode >> 16 & 255);
		this.b = (hexCode >> 0 & 255);
		this.g = (hexCode >> 8 & 255);
		this.a = (hexCode >> 24 & 255);		
	}

	public int getA() {
		return a;
	}

	public Color setA(int a) {
		this.a = a;
		return this;
	}

	public int getR() {
		return r;
	}

	public Color setR(int r) {
		this.r = r;
		return this;
	}

	public int getG() {
		return g;
	}

	public Color setG(int g) {
		this.g = g;
		return this;
	}

	public int getB() {
		return b;
	}

	public Color setB(int b) {
		this.b = b;
		return this;
	}

	@Override
	public String toString() {
		return "Color [a=" + a + ", r=" + r + ", g=" + g + ", b=" + b + "]";
	}

	public int toInt() {
		int i = 0;
		i+= a<<24;
		i+= r<<16;
		i+= b<<0;
		i+= g<<8;
//		this.red = (float)(color >> 16 & 255) / 255.0F;
//        this.blue = (float)(color >> 8 & 255) / 255.0F;
//        this.green = (float)(color & 255) / 255.0F;
//        this.alpha = (float)(color >> 24 & 255) / 255.0F;
		return i;
	}
	public LuaTable toLuaValue(){
		LuaTable t = new LuaTable();
		t.set("r", LuaValue.valueOf(r));
		t.set("g", LuaValue.valueOf(g));
		t.set("b", LuaValue.valueOf(b));
		t.set("a", LuaValue.valueOf(a));
		return t;
	}
	public Color copy(){
		return new Color(toInt());
	}

	public Color setRGB(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
		return this;
	}
	public Color setARGB(int a, int r,int g, int b){
		setRGB(r, g, b);
		this.a = a;
		return this;
	}
	/**Copies values from object, this is so you dont need to make a new obj when changing colors to a setting<br>returns this*/
	public Color setFrom(Color c){
		setARGB(c.a, c.r, c.g, c.b);
		return this;
	}

	public java.awt.Color toAWTColor() {
		return new java.awt.Color(r, g, b, a);
	}
	
}
