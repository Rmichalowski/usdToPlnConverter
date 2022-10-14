Program działa w konsoli po skompilowaniu programu.

Aby przeliczyć kwotę USD na PLN, tworzymy obiekt "Computer" przypisujemy mu cenę w USD
oraz datę ksiegowania. Konstruktor obiektu automatycznie użyje api NBP i przypisze przeliczoną 
wartość do zmiennej pricePLN. Uzyskać ją można funkcją obiekt.getPricePLN();, lub eksportując 
koszyk zawierający dany komputer do pliku XML używając funkcji obiekt.toFileXML();
Plik domyślnie eksportowany jest do "../usdToPlnConverter/faktura.xml".

Program współpracuje z bazą danych MYSQL konfigurowaną w pliku java/resources/META-INF/persistence.xml .

Wersja javy: 17.0.2
Użyte środowisko: IntelliJ + maven
Użyta baza danych: MYSQL


