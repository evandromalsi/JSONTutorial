package com.example.jsontutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ReceiverCallNotAllowedException;
import android.os.Bundle;
import android.widget.Toast;

import com.example.jsontutorial.adapter.ListAdapter;
import com.example.jsontutorial.api.RetrofitClient;
import com.example.jsontutorial.model.ResponseContacts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.list);
        getContact();
    }

    private void getContact(){
        Call<ResponseContacts> call = RetrofitClient.getInstance().getMyApi().getContact();
        call.enqueue(new Callback<ResponseContacts>(){
            @Override
            public void onResponse(Call<ResponseContacts>call, Response<ResponseContacts> response){
                if (response.code()== 200){
                    ResponseContacts contatcList= response.body();
                    ListAdapter mAdapter = new ListAdapter(getApplicationContext(), contatcList.getContacts());
                    RecyclerView.LayoutManager mLayoutManager= new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Call<ResponseContacts>call, Throwable t){
                Toast.makeText(getApplicationContext(), "an error has occured", Toast.LENGTH_LONG).show();
            }
        });
    }
}