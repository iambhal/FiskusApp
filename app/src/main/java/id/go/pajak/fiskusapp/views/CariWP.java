package id.go.pajak.fiskusapp.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import id.go.pajak.fiskusapp.R;
import id.go.pajak.fiskusapp.models.DetailProfileWP;

public class CariWP extends Fragment {

    Button cari;
    TextView tvNpwp, tvNama;

    private String URLstring = "http://10.254.56.99/integrationsvc/index.php/kswpprovider/profile?npwp=";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cari_wp, container, false);
        tvNpwp = view.findViewById(R.id.txCari);
        cari = view.findViewById(R.id.btCari);
        tvNama = view.findViewById(R.id.txNama);

        cari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestJSON(tvNpwp.getText().toString());
            }
        });

        return view;
    }

    private void requestJSON(String npwp) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLstring + npwp,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);

                            String result = array.getString(0);
                            if ("0".equalsIgnoreCase(result)) {
                                Toast.makeText(getView().getContext(), "WP Tidak Diketemukan", Toast.LENGTH_SHORT).show();
                                tvNama.setText(null);
                            } else {

                                JSONObject profileWP = array.getJSONObject(1);

                                DetailProfileWP detailProfileWP = new DetailProfileWP();
                                detailProfileWP.setNPWP(profileWP.getString(detailProfileWP.KEY_NPWP));
                                detailProfileWP.setNAMA(profileWP.getString(detailProfileWP.KEY_NAMA));
                                detailProfileWP.setALAMAT(profileWP.getString(detailProfileWP.KEY_ALAMAT));
                                detailProfileWP.setKELURAHAN(profileWP.getString(detailProfileWP.KEY_KELURAHAN));
                                detailProfileWP.setKECAMATAN(profileWP.getString(detailProfileWP.KEY_KECAMATAN));
                                detailProfileWP.setKABKOT(profileWP.getString(detailProfileWP.KEY_KABKOT));
                                detailProfileWP.setPROVINSI(profileWP.getString(detailProfileWP.KEY_PROVINSI));
                                detailProfileWP.setNAMA_KANWIL(profileWP.getString(detailProfileWP.KEY_NAMA_KANWIL));
                                detailProfileWP.setNAMA_KPP(profileWP.getString(detailProfileWP.KEY_NAMA_KPP));
                                detailProfileWP.setEMAIL(profileWP.getString(detailProfileWP.KEY_EMAIL));
                                detailProfileWP.setFAX(profileWP.getString(detailProfileWP.KEY_FAX));
                                detailProfileWP.setJENIS_WP(profileWP.getString(detailProfileWP.KEY_JENIS_WP));
                                detailProfileWP.setKODE_KLU(profileWP.getString(detailProfileWP.KEY_KODE_KLU));
                                detailProfileWP.setKLU(profileWP.getString(detailProfileWP.KEY_KLU));
                                detailProfileWP.setTGL_DAFTAR(profileWP.getString(detailProfileWP.KEY_TGL_DAFTAR));
                                detailProfileWP.setSTATUS_PKP(profileWP.getString(detailProfileWP.KEY_STATUS_PKP));
                                detailProfileWP.setTGL_PENGUKUHAN_PKP(profileWP.getString(detailProfileWP.KEY_TGL_PENGUKUHAN_PKP));
                                detailProfileWP.setTTL(profileWP.getString(detailProfileWP.KEY_TTL));
                                detailProfileWP.setBADAN_HUKUM(profileWP.getString(detailProfileWP.KEY_BADAN_HUKUM));

                                Toast.makeText(getView().getContext(), "Cek Kepatuhan WP Berhasil", Toast.LENGTH_SHORT).show();
                                tvNama.setText(detailProfileWP.toString());


                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //displaying the error in toast if occurrs
                        Toast.makeText(getView().getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(getView().getContext());

        //adding the string request to request queue
        requestQueue.add(stringRequest);

    }
}
