package com.example.distribuidora;

import android.annotation.TargetApi;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Bajas extends Activity {

	private EditText et1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bajas);
		// Show the Up button in the action bar.
		setupActionBar();
		
		et1 = (EditText) findViewById(R.id.id);
	}
	
	public void borrar(View view) {
		AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        
        SQLiteDatabase bd = admin.getWritableDatabase();
        
        String id = et1.getText().toString();
        
        int cant = bd.delete("distribuidora", "_id=" + id, null);
        bd.close();
        
        et1.setText("");
        
        if (cant == 1) {
            Toast.makeText(this, "El registro ha sido eliminado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "El registro no existe", Toast.LENGTH_SHORT).show();
        }
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
		getMenuInflater().inflate(R.menu.bajas, menu);
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
