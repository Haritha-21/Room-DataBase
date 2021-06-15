package com.example.addvwinsuproomdata;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AdduserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AdduserFragment extends Fragment {
    private EditText userid,username,useremail;
    private Button Btnsave;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AdduserFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AdduserFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AdduserFragment newInstance(String param1, String param2) {
        AdduserFragment fragment = new AdduserFragment();
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
        View view = inflater.inflate(R.layout.fragment_adduser, container, false);
        userid=view.findViewById(R.id.userid);
        username=view.findViewById(R.id.name);
        useremail=view.findViewById(R.id.email);
        Btnsave=view.findViewById(R.id.save);

        Btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Userid=Integer.parseInt(userid.getText().toString());
                String Username= username.getText().toString();
                String Useremail= useremail.getText().toString();

                user user =new user();
                user.setUid(Userid);
                user.setName(Username);
                user.setEmail(Useremail);
                MainActivity.myappdatabase.myDao().adduser(user);
                Toast.makeText(getActivity(),"user added successfully",Toast.LENGTH_SHORT).show();
                userid.setText("");
                username.setText("");
                useremail.setText("");


            }
        });


        return view;
    }
}