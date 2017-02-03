package lehilti.mapmarkers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap m_map;
    boolean mapReady=false;
    MarkerOptions casa;
    MarkerOptions Casa_Hellen;
    MarkerOptions Sato;
    MarkerOptions Pastorinho;

    static final CameraPosition saopaulo = CameraPosition.builder()
            .target(new LatLng(-23.503207,-46.720023))
            .zoom(13)
            .bearing(0)
            .tilt(0)
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        casa = new MarkerOptions()
        .position(new LatLng(-23.503207,-46.720023))
        .title("Minha casa");


        Casa_Hellen = new MarkerOptions()
                .position(new LatLng(-23.494063,-46.722515))
                .title("Casa do meu amor")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cora3));

        Sato = new MarkerOptions()
                .position(new LatLng(-23.496408,-46.728629))
                .title("Mercado sato");

        Pastorinho = new MarkerOptions()
                .position(new LatLng(-23.506325,-46.716877))
                .title("Mercado Pastorinho");

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady=true;
        m_map = googleMap;
        m_map.addMarker(casa);
        m_map.addMarker(Casa_Hellen);
        m_map.addMarker(Sato);
        m_map.addMarker(Pastorinho);
        m_map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        flyto(saopaulo);

    }

    private void flyto(CameraPosition target){
        m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target),10000,null);
    }
}
