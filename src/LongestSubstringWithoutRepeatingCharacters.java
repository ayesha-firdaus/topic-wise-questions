import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
//    logic
//    1>each time we encounter a new alphabet with add it in map with its position
//    2>if we get the same alpabet we will try to check if it exist in range and the update the first pointer accordingly

    public int lengthOfLongestSubstring1(String s) {
//        t 0(2n)
//        s o(n)


        int i,j=0;
        char ch1,ch2;
        Set<Character> set=new HashSet<>();
        int m=0;

        for(i=0;i<s.length();i++)
        {
            ch1=s.charAt(i);
            if(!set.contains(ch1))
            {
                set.add(ch1);

                m=Math.max(m,i-j+1);
            }
            else{

                while(set.contains(ch1))
                {
                    ch2=s.charAt(j);
                    j++;
                    set.remove(ch2);

                }
                set.add(ch1);

            }
        }
        return m;
    }

public int lengthOfLongestSubstring(String s) {
//        t o(n)
//            s 0(n)
    Map<Character,Integer> m=new HashMap<>();
    char ch1;
    int j=0,max=0;
    for(int i=0;i<s.length();i++)
    {
        ch1=s.charAt(i);
        if(!m.containsKey(ch1))
        {
            m.put(ch1,i);


        }
        else{
            int getIndex=m.get(ch1);

            if(j<=getIndex&&i>getIndex)
            {
                j=getIndex+1;

            }
            m.put(ch1,i);


        }
        max=Math.max(max,i-j+1);
    }
    return max;
}
    static int method3(String s)
    {
        //        t o(n)
//            s 0(n)
        Map<Character,Integer> m=new HashMap<>();
        int j=0,index=-1,ans=0;
        char ch;
        for(int i=0;i<s.length();i++)
        {
            ch=s.charAt(i);
            if(m.containsKey(ch))
            {
               index=m.get(ch);
               j=Math.max(index,j)+1;
            }
            m.put(ch,i);
            ans=Math.max(ans,i-j+1);

        }
 return ans;
    }

    public static void main(String[] args) {
        System.out.println(method3("abcabcdba"));
    }
}
