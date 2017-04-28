package com.example.sterlingortiz.smithguru;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

/**
 * Created by Sterling Ortiz on 4/28/2017.
 */

public class ViewListContents extends AppCompatActivity {

    DatabaseHelper myDB;
    ArrayList<UserAccounts> userAccountList;
    ListView listView;
    UserAccounts account;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_contents_layout);

        myDB = new DatabaseHelper(this);

        userAccountList = new ArrayList<>();
        Cursor data = myDB.getListContents();
        int numRows = data.getCount();
        if(numRows == 0){
            Toast.makeText(ViewListContents.this,"The Database is empty  :(.",Toast.LENGTH_LONG).show();
        }else{
            int i=0;
            while(data.moveToNext()){
                account = new UserAccounts(data.getString(1),data.getString(2),data.getString(3));
                userAccountList.add(i, account);
                System.out.println(data.getString(1)+" "+data.getString(2)+" "+data.getString(3));
                System.out.println(userAccountList.get(i).getServiceProvider());
                i++;
            }
            ThreeColumn_ListAdapter adapter =  new ThreeColumn_ListAdapter(this,R.layout.list_adapter_view, userAccountList);
            listView = (ListView) findViewById(R.id.listView);
            listView.setAdapter(adapter);
        }
    }
}

