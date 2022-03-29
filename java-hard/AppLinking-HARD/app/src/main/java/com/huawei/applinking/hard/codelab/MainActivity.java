package com.huawei.applinking.hard.codelab;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.huawei.agconnect.applinking.AGConnectAppLinking;
import com.huawei.agconnect.applinking.AppLinking;

public class MainActivity extends AppCompatActivity {

	// replace your App Linking Uri prefix
    private static final String DOMAIN_URI_PREFIX = "<YOUR_DOMAIN_URI_PREFIX>";
	
    private static final String DEEP_LINK = "https://developer.huawei.com/consumer/cn";
    private static final String ANDROID_DEEP_LINK = "codelabhard://applinking.codelab/testid=123";
    private static String App_LinkingUrl;

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

        // create Button
        findViewById(R.id.create).setOnClickListener(view -> {
            createAppLinking();
        });
        // share Button
        findViewById(R.id.shareShort).setOnClickListener(view -> {
            shareLink(App_LinkingUrl);
        });
    }

    private void createAppLinking() {
        AppLinking.Builder builder = new AppLinking.Builder()
                .setUriPrefix(DOMAIN_URI_PREFIX)
                .setDeepLink(Uri.parse(DEEP_LINK))
                .setAndroidLinkInfo(new AppLinking.AndroidLinkInfo.Builder()
                        .setAndroidDeepLink(ANDROID_DEEP_LINK)
                        .build());

        TextView longTextView = findViewById(R.id.longLinkText);
        longTextView.setText(builder.buildAppLinking().getUri().toString());

        builder.buildShortAppLinking().addOnSuccessListener(shortAppLinking -> {
            Log.i("AppLinkingCodeLab", "buildShortAppLinking success");
            TextView shortTextView = findViewById(R.id.shortLinkText);
            App_LinkingUrl = shortAppLinking.getShortUrl().toString();
            shortTextView.setText(App_LinkingUrl);
        }).addOnFailureListener(e -> {
            Log.i("AppLinkingCodeLab", "buildShortAppLinking failed: " + e.toString());
        });
    }

    private void shareLink(String LinkingUrl) {
        if (LinkingUrl != null) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, LinkingUrl);
            startActivity(intent);
        }
    }
}