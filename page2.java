package com.example.finaldemo;

import android.app.Activity;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.finaldemo.db.Controller;
import com.example.finaldemo.db.Database;
import com.example.finaldemo.model.Message;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class page2 extends Activity {

    public TextView name;
    public TextView phonenumber;

    private ListView listView;
    private ArrayList<Message> datalist;
    private ArrayAdapter<Message> adapter;

    private Controller controller = new Controller();
    private SQLiteDatabase db;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);

        name = findViewById(R.id.name);
        phonenumber = findViewById(R.id.phoneNumber);
        listView = findViewById(R.id.listView);

        Intent getdaData = getIntent();
        String getName = getdaData.getStringExtra("name");
        String getPhone = getdaData.getStringExtra("phonenumber");

        name.setText("志愿者： " + getName);
        phonenumber.setText("手机号： " + getPhone);

        datalist = new ArrayList<>();


        Database.setContext(page2.this);


        insertSomething();

        datalist = controller.selectM("select * from tb_m");
//        datalist.add("冰球");
//        datalist.add("速度滑冰");
//        datalist.add("花样滑冰");
//        datalist.add("短道速滑");
        adapter = new ArrayAdapter<>(page2.this, android.R.layout.simple_list_item_1, datalist);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        Intent intent = new Intent(page2.this, page3.class);
                        intent.putExtra("sport", "冰球");
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent2 = new Intent(page2.this, page3.class);
                        intent2.putExtra("sport", "速度滑冰");
                        startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3 = new Intent(page2.this, page3.class);
                        intent3.putExtra("sport", "花样滑冰");
                        startActivity(intent3);
                        break;
                    case 3:
                        Intent intent4 = new Intent(page2.this, page3.class);
                        intent4.putExtra("sport", "短道速滑");
                        startActivity(intent4);
                        break;
                }
            }
        });

    }

    private void insertSomething() {
        controller.insertM("冰球");
        controller.insertM("速度滑冰");
        controller.insertM("花样滑冰");
        controller.insertM("短道速滑");
//        controller.deleteM("冰球");
//        controller.deleteM("速度滑冰");
//        controller.deleteM("花样滑冰");
//        controller.deleteM("短道速滑");
    }

}
