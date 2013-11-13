package jp.co.iti.mymupdfsample;

import com.artifex.mupdfdemo.MuPDFActivity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button buttonShowPdf = (Button)findViewById(R.id.button_show_pdf);
		buttonShowPdf.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View view) {
				MainActivity.this.showPdf();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void showPdf() {
		String filePath = Environment.getExternalStorageDirectory()
							+ "/mysample.pdf";

		Uri uri = Uri.parse(filePath);

		Intent intent = new Intent(this, MuPDFActivity.class);
		intent.setAction(Intent.ACTION_VIEW);
		intent.setData(uri);

		try {
			startActivity(intent);
		} catch (ActivityNotFoundException e) {
			e.printStackTrace();
		}
	}
}
