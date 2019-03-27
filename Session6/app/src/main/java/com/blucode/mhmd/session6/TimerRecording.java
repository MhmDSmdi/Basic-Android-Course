package com.blucode.mhmd.session6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class TimerRecording {

    private Timer timer;
    private long tick;
    private String tickString;
    private Handler handler;
    private TimerTask tickTask;

    private void init() {
        tickTask = new TimerTask() {
            @Override
            public void run() {
                tick++;
                tickString = String.format("%02d:%02d:%d", TimeUnit.MILLISECONDS.toMinutes(tick) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(tick)),
                        TimeUnit.MILLISECONDS.toSeconds(tick) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(tick)),
                        (TimeUnit.MILLISECONDS.toMillis(tick) - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(tick))) / 100);
                handler.obtainMessage(1).sendToTarget();
            }
        };
        timer = new Timer();
    }


    public TimerRecording(Handler handler) {
        this.handler = handler;
    }

    public String getTickString() {
        return tickString;
    }

    public void cancelTimer() {
        tick = 0;
        tickString ="";
        tickTask.cancel();
        timer.cancel();
        timer = null;
        tickTask = null;
    }

    public void startTimer() {
        init();
        timer.schedule(tickTask, 0, 1);
    }

    interface TimerListener {
        void tick(String tick);
    }

    public long getTick() {
        return tick;
    }
}
