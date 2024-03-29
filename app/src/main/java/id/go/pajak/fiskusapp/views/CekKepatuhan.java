package id.go.pajak.fiskusapp.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
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

import java.util.ArrayList;

import id.go.pajak.fiskusapp.MainActivity;
import id.go.pajak.fiskusapp.R;
import id.go.pajak.fiskusapp.models.DetailKepatuhanWP;
import id.go.pajak.fiskusapp.models.DetailPenyidikan;
import id.go.pajak.fiskusapp.models.DetailSptM;
import id.go.pajak.fiskusapp.models.DetailSptT;
import id.go.pajak.fiskusapp.models.DetailUtang;
import id.go.pajak.fiskusapp.models.DetailWP;
import id.go.pajak.fiskusapp.models.ModelKepatuhanWP;
import id.go.pajak.fiskusapp.models.UserHelper;

public class CekKepatuhan extends Fragment {
    Button cari;
    TextView tvNpwp,tvNama;

    private String URLstring ="http://10.254.56.99/integrationsvc/index.php/kswpprovider/valskfbynpwp?npwp=";
    ModelKepatuhanWP modelKepatuhanWP = new ModelKepatuhanWP();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cek_kepatuhan, container, false);
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

    private void requestJSON(String npwp){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLstring+npwp,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);

                            JSONObject kepatuhanWp = array.getJSONObject(1);
                            DetailKepatuhanWP detailKepatuhanWP = new DetailKepatuhanWP();
                            String result = kepatuhanWp.getString(detailKepatuhanWP.KEY_KD_STS_SKF);

                            if("0".equalsIgnoreCase(result)){
                                Toast.makeText(getView().getContext(), "WP Tidak Diketemukan", Toast.LENGTH_SHORT).show();
                                tvNama.setText(null);
                            } else {
                                detailKepatuhanWP.setKdStatusWP(kepatuhanWp.getString(detailKepatuhanWP.KEY_KD_STS_SKF));
                                detailKepatuhanWP.setStatusSKF(kepatuhanWp.getString(detailKepatuhanWP.KEY_STS_SKF));
//
                                JSONObject detailWp = kepatuhanWp.getJSONObject(detailKepatuhanWP.KEY_detailWP);


                                JSONObject detailSptT = kepatuhanWp.getJSONObject(detailKepatuhanWP.KEY_detailSptT);
                                JSONObject detailSptM = kepatuhanWp.getJSONObject(detailKepatuhanWP.KEY_detailSptM);
                                JSONObject detailUtang = kepatuhanWp.getJSONObject(detailKepatuhanWP.KEY_detailUtang);
                                JSONObject detailSidik = kepatuhanWp.getJSONObject(detailKepatuhanWP.KEY_detailPenyidikan);

                                DetailWP detailWP = new DetailWP();
                                detailWP.setKdStatusWP(detailWp.getString(detailWP.KEY_kdStatusWP));
                                detailWP.setStatusWP(detailWp.getString(detailWP.KEY_statusWP));
                                detailWP.setNpwp15(detailWp.getString(detailWP.KEY_npwp15));
                                detailWP.setNamaWP(detailWp.getString(detailWP.KEY_namaWP));
                                detailWP.setTglDaftar(detailWp.getString(detailWP.KEY_tglDaftar));

                                detailKepatuhanWP.setDetailWP(detailWP);

                                DetailSptT detailSPTT = new DetailSptT();
                                detailSPTT.setKdStatusSptT(detailSptT.getString(detailSPTT.KEY_kdStatusSptT));
                                detailSPTT.setKetStatusSptT(detailSptT.getString(detailSPTT.KEY_ketStatusSptT));
                                detailSPTT.setDataBpsSpt1(detailSptT.getString(detailSPTT.KEY_dataBpsSpt1));
                                detailSPTT.setDataBpsSpt2(detailSptT.getString(detailSPTT.KEY_dataBpsSpt2));
                                detailSPTT.setThnSpt1(detailSptT.getString(detailSPTT.KEY_thnSpt1));
                                detailSPTT.setThnSpt2(detailSptT.getString(detailSPTT.KEY_thnSpt2));
                                detailSPTT.setTglTerimaSpt1(detailSptT.getString(detailSPTT.KEY_tglTerimaSpt1));
                                detailSPTT.setTglTerimaSpt2(detailSptT.getString(detailSPTT.KEY_tglTerimaSpt2));

                                detailKepatuhanWP.setDetailSptT(detailSPTT);

                                DetailSptM detailSPTM = new DetailSptM();
                                detailSPTM.setKdStatusSptM(detailSptM.getString(detailSPTM.KEY_kdStatusSptM));
                                detailSPTM.setKetStatusSptM(detailSptM.getString(detailSPTM.KEY_ketStatusSptM));

                                detailKepatuhanWP.setDetailSptM(detailSPTM);

                                DetailUtang detailUtangWP = new DetailUtang();
                                detailUtangWP.setKdStatusUtang(detailUtang.getString(detailUtangWP.KEY_kdStatusUtang));
                                detailUtangWP.setKetStatusUtang(detailUtang.getString(detailUtangWP.KEY_ketStatusUtang));

                                detailKepatuhanWP.setDetailUtang(detailUtangWP);

                                DetailPenyidikan detailPenyidikan = new DetailPenyidikan();
                                detailPenyidikan.setKdStatusSidik(detailSidik.getString(detailPenyidikan.KEY_kdStatusSidik));
                                detailPenyidikan.setKetStatusSidik(detailSidik.getString(detailPenyidikan.KEY_ketStatusSidik));

                                detailKepatuhanWP.setDetailPenyidikan(detailPenyidikan);

                                Toast.makeText(getView().getContext(), "Cek Kepatuhan WP Berhasil", Toast.LENGTH_SHORT).show();
                                tvNama.setText(detailKepatuhanWP.toString());
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
