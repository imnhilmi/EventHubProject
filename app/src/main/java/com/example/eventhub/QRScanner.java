package com.example.eventhub;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QRScanner extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private static final int CAMERA_PERMISSION_REQUEST_CODE = 100;
    private ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_scanner);

        // Check and request camera permission
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},
                    CAMERA_PERMISSION_REQUEST_CODE);
        } else {
            initializeScanner();
        }
    }

    private void initializeScanner() {
        // Initialize ZXingScannerView
        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);

        // Set the result handler
        scannerView.setResultHandler(this);

        // Start camera
        scannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (scannerView != null) {
            scannerView.stopCamera();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (scannerView != null) {
            scannerView.setResultHandler(this);
            scannerView.startCamera();
        }
    }

    @Override
    public void handleResult(Result rawResult) {
        // Handle the result here
        String result = rawResult.getText();
        Toast.makeText(this, "QR Code Result: " + result, Toast.LENGTH_SHORT).show();

        // Resume scanning
        scannerView.resumeCameraPreview(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, initialize the scanner
                initializeScanner();
            } else {
                // Permission denied, show a message or handle accordingly
                Toast.makeText(this, "Camera permission is required to use the QR scanner", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
