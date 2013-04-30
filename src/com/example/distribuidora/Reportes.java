package com.example.distribuidora;

import android.annotation.TargetApi;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class Reportes extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reportes);
		// Show the Up button in the action bar.
		setupActionBar();
		
		try {
			AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
			SQLiteDatabase db = admin.getReadableDatabase();

			Cursor cursor = db.rawQuery("select _id, modelo, color from distribuidora", null);
			
			String[] columns = new String[] {"_id", "modelo", "color"};
			int[] to = new int[] {R.id._id, R.id.modelo, R.id.color};
		
			SimpleCursorAdapter dataAdapter = new SimpleCursorAdapter(this, R.layout.info, cursor, columns, to, 0);
		
			ListView listView = (ListView) findViewById(R.id.listView);
			listView.setAdapter(dataAdapter);
			
			listView.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> listView, View view, int position, long id) {
					//Get the cursor, positioned to the corresponding row in the result set
					//Cursor cursor = (Cursor) listView.getItemAtPosition(position);
				 
					//Get the state's capital from this row in the database.
					//int _id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
					
					// Intent intent = new Intent(Ligas.this, Informacion.class);
			        // intent.putExtra("_id", _id);
			        // startActivity(intent);
				}
			});
			
		} catch (Exception e) {
			Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
		}
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
		getMenuInflater().inflate(R.menu.reportes, menu);
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
