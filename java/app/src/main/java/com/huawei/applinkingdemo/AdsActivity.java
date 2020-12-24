package com.huawei.applinkingdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.huawei.agconnect.applinking.AGConnectAppLinking;

public class AdsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads);
        AGConnectAppLinking.getInstance().getAppLinking(this,getIntent()).addOnSuccessListener(resolvedLinkData -> {
            Uri deepLink = null;
            if (resolvedLinkData != null) {
                deepLink = resolvedLinkData.getDeepLink();
                TextView textView = findViewById(R.id.textView);
                textView.setText(deepLink.toString());
            }
        }).addOnFailureListener(e -> {
            Log.i("AppLinking", "getAppLinking:onFailure", e);
        });
    }
}