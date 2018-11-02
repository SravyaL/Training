package com.Verizon.ui;

public class RectangularFlexi implements FlexyBanner {
	private int width;
	private int height;
	
	public RectangularFlexi(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		return width*height;
	}

	@Override
	public double getPerimeter() {
		return 02*(width+height);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "RectangularFlexi [width=" + width + ", height=" + height + "]";
	}
	

}
