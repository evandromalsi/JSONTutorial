package com.example.jsontutorial.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsontutorial.R;
import com.example.jsontutorial.model.ContactsItem;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ContactViewHolder>{

    private List<ContactsItem> listContact = new ArrayList<>();

    private Context context;

    public ListAdapter(Context context, List<ContactsItem> listContact){
        this.listContact = listContact;
        this.context = context;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vh = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);

        ContactViewHolder contactViewHolder = new ContactViewHolder(vh);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        ContactsItem Contact = listContact.get(position);
        holder.name.setText(Contact.getName());
        holder.email.setText(Contact.getEmail());
        holder.mobile.setText(Contact.getPhone().getMobile());

    }

    @Override
    public int getItemCount() {
        return listContact.size();
    }


    public class ContactViewHolder extends RecyclerView.ViewHolder{
        public TextView mobile;
        public TextView name;
        public TextView email;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            mobile = itemView.findViewById(R.id.mobile);
            name = itemView.findViewById(R.id.email);
            email = itemView.findViewById(R.id.name);
        }
    }
}