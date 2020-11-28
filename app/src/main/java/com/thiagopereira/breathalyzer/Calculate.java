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
			final double weight = it.getDoubleExtra("weight", 1);
			final String gender = it.getStringExtra("gender");
			final int ndrinks = it.getIntExtra("ndrinks", 0);
			final String fasting = it.getStringExtra("fasting");
			double coefficient= it.getDoubleExtra("coefficient", 1);

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