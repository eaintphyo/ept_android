package com.example.androidmapsv2;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {
	
	final int RQS_GooglePlayServices = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
	    case R.id.menu_legalnotices:
	    	String LicenseInfo = GooglePlayServicesUtil.getOpenSourceSoftwareLicenseInfo(
	    			getApplicationContext());
	    	AlertDialog.Builder LicenseDialog = new AlertDialog.Builder(MainActivity.this);
	    	LicenseDialog.setTitle("Legal Notices");
	    	LicenseDialog.setMessage(LicenseInfo);
	    	LicenseDialog.show();
	        return true;
	    }
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
		
		if (resultCode == ConnectionResult.SUCCESS){
			Toast.makeText(getApplicationContext(), 
					"isGooglePlayServicesAvailable SUCCESS", 
					Toast.LENGTH_LONG).show();
		}else{
			GooglePlayServicesUtil.getErrorDialog(resultCode, this, RQS_GooglePlayServices);
		}
		
	}

}
