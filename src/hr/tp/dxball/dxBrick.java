package hr.tp.dxball;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

public class dxBrick {
	
	
	float top,bottom,left,right;
	Canvas canvas = new Canvas();
	int x,y,color;
	Point point;
	Paint paint;
	
	
	

	dxBrick(float left,float top,float right,float bottom,int color)
	{
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
		this.color = color;
		paint = new Paint();
		paint.setColor(color);
	}
	public void setBarLeft(float left)
	{
		this.left = left;
	}
	public void setBarRight(float right)
	{
		this.right = right;
	}
	public void setBarTop(float top)
	{
		this.top = top;
	}
	public void setBarBottom(float bottom)
	{
		this.bottom = bottom;
	}
	
	public float getBarLeft()
	{
		return left;
	}
	public float getBarRight()
	{
		return right;
	}
	public float getBarTop()
	{
		return top;
	}
	public float getBarBottom()
	{
		return bottom;
	}
	public Paint getPaint()
	{
		return paint;
	}
}
