package sort;

import java.util.ArrayList;
import java.util.List;

public class RadixSortLSD {
    /**
       * Sorts a list of Dutch mobile phone numbers using LSD radix sort.
            *
            * @param phoneNumbers
   *     The list of phone numbers to sort.
   * @return The sorted list of phone numbers.
            * @throws NullPointerException
   *     If `phoneNumbers` equals `null`.
            */
    static List<String> radixSortLSD(List<String> phoneNumbers) {
        if (phoneNumbers == null) throw new NullPointerException() ;
        else {


            for (int pos = 9 ; pos >= 2 ; --pos) {


                List<String>[] bucket = new ArrayList[10] ;
                for (int i = 0 ; i <= 9 ;  ++i)
                    bucket[i] = new ArrayList<>();

                for (String phoneNumber: phoneNumbers) {
                    char c = phoneNumber.charAt(pos) ;
                    bucket[c-'0'].add(phoneNumber) ;
                }


                phoneNumbers = new ArrayList<>() ;
                for (int i = 0; i < 10 ;  ++i) // All digits
                    phoneNumbers.addAll(bucket[i]) ;
            }

            return phoneNumbers;
        }
    }
}
