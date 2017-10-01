package com.linua.instrumentedtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends BaseActivity {

    private String mShowText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initData();
        TextView tvTestIntent = (TextView) findViewById(R.id.tvTestIntent);
        tvTestIntent.setText(tvTestIntent.getText().toString() + mShowText);
    }

    private void initData(){
        Intent intent = getIntent();
        if(intent != null && !TextUtils.isEmpty(intent.getStringExtra("testString"))){
            mShowText = intent.getStringExtra("testString");
        }
    }

    @Override
    public void onClick(View v){
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }
}
