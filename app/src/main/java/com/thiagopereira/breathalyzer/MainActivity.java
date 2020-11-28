package com.thiagopereira.breathalyzer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if(data != null) {
			final double level = data.getDoubleExtra("level", 0);
			final String classification = data.getStringExtra("classification");

			final String message = getString(R.string.level) + " " + level + "\n" + getString(R.string.classification) + " " + classification;
			Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
		}
	}

	public void send(final View v) {
		try {
			final double weight = Double.parseDouble(((EditText) findViewById(R.id.editWeight)).getText().toString());
			final String gender = ((EditText) findViewById(R.id.editGender)).getText().toString();
			final int ndrinks = Integer.parseInt(((EditText) findViewById(R.id.editNdrinks)).getText().toString());
			final String fasting = ((EditText) findViewById(R.id.editFasting)).getText().toString();
			double coefficient;

			if(weight == 0) {
				Toast.makeText(getApplicationContext(), "Weight must be greater that 0!", Toast.LENGTH_SHORT).show();
				return;
			}

			if(fasting.equals("n") || fasting.equals("N")) {
				coefficient = 1.1;
			} else if(gender.equals("m") || gender.equals("M")) {
				coefficient = 0.7;
			} else if(gender.equals("f") || gender.equals("F")) {
				coefficient = 0.6;
			} else {
				Toast.makeText(getApplicationContext(), "Invalid values!", Toast.LENGTH_SHORT).show();
				return;
			}

			final Intent it = new Intent(this, Calculate.class);

			it.putExtra("weight", weight);
			it.putExtra("gender", gender);
			it.putExtra("ndrinks", ndrinks);
			it.putExtra("fasting", fasting);
			it.putExtra("coefficient", coefficient);

			startActivityForResult(it, 0);
		} catch(Exception e) {
			Toast.makeText(getApplicationContext(), "Fill all fields!", Toast.LENGTH_SHORT).show();
		}
	}
}