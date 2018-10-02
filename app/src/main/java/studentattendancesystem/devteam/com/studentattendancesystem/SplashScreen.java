package studentattendancesystem.devteam.com.studentattendancesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    private final static int SECONDS = 3;
    Animation scaleDown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        final ImageView MTI_Logo = (ImageView)findViewById(R.id.MTI_Logo);


        scaleDown = AnimationUtils.loadAnimation(this, R.anim.splash_animation);

        /****** Create Thread that will sleep for 5 seconds****/
        Thread background = new Thread() {
            public void run() {
                try {
                    // Thread will sleep for 3 seconds
                    //scaleView(MTI_Logo,1f,0.2f,1f,0.2f);

                    MTI_Logo.startAnimation(scaleDown);
                    sleep(SECONDS*1000);

                    // After 5 seconds redirect to another intent
                    Intent i=new Intent(getBaseContext(),LogInActivity.class);
                    startActivity(i);

                    //Remove activity
                    finish();
                } catch (Exception e) {
                }
            }
        };
        // start thread
        background.start();

    }
    public void scaleView(View v,float XstartScale,float XendScale, float YstartScale, float YendScale) {
        Animation anim = new ScaleAnimation(
                XstartScale, XendScale, // Start and end values for the X axis scaling
                YstartScale, YendScale, // Start and end values for the Y axis scaling
                Animation.START_ON_FIRST_FRAME, 50f, // Pivot point of X scaling
                Animation.START_ON_FIRST_FRAME, 50f); // Pivot point of Y scaling
        anim.setFillAfter(false); // Needed to keep the result of the animation
        anim.setDuration(1000);
        v.startAnimation(anim);
    }
}
