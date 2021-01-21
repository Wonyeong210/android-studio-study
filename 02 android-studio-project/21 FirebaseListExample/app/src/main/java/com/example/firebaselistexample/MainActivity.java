package com.example.firebaselistexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<User> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true); // RecyclerView 기존 성능 강화
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>(); // User 객체를 담을 ArrayList -> Adapter

        database = FirebaseDatabase.getInstance(); // Firebase Database 연동

        databaseReference = database.getReference("User");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Firebase Database의 데이터를 받아오는 곳
                arrayList.clear(); // 기존 arrayList가 존재하지 않도록 초기화
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출
                    User user = snapshot.getValue(User.class); // 만들어뒀던 User객체에 데이터를 담는다.
                    arrayList.add(user); // 담은 데이터를 배열리스트에 넣고 RecyclerView로 보낼 준비
                }
                adapter.notifyDataSetChanged(); // 리스트 저장 및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // DB를 가져오던 중 에러 발생 시
                Log.e("MainActivity", String.valueOf(databaseError.toException()));
            }
        });

        adapter = new CustomAdapter(arrayList, this);
        recyclerView.setAdapter(adapter); // RecyclerView로 Adapter 구현


    }
}