package sg.edu.np.mad.mad_recyclerview;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    ArrayList<Item> itemList;

    public ItemAdapter(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Todo;
        CheckBox checkBox;
        //View v;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);

            Todo = itemView.findViewById(R.id.textView);
            checkBox = itemView.findViewById(R.id.checkBox);
            //v = itemView;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                    View view = LayoutInflater.from(v.getContext()).inflate(R.layout.dialog,null);
                    TextView message = view.findViewById(R.id.message);
                    message.setText(itemList.get(getAdapterPosition()).Todo + "?");
                    builder.setTitle("Delete");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int id){
                            itemList.remove(getAdapterPosition());
                            notifyDataSetChanged();
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int id){
                        }
                    }).setView(view).create().show();
                }
            });
        }
    }

    @NonNull
    @Override
    public ItemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.MyViewHolder holder, final int position) {
        Item item = itemList.get(position);
        holder.Todo.setText(item.Todo);
        if(item.Checkbox){
            holder.checkBox.setChecked(true);
        }
        else{
            holder.checkBox.setChecked(false);
        }
        /*holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                View view = LayoutInflater.from(v.getContext()).inflate(R.layout.dialog,null);
                TextView message = view.findViewById(R.id.message);
                message.setText(itemList.get(position).Todo + "?");
                builder.setTitle("Delete");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        itemList.remove(position);
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                    }
                }).setView(view).create().show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return itemList.size() ;
    }


}
