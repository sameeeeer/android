package com.example.blogging.Fragment;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.blogging.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class AboutusFragment extends Fragment implements OnMapReadyCallback {

    private MapView mapView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_aboutus, container, false);

        mapView = v.findViewById(R.id.map);
        mapView.getMapAsync(this);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return v;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(27.706185, 85.330024))
                .title("Blogging for you")
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(27.706185, 85.330024), 14f));
    }

    public static AboutusFragment newInstance() {
        AboutusFragment aboutusFragment = new AboutusFragment();
        return aboutusFragment;

    }

}
