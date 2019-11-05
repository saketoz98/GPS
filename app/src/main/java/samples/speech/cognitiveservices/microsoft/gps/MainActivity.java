package samples.speech.cognitiveservices.microsoft.gps;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView locationTV;
    double latitude, longitude;
    private FusedLocationProviderClient fusedLocationClient;
    Geocoder geocoder;
    List<Address> addresses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationTV = (TextView) findViewById(R.id.textView);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);


        fusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    longitude = location.getLongitude();
                    latitude = location.getLatitude();
                    Log.d("Latitude",Double.toString(latitude) );

                    locationTV.setText("Latitude " + latitude + "\n Longitude " + longitude );
                }
            }
        });
    }
}
