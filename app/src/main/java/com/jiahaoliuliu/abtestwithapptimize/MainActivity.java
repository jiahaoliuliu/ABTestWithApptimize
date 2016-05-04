package com.jiahaoliuliu.abtestwithapptimize;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Internal variables
    private Context mContext;

    // Views
    private Button mCheckMyFantasticItemView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize variables
        mContext = this;

        // Link the views
        mCheckMyFantasticItemView = (Button) findViewById(R.id.check_my_fantastic_item_button);
        mCheckMyFantasticItemView.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view) {
                // Show my item details
                Intent startItemDetailsIntent = new Intent(mContext, ItemDetailsActivity.class);
                startActivity(startItemDetailsIntent);
            }
        });
    }
}
