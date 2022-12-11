package com.example.samachar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.view.WindowManager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class HomeScreen extends AppCompatActivity {

    //48deffa067a14aeb8970a4d93655041e

    public String AIP_ID="48deffa067a14aeb8970a4d93655041e";
    private TabLayout tabLayout;
    private TabItem x_home,x_science,x_health,x_technology,x_sports,x_entertainment;
    private AdapterClass adapterClass;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        x_home=findViewById(R.id.home_1);
        x_science=findViewById(R.id.science_1);
        x_health=findViewById(R.id.health_1);
        x_technology=findViewById(R.id.technology_1);
        x_sports=findViewById(R.id.sports_1);
        x_entertainment=findViewById(R.id.entertainment_1);

        ViewPager viewPager=findViewById(R.id.fragment_container);
        tabLayout=findViewById(R.id.category);

        adapterClass=new AdapterClass(getSupportFragmentManager(),6);
        viewPager.setAdapter(adapterClass);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4||tab.getPosition()==5)
                {
                    adapterClass.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
       viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }

}