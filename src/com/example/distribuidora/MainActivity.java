package com.example.distribuidora;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	Button btnAltas;
	Button btnBajas;
	Button btnReportes;
	Button btnSalir;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnAltas = (Button) findViewById(R.id.altas);
		btnBajas = (Button) findViewById(R.id.bajas);
		btnReportes = (Button) findViewById(R.id.reportes);
		btnSalir = (Button) findViewById(R.id.salir);
		
		btnAltas.setOnClickListener(this);
		btnBajas.setOnClickListener(this);
		btnReportes.setOnClickListener(this);
		btnSalir.setOnClickListener(this);
		
	}
	
	public void onClick(View view) {
		Intent intent;
		
		switch(view.getId()) {
			case R.id.altas:
				intent = new Intent(this, Altas.class);
				startActivity(intent);
				
				break;
			case R.id.bajas:
				intent = new Intent(this, Bajas.class);
				startActivity(intent);
				
				break;
			case R.id.reportes:
				intent = new Intent(this, Reportes.class);
				startActivity(intent);
				
				break;
			case R.id.salir:
				finish();
				
				break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
