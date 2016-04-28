package com.example.patryk.test2;

import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

import static com.example.patryk.test2.R.drawable.cast_ic_notification_2;

public class MapButton extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_button);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        // example marker in sydney


//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//
//
//        // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            return;
//        }
//        mMap.setMyLocationEnabled(true);
//

        // setting second marker in wroclaw

        LatLng wroclaw = new LatLng(51.103154 , 17.084636) ;
        mMap.addMarker(new MarkerOptions().position(wroclaw).draggable(true).title("hallo here i am "));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(wroclaw));
    }

        // function try to find place given by user


    public void clickMetoFindPlaceFunction(View view)
    {

        EditText userText = (EditText)findViewById(R.id.editText2);
        String location  = userText.getText().toString() ;
        List<Address> addressList = null ;

        String [] tab = new String[2] ;

        for (int i = 0 ; i < tab.length ; i++) {

            tab[i] = location;
        }

        for (int i = 0 ; i < 1 ; i++) {

            System.out.println(tab[i]);
        }

        if(location != null || !location.equals(""))
        {
            Geocoder geocoder = new Geocoder(this);
            try {
                addressList = geocoder.getFromLocationName(location , 1) ;
            } catch (IOException e) {
                e.printStackTrace();
            }
            Address address = addressList.get(0) ;



            LatLng finndMe = new LatLng(address.getLatitude(), address.getLongitude());
            mMap.addMarker(new MarkerOptions().position(finndMe).title("OOoo here is this place ! "));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(finndMe));



        }
    }

    // hybrid look of the map

    public void streetView(View view) {
        if( mMap.getMapType() == GoogleMap.MAP_TYPE_NORMAL)
        {
            mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        }else {
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        }
    }

    // flat marker


    public void flatMarkerFunction(View view) {

      LatLng breslau = new LatLng(51.103154 , 17.084636);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(breslau, 1));

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(cast_ic_notification_2))
                .position(breslau)
                .flat(true)
                .rotation(245));

        CameraPosition cameraPosition = CameraPosition.builder()
                .target(breslau)
                .zoom(13)
                .bearing(90)
                .build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), 2000, null);


    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "MapButton Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.patryk.test2/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "MapButton Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.patryk.test2/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }



}
