package sg.edu.np.mad.mad_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ArrayList<Item> itemList;
    Button Enter;
    EditText Addon;
    RecyclerView rv;
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemList = new ArrayList<>();
        Enter = findViewById(R.id.button);
        rv = findViewById(R.id.rv);
        Addon = findViewById(R.id.editText);
        itemList.add(new Item("Wash myself",true));
        itemList.add(new Item("Sleep",false));
        itemList.add(new Item("Sleep",false));
        itemList.add(new Item("Sleep",false));
        itemList.add(new Item("Sleep",false));
        itemList.add(new Item("Sleep",false));
        itemList.add(new Item("Sleep",false));
        itemList.add(new Item("Sleep",false));
        itemList.add(new Item("Sleep",false));
        itemList.add(new Item("Sleep",false));
        itemList.add(new Item("Sleep",false));
        itemList.add(new Item("Sleep",false));
        itemList.add(new Item("Sleep",false));
        itemList.add(new Item("Sleep",false));
        itemList.add(new Item("Sleep",false));

        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ItemAdapter(itemList);
        rv.setAdapter(adapter);
        Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Addon.getText().toString().equals("")){
                    itemList.add(new Item(Addon.getText().toString(),false));
                    adapter.notifyDataSetChanged();
                    Addon.setText("");
                    showNewEntry(rv,itemList);
                }
            }
        });

    }

    /**
     * Upon calling this method, the keyboard will retract
     * and the recyclerview will scroll to the last item
     *
     * @param rv RecyclerView for scrolling to
     * @param data ArrayList that was passed into RecyclerView
     */
    private void showNewEntry(RecyclerView rv, ArrayList data){
        //scroll to the last item of the recyclerview
        rv.scrollToPosition(data.size() - 1);

        //auto hide keyboard after entry
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(rv.getWindowToken(), 0);
    }


}
