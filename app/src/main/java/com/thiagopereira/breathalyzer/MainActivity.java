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

	public void send(final View v) {
		try {
			final double weight = Double.parseDouble(((EditText) findViewById(R.id.editWeight)).getText().toString());
			final String gender = ((EditText) findViewById(R.id.editGender)).getText().toString();
			final int ndrinks = Integer.parseInt(((EditText) findViewById(R.id.editNdrinks)).getText().toString());
			final String fasting = ((EditText) findViewById(R.id.editFasting)).getText().toString();

			//final Integer it = new Intent(getApplicationContext());

			/*
			double coefficient;

			if(weight == 0) {
				Toast.makeText(getApplicationContext(), "Weight must be greater that 0!", Toast.LENGTH_SHORT).show();
				return;
			} else if(ndrinks == 0) {
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

			final double result = (4.8*ndrinks)/(coefficient*weight);
			*/

		} catch(Exception e) {
			Toast.makeText(getApplicationContext(), "Fill all fields!", Toast.LENGTH_SHORT).show();
		}
	}
}