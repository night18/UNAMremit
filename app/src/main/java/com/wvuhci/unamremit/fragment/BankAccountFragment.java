package com.wvuhci.unamremit.fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.wvuhci.unamremit.R;
import com.wvuhci.unamremit.core.ProcessController;
import static com.wvuhci.unamremit.MainActivity.paymentInfo;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BankAccountFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BankAccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BankAccountFragment extends ProcessController {
    private View view;
    private Button continueButton, backButton;
    private Spinner stateSpinner, bankSpinner;
    private String[] stateArray, bankArray;
    private EditText routingET, accountET,addr1ET, addr2ET, cityET, zipcodeET;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public BankAccountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BankAccountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BankAccountFragment newInstance(String param1, String param2) {
        BankAccountFragment fragment = new BankAccountFragment();
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
        view = inflater.inflate(R.layout.fragment_bank_account, container, false);
        continueButton = (Button) view.findViewById(R.id.continue_button_bank);
        continueButton.setOnClickListener(this);

        backButton = (Button) view.findViewById(R.id.back_button_bank);
        backButton.setOnClickListener(this);

        routingET = view.findViewById(R.id.et_routing_number);
        accountET = view.findViewById(R.id.et_account_number);
        addr1ET = view.findViewById(R.id.et_address1);
        addr2ET = view.findViewById(R.id.et_address2);
        cityET = view.findViewById(R.id.et_city);
        zipcodeET = view.findViewById(R.id.et_bank_zipcode);

        stateSpinner = (Spinner) view.findViewById(R.id.spinner_state);
        stateArray = getResources().getStringArray(R.array.state_name);
        ArrayAdapter<CharSequence> stateList = new ArrayAdapter<CharSequence>(this.getActivity(),R.layout.spinner_item , stateArray ){
            @Override
            public boolean isEnabled(int position){
                if(position == 0){
                    return false;
                }else{
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent){
                View dropdownView = super.getDropDownView(position,convertView,parent);
                TextView tv = (TextView) dropdownView;

                if(position == 0){
                    tv.setTextColor(Color.parseColor("#C0C0C0"));
                }else{
                    tv.setTextColor(Color.parseColor("#000000"));
                }
                return tv;
            }
        };
        stateList.setDropDownViewResource(R.layout.spinner_item);
        stateSpinner.setAdapter(stateList);


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.continue_button_bank:
                paymentInfo.setRoutingNumber(routingET.getText().toString());
                paymentInfo.setAccountNumber(accountET.getText().toString());
                paymentInfo.setAddr1(addr1ET.getText().toString());
                paymentInfo.setAddr2(addr2ET.getText().toString());
                paymentInfo.setCity(cityET.getText().toString());
                paymentInfo.setZipCode(zipcodeET.getText().toString());




                nextFragment = new ReviewFragment();
                switchFragment(nextFragment);
                break;
            case R.id.back_button_bank:
                getFragmentManager().popBackStack();
                break;
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
