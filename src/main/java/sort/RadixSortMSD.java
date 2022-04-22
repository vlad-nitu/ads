package sort;

import java.util.ArrayList;
import java.util.List;

public class RadixSortMSD {
    /**
     * Sorts a list of words using MSD radix sort.
     *
     * @param words
     *     The list of words to sort.
     * @return The sorted list of words.
     * @throws NullPointerException
     *     If `words` equals `null`.
     */
    static List<String> radixSortMSD(List<String> words) {
        if (words == null) throw new NullPointerException() ;
        else {
            return sort(words, 0);

        }
    }

    public static List<String> sort (List<String> words, int pos){

        if (words.size() == 1) return words; // trivially sorted, base case

        List<String>[] bucket = new ArrayList[26] ;
        List<String> res = new ArrayList<>() ;



        for (String word: words)
            if (pos < word.length())
            {
                int i = word.charAt(pos) - 'a';
                if (bucket[i] == null)
                    bucket[i] = new ArrayList<>() ;
                bucket[i].add(word);

            }
            else res.add(word) ;

        for (int i = 0 ; i < 26 ; ++i)
            if (bucket[i] != null)
            {

                List<String> new_words = bucket[i] ;
                if (new_words.size() > 0)
                    new_words = sort(new_words, pos + 1) ;


                res.addAll(new_words) ;

            }

        return res;


    }
}
