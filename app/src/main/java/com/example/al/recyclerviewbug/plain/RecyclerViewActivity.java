package com.example.al.recyclerviewbug.plain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import com.example.al.recyclerviewbug.R;

public class RecyclerViewActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recycler_view);

    setTitle("Without Android Annotations");

    final RecyclerView recyclerView = findViewById(R.id.recycler_view);
    recyclerView.setAdapter(new Adapter(new String[]{ "Hello", "World" }));
  }

  public static class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private String[] items;

    static class ViewHolder extends RecyclerView.ViewHolder {
      private final TextView left;
      private final TextView right;

      ViewHolder(View v) {
        super(v);
        left = v.findViewById(R.id.left);
        right = v.findViewById(R.id.right);
      }

      public void bind(String text) {
        left.setText("Left " + text);
        right.setText("Right " +  text);
      }
    }
    public Adapter(String[] dataSet) {
      items = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
      // Create a new view.
      final View v = LayoutInflater.from(viewGroup.getContext())
          .inflate(R.layout.item, viewGroup, false);

      return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
      viewHolder.bind(items[position]);
    }

    @Override
    public int getItemCount() {
      return items.length;
    }
  }
}
