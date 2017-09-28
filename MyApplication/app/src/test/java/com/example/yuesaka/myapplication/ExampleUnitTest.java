package com.example.yuesaka.myapplication;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricTestRunner.class)
public class ExampleUnitTest {
    /** test.json:
     * {
        "glossary": {
            "title": "example glossary",
            "GlossDiv": {
                "title": "S",
                "GlossList": {
                    "GlossEntry": {
                        "ID": "SGML",
                        "SortAs": "SGML",
                        "GlossTerm": "Standard Generalized Markup Language",
                        "Acronym": "SGML",
                        "Abbrev": "ISO 8879:1986",
                        "GlossDef": {
                            "para": "A meta-markup language, used to create markup languages such as DocBook.",
                            "GlossSeeAlso": ["GML", "XML"]
                        },
                        "GlossSee": "markup"
                    }
                }
            }
        }
     }
     */
    @Test
    public void canReadFile() throws Exception {
        URL jsonUrl = this.getClass().getClassLoader().getResource("test.json");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(jsonUrl.openStream()));

        StringBuilder sb = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            sb.append(inputLine);
        }
        in.close();
        JSONObject jsonObject = new JSONObject(sb.toString());
        assertTrue(jsonObject.getJSONObject("glossary") != null);
        assertTrue(jsonObject.getJSONObject("glossary").getString("title").equals("example glossary"));
        assertTrue(jsonObject.getJSONObject("glossary").getJSONObject("GlossDiv").getString("title").equals("S"));
    }
}