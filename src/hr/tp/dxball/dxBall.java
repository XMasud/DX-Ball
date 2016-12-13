package hr.tp.dxball;

import android.graphics.Canvas;
import android.graphics.Paint;

public class dxBall {
	
	private boolean ballLife = true; 
	private float x,y;
	private float radius = 20;
	
	
	private float displacementX = 5;
	private float displacementY = -5;
	
	public float getY()
	{
		return y;
	}
	public void setY(float y)
	{
		this.y = y;
	}
	public float getX()
	{
		return x;
	}
	public void setX(float x)
	{
		this.x = x;
	}
	public float getRadius()
	{
		return radius;
	}

	public float getdisplcementX()
	{
		return displacementX;
	}
	
	public float getdisplcementY()
	{
		return displacementY;
	}
	public void setdisplacementX(float displacementX)
	{
		this.displacementX = displacementX;
	}
	public void setdisplacementY(float displacementY)
	{
		this.displacementY = displacementY;
	}
	public void setRadius(float radius)
	{
		this.radius = radius;
	}
	
	public boolean isballLife()
	{
		return ballLife;
	}
	
	public void setBallAlive(boolean ballLife)
	{
		this.ballLife = ballLife;
	}
	
	public void setBall(Canvas canvas,dxBar bar)
	{
		float barMid = (bar.getBarRight()-bar.getBarLeft())/2;
		x = bar.getBarLeft()+barMid;
		y = bar.getBarTop()-radius;
	}
	public void drawBall(Canvas canvas,Paint paint)
	{
		canvas.drawCircle(x, y, radius, paint);
	}
	
	public void nextPosition(Canvas canvas,dxBar bar)
	{
		if(x == canvas.getWidth()-radius|| (x == bar.getBarLeft()-radius && y>= bar.getBarTop() && y<=bar.getBottom()) && displacementX>0)
		{
			displacementX = - displacementX;
		}
		else if(y<=radius)
		{
			displacementY = -displacementY;
		}
		else if(x<=radius)
		{
			displacementX = -displacementX;
		}
		else if(y > bar.getBarTop()- radius && x>bar.getBarLeft()&& x<bar.getBarRight() )
		{
			displacementY = -displacementY;
		}
		else if(y > bar.getBottom() && y <= canvas.getHeight())
		{
			displacementX = 0;
			displacementY = 0;
			
			dxGameView.LIFE--;
			if(dxGameView.LIFE<=0)
			{
				ballLife = false;
			}
			else
			{
				dxGameView.firstTime = true;
				displacementX = 5;
				displacementY = -5;
			}
				
		}
		x += displacementX;
		y += displacementY;
	}
	

}
