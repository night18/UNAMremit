package com.wvuhci.unamremit.core;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioGroup;

import com.wvuhci.unamremit.R;
import com.wvuhci.unamremit.fragment.*;

/**
 * Use for control the process of the fragment
 */

public class ProcessController extends Fragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener{
    protected Fragment homeFragment, amountFragment, receiverFragment, paymentFragment, paymethodFragment, reviewFragment;
//
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.StartRemit:
                amountFragment = new AmountFragment();
                switchFragment(amountFragment);
                break;
            case R.id.continue_button_amount:
                receiverFragment = new ReceiverFragment();
                switchFragment(receiverFragment);
                break;
            case R.id.continue_button_receiver:
                paymentFragment = new PaymentFragment();
                switchFragment(paymentFragment);
                break;
            case R.id.continue_button_payment:
                if(paymethodFragment !=null) {
                    switchFragment(paymethodFragment);
                }
                break;
            case R.id.continue_button_bank:
                reviewFragment = new ReviewFragment();
                switchFragment(reviewFragment);
                break;
            case R.id.continue_button_card:
                reviewFragment = new ReviewFragment();
                switchFragment(reviewFragment);
                break;
            case R.id.back_button_receiver:
            case R.id.back_button_payment:
            case R.id.back_button_bank:
            case R.id.back_button_card:
                getFragmentManager().popBackStack();
                break;

            default:
                break;
        }
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
