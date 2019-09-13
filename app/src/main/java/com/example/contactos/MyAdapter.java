package com.example.contactos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<Contacto> mContactList;
    private OnItemClickListener mListener;
    Context ctx;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        //public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public ExampleViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
           // mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.txtUsuario);
            mTextView2 = itemView.findViewById(R.id.txtEmail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public MyAdapter(ArrayList<Contacto> exampleList) {
        mContactList = exampleList;
    }






    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
         //each data item is just a string in this case
        public TextView textView;

        public MyViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.txtUsuario);
        }
    }


    //public MyAdapter(){}
    //public MyAdapter(ArrayList<Contacto> dataSet){
    //    mdataSet = dataSet;
    //}


//    @NonNull
    //@Override
    //public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      //  View v =  LayoutInflater.from(parent.getContext())
        //        .inflate(R.layout.my_text_view,
          //              parent, false   );

        //MyViewHolder vh = new MyViewHolder(v);
        //return vh;

    //}

  //  @Override
    //public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      //  holder.textView.setText((CharSequence) mdataSet.get(position));
        //holder.textView.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View view) {
              //  Toast.makeText(ctx,
                //        "Presionando: " + ((TextView)view).getText() , Toast.LENGTH_LONG).show();
            //}
        //});
    //}

    //@Override
    //public int getItemCount() {
      //  return mdataSet.size();
    //}



}
