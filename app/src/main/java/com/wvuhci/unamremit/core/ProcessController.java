package com.wvuhci.unamremit.core;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioGroup;

import com.wvuhci.unamremit.MainActivity;
import com.wvuhci.unamremit.R;
import com.wvuhci.unamremit.fragment.*;

/**
 * Use for control the process of the fragment
 */

public class ProcessController extends Fragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener{
    protected Fragment nextFragment;

    @Override
    public void onClick(View view) {

    }

    public void switchFragment(Fragment fragment){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.main_container, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

    }
}
