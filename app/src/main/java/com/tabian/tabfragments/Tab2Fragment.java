package com.tabian.tabfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Tab2Fragment extends Fragment
{
    private static final String TAG = "Tab2Fragment";
    private static Button btn;
    private static EditText contactTxt;
    private static boolean added=false;
    static ArrayList<String> x;
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.tab2_fragment, container, false);

        btn = (Button) view.findViewById(R.id.addContacts);
        contactTxt = (EditText)view.findViewById(R.id.editText);

        x=new ArrayList<>();
        x.add("9167058724");
        x.add("9967868733");

        ListView listView = (ListView) view.findViewById(R.id.list);
        listView.setAdapter(new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_list_item_1 ,x));
        return view;
    }

    static void addContact()
    {
        if(!added){
            contactTxt.setVisibility(View.VISIBLE);
            btn.setText("ADD");
            if(!x.contains(contactTxt.getText().toString()))
                x.add(contactTxt.getText().toString());
            contactTxt.setText("");
            added = true;
        }
        else{
            contactTxt.setVisibility(View.GONE);
            btn.setText("ADD CONTACT");
            added = false;
        }

    }

    void refresh()
    {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(Tab2Fragment.this).attach(Tab2Fragment.this).commit();
    }
}