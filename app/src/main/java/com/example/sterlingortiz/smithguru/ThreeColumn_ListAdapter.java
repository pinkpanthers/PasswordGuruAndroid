package com.example.sterlingortiz.smithguru;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Sterling Ortiz on 4/28/2017.
 */

public class ThreeColumn_ListAdapter extends ArrayAdapter<UserAccounts> {

    private LayoutInflater mInflater;
    private ArrayList<UserAccounts> users;
    private int mViewResourceId;

    public ThreeColumn_ListAdapter(Context context, int textViewResourceId, ArrayList<UserAccounts> users) {
        super(context, textViewResourceId, users);
        this.users = users;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

        UserAccounts user = users.get(position);

        if (user != null) {
            TextView serviceProvider = (TextView) convertView.findViewById(R.id.userServiceProviderDisplay);
            TextView userName = (TextView) convertView.findViewById(R.id.usernameDisplay);
            TextView userPassword = (TextView) convertView.findViewById(R.id.userPasswordDisplay);
            if (serviceProvider != null) {
                serviceProvider.setText(user.getServiceProvider());
            }
            if (userName != null) {
                userName.setText((user.getAcctUsername()));
            }
            if (userPassword != null) {
                userPassword.setText((user.getAcctPassword()));
            }
        }

        return convertView;
    }
}
