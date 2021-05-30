package leetcode.contests.contest_243;

public class EqualSummationsOfTwoWords {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        StringBuilder first=new StringBuilder("");
        StringBuilder second=new StringBuilder("");
        StringBuilder target=new StringBuilder("");

        for (char c:firstWord.toCharArray()) {
            int val=(int)c-97;
            first.append(val);
        }

        for (char c:secondWord.toCharArray()) {
            int val=(int)c-97;
            second.append(val);
        }

        for (char c:targetWord.toCharArray()) {
            int val=(int)c-97;
            target.append(val);
        }

        return (Integer.parseInt(first.toString())+
                Integer.parseInt(second.toString()))==Integer.parseInt(target.toString());

    }
}
