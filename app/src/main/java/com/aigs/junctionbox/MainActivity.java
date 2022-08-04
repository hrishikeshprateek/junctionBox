package com.aigs.junctionbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView logout;
    Button dev1,dev2,dev3,dev4;
    String stat1 = "OFF",stat2 = "OFF",stat3 = "OFF",stat4 ="OFF";

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout = findViewById(R.id.logout);
        dev1 = findViewById(R.id.but);
        dev2 = findViewById(R.id.but1);
        dev3 = findViewById(R.id.but2);
        dev4 = findViewById(R.id.but3);
        recyclerView = findViewById(R.id.rec);

        AlertDialog alertDialog =  new AlertDialog.Builder(MainActivity.this)
                .setMessage("Processing your request ...")
                .setCancelable(false)
                .create();

        attachDataListeners();
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setCancelable(false)
                        .setMessage("Do you really want to logout !!")
                        .setPositiveButton("LOGOUT", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                FirebaseAuth.getInstance().signOut();
                                finish();
                                startActivity(new Intent(MainActivity.this,Login.class));
                            }
                        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();
            }
        });

        dev1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.show();
                if (stat1.equals("ON")){
                    //SET VALUE OFF
                    FirebaseDatabase
                            .getInstance()
                            .getReference("cmd")
                            .child("Device1")
                            .setValue("OFF")
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (!task.isSuccessful()){
                                        Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                                    alertDialog.dismiss();
                                }
                            });
                }else {
                    //SET VALUE ON
                    FirebaseDatabase
                            .getInstance()
                            .getReference("cmd")
                            .child("Device1")
                            .setValue("ON")
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (!task.isSuccessful()){
                                        Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                                    alertDialog.dismiss();
                                }
                            });

                }
            }
        });

        dev2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.show();
                if (stat2.equals("ON")){
                    //SET VALUE OFF
                    FirebaseDatabase
                            .getInstance()
                            .getReference("cmd")
                            .child("Device2")
                            .setValue("OFF")
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (!task.isSuccessful()){
                                        Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                                    alertDialog.dismiss();
                                }
                            });
                }else {
                    //SET VALUE ON
                    FirebaseDatabase
                            .getInstance()
                            .getReference("cmd")
                            .child("Device2")
                            .setValue("ON")
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (!task.isSuccessful()){
                                        Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                                    alertDialog.dismiss();
                                }
                            });
                }
            }
        });

        dev3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.show();
                if (stat3.equals("ON")){
                    //SET VALUE OFF
                    FirebaseDatabase
                            .getInstance()
                            .getReference("cmd")
                            .child("Device3")
                            .setValue("OFF")
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (!task.isSuccessful()){
                                        Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                                    alertDialog.dismiss();
                                }
                            });
                }else {
                    //SET VALUE ON
                    FirebaseDatabase
                            .getInstance()
                            .getReference("cmd")
                            .child("Device3")
                            .setValue("ON")
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (!task.isSuccessful()){
                                        Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                                    alertDialog.dismiss();
                                }
                            });
                }
            }
        });

        dev4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.show();
                if (stat4.equals("ON")){
                    //SET VALUE OFF
                    FirebaseDatabase
                            .getInstance()
                            .getReference("cmd")
                            .child("Device4")
                            .setValue("OFF")
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (!task.isSuccessful()){
                                        Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                                    alertDialog.dismiss();
                                }
                            });
                }else {
                    //SET VALUE ON
                    FirebaseDatabase
                            .getInstance()
                            .getReference("cmd")
                            .child("Device4")
                            .setValue("ON")
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (!task.isSuccessful()){
                                        Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                                    alertDialog.dismiss();
                                }
                            });

                }
            }
        });

        Toast.makeText(MainActivity.this, "Welcome "+ FirebaseAuth.getInstance().getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();

    }

    private void attachDataListeners(){
        FirebaseDatabase
                .getInstance()
                .getReference("cmd")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            List<DataSnapshot> list= new ArrayList<>();

                            stat1 = snapshot.child("Device1").getValue(String.class);
                            stat2 = snapshot.child("Device2").getValue(String.class);
                            stat3 = snapshot.child("Device3").getValue(String.class);
                            stat4 = snapshot.child("Device4").getValue(String.class);

                            dev1.setText("Device 1 : "+stat1);
                            dev2.setText("Device 2 : "+stat2);
                            dev3.setText("Device 3 : "+stat3);
                            dev4.setText("Device 4 : "+stat4);

                            for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                                list.add(dataSnapshot);
                            }
                            recyclerView.setAdapter(new StatusAdapter(list));

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(MainActivity.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}