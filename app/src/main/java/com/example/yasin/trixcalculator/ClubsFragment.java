package com.example.yasin.trixcalculator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClubsFragment extends Fragment {


    public ClubsFragment() {
        // Required empty public constructor
    }

    boolean isScored = false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_clubs, container, false);

        final ComplexActivity activity = (ComplexActivity)getActivity();

        SeekBar seek = v.findViewById(R.id.Lseek);

        final TextView t1L = v.findViewById(R.id.team1L);
        final TextView t2L = v.findViewById(R.id.team2L);

        final ImageView image = v.findViewById(R.id.ClubsImage);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isScored){
                    DiamondsFragment fragment = new DiamondsFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.mainFrame,fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }

            }
        });

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int value = SeekValues.SeekValues(seekBar);
                int mid = seekBar.getMax()/2;
                if(value!= mid){
                    t1L.setText(String.valueOf(value));
                    t2L.setText(String.valueOf(mid-value-1));
                    activity.setLtoosh(value*-15);
                    isScored = true;

                }else{
                    t1L.setText("0");
                    t2L.setText("0");
                    isScored=false;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return v;
    }



}
