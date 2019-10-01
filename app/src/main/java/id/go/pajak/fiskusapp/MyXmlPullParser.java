package id.go.pajak.fiskusapp;

import android.content.Context;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyXmlPullParser {
    Context _context;

    public MyXmlPullParser(Context _context) {
        this._context = _context;
    }

    public List<Map<String, String>> readXml(String XmlString, String ParentTag) {
        Map<String, String> map = new HashMap<String, String>();
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();

        try {
            String Tag = "";
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            xpp.setInput(new StringReader(XmlString));
            int eventType = xpp.getEventType();

            while (true) {
                if (eventType == XmlPullParser.START_TAG) {
                    Tag = xpp.getName();
                } else if (eventType == XmlPullParser.END_TAG) {
                    Tag = "";
                    if (xpp.getName().equals(ParentTag)) {
                        list.add(map);
                        map = new HashMap<String, String>();
                    }
                } else if (eventType == XmlPullParser.TEXT) {
                    String text = xpp.getText();
                    if (!Tag.equals("") && !Tag.equals(ParentTag)) {
                        map.put(Tag, text);
                    }
                } else if (eventType == XmlPullParser.END_DOCUMENT) {
                    System.out.println("End document");
                    break;
                }
                eventType = xpp.next();
            }
        } catch (XmlPullParserException e) {
            Log.e("xml reader", "error in parsing  xml");
            return null;
        } catch (IOException e) {
            Log.e("xml reader", "error in IO in xml");
            return null;
        }
        return list;
    }
}
