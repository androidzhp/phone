package com.example.codess;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText et_number;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et_number = (EditText) findViewById(R.id.editText1);
		Button bt_call = (Button) findViewById(R.id.button1);
		bt_call.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				callPhone();
			}
		});
	}

	private void callPhone() {
		String number = et_number.getText().toString();
		if ("".equals(number)) {
			Toast.makeText(MainActivity.this, "号码不能为空", Toast.LENGTH_LONG).show();
			return;
		}

		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_CALL);
		intent.setData(Uri.parse("tel:" + number));
		startActivity(intent);
	}

}
