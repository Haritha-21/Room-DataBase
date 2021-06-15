package com.example.addvwinsuproomdata;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link readuserfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class readuserfragment extends Fragment {
    private TextView txtinfo;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public readuserfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment readuserfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static readuserfragment newInstance(String param1, String param2) {
        readuserfragment fragment = new readuserfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_readuserfragment, container, false);
        txtinfo= view.findViewById(R.id.txt_display_info);
        List<user> users =MainActivity.myappdatabase.myDao().getuser();
        String info="";
        for(user usr:users)
        {
            int id= usr.getUid();
            String name=usr.getName();
            String email=usr.getEmail();
            info=info+"\n\n"+"id:"+id+"\n Name:"+name+"\n"+"Email:"+email;
        }
        txtinfo.setText(info);
        return view;
    }

}