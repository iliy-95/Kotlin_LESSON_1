package com.example.mydzdoublelessonsix;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MonthsFragment<isLandscape> extends Fragment {

    public static final String CURRENT_MONTHS = "CurrentMonths";

    private Months currentMonths;
    private boolean isLandscape;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_months, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList(view);
    }





    private void initList(View view) {
        LinearLayout layoutView = (LinearLayout) view;
        String[] notes = getResources().getStringArray(R.array.notes);

        for (int i = 0; i < notes.length; i++) {
            String city = notes[i];
            TextView tv = new TextView(getContext());
            tv.setText(city);
            tv.setTextSize(25);
            layoutView.addView(tv);
            final int fi = i;
            tv.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        //showPortFlora(fi);
                        //currentPosition = fi;
                        //showFlora(currentPosition);
                        currentMonths = new Months(fi,
                                getResources().getStringArray(R.array.notes)[fi]) {
                        };
                        showFlora(currentMonths);
                    }
                });
                }
            } {



        }



    // Сохраним текущую позицию (вызывается перед выходом из фрагмента)
    //@Override
   // public void onSaveInstanceState( Bundle outState) {
       // outState.putInt(CURRENT_MONTHS, currentPosition);
        //super.onSaveInstanceState(outState);
    //}
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(CURRENT_MONTHS,currentMonths);
        super.onSaveInstanceState(outState);
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        isLandscape = getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;


        if (savedInstanceState != null) {

            //currentPosition = savedInstanceState.getInt(CURRENT_MONTHS, 0);
            currentMonths = savedInstanceState.getParcelable(CURRENT_MONTHS);
        } else {

            currentMonths = new Months(0, getResources().getStringArray(R.array.notes)[0]) {
            };
        }

        if (isLandscape) {
            showLandFlora(currentMonths);
        }
    }







        private void showFlora ( Months currentMonths){
            if (isLandscape) {
                showLandFlora(currentMonths);
            } else {
                showPortFlora(currentMonths);
            }
        }

        //  ландшафтная ориентации
        private void showLandFlora (Months currentMonths){
            // Создаём новый фрагмент с текущей позицией для вывода изоображения.
            FloraFragment detail = FloraFragment.newInstance(currentMonths);

            // Выполняем транзакцию по замене фрагмента
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.imge2Notes, detail);  // замена фрагмента
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }




    private void showPortFlora ( Months currentMonths){
            // Откроем вторую activity
            Intent intent = new Intent();
            intent.setClass(getActivity(), FloraOrientation.class);
            // и передадим туда параметры
            intent.putExtra(FloraFragment.KEY_MONTHS, currentMonths);
            startActivity(intent);
        }



}


