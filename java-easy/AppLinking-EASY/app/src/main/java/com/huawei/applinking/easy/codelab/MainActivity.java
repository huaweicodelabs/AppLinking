package com.huawei.applinking.easy.codelab;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.huawei.agconnect.applinking.AGConnectAppLinking;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AGConnectAppLinking.getInstance().getAppLinking(this).addOnSuccessListener(resolvedLinkData -> {
            Uri deepLink = null;
            if (resolvedLinkData!= null) {
                deepLink = resolvedLinkData.getDeepLink();
                Log.i("AppLinkingCodeLab", "Open From App Linking: " + deepLink.toString());
                TextView resultText = findViewById(R.id.result_text);
                resultText.setText(deepLink.toString());
                // Perform subsequent processing based on the deep link
            }
        });

    }
}