package com.bawei.mafalu20190722.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bawei.mafalu20190722.R;
import com.bawei.mafalu20190722.ui.frag.FragHome;
import com.bawei.mafalu20190722.ui.frag.FragMy;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fram)
    FrameLayout fram;
    @BindView(R.id.rb_homg)
    RadioButton rbHomg;
    @BindView(R.id.rb_my)
    RadioButton rbMy;
    @BindView(R.id.rg)
    RadioGroup rg;
    private FragHome fragHome;
    private FragMy fragMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragHome = new FragHome();
        fragMy = new FragMy();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fram,fragHome).show(fragHome)
                .add(R.id.fram,fragMy).hide(fragMy)
                .commit();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (checkedId){
                    case R.id.rb_homg:
                        transaction.show(fragHome).hide(fragMy);
                        break;
                    case R.id.rb_my:
                        transaction.show(fragMy).hide(fragHome);
                        break;
                }
                transaction.commit();
            }
        });
    }
}
