# Fejlesztői dokumentáció

## Használt szoftver

A program VSCode-ban készült, Java támogatással kiegészítve, "No build tools" eszközzel.

## Külső modulok

A program a követkeő külső modulokat használja:

Működéshez:

* gson

A Gson a konvertáláshoz szükséges.

Teszteléshez:

* testng
* jcommander
* slf4-api

A jcommander és az slf4-api a testng függősége.

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

A push(), put() és delete() metódus esetén lehetőség van egy plusz paraméter megadására, ami értelemszerűen nem kötelező.
Ebben a paraméterben átadható egy token az azonosításhoz.

A jelenleg átadott HTTP fejléc: "Authorization":"Bearer". Előfordulhat olyan szerver, ahol a Bearer helyett más szöveget kell a token előtt átadni.

## Convert osztály

A Convert osztály generikus típusokat használ annak érdekében, hogy rugalmasan bármilyen objektumot használhasson a felhasználó.

* toListObject()
* toObject()
* listToJson()
* toJson()

## Java dokumentáció készítése

A Java dokumentáció a scripts/create_docs.sh scripttel generálható, ami egy Bash script.

```bash
bash scripts/create_docs.sh
```

Az eredmény a docs könyvtárba kerül, ez jelenik meg a GitHub-on weblapként.

## Tesztelés

### Automatikus teszt

A Client osztály tesztelhető automatikusan a Typicode hamis REST API segítségével.

* test/auto

Az automatikus teszt TestNG-vel van megvalósítva.

### Kézi tesztelés

A Convert és a Client osztály tesztelhető kézzel:

* test/hand

A kézi tesztelés annyit jelent, hogy nem a VSCode beépített tesztelőjén keresztül tesztelünk. A nevükben TestCon-ra végződő osztályok tartalmaznak egy main() metódust, azon keresztül futtathatók.

Az EmpConvertTest osztály dolgozók adataival teszeli a konvertálást. A teszteléshez szükség van az Employee osztályra.

A TypicodeClientTestCon, egy kéziteszt a Client osztály tesztelésére. Szükséges hozzá a typicode.com elérése.

A Typicode ConvertTestCon, a Convert osztály kéziteszteléshez használható, egyik tesztben szükséges a typicode.com elérése.

## Tennivalók

* A Client osztály get() metódusa is tudjon azonosítással lekérdezni.
* Több automatikus tesztre van szükség a Client osztály esetén.
* A Convert osztály számára automatkus tesztek írása.
* Ha működnek az automatizált tesztek, a kézitesztek törölhetők.
* Aszinkron metódusok létrehozása.
* Az Authorization HTTP fejléc állítása konstruktorral és metódussal.
