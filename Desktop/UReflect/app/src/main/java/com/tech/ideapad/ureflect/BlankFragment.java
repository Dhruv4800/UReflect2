package com.tech.ideapad.ureflect;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
UsageListAdapter us=new UsageListAdapter();
    //long totalusage=us.add();
    TextView txt;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_blank, container, false);
        txt=(TextView)v. findViewById(R.id.totalusage);
        /*txt.setText(String.format("%02d hrs, %02d min, %02d sec",
                TimeUnit.MILLISECONDS.toHours(us.add()),
                TimeUnit.MILLISECONDS.toMinutes(us.add()) % TimeUnit.HOURS.toMinutes(1),
                TimeUnit.MILLISECONDS.toSeconds(us.add()) % TimeUnit.MINUTES.toSeconds(1)));*/
        return v;
    }


}
