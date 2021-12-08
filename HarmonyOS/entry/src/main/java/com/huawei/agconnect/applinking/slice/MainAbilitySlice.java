package com.huawei.agconnect.applinking.slice;

import com.huawei.agconnect.applinking.AGConnectAppLinking;
import com.huawei.agconnect.applinking.AppLinking;
import com.huawei.agconnect.applinking.ResourceTable;
import com.huawei.agconnect.common.AGCLogger;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.Text;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import ohos.utils.net.Uri;

public class MainAbilitySlice extends AbilitySlice {
    HiLogLabel hiLogLabel = new HiLogLabel(HiLog.LOG_APP,MODE_PRIVATE,"AppLingking");
    private String LongUri;
    private String ShortUri;
    private Text shortLink,longLink;
    private static final String DEEP_LINK = "https://page.xiaobingtang.cn/detail?id=123";
    private static final String DOMAIN_URI_PREFIX = "https://applinkingdemo.drcn.agconnect.link";

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        Button createButton = (Button) findComponentById(ResourceTable.Id_createButton);
        Button shareLongButton = (Button) findComponentById(ResourceTable.Id_shareLongButton);
        Button shareShortButton = (Button) findComponentById(ResourceTable.Id_shareShortButton);

        longLink = (Text) findComponentById(ResourceTable.Id_longlink);
        shortLink = (Text) findComponentById(ResourceTable.Id_shortlink);
        AGConnectAppLinking.getInstance()
                .getAppLinking(getAbility())
                .addOnSuccessListener(
                        resolvedLinkData -> {
                            if(resolvedLinkData != null){
                                StringBuilder stringBuffer = new StringBuilder();
                                if(resolvedLinkData.getDeepLink() != null){
                                    stringBuffer.append(resolvedLinkData.getDeepLink().toString());
                                    //解析出deeplink后跳转到实际页面
                                    Intent intents = new Intent();
                                    intents.setUri(Uri.parse(resolvedLinkData.getDeepLink().toString()));
                                    startAbility(intents);
                                }
                            }
                        })
                .addOnFailureListener(
                        e -> {
                            AGCLogger.e("ApplinkingAbilitySlice", "getAppLinking:onFailure", e);
                        });

        createButton.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                createLinking();
            }
        });

        shareLongButton.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                shareLink(longLink.getText());

            }
        });

        shareShortButton.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                shareLink(shortLink.getText());

            }
        });
    }

    public void createLinking(){
        AppLinking.Builder builder =
                AppLinking.newBuilder()
                        .setIsShowPreview(true)
                        .setUriPrefix(DOMAIN_URI_PREFIX)
                        .setDeepLink(Uri.parse(DEEP_LINK))
                        .setHarmonyLinkInfo(
                                AppLinking.HarmonyLinkInfo.newBuilder()
                                        .setHarmonyDeepLink("agckit://helloWorld")
                                        .build())
                        .setCampaignInfo(
                                AppLinking.CampaignInfo.newBuilder()
                                        .setName("HDC")
                                        .setSource("Huawei")
                                        .setMedium("App")
                                        .build())
                        .setPreviewType(AppLinking.LinkingPreviewType.SocialInfo)//展示预览页详情
                        .setSocialCardInfo(
                                AppLinking.SocialCardInfo.newBuilder()
                                        .setDescription("HDC")
                                        .setTitle("Huawei")
                                        .setImageUrl("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3862731350,3483076630&fm=26&gp=0.jpg")
                                        .build());
        LongUri = builder.buildAppLinking().getUri().toString();
        longLink.setText(LongUri);
        HiLog.info(hiLogLabel,"this is LongUri: " + LongUri);

        builder.buildShortAppLinking().addOnSuccessListener(shortAppLinking ->
        {
            ShortUri = shortAppLinking.getShortUrl().toString();
            shortLink.setText(ShortUri);
            HiLog.info(hiLogLabel,"this is ShortLink: " + ShortUri);
        }).addOnFailureListener(e -> {

        });
    }

    public void shareLink(String appLinking){
        if (appLinking != null) {
            Intent intent = new Intent();
            Operation operation = new Intent.OperationBuilder().withUri(Uri.parse(appLinking)).build();
            intent.setOperation(operation);
            startAbility(intent);
        }
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
