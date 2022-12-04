package com.example.kiosk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    GridView gridView1, gridView2, gridView3;
    int[] numberImageg1 = {R.drawable.aame, R.drawable.dda, R.drawable.ddcr, R.drawable.icr,R.drawable.dddr,R.drawable.idr,};
    String[] numberMenug1 = {"아이스아메리카노","따뜻한아메리카노","따뜻한카페라떼","아이스카페라떼","따뜻한돌체라떼","아이스돌체라떼"};
    int[] numberImageg2 = {R.drawable.icetea, R.drawable.jamon, R.drawable.lemon, R.drawable.orange, R.drawable.raim, R.drawable.uja};
    String[] numberMenug2 = {"복숭아아이스티","스카플링자몽","레몬에이드","오렌지쥬스","스파클링라임","유자차"};
    int[] numberImageg3 = {R.drawable.ddarcake, R.drawable.gran, R.drawable.kas, R.drawable.milkcake, R.drawable.newcake, R.drawable.shocake};
    String[] numberMenug3 = {"딸기케이크","할머니빵","크림카스테라","밀크케이크","뉴욕치즈케이크","쇼콜라케이크"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); //액티비티의 앱바(App Bar)로 지정
        ActionBar actionBar = getSupportActionBar(); //앱바 제어를 위해 툴바 액세스
        actionBar.setDisplayHomeAsUpEnabled(true); // 앱바에 뒤로가기 버튼 만들기
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        gridView1 = findViewById(R.id.gridview1);
        gridView2 = findViewById(R.id.gridview2);
        gridView3 = findViewById(R.id.gridview3);

        GridViewAdapter gridViewAdapter1 = new GridViewAdapter(MenuActivity.this, numberImageg1, numberMenug1);
        gridView1.setAdapter(gridViewAdapter1);
        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long I){
                Intent intent = new Intent(getApplicationContext(), OrderActivity.class);
                startActivity(intent);
            }
        });
        GridViewAdapter gridViewAdapter2 = new GridViewAdapter(MenuActivity.this, numberImageg2, numberMenug2);
        gridView2.setAdapter(gridViewAdapter2);
        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long I){
                Intent intent = new Intent(getApplicationContext(), OrderActivity.class);
                startActivity(intent);
            }
        });
        GridViewAdapter gridViewAdapter3 = new GridViewAdapter(MenuActivity.this, numberImageg3, numberMenug3);
        gridView3.setAdapter(gridViewAdapter3);
        gridView3.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long I){
                Intent intent = new Intent(getApplicationContext(), OrderActivity.class);
                startActivity(intent);
            }
        });


        init(); // 스크롤뷰 init

        Button cartbtn = (Button) findViewById(R.id.cart_btn);
        cartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CartActivity.class);
                startActivity(intent);
            }
        });
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
                startActivity(new Intent(this,MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected (item);
        }
    }
    public void init() {
        coffeView = findViewById(R.id.gridview1);
        drinkView = findViewById(R.id.gridview2);
        dessertView = findViewById(R.id.gridview3);
    }
    private View coffeView;
    private View drinkView;
    private View dessertView;
    public void onClick(View v){ //버튼 클릭시 스크롤뷰 보이기
        Button coffebtn = (Button) findViewById(R.id.btn_coffe);
        Button drinkbtn = (Button) findViewById(R.id.btn_drink);
        Button dessertbtn = (Button) findViewById(R.id.btn_dessert);
        switch(v.getId()) {
            //coffe 스크롤뷰만 보이기
            case R.id.btn_coffe :
                coffeView.setVisibility(View.VISIBLE);
                drinkView.setVisibility(View.INVISIBLE);
                dessertView.setVisibility(View.INVISIBLE);
                coffebtn.setSelected(true);
                drinkbtn.setSelected(false);
                dessertbtn.setSelected(false);
                break;
            //drink 스크롤뷰만 보이기
            case R.id.btn_drink :
                coffeView.setVisibility(View.INVISIBLE);
                drinkView.setVisibility(View.VISIBLE);
                dessertView.setVisibility(View.INVISIBLE);
                coffebtn.setSelected(false);
                drinkbtn.setSelected(true);
                dessertbtn.setSelected(false);
                break;
            //dessert 스크롤뷰만 보이기
            case R.id.btn_dessert :
                coffeView.setVisibility(View.INVISIBLE);
                drinkView.setVisibility(View.INVISIBLE);
                dessertView.setVisibility(View.VISIBLE);
                coffebtn.setSelected(false);
                drinkbtn.setSelected(false);
                dessertbtn.setSelected(true);
                break;
        }
    }
}