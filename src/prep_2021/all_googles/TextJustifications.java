package prep_2021.all_googles;

import java.util.ArrayList;
import java.util.List;

public class TextJustifications {
    int idx = 0;

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        while (idx < words.length) {
            List<StringBuilder> wordsInLine = new ArrayList<>();
            int width = alignWords(words, maxWidth, wordsInLine);
            padText(wordsInLine, maxWidth, width, idx == words.length);

            result.add(format(wordsInLine));
        }
        return result;
    }


    private int alignWords(String[] words, int maxWidth, List<StringBuilder> sb) {
        int currLen = 0;
        while (idx < words.length && currLen + words[idx].length() <= maxWidth) {
            sb.add(new StringBuilder().append(' ').append(words[idx]));
            currLen += words[idx].length() + 1;
            idx++;
        }
        sb.get(0).deleteCharAt(0);
        return currLen - 1;
    }

    private void padText(List<StringBuilder> words, int maxWidth, int currWidth, boolean lastLine) {
        int i = lastLine ? words.size() - 1 : 0, n = Math.max(1, words.size() - 1);
        while (currWidth < maxWidth) {
            words.get(i).append(' ');
            currWidth++;
            i = lastLine ? words.size() - 1 : (i + 1) % n;
        }
    }

    private String format(List<StringBuilder> words) {
        StringBuilder sb = new StringBuilder();
        for (StringBuilder word : words) {
            sb.append(word);
        }
        return sb.toString();
    }
}
