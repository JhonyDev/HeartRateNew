package com.app.heartrate.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.app.heartrate.R;
import com.app.heartrate.info.Info;
import com.app.heartrate.mvvm.MvvmUtils;
import com.app.heartrate.mvvm.capsules.request.PostLoginPojo;
import com.app.heartrate.mvvm.capsules.response.RegResponse;
import com.app.heartrate.mvvm.mapping_utils.GenericCall;
import com.app.heartrate.mvvm.mapping_utils.GenericResponse;
import com.app.heartrate.utils.DialogUtils;
import com.app.heartrate.utils.SharedPrefUtils;
import com.app.heartrate.utils.Utils;

public class LoginActivity extends AppCompatActivity implements Info {
    public static Activity context;
    EditText etEmail;
    EditText etPassword;
    String strEtEmail;
    String strEtPassword;
    boolean isPassVisible = false;
    private Dialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_pass);

        loadingDialog = new Dialog(this);
        DialogUtils.initLoadingDialog(loadingDialog);

//        if (!SharedPrefUtils.getToken(this).isEmpty()) {
//            startActivity(new Intent(this, MainScreen.class));
//            finish();
//        }

    }

    public void signUp(View view) {
        startActivity(new Intent(this, SignUpActivity.class));
    }

    public void showPassword(View view) {
        if (!isPassVisible) {
            etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            isPassVisible = true;
        } else {
            etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            isPassVisible = false;
        }

    }

    private void castStrings() {
        strEtEmail = etEmail.getText().toString();
        strEtPassword = etPassword.getText().toString();
    }

    private boolean isEverythingValid() {
        if (!Utils.validEt(etEmail, strEtEmail))
            return false;
        return Utils.validEt(etPassword, strEtPassword);
    }

    public void Login(View view) {
        castStrings();
        if (!isEverythingValid())
            return;
        initSignIn();
    }

    private void initSignIn() {
        castStrings();
        loadingDialog.show();
        new GenericCall<>(MvvmUtils.getNcs().postLogin(new PostLoginPojo(strEtEmail, strEtPassword)))
                .getMutableLiveData().observe(this, this::initResponse);
    }

    private void initResponse(GenericResponse<RegResponse> regResponseGenericResponse) {
        loadingDialog.dismiss();
        if (regResponseGenericResponse.isSuccessful()) {

            SharedPrefUtils.setToken(this, regResponseGenericResponse.getResponse().getKey());
            Log.i(TAG, "initResponse: " + regResponseGenericResponse.getResponse().getKey());
            startActivity(new Intent(this, MainScreen.class));
            finish();
        } else
            MvvmUtils.printErrors(this, regResponseGenericResponse);
    }
}