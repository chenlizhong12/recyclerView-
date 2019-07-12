package com.marvin.testproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<FruitBean> mFruitBeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = findViewById(R.id.recycler_list);
        recyclerView.setLayoutManager(layoutManager);
        DataAdapter dataAdapter = new DataAdapter(this, mFruitBeans);
        recyclerView.setAdapter(dataAdapter);
        dataAdapter.setOnItemClickListener(new DataAdapter.OnItemClickListener() {
            @Override
            public void setItemClick(View view, int tag, int position) {
                switch (view.getId()) {
                    case R.id.iv_item:
                        Toast.makeText(MainActivity.this, "图片被点击了" + position, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tv_item:
                        Toast.makeText(MainActivity.this, "文字被点击了" + position, Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });

    }

    private void initData() {
        mFruitBeans = new ArrayList<>();
        mFruitBeans.add(new FruitBean("西瓜", R.drawable.ic_launcher_background));
        mFruitBeans.add(new FruitBean("香蕉", R.drawable.ic_launcher_background));
        mFruitBeans.add(new FruitBean("哈密瓜", R.drawable.ic_launcher_background));
    }
}
