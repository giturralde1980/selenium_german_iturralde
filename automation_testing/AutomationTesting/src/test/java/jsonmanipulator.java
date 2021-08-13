import io.cucumber.gherkin.internal.com.eclipsesource.json.Json;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;

public class jsonmanipulator {
    public static void main (String args[])
    {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/test/resources/caseCustomEndPointSalesforce.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject reason = (JSONObject) jsonObject.get("reason");
            JSONObject ocrResult = (JSONObject)  reason.get("ocrResult");
            ocrResult.put("ocrId", "testtest");
            System.out.println(ocrResult.get("ocrId"));
            JSONArray result = (JSONArray)  ocrResult.get("result");
            HashMap mapa = new HashMap();
            mapa.put("result","pepe");
            mapa.put("field","Name");
            mapa.put("mismatch",true);
            mapa.put("expected","test");

            result=new JSONArray();
            result.add(mapa);

            System.out.println(jsonObject);
            //ocrResult.put(result);
            //Iterator<JSONObject> iterator = result.iterator();
           // while (iterator.hasNext()) {
           //     System.out.println(iterator.next());
            // }



            String variable="";
            // An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework.
            // Iterators differ from enumerations in two ways:
            // 1. Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
            // 2. Method names have been improved.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
