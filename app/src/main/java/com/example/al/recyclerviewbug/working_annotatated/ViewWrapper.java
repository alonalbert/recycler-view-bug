package com.example.al.recyclerviewbug.working_annotatated;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * AndroidAnnotations needs this to support RecyclerView.
 * https://github.com/androidannotations/androidannotations/wiki/Adapters-and-lists#recyclerview-and-viewholder
 */
public class ViewWrapper<V extends View> extends RecyclerView.ViewHolder {

  private V view;

  public ViewWrapper(V itemView) {
    super(itemView);
    view = itemView;
  }

  public V getView() {
    return view;
  }
}
