package com.example.biometricauthentication.biometricManager;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;

/**
 * Created by RavindraP on 12,July,2019
 */
public class BiometricUtils {

    public static boolean isBiometricPromtEnabled(){
        return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P);
    }

    public static boolean isSdkVersionSupported() {
        return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M);
    }

    public static boolean isBiometricHardwareSupported(Context mContext){
        FingerprintManagerCompat fingerprintManagerCompat = FingerprintManagerCompat.from(mContext);
        return fingerprintManagerCompat.isHardwareDetected();
    }

    public static boolean isBiometricAvailable(Context mContext){
        FingerprintManagerCompat fingerprintManagerCompat = FingerprintManagerCompat.from(mContext);
        return fingerprintManagerCompat.hasEnrolledFingerprints();
    }

    public static boolean isBiometricPermissionGranted(Context mContext){
        return (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.USE_FINGERPRINT) == PackageManager.PERMISSION_GRANTED);
    }

}
