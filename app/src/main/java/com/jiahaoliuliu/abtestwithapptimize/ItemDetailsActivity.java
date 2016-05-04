package com.jiahaoliuliu.abtestwithapptimize;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.apptimize.Apptimize;
import com.apptimize.ApptimizeTest;

public class ItemDetailsActivity extends AppCompatActivity {

    private static final String TAG = "ItemDetailsActivity";

    // Views
    private Toolbar mToolbar;
    private LinearLayout mBottomButtonsLinearLayout;
    private ImageView mCallButtonImageView;
    private ImageView mEmailButtonImageView;
    private ImageView mSmsButtonImageView;

    // Internal variables
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Initialize the variables
        this.mContext = this;

        // Link the views
        mToolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mBottomButtonsLinearLayout = (LinearLayout)findViewById(R.id.bottom_buttons_linear_layout);

        mCallButtonImageView = (ImageView)findViewById(R.id.call_button_image_view);
        mCallButtonImageView.setOnClickListener(mOnClickListener);

        mEmailButtonImageView= (ImageView)findViewById(R.id.email_button_image_view);
        mEmailButtonImageView.setOnClickListener(mOnClickListener);

        mSmsButtonImageView = (ImageView)findViewById(R.id.sms_button_image_view);
        mSmsButtonImageView.setOnClickListener(mOnClickListener);

        // runABTest
        runABTest();
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.call_button_image_view:
                    Toast.makeText(mContext, "Calling...", Toast.LENGTH_LONG).show();
                    Apptimize.track("User call");
                    break;
                case R.id.email_button_image_view:
                    Toast.makeText(mContext, "Sending email...", Toast.LENGTH_LONG).show();
                    Apptimize.track("Send email");
                    break;
                case R.id.sms_button_image_view:
                    Toast.makeText(mContext, "Sending SMS...", Toast.LENGTH_LONG).show();
                    Apptimize.track("Send SMS");
                    break;
            }
        }
    };

    private void runABTest() {
        Apptimize.runTest("BottomButtonsABTest", new ApptimizeTest() {
            @Override
            public void baseline() {
                // Variant: baseline
                Log.v(TAG, "Baseline received");
            }

            @SuppressWarnings("unused")
            public void variation1() {
                // Variant: variation1
                Log.v(TAG, "Variation 1 received");
                mBottomButtonsLinearLayout.setBackgroundColor(getResources().getColor(android.R.color.black));
            }

            @SuppressWarnings("unused")
            public void variation2() {
                // Variant: variation2
                Log.v(TAG, "Variation 2 received");
                mBottomButtonsLinearLayout.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
            }

            @SuppressWarnings("unused")
            public void variation3() {
                // Variant: variation3
                Log.v(TAG, "Variation 3 received");
                mBottomButtonsLinearLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
            }
        });
    }
}
