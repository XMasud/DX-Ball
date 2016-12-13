package hr.tp.dxball;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class LabDxBallActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       
        MediaPlayer mp1 = MediaPlayer.create(this, R.raw.dxball);
        mp1.start();
        mp1.setLooping(true);
        
       
    }
    
    public void onClick(View v)
    {
    	switch(v.getId()){
    	case R.id.button1:
    		Intent intent = new Intent(this,GameCanvas.class);
    		startActivity(intent);
    		
    		break;
    	
    	case R.id.button2:
    		finish();
    		System.exit(0);
    		break;
    	
    	}
    	
    }

	
}
