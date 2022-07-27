
```c
/*
Un'area giochi è accessibile da gruppi formati da 2, 3, 4 persone.
L'area giochi può ospitare al massimo 50 persone.
Programmare l'ingresso e l'uscita di ognuno dei 3 tipi di gruppo,
assicurando quanto segue:
- un gruppo di N persone, con N in {2, 3, 4}, non può accedere all'area giochi e
deve essere messo in attesa se i posti disponivili sono meno di N.
- un gruppo di N persone non può essere in attesa se ci sono almeno N
posti disponibili nell'area giochi.
*/

mutex = 1;
gruppoD = 0;
gruppoT = 0;
gruppoQ = 0;

int posti = 50, int attesaD = 0, int attesaT = 0, int attesaQ = 0;

GruppiDue(){
 entraD();
 gioca();
 esceD();
}

GruppiTre(){
 entraT();
 gioca();
 esceT();
}

GruppiQuattro(){
 entraQ();
 gioca();
 esceQ();
}

entraD(){
 wait(mutex);
 if(posti >= 2){
  posti = posti - 2;
  signal(mutex);
 }else{
  attesaD++
  signal(mutex);
  wait(gruppoD);
 }
}

entraT(){
 wait(mutex);
 if(posti >= 3){
  posti = posti - 3;
  signal(mutex);
 }else{
  attesaT++
  signal(mutex);
  wait(gruppoT);
 }
}

entraQ(){
 wait(mutex);
 if(posti >= 4){
  posti = posti - 4;
  signal(mutex);
 }else{
  attesaQ++
  signal(mutex);
  wait(gruppoQ);
 }
}

esceD(){
 wait(mutex);
 posti = posti + 2;
 while (posti >= 2 && attesaD > 0){
  posti = posti - 2;
  attesaD--;
  signal(mutex);
  signal(gruppoD);
  wait(mutex);
 }
 while (posti >= 3 && attesaT > 0){
  posti = posti - 3;
  attesaT--;
  signal(mutex);
  signal(gruppoT);
  wait(mutex);
 }
 while (posti >= 4 && attesaQ > 0){
  posti = posti - 4;
  attesaQ--;
  signal(mutex);
  signal(gruppoQ);
  wait(mutex);
 }
 signal(mutex);
}

esceT(){
 wait(mutex);
 posti = posti + 3;
 while (posti >= 3 && attesaT > 0){
  posti = posti - 3;
  attesaT--;
  signal(mutex);
  signal(gruppoT);
  wait(mutex);
 }
 while (posti >= 4 && attesaQ > 0){
  posti = posti - 4;
  attesaQ--;
  signal(mutex);
  signal(gruppoQ);
  wait(mutex);
 }
 while (posti >= 2 && attesaD > 0){
  posti = posti - 2;
  attesaD--;
  signal(mutex);
  signal(gruppoD);
  wait(mutex);
 }


 signal(mutex);
}

esceQ(){
 wait(mutex);
 posti = posti + 4;
 while (posti >= 4 && attesaQ > 0){
  posti = posti - 4;
  attesaQ--;
  signal(mutex);
  signal(gruppoQ);
  wait(mutex);
 }
 while (posti >= 3 && attesaT > 0){
  posti = posti - 3;
  attesaT--;
  signal(mutex);
  signal(gruppoT);
  wait(mutex);
 }

 while (posti >= 2 && attesaD > 0){
  posti = posti - 2;
  attesaD--;
  signal(mutex);
  signal(gruppoD);
  wait(mutex);
 }


 signal(mutex);
}
```
