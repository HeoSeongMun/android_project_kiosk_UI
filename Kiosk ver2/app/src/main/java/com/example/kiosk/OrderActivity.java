package com.example.kiosk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    private Button btnoption1, btnoption2, btnoption3, btnorder;
    private ImageButton btnminus, btnplus;
    private TextView textnumber;
    private int count = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = findViewById (R.id.toolbar);
        setSupportActionBar (toolbar); //액티비티의 앱바(App Bar)로 지정
        ActionBar actionBar = getSupportActionBar (); //앱바 제어를 위해 툴바 액세스
        actionBar.setDisplayHomeAsUpEnabled (true); // 앱바에 뒤로가기 버튼 만들기
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        textnumber = findViewById(R.id.number);
        textnumber.setText(count+"");
        btnplus = findViewById(R.id.plus_btn);
        btnminus = findViewById(R.id.minus_btn);
        btnorder = findViewById(R.id.btn_order);

        btnorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CartActivity.class);
                startActivity(intent);
            }
        });

        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                textnumber.setText(count+"");
            }
        });
        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                textnumber.setText(count+"");
            }
        });
    }
    public void onClick(View v){
        Button sizeM = (Button) findViewById(R.id.select_M);
        Button sizeL = (Button) findViewById(R.id.select_L);
        Button shotadd = (Button) findViewById(R.id.option1_btn);
        Button syrupadd = (Button) findViewById(R.id.option2_btn);
        Button whippingadd = (Button) findViewById(R.id.option3_btn);
        int pressf = 0;
        switch(v.getId()) {
            case R.id.select_M:
                sizeM.setSelected(true);
                sizeL.setSelected(false);
                break;
            case R.id.select_L:
                sizeM.setSelected(false);
                sizeL.setSelected(true);
                break;
        }
        switch(v.getId()){
            case R.id.option1_btn:
                shotadd.setSelected(!shotadd.isSelected());
                break;
            case R.id.option2_btn:
                syrupadd.setSelected(!syrupadd.isSelected());;
                break;
            case R.id.option3_btn:
                whippingadd.setSelected(!whippingadd.isSelected());
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater ().inflate (R.menu.menu_toolbar, menu);
        return true;
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId ()) {
            case android.R.id.home: //툴바 뒤로가기버튼 눌렸을 때 동작
                finish ();
                return true;
            case R.id.item1:
                startActivity(new Intent(this,MenuActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected (item);
        }
    }
}