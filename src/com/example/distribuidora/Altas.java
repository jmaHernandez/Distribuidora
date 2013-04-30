package com.example.distribuidora;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Altas extends Activity {
	
	private EditText et1, et2, et3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_altas);
		// Show the Up button in the action bar.
		setupActionBar();
		
		et1 = (EditText) findViewById(R.id.id);
        et2 = (EditText) findViewById(R.id.modelo);
        et3 = (EditText) findViewById(R.id.color);
        
	}
	
	public void guardar(View view) {
		AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        
        SQLiteDatabase bd = admin.getWritableDatabase();
        
        String id = et1.getText().toString();
        String modelo = et2.getText().toString();
        String color = et3.getText().toString();
        
        ContentValues registro = new ContentValues();
       
        registro.put("_id", id);
        registro.put("modelo", modelo);
        registro.put("color", color);
        
        bd.insert("distribuidora", null, registro);
        bd.close();
        
        et1.setText("");
        et2.setText("");
        et3.setText("");
        
        Toast.makeText(this, "el registro ha sido insertado", Toast.LENGTH_SHORT).show();
	}
	
	public void menu(View view) {
		finish();
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.altas, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
