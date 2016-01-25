package com.doubly.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.doubly.R;
import com.doubly.object.Interest;
import com.doubly.object.User;
import com.doubly.server.DBOpenHelper;
import com.doubly.utils.Session;
import com.doubly.utils.SessionKeys;

/**
 * Created by tinyiota on 1/7/16.
 */
public class AddInterestDialog extends BaseDialog {
    public AddInterestDialog(Context context) {
        super(context);
    }

    /** */

    //check interest exists
    //if not, insert into interest table ( user and global)
    //if it does, get list of interests that match


    private void createUserInterest(String name,String keywords,String radius,Boolean notify)
    {
        DBOpenHelper helper = new DBOpenHelper(context);
        int matchcount = 0; //getMatchCount(name);
        if(helper.interestExists(name))
        {
           // helper.addUserInterest

    }else
    {

        Interest newInterest = new Interest(name, matchcount);
    }
        int uID = Session.getInt(SessionKeys.PREFFS_USER_ID);

        //helper.addUserInterest(newInterest);

    }


    public void init()
    {
        setContentView(R.layout.dialog_add_interest);

        //View rootView = View.inflate(context, R.layout.dialog_add_interest, null);

        Button post = (Button)findViewById(R.id.post_interest);
        final EditText interestName   = (EditText)findViewById(R.id.interest_name);
        final EditText interestKeys = (EditText)findViewById(R.id.interest_keys);
        final EditText interestRadius = (EditText)findViewById(R.id.interest_radius);
        final RadioButton notify = (RadioButton)findViewById(R.id.interest_notifications);

        post.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        String name = interestName.getText().toString();
                        String keys = interestKeys.getText().toString();
                        String radius = interestRadius.getText().toString();
                        Boolean notif = notify.isChecked();
                        createUserInterest(name,keys,radius,notif);
                    }
                });
    }
}
