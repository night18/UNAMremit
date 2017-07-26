package com.wvuhci.unamremit.core;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.wvuhci.unamremit.R;
import com.wvuhci.unamremit.fragment.*;

/**
 * Use for control the process of the fragment
 */

public class ProcessController extends Fragment implements View.OnClickListener{
    Fragment homeFragment, amountFragment, receiverFragment, paymentFragment, bankAccountFragment, reviewFragment;
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
                //TODO make credit card payment fragment
                bankAccountFragment = new BankAccountFragment();
                switchFragment(bankAccountFragment);
                break;
            case R.id.continue_button_bank:
                reviewFragment = new ReviewFragment();
                switchFragment(reviewFragment);
                break;
            case R.id.back_button_receiver:
            case R.id.back_button_payment:
            case R.id.back_button_bank:
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

}
