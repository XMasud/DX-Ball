package hr.tp.dxball;

import android.graphics.Canvas;
import android.graphics.Paint;

public class dxBar {

	private float barLeft,barRight,barTop,barBottom;
	
	public void setBarSize(Canvas canvas)
	{
		barLeft = (canvas.getWidth()/2)-(canvas.getWidth()/6);
		barRight = barLeft + (canvas.getWidth()/3);
		barBottom = canvas.getHeight()-30;
		barTop = barBottom - 30;
	}
	public void drawBar(Canvas canvas,Paint paint)
	{
		barRight = barLeft + (canvas.getWidth()/3);
		canvas.drawRect(barLeft, barTop, barRight, barBottom, paint);
		
	}
	
	public float getBarLeft() {
		// TODO Auto-generated method stub
		return barLeft;
	}

	public float getBarRight() {
		// TODO Auto-generated method stub
		return barRight;
	}

	public float getBarTop() {
		// TODO Auto-generated method stub
		return barTop;
	}

	public float getBottom() {
		// TODO Auto-generated method stub
		return barBottom;
	}
	public void setBarBottom(float barBottom)
	{
		this.barBottom = barBottom;
	}
	public void setBarLeft(float barLeft)
	{
		this.barLeft = barLeft;
	}
	public void setBarRight(float barRight)
	{
		this.barRight = barRight;
	}
	public void setBarTop(float barTop)
	{
		this.barTop = barTop;
	}

}
