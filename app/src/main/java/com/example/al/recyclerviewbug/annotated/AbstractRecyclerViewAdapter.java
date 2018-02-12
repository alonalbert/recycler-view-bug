package com.example.al.recyclerviewbug.annotated;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * AndroidAnnotations needs this to support RecyclerView.
 * https://github.com/androidannotations/androidannotations/wiki/Adapters-and-lists#recyclerview-and-viewholder
 */
public abstract class AbstractRecyclerViewAdapter<T, V extends View> extends RecyclerView.Adapter<ViewWrapper<V>> {

  protected T[] items = null;

  @Override
  public int getItemCount() {
    return items != null ? items.length : 0;
  }

  @Override
  public final ViewWrapper<V> onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ViewWrapper<V>(onCreateItemView(parent, viewType));
  }

  protected abstract V onCreateItemView(ViewGroup parent, int viewType);
}
