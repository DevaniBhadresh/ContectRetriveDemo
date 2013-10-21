package com.ContectRetrive;

import java.net.URI;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts.Phones;
import android.provider.ContactsContract;
import android.provider.UserDictionary;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContectRetriveActivity extends Activity {
    /** Called when the activity is first created. */
	ListView ls;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ls=(ListView)findViewById(R.id.lstContect);
        
        ContentResolver cr = getContentResolver();
        Cursor c = cr.query(ContactsContract.Contacts.CONTENT_URI, null,
        null, null, null);
        String names[]=new String[c.getCount()];
        String num[]=new String[c.getCount()];
                int i=0;
                while(c.moveToNext())
                {
                 names[i++]=c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                }
                ArrayAdapter<String> aa=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);
                ls.setAdapter(aa);

        
    }
}