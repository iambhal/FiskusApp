package id.go.pajak.fiskusapp.views;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.util.List;
import java.util.Map;

import id.go.pajak.fiskusapp.MyXmlPullParser;
import id.go.pajak.fiskusapp.R;
import id.go.pajak.fiskusapp.models.UserHelper;
import id.go.pajak.fiskusapp.models.UserModel;

public class CariPegawaiView extends Fragment {

    Button cari;
    TextView txNama, txCari;



    String URL = "http://10.245.7.74/ws/tsikkaws.php";
    String NAMESPACE = "http://10.254.232.72/ws/tsikkaws.php";
//    String NAMESPACE = "http://10.245.7.74/ws/tsikkaws.php/";

    String METHOD_NAME = "CekPegawai";
    String SOAP_ACTION = "http://10.245.7.74/ws/tsikkaws.php/CekPegawai";
    String PARAMETER_NAME = "ip";
    UserModel user;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            final View view = inflater.inflate(R.layout.fragment_cari_pegawai, container, false);

            cari = view.findViewById(R.id.btCari);
            txNama = view.findViewById(R.id.txNama);
            txCari = view.findViewById(R.id.txCari);
            cari.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UserHelper userHelper = new UserHelper(view.getContext());
                    user = userHelper.findUser(txCari.getText().toString());
                    String hasil = "Data Pegawai<br />Nama: "+user.getNama().toString()+"<br />NIP: "+user.getNip19().toString()+"<br />Jabatan: "+user.getJabatan().toString();
                    txNama.setText(Html.fromHtml(hasil));

//                    new CallWebService().execute(txCari.getText().toString());
                }
            });

        return view;
    }

    class CallWebService extends AsyncTask<String, Void, String> {

        @Override
        protected void onPostExecute(String s) {
            txNama.setText(s);

        }


        @Override
        protected String doInBackground(String... params) {
            String result="";

            System.setProperty("http.keepAlive","true");

            SoapObject soapObject = new SoapObject(NAMESPACE, METHOD_NAME);

            PropertyInfo propertyInfo = new PropertyInfo();
            propertyInfo.setName(PARAMETER_NAME);
            propertyInfo.setValue(params[0]);
            propertyInfo.setType(String.class);

            soapObject.addProperty(propertyInfo);

            SoapSerializationEnvelope envelope =  new SoapSerializationEnvelope(SoapEnvelope.VER11);

            envelope.implicitTypes = true;
            envelope.bodyOut = soapObject;
//            envelope.encodingStyle = SoapSerializationEnvelope.ENC;
            envelope.dotNet = true;
            envelope.setOutputSoapObject(soapObject);

            HttpTransportSE httpTransportSE = new HttpTransportSE(null);
            httpTransportSE.setUrl(URL);
            httpTransportSE.debug = true;
            List<Map<String , String>> list;

            try {
                list = httpTransportSE.call(SOAP_ACTION, envelope,null);
//                SoapObject response = (SoapObject) envelope.getResponse();
//                SoapObject resultString = (SoapObject) envelope.bodyIn;
//                SoapObject response = (SoapObject)resultString.getProperty(0);
//
//
//                result = response.toString();
//                System.out.println(result);
                SoapPrimitive soapPrimitive = (SoapPrimitive)envelope.getResponse();
                result = soapPrimitive.toString();
            } catch(XmlPullParserException e){
                MyXmlPullParser objMyXmlPullParser = new MyXmlPullParser(getContext());
                list = objMyXmlPullParser.readXml(result, "Envelope");

            } catch (Exception e) {
                e.printStackTrace();
            }

            return result;
        }


    }
}
