package leetcode.contests.contest_184;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class HTMLEntityParser {
    HTMLEntityParser htmlEntityParser;

    @BeforeEach
    public void init() {
        htmlEntityParser = new HTMLEntityParser();
    }

    @Test
    public void firstTest() {
        String text = "&amp; is an HTML entity but &ambassador; is not.";
        String expected = "& is an HTML entity but &ambassador; is not.";
        String res = htmlEntityParser.entityParser(text);
        Assertions.assertEquals(expected, res);

    }

    @Test
    public void secondTest() {
        String text = "and I quote: &quot;...&quot;";
        String expected = "and I quote: \"...\"";
        String res = htmlEntityParser.entityParser(text);
        Assertions.assertEquals(expected, res);

    }

    @Test
    public void thirdTest() {
        String text = "Stay home! Practice on Leetcode :)";
        String expected = "Stay home! Practice on Leetcode :)";
        String res = htmlEntityParser.entityParser(text);
        Assertions.assertEquals(expected, res);

    }

    @Test
    public void fourthTest() {
        String text = "x &gt; y &amp;&amp; x &lt; y is always false";
        String expected = "x > y && x < y is always false";
        String res = htmlEntityParser.entityParser(text);
        Assertions.assertEquals(expected, res);

    }

    @Test
    public void fifthTest() {
        String text = "leetcode.com&frasl;problemset&frasl;all";
        String expected = "leetcode.com/problemset/all";
        String res = htmlEntityParser.entityParser(text);
        Assertions.assertEquals(expected, res);

    }

    public java.lang.String entityParser(String text) {
        HashMap<String, Character> map = new HashMap<>();
        map.put("&quot;", '"');
        map.put("&apos;", '#');
        map.put("&amp;", '&');
        map.put("&gt;", '>');
        map.put("&lt;", '<');
        map.put("&frasl;", '/');
        StringBuilder sb = new StringBuilder();
        int start = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '&'){
                sb.append(text.substring(start,i));
                start = i;
            }
            else if (c == ';') {
                String str = text.substring(start, i+1);
                start=i+1;
                if(map.get(str)!=null){

                    if(map.get(str)=='#')
                        sb.append("'");
                    else
                        sb.append(map.get(str));
                }else {
                    sb.append(str);
                }

            }
        }
        sb.append(text.substring(start));
        return sb.toString();
    }

}
