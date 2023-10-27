# 3. semester SP opgave 02
## - gruppe 4 (kun for piger - og Frederik)

### Introduktion til projektet
Projektet er en SP02 opgave på datamatikeruddannelsens 3. semester (CPH Business).
Overordnet set handler projektet om at trække data fra en hjemmeside og gemme data på en database. Altså webscraping (datamining) og brug af Rest API.
Teknologierne der er anvendt i projektet, samt applikationens lag, er beskrevet nedenfor, og vil derfor ikke fylde noget i introduktionen.

> Projektdeltagerne er:<br>
> Natasja Vitoft <br>
> Veronika Minddal <br>
> Signe K. Larsen <br>
> Frederik G. Johannessen

### Business Idea
Firmanavn: **Data Girls - powered by data**.

Ved hjælp af data, vi snedigt skraber fra vejrtjenester, spår vi i kaffegrumsen (eller rettere i skyerne) for at afdække, hvor i Danmark regndråberne næste gang vil danse. Og voila! Når skyerne samler sig, og regnen begynder at falde, er vi klar til at målrette salget af de mest stilfulde paraplyer, komfortable gummistøvler og effektive regnslag - alt sammen fra den eksklusive spanske producent, **RainMain!**


### Vi vil anvende følgende teknologier
![Java](https://img.shields.io/badge/Java-%23FF0000?style=flat-square&logo=java&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-%23336791?style=flat-square&logo=postgresql&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-%23000000?style=flat-square&logo=intellij-idea&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-%23181717?style=flat-square&logo=github&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-%23C71A36?style=flat-square&logo=apache-maven&logoColor=white)
![JPA](https://img.shields.io/badge/JPA-%23008000?style=flat-square&logoColor=white)
![Jsoup](https://img.shields.io/badge/Jsoup-%23008000?style=flat-square&logoColor=white)
![Javalin](https://img.shields.io/badge/Javalin-%230056D6?style=flat-square&logoColor=white)


### Apllikationens lag
![3_Sem_SP02_app](https://github.com/FrederikGJ/3sem_sp02/assets/113090989/a802b741-d6f3-46db-a20c-955c31925af3)

### EER diagram
<img width="527" alt="Screenshot 2023-09-28 at 13 14 23" src="https://github.com/FrederikGJ/3sem_sp02/assets/113090989/84985328-dcc4-41e6-97c8-791901faf9ac">

### API'er som vi har brugt til at hente data fra
https://dawadocs.dataforsyningen.dk/dok/api/sted <br>
https://vejr.eu/pages/api-documentation

### Projektarbejdet
Til at starte med organiserede vi projektet. Vi lavede en uformel gennemgang af det, der af Pressman og Maxim kaldes for The Process Framework (Pressman & Maxim, 2014, s. 10-11).
> The Process Framework indeholder følgende kategorier: <br>
> Communication, Planning, Modeling, Construction og Deployment <br>
> (Pressman & Maxim, 2014, s. 10-11)

I vores team har vi et godt sammenhold, og har derfor en god kommunikation fra start, som varede ved gennem hele projektet. Vi kommunikere både mundtligt, da vi mødtes fysisk de fleste dage, samt elektronisk i projektgruppes facebook.

Vi planlagde projektet ved at gennemgå kravspecifikationerne og skrive dem ind i et fælles Google Doc. Vi valgte ikke at bruge Kanban Board til opgaven, da scope for opgaven var begrænset. Ved større projekter, der strækker sig ud over en uges varighed, bruger vi Kanban værktøjet Trello.

Når det kommer til modellen fandt vi hurtigt frem til en fornuftig løsning. Da projektet er en applikation der indeholder to lag, backend og database, samt en forbindelse ud til internettet, var arkitekturen på applikationen meget overskuelig (se eventuelt billede af applikationen lag ovenfor).  

Vi har brugt GitHub til versionsstyring, hvor vi hver især anvendte feature branches, som vi senere mergede sammen i produktionen (Main).

Alt i alt er vi tilfredse med samarbejdet, men vi har talt om, at vi ved næste projekt vil bruge Kanban selvom det er et kort projekt. Da Kanban giver et dejligt overblik over opgaverne.

### Koden
Når vi strukturerer vores kode i foldere og klasser, er det fordi vi gerne vil opnå hvad der hos Pressman og Maxim kaldes Separation of Concerns (Pressman & Maxim, 2014, s. 165). Separation of Concerns handler om, at vi tager det store problem, som er at bygge hele applikationen, og bryder det ned til mindre og mere overskuelige bestanddele. De dele er de mapper og klasser applikationen består af. Tilgangen gør det mere overskueligt for os at arbejde sammen om projektet, samtidig med at det gør koden nemmere at refaktorere på et senere tidspunkt.

I vores projekt har vi gjort brug af et design pattern. Design patterns bruger kendte værktøjer til at løse kendte problemer.

Et design pattern kan også beskrives mere formelt i Pressman og Maxims bog således:

> [!Note]
> Brad Appleton defines a *design pattern* in the following manner: "A pattern is a named nugget  of insight which conveys the essence of a proven solution to a recurring problem within a certain context amidst competing concerns" (Pressman & Maxim, 2014, s. 164)

Vores DAO klasser følger singleton pattern, da vi kun laver en global instans, som man så henter med getInstace() metoden, som kaldes direkte på klassen. Ud over DAO klasserne har vi ikke brugt nogle af de klassiske design patterns.

Afsluttende vil vi gerne blive bedre til at bruge JPA til at skabe relationer mellem vores entiteter. Sådan at vi ud fra data kan skabe nye og mere interessante entiteter. 

### Litteraturliste
Pressman, R.S. and Maxim, B., 2014. Software Engineering: A Practitioner's Approach, 9th ed. [New York].



# TestRep
