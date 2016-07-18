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

public class MainActivity extends Activity implements OnClickListener {

	private EditText et_number;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et_number = (EditText) findViewById(R.id.editText1);
		Button bt_call1 = (Button) findViewById(R.id.button1);
		Button bt_call2 = (Button) findViewById(R.id.button2);
		Button bt_call3 = (Button) findViewById(R.id.button3);
		Button bt_call4 = (Button) findViewById(R.id.button4);
		bt_call1.setOnClickListener(this);
		bt_call2.setOnClickListener(this);
		bt_call3.setOnClickListener(this);
		bt_call4.setOnClickListener(this);
	}

	private void callPhone() {
		String number = et_number.getText().toString();
		if ("".equals(number)) {
			Toast.makeText(MainActivity.this, "号码不能为空", Toast.LENGTH_LONG).show();
			return;
		}

		callPhone(number);
	}

	private void callPhone(String number) {
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_CALL);
		intent.setData(Uri.parse("tel:" + number));
		startActivity(intent);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			callPhone();
			break;
		case R.id.button2:
			callPhone("110");
			break;
		case R.id.button3:
			callPhone("120");
			break;
		case R.id.button4:
			callPhone("119");
			break;
		default:
			break;
		}
	}

}
