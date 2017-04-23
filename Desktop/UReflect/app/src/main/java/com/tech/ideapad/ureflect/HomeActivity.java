package com.tech.ideapad.ureflect;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        packagename = (TextView) findViewById(R.id.packagename);
        contactList = new ArrayList<>();

        lv = (ListView) findViewById(R.id.list);

        new GetContacts().execute();
    }

    private String TAG = MainActivity.class.getSimpleName();
    TextView packagename;
    private ProgressDialog pDialog;
    private ListView lv;

    // URL to get contacts JSON
    static final String API_KEY = "e37be597f7acb0fb0f25156e08dcdca61820c1d2";
    static final String API_URL = "https://data.42matters.com/api/v2.0/android/apps/search.json?";
    // private static String url = "https://data.42matters.com/api/v2.0/android/apps/search.json?q=com.facebook.katana&access_token=e37be597f7acb0fb0f25156e08dcdca61820c1d2";

    ArrayList<HashMap<String, String>> contactList;




    /**
     * Async task class to get json by making HTTP call
     */
    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(HomeActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            //pDialog.show();

        }



        @Override
        protected Void doInBackground(Void... arg0) {
            /*String url="";
            List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);
            Iterator<ApplicationInfo> iterator = packages.iterator();
            while (iterator.hasNext()) {
                ApplicationInfo packageInfo = iterator.next();*/

            String url = API_URL + "q=" + "com.facebook.katana" + "&access_token=" + API_KEY;
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray results = jsonObj.getJSONArray("results");

                    // looping through All Contacts
                    for (int i = 0; i < results.length(); i++) {
                        JSONObject c = results.getJSONObject(i);

                        String id = c.getString("package_name");
                        String name = c.getString("category");
                        String email = c.getString("title");


                      /*  // Phone node is JSON Object
                        JSONObject phone = c.getJSONObject("phone");
                        String mobile = phone.getString("mobile");
                        String home = phone.getString("home");
                        String office = phone.getString("office");*/

                        // tmp hash map for single contact
                        HashMap<String, String> contact = new HashMap<>();

                        // adding each child node to HashMap key => value
                        contact.put("package_name", id);
                        contact.put("category", name);
                        contact.put("title", email);


                        // adding contact to contact list
                        contactList.add(contact);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter(
                    HomeActivity.this, contactList,
                    R.layout.list_item, new String[]{"package_name", "category",
                    "title"}, new int[]{R.id.name,
                    R.id.email, R.id.mobile});

            lv.setAdapter(adapter);
        }

    }

    /*PackageManager pm;

    public String packagename() {
        pm = getPackageManager();
        List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);
        Iterator<ApplicationInfo> iterator = packages.iterator();
        String pkgname = "";
        while (iterator.hasNext()) {
            ApplicationInfo packageInfo = iterator.next();
            pkgname = packageInfo.packageName;
            packagename.setText(pkgname);
        }
         return pkgname;
    }


    class PkgInfo {
        private String appname = "";
        private String pname = "";
        private String versionName = "";
        private int versionCode = 0;



    private ArrayList<PkgInfo> getPackages() {
        ArrayList<PkgInfo> apps = getInstalledApps(false);
        final int max = apps.size();
        for (int i=0; i<max; i++) {
            apps.get(i).packagename();

        }
        return apps;
    }
        private  String packagename() {
            packagename.setText(pname);
            return pname;
        }


        private ArrayList<PkgInfo> getInstalledApps(boolean getSysPackages) {
        ArrayList<PkgInfo> res = new ArrayList<PkgInfo>();
        List<PackageInfo> packs = getPackageManager().getInstalledPackages(0);
        for(int i=0;i<packs.size();i++) {
            PackageInfo p = packs.get(i);
            if ((!getSysPackages) && (p.versionName == null)) {
                continue ;
            }
            PkgInfo newInfo = new PkgInfo();
            newInfo.pname = p.packageName;
            res.add(newInfo);
        }
        return res;
    }}*/
}

