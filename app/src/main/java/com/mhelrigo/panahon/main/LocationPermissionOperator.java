package com.mhelrigo.panahon.main;

import static androidx.core.content.PermissionChecker.PERMISSION_GRANTED;

import android.Manifest;
import android.content.Context;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class LocationPermissionOperator {
    public interface OnShowPermissionRationale {
        void show(String permissionName);
    }

    public interface Result {
        void granted(String permissionName);

        void denied(String permissionName);
    }

    private AppCompatActivity appCompatActivity;
    private OnShowPermissionRationale onShowPermissionRationale;
    private Result result;
    private ActivityResultLauncher<String> requestPermissionLauncher;

    private String permission;

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public LocationPermissionOperator(AppCompatActivity appCompatActivity, OnShowPermissionRationale onShowPermissionRationale, Result result) {
        this.appCompatActivity = appCompatActivity;
        this.onShowPermissionRationale = onShowPermissionRationale;
        this.result = result;
    }

    public void initListener() {
        requestPermissionLauncher = appCompatActivity.registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
            if (isGranted) {
                result.granted(permission);
            } else {
                if (permission != Manifest.permission.ACCESS_BACKGROUND_LOCATION) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(appCompatActivity, permission)) {
                        onShowPermissionRationale.show(permission);
                    }
                }
                result.denied(permission);
            }
        });
    }

    public void verifyIfGivenPermissionIsGranted(String permission) {
        setPermission(permission);
        if (!checkSelfPermission(permission)) {
            requestPermission();
        } else {
            result.granted(permission);
        }
    }

    public Boolean checkSelfPermission(String permission) {
        return ContextCompat.checkSelfPermission(appCompatActivity.getApplicationContext(), permission) == PERMISSION_GRANTED;
    }

    public static Boolean checkSelfPermission(String permission, Context context) {
        return ContextCompat.checkSelfPermission(context, permission) == PERMISSION_GRANTED;
    }

    public void requestPermission() {
        requestPermissionLauncher.launch(permission);
    }
}
