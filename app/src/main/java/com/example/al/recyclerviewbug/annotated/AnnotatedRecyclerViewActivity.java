package com.example.al.recyclerviewbug.annotated;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.al.recyclerviewbug.R;
import com.example.al.recyclerviewbug.annotated.AnnotatedRecyclerViewActivity_.ItemView_;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.ViewById;

@SuppressLint("Registered")
@EActivity(R.layout.activity_recycler_view)
public class AnnotatedRecyclerViewActivity extends AppCompatActivity {

  @ViewById(R.id.recycler_view)
  protected RecyclerView recyclerView;

  @Bean
  Adapter adapter;

  @AfterViews
  protected void initialize() {
    setTitle("With Android Annotations");
    adapter.items = new String[]{"Hello", "World"};
    recyclerView.setAdapter(adapter);
  }

  @EViewGroup(R.layout.item)
  protected static class ItemView extends ConstraintLayout {
    @ViewById
    protected TextView left;

    @ViewById
    protected TextView right;

    public ItemView(Context context) {
      super(context);
    }

    void bind(String text) {
      left.setText("Left " + text);
      right.setText("Right " +  text);
    }
  }

  @EBean
  protected static class Adapter extends AbstractRecyclerViewAdapter<String, ItemView> {
    @RootContext
    Context context;

    @Override
    public ItemView onCreateItemView(ViewGroup parent, int viewType) {
      return ItemView_.build(context);
    }

    @Override
    public void onBindViewHolder(ViewWrapper<ItemView> holder, int position) {
      final ItemView view = holder.getView();
      final String item = items[position];

      view.bind(item);
    }
  }
}
