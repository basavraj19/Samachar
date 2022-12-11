package com.example.samachar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    public String AIP_ID="48deffa067a14aeb8970a4d93655041e";
    ArrayList<HelperClass> arrayList;
    Adapter adapter;
    String country="in";
    private RecyclerView recyclerView_home;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.homefragement,null);
       recyclerView_home=view.findViewById(R.id.home_fragment);
       arrayList=new ArrayList<>();
       recyclerView_home.setLayoutManager(new LinearLayoutManager(getContext()));
       adapter=new Adapter(getContext(),arrayList);
       recyclerView_home.setAdapter(adapter);
       findNews();
       return view;
    }

    private void findNews() {
        APIUtilities.getApiInterface().getnews(country,100,AIP_ID).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if(response.isSuccessful())
                {
                    arrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });
    }
}
