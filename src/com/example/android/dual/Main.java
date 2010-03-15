package com.example.android.dual;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main extends Activity {
	
	private static final int SHOW_EDITOR = 0;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Button button = (Button)findViewById(R.id.Button01);
		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Main.this, Editor.class);
				TextView textView = (TextView)findViewById(R.id.TextView01);
				CharSequence text = textView.getText();
				intent.putExtra("TEXT", text + "000");
				startActivityForResult(intent, SHOW_EDITOR);
			}
			 
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == SHOW_EDITOR) {
			if (resultCode == RESULT_OK) {
				TextView textView = (TextView)findViewById(R.id.TextView01);
			   	textView.setText(data.getCharSequenceExtra("TEXT"));
			}
		}
	}
	
}