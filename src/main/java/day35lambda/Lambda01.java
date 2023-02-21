package day35lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lambda01 {
    public static void main(String[] args) {


    List<Integer> nums = new ArrayList<Integer>();
        nums.add(12);
        nums.add(9);
        nums.add(131);
        nums.add(14);
        nums.add(9);
        nums.add(10);
        nums.add(4);
        nums.add(12);
        nums.add(15);

        printElements1(nums);      /* bunu yazarak asagıda olusturdugum methodumu cagiriyorum */
        System.out.println();      /* her methodu cagırdıktan sonra "sout" koyuyorum */
        printElement2(nums);
        System.out.println();
        printEvenElement1(nums);   //her defasında aynı şeyi yapıyorum asagıda methodumu hazırlayir main
        System.out.println();      //icinde cagiriyorum
        printEvenElement2(nums);
        System.out.println();
        printSquareofElements1(nums);
        printCubeofDistinctOfElements2(nums);
        printSumOfSquaresOfDistinctEvenElements(nums);
        printProductOfSquareOfDistinctEvenElements(nums);


    }

    /* Example 1
      Bir list'teki elemanları aynı satırda aralarına bosluk koyarak yazdiran method'u olusturunuz.
      (Structured) */
    public static void printElements1(List<Integer> nums) {     /* methodumu olusturuyorum */
        for (Integer w : nums) {                                /* list veriyorum */
            System.out.print(w + " ");                          /* aynı satır dedigi icin "ln"yi kaldırdım */
        }
    }


    /* Eexample 2
    aynı soruyu (Functional) kullanarak yapıyorum */

    public static void printElement2(List<Integer> nums) {
        nums.stream().forEach(t -> System.out.print(t + " "));
    }



   /*Example 3
   Bir listteki cift elemanları ayni satirda aralarina bosluk koyarak yazdiran methodu olusturunuz.
   (Sstructured) */

    public static void printEvenElement1(List<Integer> nums) {

        for (Integer w : nums) {
            if (w % 2 == 0) {
                System.out.print(w + " ");
            }
        }
    }


    /* Example 4.)
       Bir listteki cift elemanları ayni satirda aralarina bosluk koyarak yazdiran methodu olusturunuz.
       (Functional) */
    public static void printEvenElement2(List<Integer> nums) {
        nums.                                      //filter() methodu ciftleri alip siralayacak soruya göre ne istiyorsak onu yapacak
        stream().                                  // görünümü bu sekildede yapabilirim bir satirda seksen karakterden
        filter(t -> t % 2 == 0).                   //fazlasını yazmamak icicn
        forEach(t -> System.out.print(t + " "));
    }




    /* Example 5.)
    Bir listteki tek sayı olan elemanların karelerini aynı
    satirda aralarina bosluk koyarak yazdiran methodu olusturunuz */
    public static void printSquareofElements1(List<Integer> nums) {
        nums.
                stream().
                filter(t -> t % 2 != 0).
                map(t -> t * t). // map()-->methodunu var olan elemanı degistirmek icin kullanırız
                forEach(t -> System.out.print(t + " "));//yazdır
    }



    /* Example 6.)
    Bir listteki tek sayı olan elemanların küplerini tekrarsız olarak aynı
    satirda aralarina bosluk koyarak yazdiran methodu olusturunuz
    (Functional)
     */
    public static void printCubeofDistinctOfElements2(List<Integer> nums) {
        nums.
        stream().
        distinct().//distinct() methodu tekrarsız eleman verir.streamdan sonra koyarsak daha az elemanla ugrasiriz.
        filter(t -> t % 2 != 0).//filtreleme yapar
        map(t -> t * t * t).//degeri methodu degistirmek icin kullandik
        forEach(t -> System.out.print(t + " "));

        /* burada Once elemeler yapilir. Yani ben buradaki methodların yerini istedigim gibi
        degistirebilirim.Önce "map()"methodunuda yazabilirim fakat methodlarda sayıları
        azaltarak gitmekte önemlidir kodlarım daha hızlı calısır
         */
    }

    /* Example 7.)
    Bir listteki farklı cift elemanların karelerinin toplamını hesaplayıp aynı
    satirda aralarina bosluk koyarak yazdiran methodu olusturunuz.*/
    public static void printSumOfSquaresOfDistinctEvenElements(List<Integer> nums) {
        Integer sum = nums.
                stream().
                distinct().
                filter(t -> t % 2 == 0).
                map(t -> t * t).
                reduce(0, (t, u) -> t + u);   // reduce()--> coklu degerleri tekli degerlere
        System.out.println();                        //cevirmek gerektiginde reduce()yi kullanırız
        System.out.println(sum);                     // toplama dedigi icin baslangıc degerini 0sıfır aldım

    }
    /* Example 8)
    farklı cift elemanların karelerinin carpımını hesaplamak icin bir yöntem olusturun */
    public static void printProductOfSquareOfDistinctEvenElements(List<Integer> nums) {
       Integer product =nums.
                stream().
                distinct().
                filter(t -> t % 2 == 0).
                map(t -> t*t).
                reduce(1, (t, u) -> t * u);  //carpma dedigi icin baslangıc degerini 1 aldım
        System.out.println();
        System.out.println(product);

    }


}
