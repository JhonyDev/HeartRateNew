package com.app.heartrate.activities;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.app.heartrate.R;
import com.app.heartrate.sigletons.HistorySingleton;

public class HistoryDetail extends AppCompatActivity {
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
    EditText etTarget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_detail);
        initViews();
    }

    private void initViews() {
        rbMale = findViewById(R.id.rbMale);
        if (HistorySingleton.getInstance().getGender() == 1)
            rbMale.setChecked(true);
        rbFemale = findViewById(R.id.rbFemale);
        if (HistorySingleton.getInstance().getGender() == 0)
            rbMale.setChecked(true);

        rbTypical = findViewById(R.id.rbTypical);
        if (HistorySingleton.getInstance().getChestPainType() == 1)
            rbTypical.setChecked(true);

        rbTypicalAngina = findViewById(R.id.rbTypicalAngina);
        if (HistorySingleton.getInstance().getChestPainType() == 2)
            rbTypicalAngina.setChecked(true);
        rbNonAnginalPain = findViewById(R.id.rbNonAnginalPain);
        if (HistorySingleton.getInstance().getChestPainType() == 3)
            rbNonAnginalPain.setChecked(true);

        rbNormal = findViewById(R.id.rbNormal);
        if (HistorySingleton.getInstance().getRestingEcg() == 0)
            rbNormal.setChecked(true);
        rbAbnormal = findViewById(R.id.rbAbnormal);
        if (HistorySingleton.getInstance().getRestingEcg() == 1)
            rbAbnormal.setChecked(true);
        rbLeftVentricular = findViewById(R.id.rbLeftVentricular);
        if (HistorySingleton.getInstance().getRestingEcg() == 2)
            rbLeftVentricular.setChecked(true);
        rbAsymptomatic = findViewById(R.id.Asymptomatic);
        if (HistorySingleton.getInstance().getRestingEcg() == 3)
            rbAsymptomatic.setChecked(true);

        rbDepNo = findViewById(R.id.rbDepNo);
        if (HistorySingleton.getInstance().getExerciseAngina() == 0)
            rbDepNo.setChecked(true);
        rbDepYes = findViewById(R.id.rbDepYes);
        if (HistorySingleton.getInstance().getExerciseAngina() == 1)
            rbDepYes.setChecked(true);

        rbSTNormal = findViewById(R.id.rbSTNormal);
        if (HistorySingleton.getInstance().getStSlope() == 0)
            rbSTNormal.setChecked(true);
        rbUpSloping = findViewById(R.id.rbUpSloping);
        if (HistorySingleton.getInstance().getStSlope() == 1)
            rbUpSloping.setChecked(true);
        rbFlat = findViewById(R.id.rbFlat);
        if (HistorySingleton.getInstance().getStSlope() == 2)
            rbFlat.setChecked(true);
        rbDownSloping = findViewById(R.id.rbDownSloping);
        if (HistorySingleton.getInstance().getStSlope() == 3)
            rbDownSloping.setChecked(true);

        etAge = findViewById(R.id.etAge);
        etAge.setText(String.valueOf(HistorySingleton.getInstance().getAge()));
        etRestingBPS = findViewById(R.id.etRestingBPS);
        etRestingBPS.setText(String.valueOf(HistorySingleton.getInstance().getRestingBpS()));
        etCholesterol = findViewById(R.id.etCholesterol);
        etRestingBPS.setText(String.valueOf(HistorySingleton.getInstance().getCholestrol()));
        etFastingBloodSugar = findViewById(R.id.etFastingBloodSugar);
        etFastingBloodSugar.setText(String.valueOf(HistorySingleton.getInstance().getFastingBloodSugar()));
        etMaxHeartRate = findViewById(R.id.etMaxHeartRate);
        etMaxHeartRate.setText(String.valueOf(HistorySingleton.getInstance().getMaxHeartRate()));
        etOldPeak = findViewById(R.id.etOldPeak);
        etOldPeak.setText(String.valueOf(HistorySingleton.getInstance().getOldPeak()));
        etTarget = findViewById(R.id.etTarget);
        etTarget.setText(String.valueOf(HistorySingleton.getInstance().getTarget()));
    }
}