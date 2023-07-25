//30. Substring with Concatenation of All Words
//        Input: s = "barfoothefoobarman", words = ["foo","bar"]
//        Output: [0,9]
//Logic
//1>to know the frequency of every word and each time create a copy

//2>now once you find a word that is there in map then check for all the word after it until map is empty
import java.util.*;

public class SubstringwithConcatenationofAllWords {
static  void Permu(int index, String []s, String p, Set<String> set)
{
    if(index==s.length)
    {
        for(int i=0;i<s.length;i++)
        {
            p=p+s[i];
        }
        System.out.println(p);
        set.add(p);
        return;
    }
    for(int i=index;i<s.length;i++)
    {
        swap(i,index,s);
        Permu(index+1,s,p,set);
        swap(i,index,s);
    }

}
 static void swap(int i,int j,String nums[])
 {
     String temp=nums[i];
     nums[i]=nums[j];
     nums[j]=temp;
 }
 static List<Integer> solve(Set<String> set, String word[], String s) {
     int len = word[0].length() * word.length;
     List<Integer> a = new ArrayList<>();
     int i = 0, j = 0;
     String extract = "";
     for (i = 0; i < s.length(); i++) {
         if (i + len - 1 < s.length()) {
             extract = s.substring(i, i + len);
             if (set.contains(extract)) {
                 a.add(i);
             }
         } else {
             break;
         }

     }
     return a;
 }
static List<Integer> solve(String[] words,String s) {
    int nword= words.length;
    int ns=s.length();
    int len=words[0].length();
     int target=len*nword;
     Map<String,Integer> m=new HashMap<>();
     List<Integer> ans=new ArrayList<>();
     for(String word:words)
     {
         m.put(word,m.getOrDefault(word,0)+1);
     }
     String str="";
     int count=0;
     for(int i=0;i<=ns-target;i++)
     {
         Map<String,Integer> copy=new HashMap<>(m);
         for(int j=0;j<nword;j++)
         {
             str=s.substring(i+j*len,i+j*len+len);
             if(copy.containsKey(str))
             {
                 count=copy.get(str);
                 if(count==1)
                 {
                     copy.remove(str);
                 }
                 else{
                     copy.put(str,count-1);
                 }
                 if(copy.isEmpty())
                 {
                     ans.add(i);
                     break;
                 }

             }

         }
     }
    return ans;

}

    public static void main(String[] args) {
      String s[]={"word","good","best","good"};
      String word="wordgoodgoodgoodbestword";

        System.out.println(solve(s,word));

    }
}
