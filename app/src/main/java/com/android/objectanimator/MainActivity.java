package com.android.objectanimator;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ValueAnimator.AnimatorUpdateListener {

    private Person mPerson;
    private TextView mPersonTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPersonTv = findViewById(R.id.personTv);
        mPerson = new Person();
        mPerson.setName("张三");
    }

    public void onClick(View view) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(mPerson, "age", 1, 100);
        objectAnimator.addUpdateListener(this);
        objectAnimator.setDuration(5000);
        objectAnimator.start();
    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        int age = (int) animation.getAnimatedValue("age");
        mPerson.setAge(age);
        mPersonTv.setText(mPerson.toString() + "\t\t\t" + age + "%");
    }
}
