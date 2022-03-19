package com.app.heartrate.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.app.heartrate.R;
import com.app.heartrate.mvvm.MvvmUtils;
import com.app.heartrate.mvvm.capsules.request.PostFormData;
import com.app.heartrate.mvvm.capsules.response.PredicationRespCapsule;
import com.app.heartrate.mvvm.mapping_utils.GenericCall;
import com.app.heartrate.mvvm.mapping_utils.GenericResponse;
import com.app.heartrate.utils.DialogUtils;
import com.app.heartrate.utils.SharedPrefUtils;
import com.app.heartrate.utils.Utils;

public class FormPrediction extends AppCompatActivity {

    /**
     * int age
     * Radio sex 0 - female, 1 - male
     * Radio button - Chest Pain Type [Typical - 1, Typical Angina - 2, Non Anginal Pain - 3, Asymptomatic - 4]
     * Integer Resting BPS
     * Integer Cholesterol
     * Fasting Blood Sugar - Greater than 120 = 1 else 0
     * Resting ECG [Normal - 0, abnormality in ST/T wave - 1, Left ventricular hypertrophy - 2]
     * Integer Max HeartRate
     * Exercise Angina = 0 - depicting no, 1 - depicting yes
     * Integer old peak
     * ST Slope = [0 - normal, 1 - up sloping, 2 - flat, 3 - down sloping]
     * -----------------------------------------------------------------------
     * OUTPUT OF PREDICTION ===Target = 1 - Patient is suffering from heart risk, 0 - normal
     */
    RadioButton rbMale,
            rbFemale,
            rbTypical,
            rbTypicalAngina,
            rbNonAnginalPain,
            rbNormal,
            rbAbnormal,
            rbLeftVentricular,
            rbDepNo,
            rbDepYes,
            rbSTNormal,
            rbUpSloping,
            rbFlat,
            rbAsymptomatic,
            rbDownSloping;

    EditText etRestingBPS;
    EditText etCholesterol;
    EditText etFastingBloodSugar;
    EditText etMaxHeartRate;
    EditText etOldPeak;
    EditText etAge;

    String strEtAge;
    String strEtRestingBPS;
    String strEtCholesterol;
    String strEtFastingBloodSugar;
    String strEtMaxHeartRate;
    String strEtOldPeak;
    Dialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_prediction);
        initViews();
        loadingDialog = new Dialog(this);
        DialogUtils.initLoadingDialog(loadingDialog);

    }

    private void initViews() {
        rbMale = findViewById(R.id.rbMale);
        rbMale.setChecked(true);
        rbFemale = findViewById(R.id.rbFemale);

        rbTypical = findViewById(R.id.rbTypical);
        rbTypical.setChecked(true);
        rbTypicalAngina = findViewById(R.id.rbTypicalAngina);
        rbNonAnginalPain = findViewById(R.id.rbNonAnginalPain);

        rbNormal = findViewById(R.id.rbNormal);
        rbNormal.setChecked(true);
        rbAbnormal = findViewById(R.id.rbAbnormal);
        rbLeftVentricular = findViewById(R.id.rbLeftVentricular);
        rbAsymptomatic = findViewById(R.id.Asymptomatic);

        rbDepNo = findViewById(R.id.rbDepNo);
        rbDepNo.setChecked(true);
        rbDepYes = findViewById(R.id.rbDepYes);

        rbSTNormal = findViewById(R.id.rbSTNormal);
        rbSTNormal.setChecked(true);
        rbUpSloping = findViewById(R.id.rbUpSloping);
        rbFlat = findViewById(R.id.rbFlat);
        rbDownSloping = findViewById(R.id.rbDownSloping);

        etAge = findViewById(R.id.etAge);
        etRestingBPS = findViewById(R.id.etRestingBPS);
        etCholesterol = findViewById(R.id.etCholesterol);
        etFastingBloodSugar = findViewById(R.id.etFastingBloodSugar);
        etMaxHeartRate = findViewById(R.id.etMaxHeartRate);
        etOldPeak = findViewById(R.id.etOldPeak);
    }

    public void back(View view) {
        finish();
    }

    public void submit(View view) {
        castStrings();
        if (isEverythingValid()) {
            int sex = 0;
            int exerciseAngina = 0;
            int STSlope = 0;
            int restingECG = 0;
            int age = Integer.parseInt(strEtAge);
            int restingBPS = Integer.parseInt(strEtRestingBPS);
            int cholesterol = Integer.parseInt(strEtCholesterol);
            int fastingBloodSugar = Integer.parseInt(strEtFastingBloodSugar);
            int MaxHeartRate = Integer.parseInt(strEtMaxHeartRate);
            int oldPeak = Integer.parseInt(strEtOldPeak);

            if (rbMale.isChecked())
                sex = 1;

            int chestPainType = 1;

            if (rbTypicalAngina.isChecked())
                chestPainType = 2;

            if (rbNonAnginalPain.isChecked())
                chestPainType = 3;

            if (rbAsymptomatic.isChecked())
                chestPainType = 4;

            if (rbDepYes.isChecked())
                exerciseAngina = 1;

            if (rbAbnormal.isChecked())
                restingECG = 1;

            if (rbLeftVentricular.isChecked())
                restingECG = 2;

            if (rbUpSloping.isChecked())
                STSlope = 1;

            if (rbFlat.isChecked())
                STSlope = 2;

            if (rbDownSloping.isChecked())
                STSlope = 3;

            PostFormData postFormData = new PostFormData(age,
                    sex,
                    chestPainType,
                    restingBPS,
                    cholesterol,
                    fastingBloodSugar,
                    restingECG,
                    MaxHeartRate,
                    exerciseAngina,
                    oldPeak,
                    STSlope);
//            TODO: Post to Model

            loadingDialog.show();
            Log.i("TAG", "submit: " + SharedPrefUtils.getToken(this));
            new GenericCall<>(MvvmUtils.getNcs()
                    .postPrediction(SharedPrefUtils.getToken(this), postFormData))
                    .getMutableLiveData()
                    .observe(this, this::initPredictionResp);

        }
    }

    private void initPredictionResp(GenericResponse<PredicationRespCapsule> historyPojoGenericResponse) {
        loadingDialog.dismiss();
        if (historyPojoGenericResponse.isSuccessful()) {
            int target = historyPojoGenericResponse.getResponse().getTarget();
            Toast.makeText(this, String.valueOf(target), Toast.LENGTH_SHORT).show();
            Log.i("TAG", "initPredictionResp: " + target);
            startActivity(new Intent(this, HistoryActivity.class));
            finish();
        } else
            MvvmUtils.printGeneralErrors(this, historyPojoGenericResponse.getErrorMessages());
        if (historyPojoGenericResponse.getResponseCode() == 401) {
            SharedPrefUtils.setToken(this, "");
            Toast.makeText(this, "Please Login again", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
    }

    private void castStrings() {
        strEtRestingBPS = etRestingBPS.getText().toString();
        strEtCholesterol = etCholesterol.getText().toString();
        strEtFastingBloodSugar = etFastingBloodSugar.getText().toString();
        strEtMaxHeartRate = etMaxHeartRate.getText().toString();
        strEtOldPeak = etOldPeak.getText().toString();
        strEtAge = etAge.getText().toString();
    }

    private boolean isEverythingValid() {
        if (!Utils.validEt(etRestingBPS, strEtRestingBPS))
            return false;
        if (!Utils.validEt(etCholesterol, strEtCholesterol))
            return false;
        if (!Utils.validEt(etFastingBloodSugar, strEtFastingBloodSugar))
            return false;
        if (!Utils.validEt(etMaxHeartRate, strEtMaxHeartRate))
            return false;
        if (!Utils.validEt(etOldPeak, strEtOldPeak))
            return false;
        if (!Utils.validEt(etAge, strEtAge))
            return false;

        return true;

    }
}