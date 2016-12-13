package hr.tp.dxball;

import java.util.ArrayList;

import hr.tp.dxball.dxBall;
import hr.tp.dxball.dxBar;
import hr.tp.dxball.GameCanvas;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class dxGameView extends View {
	
	int level,score=0;
	public static int LIFE;
	static boolean firstTime = true;
	static boolean newLife;
	public static boolean Game_Over;
	float brick_X=0,brick_Y=0;
	Canvas canvas;
	static boolean first;
	Paint paint;
	dxBar bar;
	dxBall ball;
	float xT;
	
	float x=0,y=0,radius = 0;
	//static boolean firstTime = true;
	private Context context;
	
	ArrayList<dxBrick> brick = new ArrayList<dxBrick>();

	public dxGameView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		paint = new Paint();
		this.context = context;
		LIFE = 5;
		level = 1;
		first = true;
		newLife = true;
		Game_Over = false;
		bar = new dxBar();
		ball = new dxBall();
		
		setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if(ball.isballLife()){
					xT = event.getX();
					if(xT<v.getWidth()/2 && bar.getBarLeft()>0)
					{
						bar.setBarLeft(bar.getBarLeft()-10);
						xT = -10;
					}
					else if(xT >= v.getWidth()/2 && bar.getBarRight()<v.getWidth())
					{
						bar.setBarLeft(bar.getBarLeft()+10);
						xT = -10;
					}
				}
				return true;
				
			}
		});
		Log.d("Up to touchscreen working function :","true");
	}
	
	
	protected void onDraw(Canvas canvas)
	{
		if(firstTime)
		{
			firstTime  = false;
			bar.setBarSize(canvas);
			ball.setBall(canvas, bar);
			
		}
		canvas.drawRGB(255, 255, 255);
		paint.setColor(Color.RED);
		paint.setStyle(Paint.Style.FILL);
		ball.drawBall(canvas, paint);
		bar.drawBar(canvas, paint);
		ball.nextPosition(canvas, bar);
		invalidate();
		this.canvas = canvas;
		int column;
		brick_X = canvas.getWidth()/7;
		brick_Y = (canvas.getHeight()/5);
		super.onDraw(canvas);
		
		
		if(first)
		{
			first = false;
				if(level == 1)
				{
					brick_X = 0;
					brick_Y = (canvas.getHeight()/15);
					column = Color.GRAY;
					
					for(int i=0;i<49;i++)
					{
						if(brick_X >= canvas.getWidth() - canvas.getWidth()/7)
						{
							brick_X = 0;
							brick_Y += canvas.getHeight()/15; 
						}
						
						if(i%2 == 0)
							column = Color.GRAY;
						else 
							column = Color.BLACK;
						
						brick.add(new dxBrick(brick_X, brick_Y, brick_X+canvas.getWidth()/7, brick_Y+canvas.getHeight()/15, column));
						brick_X += canvas.getWidth()/7;					
				}
		}
		else
		{
			Game_Over = true;
		}
		Log.d("Up to canvas draw :","true");
	}
	
		paint.setTextSize(30);
		paint.setFakeBoldText(true);
		canvas.drawText("Life : "+LIFE, 20, 40, paint);
		
		paint.setTextSize(30);
		paint.setFakeBoldText(true);
		canvas.drawText("Points: "+score, 110, 40, paint);
		
		paint.setTextSize(30);
		paint.setFakeBoldText(true);
		
		
		for(int i=0; i<brick.size();i++)
		{
			canvas.drawRect(brick.get(i).getBarLeft(), brick.get(i).getBarTop()	, brick.get(i).getBarRight(), brick.get(i).getBarBottom(),brick.get(i).getPaint());
			
		}
		if(ball.isballLife() == false || brick.size()==0)
		{
			paint.setColor(Color.WHITE);
			canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), paint);
			
			paint.setColor(Color.BLACK);
			paint.setTextSize(20);
			paint.setFakeBoldText(true);
			
			canvas.drawText("        GAME OVER!!!", canvas.getWidth()/2-100, canvas.getHeight()/2, paint);
			canvas.drawText("                    Score : "+score, canvas.getWidth()/2-150, canvas.getHeight()/2+60, paint);
			Game_Over = false;
			
			try{
				Thread.sleep(0);
				
			}
			 catch (InterruptedException e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			
		}
		this.ballAndBrickCollision(brick,ball,canvas);
		
	
	
	}

	public void ballAndBrickCollision(ArrayList<dxBrick> brik, dxBall ball,Canvas canvas) {
		// TODO Auto-generated method stub
		for(int i=0;i<brik.size();i++)
		{
			
		    if(((ball.getY()) <= brik.get(i).getBarBottom()) && ((ball.getY()) >= brik.get(i).getBarTop()) && ((ball.getX() + ball.getRadius()) >= brik.get(i).getBarLeft()) && ((ball.getX()+ ball.getRadius()) <= brik.get(i).getBarRight()))
			{
				brik.remove(i);
				score += 1;
				ball.setdisplacementX(-(ball.getdisplcementX()));
				
			}
			else if(((ball.getY() - ball.getRadius()) <= brik.get(i).getBarBottom()) && ((ball.getY() + ball.getRadius() >= brik.get(i).getBarTop()) && ((ball.getX()) >= brik.get(i).getBarLeft()) && ((ball.getX())) <= brik.get(i).getBarRight()))
			{
				brik.remove(i);
				score += 1;
				ball.setdisplacementY(-(ball.getdisplcementY()));
			}
		}
		Log.d("Up to collision :","true");
		
	}
		
}