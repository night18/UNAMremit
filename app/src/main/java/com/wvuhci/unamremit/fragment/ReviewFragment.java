package com.wvuhci.unamremit.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wvuhci.unamremit.R;
import com.wvuhci.unamremit.core.ProcessController;

import static com.wvuhci.unamremit.MainActivity.paymentInfo;
import static com.wvuhci.unamremit.MainActivity.receiverInfo;
import static com.wvuhci.unamremit.MainActivity.transactionInfo;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ReviewFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ReviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReviewFragment extends ProcessController {
    private TextView receiverNameTV, receiverBankNameTV, receiverAccountNumberTV, usdamountTV, mxnamountTV,
            exchangeRateTV, feeTV, totalTV, senderBankMethodTV, senderBankAccountNumberTV;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ReviewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ReviewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ReviewFragment newInstance(String param1, String param2) {
        ReviewFragment fragment = new ReviewFragment();
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
        View view = inflater.inflate(R.layout.fragment_review, container, false);
        receiverNameTV = view.findViewById(R.id.tv_receiver_name);
        receiverBankNameTV = view.findViewById(R.id.tv_bank_name_receive);
        receiverAccountNumberTV = view.findViewById(R.id.tv_account_number_receive);
        usdamountTV = view.findViewById(R.id.tv_amount_send);
        mxnamountTV = view.findViewById(R.id.tv_amount_receive);
        exchangeRateTV = view.findViewById(R.id.tv_exchange_rate);
        feeTV = view.findViewById(R.id.tv_fee);
        totalTV = view.findViewById(R.id.tv_total);
        senderBankMethodTV = view.findViewById(R.id.tv_bank_method);
        senderBankAccountNumberTV = view.findViewById(R.id.tv_account_number_pay);

        receiverNameTV.setText(receiverInfo.getFirstName()+ " " + receiverInfo.getLastName());
        receiverBankNameTV.setText(receiverInfo.getBankName());

        receiverAccountNumberTV.setText(receiverInfo.getClabe());
        usdamountTV.setText(transactionInfo.getUsdAmount() + "");
        mxnamountTV.setText(transactionInfo.getMxnAmount() + "");
        exchangeRateTV.setText(transactionInfo.getExchangeRate() + "");
        feeTV.setText(transactionInfo.getFee() + "");
        double total = transactionInfo.getUsdAmount() + transactionInfo.getFee();
        totalTV.setText(total + "");
        String paymethod = "";
        switch (paymentInfo.getPayMethod()){
            case 0:
                paymethod = "bank account:";
                break;
            case 1:
                paymethod = "debit card:";
                break;
            case 2:
                paymethod = "credit card:";
                break;
        }
        senderBankMethodTV.setText(paymethod);

        senderBankAccountNumberTV.setText(paymentInfo.getAccountNumber());

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
