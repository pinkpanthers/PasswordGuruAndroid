package com.example.sterlingortiz.smithguru;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Sterling Ortiz on 4/28/2017.
 */

public class MainActivity extends AppCompatActivity {

    EditText userInputServiceProvider, userInputUsername, userInputPassword;
    Button btnAdd,btnView;
    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInputPassword = (EditText) findViewById(R.id.userPasswordDisplay);
        userInputServiceProvider = (EditText) findViewById(R.id.serviceProvider);
        userInputUsername = (EditText) findViewById(R.id.usernameInput);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnView = (Button) findViewById(R.id.btnView);
        myDB = new DatabaseHelper(this);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ViewListContents.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userServiceProvider = userInputServiceProvider.getText().toString();
                String accountUsername = userInputUsername.getText().toString();
                String accountPassword = userInputPassword.getText().toString();
                if(userServiceProvider.length() != 0 && accountUsername.length() != 0 && accountPassword.length() != 0){
                    AddData(userServiceProvider,accountUsername, accountPassword);
                    userInputPassword.setText("");
                    userInputUsername.setText("");
                    userInputServiceProvider.setText("");
                }else{
                    Toast.makeText(MainActivity.this,"You must put something in the text field!",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void AddData(String userServiceProvider,String accountUsername, String accountPassword ){
        boolean insertData = myDB.addData(userServiceProvider,accountUsername,accountPassword);

        if(insertData==true){
            Toast.makeText(MainActivity.this,"Successfully Entered Data!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this,"Something went wrong :(.",Toast.LENGTH_LONG).show();
        }
    }
}
