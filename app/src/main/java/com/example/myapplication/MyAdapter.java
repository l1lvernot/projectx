package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/*public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    Context context;
    ArrayList<Item> itemArrayList;

    public MyAdapter(Context context, ArrayList<Item> itemArrayList){
        this.context = context;
        this.itemArrayList = itemArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item = itemArrayList.get(position);
        holder.description.setText(item.description);
        holder.name.setText(item.name);
        holder.age.setText(item.age);
        holder.person_max.setText(item.person_max);
        holder.imageView.setImageResource(item.image);
    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView name;
        TextView description;
        TextView age;
        TextView person_max;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
            name = itemView.findViewById(R.id.name);
            age = itemView.findViewById(R.id.age);
            person_max = itemView.findViewById(R.id.person_max);
            description = itemView.findViewById(R.id.description);

        }
    }

}
*/
public class MyAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<Item> itemArrayList;

    MyAdapter(Context context, ArrayList<Item> item) {
        this.itemArrayList = item;
        this.inflater = LayoutInflater.from(context);

    }
    public int getCount() {
        return itemArrayList.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final MyViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_view, parent, false);
            viewHolder = new MyViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (MyViewHolder) convertView.getTag();
        }
        Item item = itemArrayList.get(position);

        viewHolder.description.setText(item.description);
        viewHolder.name.setText(item.name);
        viewHolder.age.setText(String.valueOf(item.age));
        viewHolder.person_max.setText(String.valueOf(item.person_max));
        viewHolder.imageView.setImageResource(item.getImage());

        return convertView;
    }
}
class MyViewHolder {

    final ImageView imageView;
    final TextView name;
    final TextView description;
    final TextView age;
    final TextView person_max;

    public MyViewHolder(View itemView) {

        imageView = itemView.findViewById(R.id.imageview);
        name = itemView.findViewById(R.id.name);
        age = itemView.findViewById(R.id.age);
        person_max = itemView.findViewById(R.id.person_max);
        description = itemView.findViewById(R.id.description);

    }
}