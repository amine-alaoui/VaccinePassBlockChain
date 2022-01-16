package com.cdac.vaccinePassVerifBlockChain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
	TextView fullname;
	TextView cin;
	TextView firstDose;
	TextView secondDose;
	TextView typeVaccin;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		fullname = findViewById(R.id.FullName);
		cin = findViewById(R.id.CIN);
		firstDose =findViewById(R.id.Date1Dose);
		secondDose =findViewById(R.id.Date2Dose);
		typeVaccin = findViewById(R.id.TypeVaccin);
		Bundle extra = this.getIntent().getExtras();
		if(extra!=null){
			String monMsg = extra.getString("clé");
			String [] result = monMsg.split(";");
			fullname.setText(result[1]);
			cin.setText(result[2]);
			firstDose.setText(result[3]);
			secondDose.setText(result[4]);
			typeVaccin.setText(result[5]);
		}
	}
}
