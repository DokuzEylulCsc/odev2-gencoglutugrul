# Ödev 2 (7 puan) Son Teslim: 02.12.2019 21:30 
Gündelik hayatta kullandığımız sayı sembollerine Hindu-Arap sayıları denmektedir. Ancak sayıları göstermek için kullanılan başka sayı sembolleri de vardır. Bunlardan biri de Romalıların kullandığı sembollerdir. Roma rakamları belirli harf sembollerinin yan yana tekrarlanmasıyla ifade edilir. Örneğin 10’luk sistemde 49 olarak ifade edilen sayı roma rakamları ile XLIX şeklinde yazılır. Temel Roma Rakamları tablosunu ve roma rakamlarının yazımında kullanılan iki temel kural olan Toplama Kuralı ve Çıkarma Kuralını da kullanarak; 
1.	Onluk tabanda verilen bir sayıya karşılık gelen Roma rakamları ile yazılan eşdeğerinin bulunması, ve
2.	Roma rakamları halinde verilmiş bir sayının onluk karşılıklarının elde edilmesini sağlayacak,
C#, C++, Java veya JavaScript dillerinin biriyle kodlanmış bir program yazınız. Bu programda hem onluk tabanda, hem de Roma rakamları ile verilecek en büyük sayı limiti 3999 (MMMCMXCIX), en küçük sayı ise 1 (I) olacaktır. 




İyi çalışmalar, başarılar.

# Ödev Sunumu

### Roma Sisteminde Girilen Sayıları Onluk Sistemin Rakamalarına Çevirme;
Bunun için izlediğim yol sağdan sola doğru giderek değerlerin küçüklük ya da büyüklük durumuna göre toplamak veya çıkarmak oldu. Bu algoritmayı geeksforgeek(https://www.geeksforgeeks.org/converting-roman-numerals-decimal-lying-1-3999/) sitesinde öğrendim. İlk başta aklıma gelen CD, XL gibi iki harf kullanılarak (4 veya 9'un 10'un kuvvetleri ile çarpımından elde edilen sayılar) ifade edilenleri bulup değerlerini toplayıp daha sonra tüm ifadeden onları çıkartıp kalanların değerlerini toplatıp son olarak da bu iki toplamı toplatmaktı. Fakat bu yöntem pek efektif bir çözüm değildi. Aralığı arttırmaya kaltığımızda çok fazla değişiklik yapmamızı gerektiriyordu. GeeksForGeek'deki algoritma ile sadece yeni karakterleri eklemek yeterli.
### Onluk Sistemde Girilen Sayıları Roma Rakamlarına Çevirme;
Bunu anlamak ve çözümlemek çok daha kolay oldu. Bir roma sayısının anatomisinde belli değerleri olan semboller tekrar ediyor ve tekrar edenler toplanıyor. Örneğin 3000 için MMM yani üç tane bin. Dolayısıyla eğer bir şekilde girilen sayıyı matematiksel olarak analiz edilebilecek hale getirebilirsek (254 için 200+50+4 gibi) gerisi çok kolay olacaktı. Dolayısıyla önce sayıyının kaç basamaklı olduğunu buldum. Bunun için sayının 10 tabanındaki logaritmasını aldım. Tabi bunu integer değişkende saklamak gerekiyor yoksa 50 için 2 basamak yerine 2.5 basamak hesaplayabiliriz. Daha sonra sayıyı 3*10^2 gibi bir hale getirdim.  10^2'nin roma rakamları ile karşılığı C. Şimdi tek yapmak gereken bunu 3 kez yazdırmak.
### Girilen Roma Sayısının Validasyonu
Burada henüz yapabildiğim iki şey var. Birincisi istenmeyen karakter var mı yok mu bunu kontrol etmek. Örneğin roma rakamlarında Z diye bir şey yok (en azından 1-3999 aralığında). İkinci şey ise bir rakam hiç bir zaman 3 den fazla kez art arda yazılamaz. Yani XXXX tanımsızdır.
##### Validasyon Kontrolüne Eklenecekler
1. Bir roma sayısında art arda en az iki aynı rakam geldikten sonra kendisinden büyük bir rakam gelemez. Örneğin: XXC tanımlı değilken XC tanımlıdır.
2. Bir roma sayısında art arda en fazla iki birbirinden büyük rakam gelebilir. Örneğin: IX tanımlıyken IXC tanımsızdır. 
3. Bir roma sayısında art arda V, L, D gibi ara (5'in 10'un kuvvetleri ile çarpımı ) rakamlar gelemez. Örneğin: XX tanımlıyken LL tanımsızdır.
4. Bir roma sayısında V, L, D gibi ara rakamlardan sonra kendisinden büyük bir rakam gelemez. Örneğin XC tanımlıyken LC tanımsızdır.
