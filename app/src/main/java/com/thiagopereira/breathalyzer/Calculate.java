package com.thiagopereira.breathalyzer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Calculate extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculate);
	}

	public void calculate(final View v) {
			final Intent it = getIntent();
			final double weight = it.getDoubleExtra("weight", 0);
			final String gender = it.getStringExtra("gender");
			final int ndrinks = it.getIntExtra("ndrinks", 0);
			final String fasting = it.getStringExtra("fasting");
			double coefficient;

			if(weight == 0) {
				Toast.makeText(getApplicationContext(), "Weight must be greater that 0!", Toast.LENGTH_SHORT).show();
				return;
			}

			if(fasting.equals("y") || fasting.equals("Y") || fasting.equals("s") || fasting.equals("S")) {
				coefficient = 1.1;
			} else if(gender.equals("m") || gender.equals("M")) {
				coefficient = 0.7;
			} else if(gender.equals("f") || gender.equals("F")) {
				coefficient = 0.6;
			} else {
				Toast.makeText(getApplicationContext(), "Invalid values!", Toast.LENGTH_SHORT).show();
				return;
			}

			final double level = (4.8*ndrinks)/(coefficient*weight);
			final String classification = (level > 0.2) ? getString(R.string.alcoholic) : getString(R.string.nonalcoholic);

			final Intent it2 = new Intent(this, MainActivity.class);

			it2.putExtra("level", level);
			it2.putExtra("classification", classification);

			it2.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

			setResult(0, it2);
			finish();
	}
}