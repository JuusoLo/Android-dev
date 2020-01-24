//package com.example.android_task1;
//
//import com.android.volley.toolbox.JsonArrayRequest;
//
//import android.os.Bundle;
//
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.Volley;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//import androidx.recyclerview.widget.GridLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.util.Log;
//
//import android.widget.SearchView;
//import android.widget.TextView;
//
//
//import org.json.JSONArray;
//
//import org.json.JSONObject;
//
//
//import java.util.ArrayList;
//
//public class Contacts extends AppCompatActivity {
//
//    RequestQueue requestQueue;
//
//    RecyclerView mView;
//    RecyclerView.LayoutManager layoutManager;
//    ListAdapter listAdapter;
//    ArrayList<Contact> contactsArrayList;
//    ArrayList<Contact> filteredContactsArrayList;
//
//
//    SearchView searchView;
//    String filterKey;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_contacts);
////        Toolbar toolbar = findViewById(R.id.toolbar);
////        setSupportActionBar(toolbar);
//
////        contactsRecyclerView = findViewById(R.id.check_contacts);
//
//        mView = (RecyclerView) findViewById(R.id.check_contacts);
//
//        contactsArrayList = new ArrayList<Contact>();
//        filteredContactsArrayList = new ArrayList<Contact>();
//
//        // instantiate requestQueue
//        requestQueue = Volley.newRequestQueue(this);
//        String url = "https://digitradecontacs2019.azurewebsites.net/api/contacts";
//
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
//                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
//
//                    @Override
//                    public void onResponse(JSONArray response) {
//
//                        // parse response JSON
//                        for (int i = 0; i < response.length(); i++) {
//                            try {
//                                Contact contact = new Contact(null, null, null);
//                                JSONObject object = response.getJSONObject(i);
//
//                                contact.firstName = object.getString("firstName");
//                                contact.lastName = object.getString("lastName");
//                                contact.phoneNumber = object.getString("phoneNumber");
//                                contactsArrayList.add(contact);
//
//                                Log.e("new contact", contact.toString());
//
//                                contactsArrayList.add(contact);
//
//                                setView();
//
//
//
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                        }
//
//                        Log.v("contactsArrayList", "" + contactsArrayList.toString());
//
//                    }
//                }, new Response.ErrorListener() {
//
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        // TODO: Handle error
//                        Log.e("res", error.toString());
//                    }
//                });


//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                Log.v("search submit", "" + s);
//                filterKey = s; // set filter on submit
//                filterContacts(s);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                Log.v("search text", "" + s);
//                filterKey = s; // set filter text while writing
//                return false;
//            }
//        });
//
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_contacts, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//

//        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                Log.v("contacts menu", "clicked!");
//                Log.v("contacts menu item", item.getTitle().toString());
//
//                return false;
//            }
//        });
//
//        return super.onOptionsItemSelected(item);
//    }

//    public void filterContacts(String filterK) {
//        String f = filterK.toLowerCase();
//        Log.v("contacts size", "" + contactsArrayList.size());
//        for (int i = 0; i < contactsArrayList.size(); i++) {
//            Log.v("i", "" + i);
//            Contact c = contactsArrayList.get(i);
//            if (c.firstName.toLowerCase().contains(f)) {
//                if (!filteredContactsArrayList.contains(c)) {
//                    filteredContactsArrayList.add(c);
//                }
//            } else if (c.lastName.toLowerCase().contains(f)) {
//                if (!filteredContactsArrayList.contains(c)) {
//                    filteredContactsArrayList.add(c);
//                }
//            } else if (c.phoneNumber.contains(f)) {
//                if (!filteredContactsArrayList.contains(c)) {
//                    filteredContactsArrayList.add(c);
//                }
//            }
//
//
//        }
//
//        Log.e("filteredContactsArrayList", filteredContactsArrayList.toString());
//
//        listAdapter = new ListAdapter(filteredContactsArrayList);
//        contactsRecyclerView.setAdapter(listAdapter);
//
//        // TODO set contactsArrayList as current list before filtering again
//    }

//        requestQueue.add(jsonArrayRequest);
//
//    }
//
//    private void setView() {
//        mView.setLayoutManager(new GridLayoutManager(this, 1));
//        listAdapter = new ListAdapter(this, this.contactsArrayList);
//        mView.setAdapter(listAdapter);
//        Log.e("Meneekö", "Perille?");
//
//    }
//
//}