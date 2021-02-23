package com.lambton.contact_harpreetkaur_c0788553_android;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ViewAnimator;

import java.util.logging.LogRecord;

public class AddContact extends AppCompatActivity {
    Context context;
    EditText et_name, et_number, et_email, et_organization;
    Button relationship, add;
    String relationshipString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        context = this;
        et_name = (EditText) findViewById(R.id.name);
        et_number = (EditText) findViewById(R.id.number);
        et_email = (EditText) findViewById(R.id.email);
        et_organization = (EditText) findViewById(R.id.org);
        et_name = (EditText) findViewById(R.id.name);
        relationship = (Button) findViewById(R.id.relationship);
        add = (Button) findViewById(R.id.add);

        String name = et_name.getText().toString();
        String number = et_number.getText().toString();
        String email = et_email.getText().toString();
        String organization = et_organization.getText().toString();
        relationshipString = "Unspecified";
        relationship.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                CharSequence options[] = {"Business", "Friend", "Acquaintance", "Other"};
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Choose Relationship type").
                        setItems(options, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                if (i == 0) {
                                    relationshipString = "Business";
                                } else if (i == 1) {
                                    relationshipString = "Friend";
                                } else if (i == 2) {
                                    relationshipString = "Acquaintance";
                                } else if (i == 3) {
                                    relationshipString = "Other";
                                }
                            }
                        })
                        .show();

            }


        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = et_name.getText().toString();
                String number = et_number.getText().toString();
                String email = et_email.getText().toString();
                String organization = et_organization.getText().toString();

                if (!TextUtils.isEmpty(name) || !TextUtils.isEmpty(number) || !TextUtils.isEmpty(email) || !TextUtils.isEmpty(organization)) {
                    Contact contact = new Contact(name, number, email, organization, relationshipString);
                    DBHandler dbHandler = null;
                    dbHandler.addContact(contact);
                    startActivity(new Intent(context, MainActivity.class));


                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);

                    builder.setMessage("Please fill all the fields")

                            .setNegativeButton("OK", null)
                            .show();
                }
            }

        });

    }
}







//                                                    String name = et_name.getText().toString();
//                                                    String number = et_number.getText().toString();
//                                                    String email = et_email.getText().toString();
//                                                    String organization = et_organization.getText().toString();
//
//
//                                                    if (!TextUtils.isEmpty(name) || !TextUtils.isEmpty(number) || !TextUtils.isEmpty(email) || !TextUtils.isEmpty(organization)) {
//                                                        Contact contact = new Contact(name, number, email, organization, relationshipString);
//                                                        DBHandler dbHandler = null;
//                                                        dbHandler.addContact(contact);
//                                                        startActivity(new Intent(context, MainActivity.class));
//
//
//                                                    } else {
//                                                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//
//                                                        builder.setMessage("Please fill all the fields")
//
//                                                                .setNegativeButton("OK", null)
//                                                                .show();









//       View.OnClickListener view = null;
//      // add.setOnClickListener(view);
//
//            //  add.setOnClickListener{(view) -> {
//
//
//           @Override
//           public void onClick (View view)
//             {
//                 //this.view = (View.OnClickListener) view;
//
//                 name = et_name.getText().toString();
//            number = et_number.getText().toString();
//            email = et_email.getText().toString();
//            organization = et_organization.getText().toString();
////
////                if(name.trim().length() > 0 && number.trim().length() > 0 && email.trim().length() > 0 && organization.trim().length() >
////
////                Contact
////                Contact contact = new Contact(name, number, email, organization, relationshipString);
////                dbHandler.addContact(contact);
//
//            startActivity(new Intent(context, MainActivity.class));
//
//            if (!TextUtils.isEmpty(name) || !TextUtils.isEmpty(number) || !TextUtils.isEmpty(email) || !TextUtils.isEmpty(organization)) {
//                Contact contact = new Contact(name, number, email, organization, relationshipString);
//                DBHandler dbHandler = null;
//                dbHandler.addContact(contact);
//                startActivity(new Intent(context, MainActivity.class));
//
//
//            } else {
//                AlertDialog.Builder builder = new AlertDialog.Builder(context);
//
//                builder.setMessage("Please fill all the fields")
//
//                        .setNegativeButton("OK", null)
//                        .show();

//
//










