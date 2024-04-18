package com.david.tarea.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.david.tarea.R;
import com.david.tarea.model.User;

import java.util.List;

public class ListAdapter extends ArrayAdapter<User> {
    private List<User> userList;
    private Context context;
    private int resourceLayout;
    public ListAdapter(@NonNull Context context, int resource, @NonNull List<User> objects) {
        super(context, resource, objects);
        this.userList= objects;
        this.context = context;
        this.resourceLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            view = LayoutInflater.from(context).inflate(resourceLayout, null);
        }
        User user = userList.get(position);

        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvEmail = view.findViewById(R.id.tvEmail);
        TextView tvPassword = view.findViewById(R.id.tvPassword);

        tvName.setText(user.fullName);
        tvEmail.setText(user.email);
        tvPassword.setText(user.password);
        return view;
    }
}
