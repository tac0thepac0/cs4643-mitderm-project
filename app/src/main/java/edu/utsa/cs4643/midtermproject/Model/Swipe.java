package edu.utsa.cs4643.midtermproject.Model;

import android.graphics.PointF;

import java.time.Instant;
import java.time.temporal.ChronoUnit;


public class Swipe {

    private User user;
    private PointF origin;
    private PointF current;
    private float distance;
    private String direction;
    private float velocity;
    private Instant startTime;
    private Instant endTime;
    private float duration;
    private String timestamp;

    public Swipe(User user, PointF origin, Instant startTime) {
        this.user = user;
        this.origin = origin;
        this.startTime = startTime;
        this.timestamp = this.startTime.toString();
    }

    public void addEnd(PointF current, Instant endTime) {
        this.current = current;
        this.endTime = endTime;

        duration = (float) startTime.until(this.endTime, ChronoUnit.MILLIS) / 1000;
        distance = (float) Math.sqrt(Math.pow((this.current.x - origin.x), 2) + Math.pow((this.current.y - origin.y), 2));
        velocity = Math.abs(distance / duration);

        // TODO: Implement Direction Logic
        /*
        if end_x < start_x and (abs(end_y - start_y) < threshold) then
            direction = "left"
        */
    }

    @Override
    public String toString() {
        return "Swipe{" +
                "user=" + user.getUsername() +
                ", origin=" + origin +
                ", current=" + current +
                ", distance=" + distance +
                ", direction='" + direction + '\'' +
                ", velocity=" + velocity +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", duration=" + duration +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
