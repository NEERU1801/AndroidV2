package com.adobe.busbooking;

import android.util.Log;

import com.adobe.marketing.mobile.MobileCore;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessagingService;

public class MyFirebaseInstanceIdService extends FirebaseMessagingService {
    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);

        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {

                String token = instanceIdResult.getToken();
                Log.i("MY---Token",token);
                // MobileCore.setPushIdentifier(marketingCloudVisitorId);
                MobileCore.setPushIdentifier(token);
            }
        });
    }
}
