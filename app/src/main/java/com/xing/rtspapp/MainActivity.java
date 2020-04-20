package com.xing.rtspapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import org.videolan.libvlc.util.VLCVideoLayout;

public class MainActivity extends AppCompatActivity {
    private VLCManager mVLCManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String path="rtsp://admin:admin@192.168.3.54/1";
        mVLCManager = new VLCManager(this, (VLCVideoLayout) findViewById(R.id.video_layout));
        mVLCManager.play(path);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mVLCManager != null) {
            mVLCManager.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mVLCManager != null) {
            mVLCManager.onDestroy();
        }
    }
}