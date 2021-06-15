package com.example.addvwinsuproomdata;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Homefragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Homefragment extends Fragment  implements View.OnClickListener{
    private Button Bnadduser,Bnreaduser,Bnupdate,Bndelete;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Homefragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Homefragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Homefragment newInstance(String param1, String param2) {
        Homefragment fragment = new Homefragment();
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
        View view = inflater.inflate(R.layout.fragment_homefragment, container, false);
        Bnadduser=view.findViewById(R.id.adduser);
        Bnadduser.setOnClickListener(this);
        Bnreaduser=view.findViewById(R.id.viewuser);
        Bnreaduser.setOnClickListener(this);
        Bnupdate=view.findViewById(R.id.updateuser);
        Bnupdate.setOnClickListener(this);
        Bndelete=view.findViewById(R.id.deleteuser);
        Bndelete.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.adduser:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentcontainer,new AdduserFragment()).addToBackStack(null).commit();
                break;
            case R.id.viewuser:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentcontainer,new readuserfragment()).addToBackStack(null).commit();
                break;
            case R.id.updateuser:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentcontainer,new UpdateFragment()).addToBackStack(null).commit();
                break;
            case R.id.deleteuser:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentcontainer,new Deleteuserfragment()).addToBackStack(null).commit();
                break;
        }


    }
}