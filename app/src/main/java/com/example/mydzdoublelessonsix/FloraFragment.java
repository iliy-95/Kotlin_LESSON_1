package com.example.mydzdoublelessonsix;





import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;

import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;


public class FloraFragment extends Fragment {

    public static final String KEY_MONTHS = "months";

     Months months;




    public static FloraFragment newInstance(Months months){
      FloraFragment f = new FloraFragment();

      Bundle keys = new Bundle();
      keys.putParcelable(KEY_MONTHS,  months);
      f.setArguments(keys);
      return f;
  }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        months = getArguments().getParcelable(KEY_MONTHS);
    }

    @SuppressLint("Recycle")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_flora, container, false);

        AppCompatImageView imageflora = view.findViewById(R.id.imageNotes);
        TypedArray flora_ggg = getResources().obtainTypedArray(R.array.flora_a);
        imageflora.setImageResource(flora_ggg.getResourceId(months.getImageIndex(), -1));

        TextView MonthsNameView = view.findViewById(R.id.textView);
        MonthsNameView.setText(months.getMonthsName());
        return view;






    }




}






