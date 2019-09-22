package com.example.tuan3bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    String [] presidents = {"loi", "lam"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setListAdapter(new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, presidents));
        setContentView(R.layout.activity_main);
        ListView listView = getListView();
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setTextFilterEnabled(true);
        presidents =
                getResources().getStringArray(R.array.president_array);
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_checked, presidents));
    }
//    public void onListItemClick(
//            ListView parent, View v, int position, long id)
//    {
//        Toast.makeText(this, "you have: " + presidents[position],
//                Toast.LENGTH_SHORT).show();
//    }
        public void onClick(View view) {
        ListView listView = getListView();
        String itemsSelected = "Selected items: \n";
        for (int i =0;i <listView.getCount(); i++){
            if (listView.isItemChecked(i)){
                itemsSelected += listView.getItemAtPosition(i) + "\n";
            }
        }
        Toast.makeText(this, itemsSelected,
                Toast.LENGTH_SHORT).show();
    }
}
