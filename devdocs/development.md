# Fejlesztői dokumentáció

## Használt szoftver

A program VSCode-ban készült, Java támogatással kiegészítve, "No build tools" eszközzel.

## Osztályok

Két osztály van:

* Client
* Convert

A Client osztály REST API szerverek eléréséhez készült programozói könyvtár.

A Convert segíti a JSON sztringek konvertálását Java objektumokká és fordítva.

A Client osztály a Java 11-ben megjelent HttpClient osztályra épül, így minimum 11-s Java kell a használatához.

## Client osztály

A Client osztály metódusai megfelelnek az által megvalósított HTTP metódusnak.

* get()
* push()
* put()
* delte()

## Convert osztály

A Convert osztály generikus típusokat használ annak érdekében, hogy rugalmasan bármilyen objektumot használhasson a felhasználó.

* toListObject()
* toObject()
* listToJson()
* toJson()

## Tesztelés

A Client osztály tesztelhető automatikusan a Typicode hamis REST API segítségével.

* test/auto

A Convert és a Client osztály tesztelhető kézzel:

* test/hand

A kézi tesztelés annyit jelent, hogy nem a VSCode beépített tesztelőjén keresztül tesztelünk. A nevükben TestCon-ra végződő osztályok tartalmaznak egy main() metódust, azon keresztül futtathatók.

Az EmpConvertTest osztály dolgozók adataival teszeli a konvertálást. A teszteléshez szükség van az Employee osztályra.

A TypicodeClientTestCon, egy kéziteszt a Client osztály tesztelésére. Szükséges hozzá a typicode.com elérése.

A Typicode ConvertTestCon, a Convert osztály kéziteszteléshez használható, egyik tesztben szükséges a typicode.com elérése.

## Tennivalók

* Több automatikus tesztre van szükség a Client osztály esetén.
* A Convert osztály számára automatkus tesztek írása.
* Ha működnek az automatizált tesztek, a kézitesztek törölhetők.