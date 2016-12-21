
#### Aprašymas

React Egzamino užduotis.

Reikės sukurti supaprastintą bibliotekos knygų administravimo svetainę.
Backend'as jau yra sukurtas už jus. Išbandyti jį galite http://localhost:8080/swagger-ui.html.
Front-end kodas rašoma bus `/src/main/resources/static`. Jau yra Hello World tipo implementacija.

Paleidimas iš komandinės eilutės:

```
$ mvn clean spring-boot:run -Drun.addResources=true
```

Statiniai resursai (js,html) atsinaujina iškart po pakeitimų.

#### Vertinimas

Pažymį sudarys sėkmingai išpildytų reikalavimų kiekis, kodo stilius,
papildomų užduočių išpildymas.

Nusirašinėti, dalintis patarimais,
kopijuoti iš kolegų github'o yra draudžiama.
Destytojų akis yra pakankamai įgudusi pamatyti copy-paste.

#### Reikalavimai

##### Knygų sąrašas (8 taškai)

Sukurkite knygų sąrašo puslapį.

- Atėjus į namų puslapį (localhost:8080) turime matyti knygų sąrašą.
Užkraukite knygas iš `GET /api/books` (5 taškai)
- Knygų sąraše turi matytis: id, pavadinimas, autorius. (1 taškas)
- Turi būti galimybė paspaudus mygtuką keliauti į knygos[kūrimo puslapį]((#)knygos-kūrimas). (1 taškas)
- Turi būti galimybė paspaudus mygtuką keliauti į knygos[atnaujinimo puslapį]((#)knygos-atnaujinimas). (1 taškas)

##### Knygos kūrimas (10 taškų)

- Kuriant knygą rodoma forma su laukais: pavadinimas, autoriai, kiekis, isbn. (5 taškai)
- Yra 2 mygtukai: Išsaugoti ir Atšaukti
- Išsaugoti: (4 taškai)
  - Išsaugokite naujos knygos duomenis serveryje kviesdami `POST /api/books`
  - Sugrąžinkinte vartotoją į sąrašo puslapį
  - Sąraše turi matytis naujai sukurta knyga
- Paspaudus 'Atšaukti' duomenys neturi būti išsaugoti, (1 taškas)
    o vartotojas turi būti tiesiog nukreipiamas į sąrašo puslapį.

##### Knygos atnaujinimas (4 taškai)

- Atnaujinami laukai: pavadinimas, autoriai, kiekis, isbn. (1 taškas)
- Atnaujinimo forma turi būti užpildyta informacija apie knygą, kurią naujiname.
Naudokite `GET /api/books/:id`. (1 taškas)
- Atnaujinimui gali būti naudojamas tas pats komponentas kaip kūrimui, papildžius
jį atnaujinimo logika.
- Yra 2 mygtukai: Išsaugoti ir Atšaukti
- Išsaugoti: (1 taškas)
  - Išsaugokite naujos knygos duomenis serveryje kviesdami `POST /api/books` arba `PUT /api/books/:id`
  - Sugrąžinkinte vartotoją į sąrašo puslapį
- Paspaudus 'Atšaukti' duomenys neturi būti išsaugoti,
o vartotojas turi būti tiesiog nukreipiamas į sąrašo puslapį. (1 taškas)

# Papildoma užduotis (2 balai prie galutinio pažymio)

1. Viskam naudokite Bootstrap CSS (Boostrap css stiliai jau yra įtraukti). (1 balas)
2. Tiek sąraše tiek formose rodykite knygos išleidimo datą `publishedAt` gražiame formate.
Galite tam naudoti papildomą biblioteką http://momentjs.com/. (0.5 balo)
3. Pritaikytas Container/Presentation componentų šablonas (0.5 balo)
