package com.johndavidgriffin.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private EditText mBillField;
    private EditText mTipField;
    private TextView mTipAmount;
    private TextView mTotalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBillField = (EditText) findViewById(R.id.editText);
        mTipField = (EditText) findViewById(R.id.editText2);
        mTipAmount = (TextView) findViewById(R.id.textView5);
        mTotalAmount = (TextView) findViewById(R.id.textView4);

        mBillField.addTextChangedListener(inputWatcher);
        mTipField.addTextChangedListener(inputWatcher);
    }

    private final TextWatcher inputWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        public void afterTextChanged(Editable s) {
            final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
            try
            {
                TipCalculator calc = new TipCalculator();

                calc.setBill((Float) Float.parseFloat(mBillField.getText().toString()));
                calc.setTipPercent((Float) Float.parseFloat(mTipField.getText().toString()));

                mTipAmount.setText(moneyFormat.format(calc.getTipAmount()));
                mTotalAmount.setText(moneyFormat.format(calc.getTotal()));
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Enter numbers for bill and tip percent.", Toast.LENGTH_SHORT).show();
                mTipAmount.setText(moneyFormat.format(0));
                mTotalAmount.setText(moneyFormat.format(0));
            }
        }
    };
}