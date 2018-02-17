package com.example.al.recyclerviewbug.working_annotatated;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("Registered")
//@EActivity(R.layout.activity_recycler_view)
public class WorkingAnnotatedRecyclerViewActivity extends AppCompatActivity {

//  @ViewById(R.id.recycler_view)
  protected RecyclerView recyclerView;

//  @Bean
  Adapter adapter;

//  @AfterViews
  protected void initialize() {
    setTitle("With Android Annotations");
    adapter.items = new String[]{"Hello", "World"};
    recyclerView.setAdapter(adapter);
  }

//  @EViewGroup(R.layout.item_working_annotated)
  public static class ItemView extends ConstraintLayout {
//    @ViewById
    protected TextView left;

//    @ViewById
    protected TextView right;

    public ItemView(Context context) {
      super(context);
    }

  public ItemView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  void bind(String text) {
      left.setText("Left " + text);
      right.setText("Right " +  text);
    }
  }

//  @EBean
  protected static class Adapter extends AbstractRecyclerViewAdapter<String, ItemView> {
//    @RootContext
    Context context;

//    @Override
    public ItemView onCreateItemView(ViewGroup parent, int viewType) {
      return WorkingAnnotatedRecyclerViewActivity_.ItemView_.build(context, parent);
    }

//    @Override
    public void onBindViewHolder(ViewWrapper<ItemView> holder, int position) {
      final ItemView view = holder.getView();
      final String item = items[position];

      view.bind(item);
    }
  }
}
