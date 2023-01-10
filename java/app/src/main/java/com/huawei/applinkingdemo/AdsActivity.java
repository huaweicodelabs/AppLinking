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