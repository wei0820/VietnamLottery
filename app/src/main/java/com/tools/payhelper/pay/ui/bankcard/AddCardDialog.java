package com.tools.payhelper.pay.ui.bankcard;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

import com.jingyu.pay.ui.bankcard.BankCardDateModel;
import com.jingyu.pay.ui.group.GroupDateModel;
import com.tools.payhelper.R;
import com.tools.payhelper.pay.PayHelperUtils;


public class AddCardDialog extends AlertDialog {
    private Activity activity;
    private EditText pd, name,tel,googleedt,usernaem,eusername,payedt;
    private Spinner spinner;
    private OnAddCallback onAddCallback;
    private OnAddBanKListCallback onAddBanKListCallback;
    private Dialog dialog;
    private Switch aSwitch;
    private  TextView textView,textView2;
    private Handler handlerLoading = new Handler();
    BankCardDateModel bankCardDateModel = new BankCardDateModel();
    public void setOnAddCallback(OnAddCallback onAddCallback) {
        this.onAddCallback = onAddCallback;
    }

    public  void  setAddBankCallback(OnAddBanKListCallback onAddBanKListCallback){
        this.onAddBanKListCallback = onAddBanKListCallback;

    }

    public interface OnAddCallback {
        void onAdd(String cardNo, String bankName, String bankCode);
    }
    public  interface  OnAddBanKListCallback{
        void onResponse(AddBankCardData addBankCardData);
    }

    public AddCardDialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }


    protected AddCardDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    protected AddCardDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);

        View view = LayoutInflater.from(activity).inflate(R.layout.add_bank_card, null);
        setView(view);
        setContentView(view);
        setCanceledOnTouchOutside(false);
        setCancelable(false);

        name = findViewById(R.id.bank_card);
        pd = findViewById(R.id.bank_card_no);
        tel = findViewById(R.id.teledt);
        googleedt = findViewById(R.id.googleedt);
        usernaem = findViewById(R.id.nameedt);
        eusername = findViewById(R.id.enameedt);
        payedt = findViewById(R.id.payedt);

        String maxString = PayHelperUtils.getRebate(activity).isEmpty() ? "" : PayHelperUtils.getRebate(activity);
        String minString = PayHelperUtils.getPaymentXeRebate(activity).isEmpty() ? "" : PayHelperUtils.getPaymentXeRebate(activity);





//        TextView message = findViewById(R.id.message);
//        message.setText("您的佣金比例:\n"+"卖币:"+maxString+"\n"+"小额买币:"+minString);
//        textView.setText(maxString);
//        textView2.setText(minString);


        view.findViewById(R.id.closeBtn).setOnClickListener(v -> {
            view.setEnabled(false);
            new Handler().postDelayed(() -> view.setEnabled(true), 500);

            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }

            dismiss();
        });

        view.findViewById(R.id.okBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = name.getText().toString();
                String p = pd.getText().toString();
                String t = tel.getText().toString();
                String google = googleedt.getText().toString();
                String username = usernaem.getText().toString();
                String euserName = eusername.getText().toString();
                String pay = payedt.getText().toString().isEmpty() ?"5000" : payedt.getText().toString();
                Float payF = Float.parseFloat(pay);
                bankCardDateModel.setBankCard(activity, n, p, t, payF, google, username, euserName, new BankCardDateModel.BankCardResponse() {
                    @Override
                    public void getResponse(@NonNull String s) {
                        if (!s.isEmpty()){
                            AddBankCardData addBankCardData = new Gson().fromJson(s,AddBankCardData.class);
                            if (addBankCardData !=null){
                                onAddBanKListCallback.onResponse(addBankCardData);

                            }
                        }
                    }
                });

                dismiss();

            }
        });
    }

}
