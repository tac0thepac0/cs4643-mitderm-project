package edu.utsa.cs4643.midtermproject;

import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.time.Instant;

import edu.utsa.cs4643.midtermproject.Controller.SwipeController;
import edu.utsa.cs4643.midtermproject.Model.Swipe;
import edu.utsa.cs4643.midtermproject.Model.User;


public class SwipeActivity extends AppCompatActivity {

    public static String USER;
    private Swipe swipe;
    private static SwipeController swipeController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_swipe);

        swipeController = new SwipeController();
        swipeController.setUser((User) getIntent().getSerializableExtra("USER"));
        }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        PointF current = new PointF(event.getX(), event.getY());
        String action = "";

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                action = "ACTION_DOWN";
                swipe = new Swipe(swipeController.getUser(), current, Instant.now());
                break;
            case MotionEvent.ACTION_UP:
                action = "ACTION_UP";
                if (swipe != null) {
                    swipe.addEnd(current, Instant.now());
                    swipeController.addSwipe(swipe);

                    Log.i("SwipeActivity", swipe.toString());
                }
                break;
            case MotionEvent.ACTION_MOVE:
                action = "ACTION_MOVE";
                break;
        }

//        Log.i("SwipeActivity", String.format("action %s at %f, %f at %s", action, current.x, current.y, Instant.now().toString()));

        return true;
    }
}