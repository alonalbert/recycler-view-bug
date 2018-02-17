package com.example.al.recyclerviewbug;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.al.recyclerviewbug.annotated.AnnotatedRecyclerViewActivity_;
import com.example.al.recyclerviewbug.plain.RecyclerViewActivity;
import com.example.al.recyclerviewbug.working_annotatated.WorkingAnnotatedRecyclerViewActivity_;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void startRecyclerViewActivity(View view) {
    startActivity(new Intent(this, RecyclerViewActivity.class));
  }

  public void startAnnotatedRecyclerViewActivity(View view) {
    startActivity(new Intent(this, AnnotatedRecyclerViewActivity_.class));
  }

  public void startWorkingAnnotatedRecyclerViewActivity(View view) {
    startActivity(new Intent(this, WorkingAnnotatedRecyclerViewActivity_.class));
  }
}
