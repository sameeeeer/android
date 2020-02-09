package com.example.blogging.Activities;

import androidx.fragment.app.FragmentActivity;

import android.location.Location;
import android.os.Bundle;

import com.example.blogging.Model.Place;
import com.example.blogging.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final int REQUEST_CODE=1;
    private GoogleMap mMap;
    FusedLocationProviderClient fusedLocationProviderClient;
    Location currentLocation;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        loadLocation();

        CameraUpdate zoom;
        zoom = CameraUpdateFactory.zoomTo(20);

        // Add a marker in Sydney and move the camera
        LatLng Softwarica = new LatLng(27.706416, 85.330044);
        mMap.addMarker(new MarkerOptions().position(Softwarica).title("Blog for you"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Softwarica));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(18));
//        mMap.animateCamera(zoom);

//        fetchLastLocation();
    }

    public void loadLocation() {
        List<Place> placeList = new ArrayList<>();
        placeList.add(new Place(27.704178, 85.332428, "Maitidevi"));

        CameraUpdate center, zoom;

        for (Place place : placeList) {
            zoom = CameraUpdateFactory.zoomTo(15);
            center = CameraUpdateFactory.newLatLng(
                    new LatLng(place.getLat(), place.getLon()));
            mMap.addMarker(new MarkerOptions().
                    position(new LatLng(place.getLat(),
                            place.getLon())).title(place.getName()));
            mMap.moveCamera(center);
            mMap.animateCamera(zoom);
            mMap.getUiSettings().setZoomControlsEnabled(true);


        }


    }

//    private void fetchLastLocation() {
//        if (ActivityCompat.checkSelfPermission(this,
//                Manifest.permission.ACCESS_FINE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(this,
//                    new String[]
//                            {Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE);
//            return;
//        }
//        Task<Location> task =
//                fusedLocationProviderClient.getLastLocation();
//        task.addOnSuccessListener(new OnSuccessListener<Location>() {
//            @Override
//            public void onSuccess(Location location) {
//                if (location != null){
//                    currentLocation = location;
//                    Toast.makeText(MapsActivity.this, currentLocation.getLatitude()
//                            +","+ currentLocation.getLongitude(), Toast.LENGTH_SHORT).show();
//                    Log.d("myloc:",currentLocation.getLatitude()
//                            +","+ currentLocation.getLongitude());
//
//                    LatLng current = new LatLng(currentLocation.getLatitude(),
//                            currentLocation.getLongitude());
//                    mMap.addMarker(new MarkerOptions().position(current).title("I am Here!")
//                            .snippet("marker info")
//                            .icon(BitmapDescriptorFactory
//                                    .defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
//                    mMap.moveCamera(CameraUpdateFactory.newLatLng(current));
//                    CameraUpdate zoom;
//                    zoom = CameraUpdateFactory.zoomTo(16);
//                    mMap.animateCamera(zoom);
//                    mMap.getUiSettings().setZoomControlsEnabled(true);
//
//
//                }
//                else {
//                    Toast.makeText(MapsActivity.this, "not found",
//                            Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
//
//
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if (requestCode == REQUEST_CODE){
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                fetchLastLocation();
//            }
//            else {
//                Toast.makeText(this, "No Permission", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }


}

