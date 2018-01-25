package com.example.week9text;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUp extends Activity {
	private EditText ed1 = null;
	private EditText ed2 = null;
	private EditText ed3 = null;
	private EditText ed4 = null;
	private TextView tv1 = null;
	private Button bt = null;
	private Button bt2 = null;
	AlertDialog.Builder builder = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		// 获取插件
		this.ed1 = (EditText) super.findViewById(R.id.editText1);
		this.ed2 = (EditText) super.findViewById(R.id.editText2);
		this.ed3 = (EditText) super.findViewById(R.id.editText3);
		this.ed4 = (EditText) super.findViewById(R.id.editText4);
		this.tv1 = (TextView) super.findViewById(R.id.textView6);
		this.bt = (Button) super.findViewById(R.id.button1);
		this.bt2 = (Button) super.findViewById(R.id.button2);
		builder = new AlertDialog.Builder(this);
		bt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				builder.setMessage("您输入的用户名为:" + ed1.getText())
						.setCancelable(false)
						.setPositiveButton("YES",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface arg0,
											int arg1) {
										// TODO Auto-generated method stub

									}
								})
						.setNegativeButton("NO",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface arg0,
											int arg1) {
										// TODO Auto-generated method stub
										arg0.cancel();
									}
								});
				AlertDialog alert = builder.create();
				alert.show();
				Intent  intent = new Intent();
            	intent.setClass(SignUp.this, login.class);
            	startActivity(intent);
			}
		});
		bt2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				ed1.setText("");
				ed2.setText("");
				ed3.setText("");
				ed4.setText("");

			}
		});
		// this.ed1.setOnClickListener(new OnClickListenerImpl());
		this.ed1.setOnFocusChangeListener(new OnFocusChangeListenerImpl());
		this.ed2.setOnFocusChangeListener(new OnFocusChangeListenerImpl());
		this.ed3.setOnFocusChangeListener(new OnFocusChangeListenerImpl());
		this.ed4.setOnFocusChangeListener(new OnFocusChangeListenerImpl());
	}

	public class OnFocusChangeListenerImpl implements OnFocusChangeListener {

		@Override
		public void onFocusChange(View v, boolean hf) {
			// TODO Auto-generated method stub
			if(ed1.getText().toString()=="请输入用户名")
				ed1.setText("");
			String str1 = null;
			if (v.getId() == SignUp.this.ed1.getId()) {
				if (hf) {
					str1 = "";
				}
			} else {
				if (SignUp.this.ed1.getText().length() == 0) {
					str1 = "用户名不能为空" + "\n";
				}
				if (v.getId() == SignUp.this.ed2.getId()) {
					if (hf) {
						if (str1 != null)
							str1 += "" + "\n";
						else
							str1 = "" + "\n";
					}
				} else {
					if (SignUp.this.ed2.getText().length() == 0) {
						if (str1 != null)
							str1 += "密码不能为空" + "\n";
						else
							str1 = "密码不能为空" + "\n";
						
					}
					else
					if (SignUp.this.ed2.getText().length()<6){
						if (str1 != null)
							str1 += "密码长度需大于6！" + "\n";
						else
							str1 = "密码长度需大于6！" + "\n";
					}
					if (v.getId() == SignUp.this.ed3.getId()) {
						if (hf) {
							if (str1 != null)
								str1 += "" + "\n";
							else
								str1 = "" + "\n";
						}
					} else {
						if (SignUp.this.ed3.getText().length() == 0) {
							if (str1 != null)
								str1 += "地址不能为空" + "\n";
							else
								str1 = "地址不能为空" + "\n";
						} else {
							
						}
						
					}
				}

			}
			SignUp.this.tv1.setText(str1);
		}

	}

	public class OnClickListenerImpl implements OnClickListener {

		@Override
		public void onClick(View view) {
			// TODO Auto-generated method stub
			SignUp.this.ed1.setText("");
			AlertDialog.Builder builder = new AlertDialog.Builder(null);
			builder.setMessage("您输入的用户名为:" + ed1.getText()+"  "+ed3.getText()+"  "+ed4.getText())
					.setCancelable(false)
					.setPositiveButton("YES",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface arg0,
										int arg1) {
									// TODO Auto-generated method stub

								}
							})
					.setNegativeButton("NO",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface arg0,
										int arg1) {
									// TODO Auto-generated method stub
									arg0.cancel();
								}
							});

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
