package com.app.heartrate.activities;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.app.heartrate.R;
import com.app.heartrate.mvvm.MvvmUtils;
import com.app.heartrate.mvvm.mapping_utils.GenericCall;
import com.app.heartrate.mvvm.mapping_utils.GenericResponse;
import com.app.heartrate.mvvm.capsules.request.PostRegPojo;
import com.app.heartrate.mvvm.capsules.response.RegResponse;
import com.app.heartrate.mvvm.capsules.response.UserPojo;
import com.app.heartrate.utils.DialogUtils;
import com.app.heartrate.utils.Utils;

public class SignUpActivity extends AppCompatActivity {
    public static UserPojo userPojo;
    public static String strEtPassword;
    public static Activity context;
    boolean isPassVisible = false;
    EditText etUserName;
    EditText etEmail;
    EditText etAge;
    EditText etPassword;
    EditText etConfirmPassword;
    String strEtUserName;
    String strEtEmail;
    String strEtAge;
    String strEtConfirmPassword;
    Dialog dgLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        context = this;
        initViews();
        dgLoading = new Dialog(this);
        DialogUtils.initLoadingDialog(dgLoading);

    }

    public void showPassword(View view) {
        if (!isPassVisible) {
            etConfirmPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            isPassVisible = true;
        } else {
            etConfirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            isPassVisible = false;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void castStrings() {
        strEtAge = etAge.getText().toString();
        strEtEmail = etEmail.getText().toString();
        strEtUserName = etUserName.getText().toString();
        strEtPassword = etPassword.getText().toString();
        strEtConfirmPassword = etConfirmPassword.getText().toString();
    }

    private void initViews() {
        etUserName = findViewById(R.id.et_food_items);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_pass);
        etAge = findViewById(R.id.et_age);
        etConfirmPassword = findViewById(R.id.et_confirm_pass);
    }

    public void back(View view) {
        finish();
    }

    public void signUp(View view) {
        castStrings();
        if (!isEverythingValid()) {
            Toast.makeText(this, "Fields invalid please check", Toast.LENGTH_SHORT).show();
            return;
        }
        new GenericCall<>(MvvmUtils.getNcs().postAuth(new PostRegPojo(strEtUserName,
                strEtUserName,
                strEtUserName,
                strEtEmail,
                strEtPassword,
                strEtConfirmPassword))).getMutableLiveData().observe(this, this::initResponse);
    }

    private void initResponse(GenericResponse<RegResponse> regResponseGenericResponse) {
        dgLoading.dismiss();
        if (regResponseGenericResponse.isSuccessful()) {
            Toast.makeText(this, regResponseGenericResponse.getResponse().getSuccess(), Toast.LENGTH_SHORT).show();
            finish();
        } else
            MvvmUtils.printErrors(this, regResponseGenericResponse);
    }

    private boolean isEverythingValid() {
        if (!Utils.validEt(etUserName, strEtUserName))
            return false;

        if (!Utils.validEt(etEmail, strEtEmail))
            return false;

        if (!Utils.validEt(etAge, strEtAge))
            return false;

        if (!Utils.validEt(etPassword, strEtPassword))
            return false;

        return strEtPassword.equals(strEtConfirmPassword);
    }

}