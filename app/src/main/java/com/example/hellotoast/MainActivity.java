package com.sygor.hellotoast;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hellotoast.R;

public class MainActivity extends AppCompatActivity implements com.sygor.hellotoast.MainView {

    private com.sygor.hellotoast.MainPresenter presenter;
    private TextView countView;

    final private String COUNT_KEY = "MainActivity.CountKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_relatively);

        countView = (TextView) findViewById(R.id.show_count);
        presenter = new com.sygor.hellotoast.MainPresenterImpl(this);
        presenter.init();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNT_KEY, presenter.getCount());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        presenter.init(savedInstanceState.getInt(COUNT_KEY));
    }

    public void countUp(View view) {
        presenter.countUpClicked();
    }

    public void showToast(View view) {
        presenter.showToastClicked();
    }

    @Override
    public void updateCount(int count) {
        countView.setText(String.valueOf(count));
    }

    @Override
    public void showToast(int initialCount) {
        Toast.makeText(getApplicationContext(), getString(R.string.toast_msg_template ) + initialCount, Toast.LENGTH_SHORT ).show();
    }
}
