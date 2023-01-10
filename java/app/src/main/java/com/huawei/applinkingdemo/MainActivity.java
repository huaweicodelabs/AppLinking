/*
 * Copyright 2021. Huawei Technologies Co., Ltd. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.huawei.applinkingdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.huawei.agconnect.applinking.AGConnectAppLinking;
import com.huawei.agconnect.applinking.AppLinking;

public class MainActivity extends AppCompatActivity {

    private TextView shortTextView;
    private TextView longTextView;
    private static final String DOMAIN_URI_PREFIX = "https://applinkingtest.drcn.agconnect.link";
    private static final String DEEP_LINK = "https://developer.huawei.com/consumer/cn/doc/development/AppGallery-connect-Guides";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView deeplinktext = findViewById(R.id.deepLink);
        deeplinktext.setText(DEEP_LINK);
        shortTextView = findViewById(R.id.shortLinkText);
        longTextView = findViewById(R.id.longLinkText);

        //creatButton
        findViewById(R.id.create).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAppLinking();
            }
        });
        //shareButton
        findViewById(R.id.shareLong).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareLink((String) longTextView.getText());
            }
        });
        findViewById(R.id.shareShort).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareLink((String) shortTextView.getText());
            }
        });
        //init AppLinking
        AGConnectAppLinking.getInstance();
    }
    private void createAppLinking() {
        AppLinking.Builder builder = new AppLinking.Builder()
                .setUriPrefix(DOMAIN_URI_PREFIX)
                .setDeepLink(Uri.parse(DEEP_LINK))
                .setAndroidLinkInfo(new AppLinking.AndroidLinkInfo.Builder().build())
                .setSocialCardInfo(new AppLinking.SocialCardInfo.Builder()
                        .setTitle("华为开发者大会")
                        .setImageUrl("https://developer.huawei.com/consumer/cn/events/hdc2020/img/kv-pc-cn.png?v0808")
                        .setDescription("Description").build())
                .setCampaignInfo(new AppLinking.CampaignInfo.Builder()
                        .setName("HDC")
                        .setSource("AGC")
                        .setMedium("App").build());
		longTextView.setText(builder.buildAppLinking().getUri().toString());

        builder.buildShortAppLinking().addOnSuccessListener(shortAppLinking -> {
            shortTextView.setText(shortAppLinking.getShortUrl().toString());
        }).addOnFailureListener(e -> {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        });
    }

    private void shareLink(String agcLink) {
        if (agcLink != null) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, agcLink);
            startActivity(intent);
        }
    }
}

